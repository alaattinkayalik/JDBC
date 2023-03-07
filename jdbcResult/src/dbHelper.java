import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {

    private String name = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/myschema";

    public Connection connections(){
        try {
            return DriverManager.getConnection(dbUrl,name,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getErrorMessage(SQLException exception){
        System.out.println("Error : "+exception.getMessage());
        System.out.println("Eroor Code: "+exception.getErrorCode());
    }
}
