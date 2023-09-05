import java.sql.*;

public class JDBC {
JDBC()
{
    Connection connexion = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/librarymanagement";
        connexion = DriverManager.getConnection(url, "root", "");
        statement = connexion.createStatement();


            String query = "SELECT * FROM livre";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String colonne1 = resultSet.getString("titre");
            String colonne2 = resultSet.getString("annee_publication");
            String colonne3 = resultSet.getString("auteur_id");
            System.out.println(colonne1);
            System.out.println(colonne2);
            System.out.println(colonne3);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connexion != null) connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
