import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect{


    public static void main(String args[]) throws SQLException {
        Connection conn = getRemoteConnection();

        try {

            // Create a table and write two rows
            Statement setupStatement = conn.createStatement();
            String createTable = "CREATE TABLE Beanstalk (Resource char(50));";
            String insertRow1 = "INSERT INTO Beanstalk (Resource) VALUES ('EC2 Instance');";
            String insertRow2 = "INSERT INTO Beanstalk (Resource) VALUES ('RDS Instance');";

            setupStatement.addBatch(createTable);
            setupStatement.addBatch(insertRow1);
            setupStatement.addBatch(insertRow2);
            setupStatement.executeBatch();
            setupStatement.close();

        } catch (SQLException ex) {
            // Handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            System.out.println("Closing the connection.");
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }



    }


    private static Connection getRemoteConnection() throws SQLException {

                String dbName = "RugbyGenerator";
                String userName = "Codehorse";
                String password = "RugbyPassword";
                String hostname = "codehorserugby.c8gths3wraz9.eu-west-1.rds.amazonaws.com";
                String port = "3306";
                String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/";

                Connection con = DriverManager.getConnection(jdbcUrl+dbName,userName,password);

                return con;

    }

}