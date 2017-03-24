package dao;

import classes.Project;
import java.sql.SQLException;

/**
 * @author Marinus Toman Date: 24-Mar-2017
 */
public class ProjectDB extends DBHandler {
    // Instance Fields

    // Constructors
    public ProjectDB(String user, String password) {
        super(user, password);
    }

    // Methods
    public void write(Project version, int customerID) {
        
    }
    
    private static String makeInsertQuery(String name, String start, String end, double cost, int customerID) {
        String insert = "INSERT INTO task (Name, Type, Start, End, Cost, ProjectID, Resources) "
                + "VALUES ('" + name + "', '" + start + "', '"
                + end + "', "  + cost + ", " + customerID + " );";

        return insert;
    }
    
    private void createTaskTable() {
        //create table query
        String createTable = "CREATE TABLE IF NOT EXISTS project "
                + "(ID INTEGER auto_increment not NULL, "
                + " Name VARCHAR(255), "
                + " Start DATE, End DATE, "
                + " Cost double, "
                + " PRIMARY KEY ( ID ), "
                + " CONSTRAINT FOREIGN KEY ( VersionID ) "
                + " REFERENCES version( ID ))";
        //create task table
        try {
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            System.out.println("Table not created. " + e.getMessage());
        }
    }
}
