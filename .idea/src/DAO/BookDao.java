package DAO;

import Entities.Auteur;
import Entities.Livre;
import services.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.ReservationDao.checkAndUpdateStatus;

public class BookDao {

    static  Connection connection = Database.getConnection();
    public static void insertQueryBook(Livre livre, String nom) {
        int auteurId;

        try {



            getAuteurIdParNom(nom);
            if (getAuteurIdParNom(nom) != -1) {
                auteurId = getAuteurIdParNom(nom);
                String ajoutLivreQuery = "INSERT INTO livre (titre, annee_publication, quantiy, auteur_id,status,ISBN) VALUES (?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(ajoutLivreQuery);
                preparedStatement.setString(1, livre.getTitre());
                preparedStatement.setInt(2, livre.getAnnee_publication());
                preparedStatement.setInt(3, livre.getQuantity());
                preparedStatement.setInt(4, auteurId);
                preparedStatement.setBoolean(5,livre.isStatus());
                preparedStatement.setInt(6,livre.getISBN());
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
            int auteurId = getAuteurIdParNom(nom);
            if (auteurId != -1) {
                String chercherLivreParNom = "SELECT id FROM livre WHERE titre = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(chercherLivreParNom);
                preparedStatement.setString(1, livre.getTitre());
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int livreId = resultSet.getInt("id");
                    String modifierLivreQuery = "UPDATE livre SET titre = ?, annee_publication = ?, quantiy = ?, status = ?, ISBN = ? WHERE id = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(modifierLivreQuery);
                    updateStatement.setString(1, livre.getTitre());
                    updateStatement.setInt(2, livre.getAnnee_publication());
                    updateStatement.setInt(3, livre.getQuantity());
                    updateStatement.setBoolean(4, livre.getQuantity() > 0);
                    updateStatement.setInt(5, livre.getISBN());
                    updateStatement.setInt(6, livreId);

                    int rowsUpdated = updateStatement.executeUpdate();
                    System.out.println(rowsUpdated);
                    if (rowsUpdated > 0) {
                        System.out.println("Livre modifié avec succès !");
                    } else {
                        System.out.println("Échec de la modification du livre.");
                    }
                } else {
                    System.out.println("Aucun livre trouvé avec ce titre.");
                }
            } else {
                System.out.println("L'auteur n'existe pas !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<Livre> afficherTousLesLivres() {
        List<Livre> livres = new ArrayList<>();
        try {

            String selectAllLivresQuery = "SELECT * FROM livre WHERE quantiy <> 0";
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllLivresQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Livre livre = new Livre();
                livre.setTitre(resultSet.getString("titre"));
                livre.setAnnee_publication(resultSet.getInt("annee_publication"));
                livre.setQuantity(resultSet.getInt("quantiy"));
                int auhtorId = resultSet.getInt("auteur_id");
                livre.setAuteur(fetchAuteurById(auhtorId));
                livres.add(livre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }


    public static int getAuteurIdParNom(String nom) {
        try {
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

    public static Auteur fetchAuteurById(int auteurId) {
            Auteur auteur = new Auteur();
        try {
            String selectAutherById = "SELECT * FROM auteur where id =?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(selectAutherById);
            preparedStatement.setInt(1, auteurId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                auteur.setName(resultSet.getString("nom"));
                auteur.setAdress(resultSet.getString("address"));
            } else {
                System.out.println("the auteur doesn't exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auteur;
    }


    public static int  getNameAuthorById(String nom)
    {
        try {
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

    public static  Livre rechercherLivresParTitre(String titre)
    {
         Livre livre = new Livre();
        try {
            String searchingQuery = "SELECT * FROM livre WHERE titre  LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchingQuery);
            preparedStatement.setString(1,titre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                  livre.setId_livre(resultSet.getInt("id"));
                  livre.setTitre(resultSet.getString("titre"));
                  livre.setAnnee_publication(resultSet.getInt("annee_publication"));
                  livre.setQuantity(resultSet.getInt("quantiy"));
                  int auhtorId = resultSet.getInt("auteur_id");
                  livre.setISBN(resultSet.getInt("ISBN"));
                  livre.setAuteur(fetchAuteurById(auhtorId));
            }
        }catch (SQLException e)
        {
                e.printStackTrace();
        }

       return livre;
    }

     public static  List<Livre>   rechercherLivresParAuteur(String nom)
     {
          Livre livre = new Livre();
         List<Livre> livres = new ArrayList<>();
         try {
             String searchingQuery = "SELECT livre.id, livre.titre, livre.annee_publication, livre.quantiy, auteur.nom AS nom_auteur " +
                     "FROM livre " +
                     "INNER JOIN auteur ON livre.auteur_id = auteur.id " +
                     "WHERE auteur.nom LIKE ?";
             PreparedStatement preparedStatement = connection.prepareStatement(searchingQuery);
             preparedStatement.setString(1, "%" + nom + "%");
             ResultSet resultSet = preparedStatement.executeQuery();

             while(resultSet.next())
             {
                   livre.setId_livre(resultSet.getInt("id"));
                   livre.setTitre(resultSet.getString("titre"));
                   livre.setAnnee_publication(resultSet.getInt("annee_publication"));
                   livre.setQuantity(resultSet.getInt("quantiy"));
                   livre.setISBN(resultSet.getInt("ISBN"));
                   int auhtorId = getNameAuthorById(nom) ;
                   livre.setAuteur(fetchAuteurById(auhtorId));
                   livres.add(livre);
             }
                                                                                
         }catch (SQLException e)
         {
                 e.printStackTrace();
         }
        return livres;
     }
}









