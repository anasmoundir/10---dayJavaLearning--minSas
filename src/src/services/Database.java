package services;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/librarymanagement";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";

    public static Connection getConnection() {
        Connection connexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connexion;
    }
}
