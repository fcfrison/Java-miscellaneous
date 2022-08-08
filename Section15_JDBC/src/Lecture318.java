import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
/**
 * Delete data from db.
 */
public class Lecture318 {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String id, SQL;
        Integer count;
        System.out.println("Type the id of the person to be deleted: ");
        id = sc.nextLine();
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.dbName,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection();
        SQL = """
                DELETE FROM person 
                WHERE code = ?
                """;
        PreparedStatement stmt = conn.prepareStatement(SQL);
        stmt.setString(1, id);
        count = stmt.executeUpdate();//execute query and return the number of affected rows.
        if(count>0){
            System.out.printf("number affected rows = %d",count);
        }else{
            System.out.println("No rows were affected.");
        }
        sc.close();
    }
}
