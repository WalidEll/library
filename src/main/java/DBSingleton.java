import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
    private static DBSingleton instance = null;

    private static String dbString = "jdbc:mysql://localhost:3306/library";
    private static String dbUser = "root";
    private static String dbPassword = "";
    private static Connection connection = null;

    private DBSingleton() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Not Found !!");
        }
    }

    public static DBSingleton getInstance() {
        if (instance == null)
            instance = new DBSingleton();
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dbString, dbUser, dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
