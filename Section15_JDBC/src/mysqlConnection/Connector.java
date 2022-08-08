package mysqlConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The ideia here is to make a simple Mysql connector. 
 */
public class Connector {
    // A bunch of properties related to the database.
    private final String dbManagSystem;
    private final String serverAdress;
    private String dbName = null;
    private final String port;
    private final String user;
    private final String password;

    /**
     * Connector constructor.
     * @param databaseManagSystem Name of db management system.
     * @param serverAdress Name or ip of server.
     * @param port Number of the port.
     * @param user Username.
     * @param password User password.
     */
    public Connector(String databaseManagSystem,
              String serverAdress, 
              String port,
              String user,
              String password){
            this.dbManagSystem = databaseManagSystem;
            this.serverAdress = serverAdress;
            this.port = port;
            this.user = user;
            this.password = password;
            }

    /**
     * Connector constructor.
     * @param databaseManagSystem Name of db management system.
     * @param serverAdress Name or ip of server.
     * @param port Number of the port.
     * @param user Username.
     * @param password User password.
     * @param dbName The database name.
     */
    public Connector(String databaseManagSystem,
              String serverAdress, 
              String dbName,
              String port,
              String user,
              String password){
            this.dbManagSystem = databaseManagSystem;
            this.serverAdress = serverAdress;
            this.port = port;
            this.user = user;
            this.password = password;
            this.dbName = dbName;
            }
    /**
     * Method for url composition.
     * @return A string with url.
     */
    private String urlConstruct(){
        String url;
        if(!dbName.equals(null)){
            url = "jdbc:"+ dbManagSystem + "://"+ serverAdress +":"+ port +"/"+
            dbName + "?verifyServerCertificate=false&useSSL=true";
        }else{
            url = "jdbc:"+ dbManagSystem + "://"+ serverAdress +":"+ port + 
            "?verifyServerCertificate=false&useSSL=true";
        }
        return url;
    }
    /**
     * Method that returns a JDBC connection.
     * @return An object of the class Connection.
     */
    public Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(this.urlConstruct(), 
                                this.user, this.password);
            return connection;
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
}
