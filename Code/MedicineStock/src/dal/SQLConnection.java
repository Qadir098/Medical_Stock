
package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection implements IConnection {

    private String serverName;
    private String dbName;
    private String dbUserName;
    private String dbUserPassword;
    
    SQLConnection(String sName, String dbName, String userId, String userPass) {
        this.serverName = sName;
        this.dbName = dbName;
        this.dbUserName = userId;
        this.dbUserPassword = userPass;
    }
    
    //jdbc:mysql://localhost:3306/

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.dbName, this.dbUserName,this.dbUserPassword);
        }
        catch (Exception e) {
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return null;
    }
    
}
