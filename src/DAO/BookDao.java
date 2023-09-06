package DAO;

import Entities.Livre;
import services.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {


    public static void insertQueryBook(Livre livre, String nom) {
        int auteurId;
        try {


            Connection connexion = Database.getConnection();
            getAuteurIdParNom(nom);
            if (getAuteurIdParNom(nom)!=-1) {
                auteurId = getAuteurIdParNom(nom);
                String ajoutLivreQuery = "INSERT INTO livre (titre, annee_publication, quantiy, auteur_id) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connexion.prepareStatement(ajoutLivreQuery);
                preparedStatement.setString(1, livre.getTitre());
                preparedStatement.setInt(2, livre.getAnnee_publication());
                preparedStatement.setInt(3, livre.getQuantity());
                preparedStatement.setInt(4, auteurId);
                preparedStatement.executeUpdate();
                System.out.println("Livre ajouté avec succès !");
            } else
                System.out.println("add the author first");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerLivre(Livre livre) {
        try {
            Connection connection = Database.getConnection();
            String chercherLivreParNom = "SELECT id FROM livre WHERE titre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(chercherLivreParNom);
            preparedStatement.setString(1, livre.getTitre());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int livreId = resultSet.getInt("id");
                String deleteLivre = "DELETE FROM livre where id = ?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(deleteLivre);
                preparedStatement1.setInt(1, livreId);
                preparedStatement1.executeUpdate();
                System.out.println("Livre supprimé avec succès !");
            } else {
                System.out.println("Livre introuvable.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void modifierLivre(Livre livre, String nom) {
        try {

            Connection connection = Database.getConnection();
             getAuteurIdParNom(nom);
            if (getAuteurIdParNom(nom)!=-1) {
            String chercherLivreParNom = "SELECT id FROM livre WHERE titre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(chercherLivreParNom);
            preparedStatement.setString(1, livre.getTitre());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int livreId = resultSet.getInt("id");
                 String modifierLivreQuery = "UPDATE livre SET titre = ?, annee_publication = ?, quantity = ? WHERE id = ?";
                                 PreparedStatement updateStatement = connection.prepareStatement(modifierLivreQuery);
                                 updateStatement.setString(1, livre.getTitre());
                                 updateStatement.setInt(2, livre.getAnnee_publication());
                                 updateStatement.setInt(3, livre.getQuantity());
                                 updateStatement.setInt(4, livreId);
                 
                                 int rowsUpdated = updateStatement.executeUpdate();
                                 if (rowsUpdated > 0) {
                                 System.out.println("Livre modifié avec succès !");
                                    } else {
                                   System.out.println("Échec de la modification du livre.");
                                }


                System.out.println("Livre modifié avec succès !");
            }   }else
            {
                            System.out.println("l'autheur n'exist pas  !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


//       public static void  afficherTousLesLivres()
//         {
//             try{
//            Connection connection = Database.getConnection();
//         String selectAllLivresQuery = "SELECT * FROM livre";
//        PreparedStatement preparedStatement = connection.prepareStatement(selectAllLivresQuery);
//           ResultSet resultSet = preparedStatement.executeQuery();
//
//
//             }
//             catch (SQLException e)
//             {
//                            e.printStackTrace();
//             }
//
//         }


    }

    public static int getAuteurIdParNom(String nom)
    {
        try {
            Connection connection = Database.getConnection();
            String rechercheAuteurQuery = "SELECT id FROM auteur WHERE nom = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(rechercheAuteurQuery);
            preparedStatement.setString(1, nom);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return -1;
    }
}









