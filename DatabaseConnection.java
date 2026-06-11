import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection connect() {

        try {

            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:atm.db";

            Connection conn = DriverManager.getConnection(url);

            System.out.println("Database Connected Successfully!");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}