import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static String userName = "root";
    static String password = "12345";
    static String dbUrl = "jdbc:mysql://localhost:3306/myschema";
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl,userName,password);
            System.out.println("Başarıyla Çalıştı");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }
}