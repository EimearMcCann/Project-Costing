package dao;

import classes.Version;

/**
 * @author Marinus Toman
 * Date: 24-Mar-2017
 */
public class VersionDB extends DBHandler{
    // Instance Fields

    // Constructors
    public VersionDB(String user, String password){
        super(user, password);
    }

    // Methods
    
    public void write(Version version, int projectID){
        
    }
}
