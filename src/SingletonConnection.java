import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "123456");
            System.out.println("Connected to the database successfully");
        }catch ( SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
