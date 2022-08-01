package mysqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException{
        final String url =   "jdbc:mysql://"+ DbParameters.server+":"+ DbParameters.port + 
                            "?verifyServerCertificate=false&useSSL=true";
        Connection connObj = DriverManager.getConnection(url, DbParameters.user, 
                                                            DbParameters.password);
        System.out.println("Connection established.");
        connObj.close();
    }
}
