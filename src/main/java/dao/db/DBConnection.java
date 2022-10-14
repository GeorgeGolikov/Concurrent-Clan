package dao.db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null)
            connection = getConnection();
        return connection;
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/concurrent-clan";
        String user = "postgres";
        String password = "postgres";
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(url, user, password);

        if (connection.isValid(1)) {
            System.out.println("Connection successful!\n");
        }

        return connection;
    }

    private DBConnection() {

    }
}
