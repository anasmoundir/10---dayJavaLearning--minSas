package DAO;

import Entities.Livre;
import services.Database;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static DAO.BookDao.afficherTousLesLivres;

public class ReservationDao {

     static  Connection connection = Database.getConnection();

    public static Livre emprunterLiveQuery(Scanner scanner, String titre) {

        Livre livre = new Livre();
        try {
            livre = BookDao.rechercherLivresParTitre(titre);
            System.out.println(livre.getTitre());

            if (livre != null) {
                String statement = "SELECT * FROM livrecopy WHERE livre_id = ? AND etat = 1 ";
                PreparedStatement preparedStatement = connection.prepareStatement(statement);
                preparedStatement.setInt(1, livre.getId_livre());;
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                     livre = updateLivrequantity(livre);
                    int livreCopyId = resultSet.getInt("id");
                    int adherentId = obtenirIdAdherent(scanner);
                    if (adherentId != -1) {
                        String query = "INSERT INTO reservation (livre_copy_id,adherent_id,date_reservation,date_limit) VALUES(?,?,?,?)";
                        PreparedStatement preparedStatement1 =connection.prepareStatement(query);
                        preparedStatement1.setInt(1,livreCopyId);
                        preparedStatement1.setInt(2,adherentId);
                        LocalDate datenow = LocalDate.from(LocalDateTime.now());
                        preparedStatement1.setDate(3,Date.valueOf(datenow));
                        LocalDate dateLimite = datenow.plusDays(7);
                        preparedStatement1.setDate(4, Date.valueOf(dateLimite));
                        preparedStatement1.executeUpdate();
                        checkAndUpdateStatus(livre);
                        updateLivreCopyState(livreCopyId, 1);
                        System.out.println("Emprunt réussi !");
                    } else {
                        System.out.println("Adhérent introuvable.");
                    }
                } else {
                    System.out.println("Aucune copie de ce livre n'est disponible.");
                }
            } else {
                System.out.println("Livre introuvable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livre;
    }


    public  static Livre updateLivrequantity(Livre livre)
    {
        int newquantity = livre.getQuantity();
        if(newquantity>0)
        {
        try {
            String query ="UPDATE livre SET quantiy = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            newquantity =newquantity-1;
            preparedStatement.setInt(1,newquantity);
            preparedStatement.setInt(2,livre.getId_livre());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return livre;
        }
        else
        {
            return livre;
        }
    }
    public static int obtenirIdAdherent(Scanner scanner) {
        System.out.print("Entrez le numéro de membre de l'adhérent : ");
        String numeroMembre = scanner.nextLine();

        try {
            Connection connection = Database.getConnection();
            String searchQuery = "SELECT id FROM adherent WHERE numero_membre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
            preparedStatement.setString(1, numeroMembre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return -1;
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean checkAndUpdateStatus(Livre livre) {
        boolean status = true;
        try {
            Connection connection = Database.getConnection();
            String query = "SELECT quantiy FROM livre WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, livre.getId_livre());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int quantity = resultSet.getInt("quantiy");
                status = true;
                String updateQuery = "UPDATE livre SET status = ? WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setBoolean(1, status);
                updateStatement.setInt(2, livre.getId_livre());
                updateStatement.executeUpdate();
            } else {
                status = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }
    private static void updateLivreCopyState(int livreCopyId, int newState) {
        try {
            System.out.println("here");

            String selectQuery = "SELECT Nbr_emprunt FROM livrecopy WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, livreCopyId);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int currentEmprunts = resultSet.getInt("Nbr_emprunt");
                int newEmprunts = currentEmprunts + 1;
                String updateQuery = "UPDATE livrecopy SET Nbr_emprunt = ? WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, newEmprunts);
                updateStatement.setInt(2, livreCopyId);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void retournerLivreQuery(Scanner scanner, String titre) {
        try {

            Livre livre = BookDao.rechercherLivresParTitre(titre);
            if (livre != null) {
                String query = "UPDATE reservation SET date_limit = ? WHERE livre_copy_id IN (SELECT id FROM livrecopy WHERE livre_id = ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                LocalDate dateRetour = LocalDate.from(LocalDateTime.now());
                preparedStatement.setDate(1, Date.valueOf(dateRetour));
                preparedStatement.setInt(2, livre.getId_livre());
                preparedStatement.executeUpdate();
                updateLivreCopyState(livre.getId_livre(), 0);
                System.out.println("Livre retourné avec succès !");
            } else {
                System.out.println("Livre introuvable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


















}
