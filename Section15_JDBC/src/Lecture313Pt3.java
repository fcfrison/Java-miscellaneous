import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
import person.*;
public class Lecture313Pt3 {
    
    /**
     * The exercise consists in update data in the db. 
     */
    public static void main(String[] args) throws SQLException{
        Person person_;
        String SQL;
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the id of the person: ");
        String aux = sc.nextLine();
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.dbName,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection();
        SQL =   """
                SELECT * FROM person
                WHERE code = ?
                """;
        PreparedStatement stmt = conn.prepareStatement(SQL);
        stmt.setString(1,aux);
        ResultSet result = stmt.executeQuery();
        if(result.next()){
            person_ = new Person(result.getInt("code"), 
                                    result.getString("name"));
            System.out.println(person_);
        }else{
            System.out.println("Sorry, the user id was not found.");
            sc.close();
            stmt.close();
            conn.close();
            return;
        }
        System.out.println("Type the new name of the person:");
        aux = sc.nextLine();
        SQL = """
                UPDATE 
                    person
                SET
                    name = ?
                WHERE 
                    code = ?
                """;
        stmt.close();
        stmt = conn.prepareStatement(SQL);
        stmt.setString(1,aux);
        stmt.setInt(2,person_.getCode());
        stmt.executeUpdate();
        sc.close();
        conn.close();
        System.out.printf("The name was updated to %s.",aux);
    }
}
