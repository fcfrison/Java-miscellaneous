import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;

public class Lecture309 {
    /**
     * Creating a database via JDBC.
     */
    public static void main(String[] args) throws SQLException {
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS java_course");
        System.out.println("The database was created.");
        conn.close();
    }
}
