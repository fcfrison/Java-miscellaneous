import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysqlConnection.Connector;
import mysqlConnection.DbParameters;
import Person.Person;

/**
 * It's possible to query the data on the 'person' table and register it on an Person
 * object.
 */
public class Lecture313Pt1 {
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
        String sql = """
                SELECT * FROM 
                person;
                """;
        Statement stmt = conn.createStatement(); //instantiating a statement object.
        ResultSet result = stmt.executeQuery(sql); // executing query.
        List<Person> lst = new ArrayList<Person>();
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
