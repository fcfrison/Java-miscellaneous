package mysqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorFromProperties {

    public static Connection getConnection(){
        try{
            Properties properties = ConnectorFromProperties.getProperties();
            final String url = properties.getProperty("db.url");
            final String user = properties.getProperty("db.user");
            final String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, user, password);

        } catch(IOException|SQLException e ){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * This static method loads the data from a '.properties' file and 
     * returns an object from the Properties class, which can be used 
     * for load the database sensitive information needed for access.
     * @return An object from the class Properties.
     * @throws IOException
     */
    private static Properties getProperties() throws IOException{ //The Properties class handles .properties files.
        Properties properties = new Properties();
        String path = "/db_conn.properties"; // the path to the chosen file.
        properties.load(ConnectorFromProperties.class.getResourceAsStream(path));// loading the file as a stream
        return properties;
    }

}
