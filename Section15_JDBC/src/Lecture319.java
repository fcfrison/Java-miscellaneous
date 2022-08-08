import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysqlConnection.ConnectorFromProperties;
import person.Person;
/*
 * Instead of creating a Java file for storing the database configuration, 
 * a better aproach is to create an external file with format '.properties' 
 * and load all the data needed to connect with the database using such file.
 * The Java environment has tools for dealing with such type of file (for instance, 
 * there are built-in methods and classes whose purpose is to handle it). 
 */
public class Lecture319 {
    public static void main(String[] args) throws SQLException{
        Connection conn = ConnectorFromProperties.getConnection();//Opening a connection using a '.properties' file. 
        String sql = """
                SELECT * 
                FROM person;
                """;
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        List<Person> lista = new ArrayList<Person>();
        while(result.next()){
            lista.add(new Person(
                        result.getInt("code"),
                        result.getString("name")));
        }
        for (Person person : lista) {
            System.out.println(person);
        }
    }
}
