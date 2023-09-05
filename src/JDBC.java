import java.sql.*;

public class JDBC {
JDBC()
{
    Connection connexion = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/lyrics_application";
        connexion = DriverManager.getConnection(url, "root", "");
        statement = connexion.createStatement();


        String query = "SELECT * FROM admin";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String colonne1 = resultSet.getString("email");
            System.out.printf(colonne1);

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
