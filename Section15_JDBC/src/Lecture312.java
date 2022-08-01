import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
/*
 * Insert data into database via JDBC.
 */
public class Lecture312 {
    public static void main(String[] args) throws SQLException {
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.dbName,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection(); //opening the connection.
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your name: ");
        String name = sc.nextLine();
        String sql = "INSERT INTO person (name) VALUES (?)";//the '?' symbol is the parameters to be replaced.
        //One way to avoid a SQL injection attack is to use the method prepareStatement.
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name); // we have just one parameter.
        stmt.execute();
        System.out.println("Your name was registered.");
        conn.close();
        sc.close();
    }
}
