import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        try {
            connection = helper.getConnection();
            System.out.println("Başarıyla Çalıştı");
        }catch (SQLException exception){
            helper.getErrorMessage(exception);
        }finally {
            connection.close();
        }

    }
}