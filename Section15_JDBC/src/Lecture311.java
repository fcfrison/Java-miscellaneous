import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
/**
 * Creating table via JDBC.
 */
public class Lecture311 {
    public static void main(String[] args) throws SQLException {
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.dbName,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection();
        Statement stmt = conn.createStatement();
        String sql = """
                CREATE TABLE person(
                    code INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(80) NOT NULL
                );
                """;
        stmt.execute(sql);
        System.out.println("The table was created.");
        conn.close();
    }
}
