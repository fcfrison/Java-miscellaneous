import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
import person.*;
/*
 * Select data from db.
 */
public class Lecture313Pt2Exercise {
    public static void main(String[] args) throws SQLException{
        Connector connParam = new Connector(
                                DbParameters.dbManagSystem,
                                DbParameters.server,
                                DbParameters.dbName,
                                DbParameters.port,
                                DbParameters.user,
                                DbParameters.password
                                );
        Connection conn = connParam.getConnection();
        List<Person> lst = new ArrayList<Person>();
        String sql = """
                SELECT *
                FROM person
                WHERE name LIKE ?
                """;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "F%");
        //ResultSet result = stmt.executeQuery(sql);
        ResultSet result = stmt.executeQuery();
 
        while(result.next()){
            int code = result.getInt("code");
            String name = result.getString("name");
            lst.add(new Person(code,name));
        }
        for (Person person : lst) {
            System.out.println(person);
        }
        conn.close();
        
    }
}
