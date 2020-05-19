package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private final static String DB_URL = "jdbc:postgresql://localhost:.../...";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "secret";

    private static Connection connection;

    public DbConnection(){
    }

    public static Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
        return connection;
    }
}
