package busrev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // This method can be called from other classes
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busrev";  
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Make sure MySQL JDBC is loaded
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, username, password);
    }
}
