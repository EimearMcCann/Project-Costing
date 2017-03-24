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
    public void write(Project project, int customerID) {
        openConnection();
        //createTaskTable();
        if (project != null && customerID > 0) {
            try {
                String startDate = project.getStartDate().toString();
                String endDate = project.getEndDate().toString();
                String query = makeInsertQuery(project.getName(), startDate, endDate, project.getCost(), customerID);
                stmt.executeQuery("USE project_costing;");
                stmt.executeUpdate(query);
                System.out.println("success...written to db");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                closeConnection();
            }
        }
    }
    
    private static String makeInsertQuery(String name, String start, String end, double cost, int customerID) {
        String insert = "INSERT INTO project (Name, Type, Start, End, Cost, CustomerID) "
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
