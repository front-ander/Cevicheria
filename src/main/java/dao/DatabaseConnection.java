package dao;

/**
 *
 * @author Anderson
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Cevicheria;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "admin123";
    private static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a la base de datos establecida.");
            }
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

