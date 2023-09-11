package DAO;

import services.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RapportGenerationDao {

    public static void genererRapportStatistique() {
        System.out.println("here");
        try {
            Connection connection = Database.getConnection();


            String totalLivresQuery = "SELECT COUNT(*) AS totalLivres FROM livre";
            PreparedStatement totalLivresStatement = connection.prepareStatement(totalLivresQuery);
            ResultSet totalLivresResult = totalLivresStatement.executeQuery();
            if (totalLivresResult.next()) {
                int totalLivres = totalLivresResult.getInt("totalLivres");
                System.out.println("Nombre total de livres : " + totalLivres);
            }


            String livresDisponiblesQuery = "SELECT COUNT(*) AS livresDisponibles FROM livre  WHERE quantiy <> 0";
            PreparedStatement livresDisponiblesStatement = connection.prepareStatement(livresDisponiblesQuery);
            ResultSet livresDisponiblesResult = livresDisponiblesStatement.executeQuery();
            if (livresDisponiblesResult.next()) {
                int livresDisponibles = livresDisponiblesResult.getInt("livresDisponibles");
                System.out.println("Nombre de livres disponibles : " + livresDisponibles);
            }


            String livresEmpruntesQuery = "SELECT COUNT(*) AS livresEmpruntes FROM livrecopy WHERE etat = 1";
            PreparedStatement livresEmpruntesStatement = connection.prepareStatement(livresEmpruntesQuery);
            ResultSet livresEmpruntesResult = livresEmpruntesStatement.executeQuery();
            if (livresEmpruntesResult.next()) {
                int livresEmpruntes = livresEmpruntesResult.getInt("livresEmpruntes");
                System.out.println("Nombre de livres empruntés : " + livresEmpruntes);
            }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
