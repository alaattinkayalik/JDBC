# JDBC
Java Database Connectivity (JDBC) is an application programming interface (API) for the Java programming language, which defines how a client may access a database. It is a Java-based data access technology used for Java database connectivity. It is part of the Java Standard Edition platform, from Oracle Corporation.
https://media.geeksforgeeks.org/wp-content/uploads/20200229213833/Architecture-of-JDBC2.jpg
JDBC ('Java Database Connectivity') allows multiple implementations to exist and be used by the same application. The API provides a mechanism for dynamically loading the correct Java packages and registering them with the JDBC Driver Manager. The Driver Manager is used as a connection factory for creating JDBC connections.

JDBC connections support creating and executing statements. These may be update statements such as SQL's CREATE, INSERT, UPDATE and DELETE, or they may be query statements such as SELECT. Additionally, stored procedures may be invoked through a JDBC connection. JDBC represents statements using one of the following classes:

Statement – the statement is sent to the database server each and every time.
PreparedStatement – the statement is cached and then the execution path is pre-determined on the database server allowing it to be executed multiple times in an efficient manner.
CallableStatement – used for executing stored procedures on the database.
Update statements such as INSERT, UPDATE and DELETE return an update count that indicates how many rows were affected in the database. These statements do not return any other information.

Query statements return a JDBC row result set. The row result set is used to walk over the result set. Individual columns in a row are retrieved either by name or by column number. There may be any number of rows in the result set. The row result set has metadata that describes the names of the columns and their types.

There is an extension to the basic JDBC API in the javax.sql.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Mydb1 {
   static String URL = "jdbc:mysql://localhost/mydb";

   public static void main(String[] args) {
      try {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(URL, "root", "root");
        Statement stmt = conn.createStatement();
      
        String sql = "INSERT INTO emp1 VALUES ('pctb5361', 'kiril', 'john', 968666668)";
        stmt.executeUpdate(sql);
           
        System.out.println("Inserted records into the table...");
      } catch (Exception e) {
        e.printStackTrace();
      }
   }
}
