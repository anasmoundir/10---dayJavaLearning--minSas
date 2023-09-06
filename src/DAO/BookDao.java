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
            String rechercherAutheurParNom = "select id from auteur where nom = ? ";
            PreparedStatement PreparedStatement = connexion.prepareStatement(rechercherAutheurParNom);
            PreparedStatement.setString(1, nom);
            ResultSet resultset = PreparedStatement.executeQuery();
            if (resultset.next()) {
                auteurId = resultset.getInt("id");
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

    public static void modifierLivre(Livre livre,String nom) {
        try {
            Connection connection = Database.getConnection();
            String chercherLivreParNom = "SELECT id FROM livre WHERE titre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(chercherLivreParNom);
            preparedStatement.setString(1, livre.getTitre());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int livreId = resultSet.getInt("id");

                 
                System.out.println("Livre modifié avec succès !");
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
}

























