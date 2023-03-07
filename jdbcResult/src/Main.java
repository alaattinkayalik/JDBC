import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

    }


    public static void selectDemo() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.connections();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select name,surname from mytable");
            ArrayList<Country> arrayList = new ArrayList<Country>();
            while (resultSet.next()) {
                arrayList.add(new Country(resultSet.getString("name"), resultSet.getString("surname")));
            }
        } catch (SQLException exception) {
            helper.getErrorMessage(exception);
        }
    }

    public static void insertDemo() throws SQLException{
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.connections();
            statement = connection.prepareStatement("insert into mytable(name,surname) values ('Alaattin','Kayalık')");
            System.out.println("Kayıt Eklendi");
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.getErrorMessage(exception);
        }finally {
            statement.close();
            connection.close();
        }
    }
    public static void updateDemo() throws SQLException{
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.connections();
            statement = connection.prepareStatement("Update mytable SET surname = 'Kaya' where name ='Alaattin'");
            statement.executeUpdate();
            System.out.println("Kayıt Güncellendi");
        } catch (SQLException exception) {
            helper.getErrorMessage(exception);
        }finally {
            statement.close();
            connection.close();
        }
    }

    public static void deleteDemo() throws SQLException{
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.connections();
            statement = connection.prepareStatement("Delete From mytable where idmytable=1");
            statement.executeUpdate();
            System.out.println("Kayıt Silindi");
        } catch (SQLException exception) {
            helper.getErrorMessage(exception);
        }finally {
            statement.close();
            connection.close();
        }
    }
}