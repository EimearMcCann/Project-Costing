package dao;

import classes.Date;
import classes.Resource;
import classes.Task;
import classes.Version;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Marinus Toman
 * Date: 23-Mar-2017
 */
public class TaskDB extends DBHandler{
    
    
    /**
     * Construct new task db handler
     * @param user
     * @param password 
     */
    public TaskDB(String user, String password) {
        super(user, password);
    }

    /**
     * 
     * @param id
     * @return 
     */
    public Task read(int id) {
        String query = makeSelectTask(id);
        Task t = null;
        try {
            openConnection();
            ResultSet rs = stmt.executeQuery(query);
            Task.setNextID(id);
            rs.next();
            java.sql.Date sqlDate = rs.getDate("Start");
            //Date temp = Date.valueOf(sqlDate.toString());
            //t = new Task(rs.getInt("projectID"), rs.getString("Name"), rs.getString("Type"), temp, rs.getInt("duration"), Resource.APPRENTICE);
        } catch (SQLException e) {
            System.out.println("Problem with SQL.\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return t;
    }

    public void write(Task task, Version version) {
        openConnection();
        //createTaskTable();
        if (task != null && version != null) {
            try {
                String startDate = task.getStartDate().toString();
                String endDate = task.getEndDate().toString();
                String query = makeInsertQuery(task.getName(), task.getTYPE(), startDate, endDate, version.getNumber(), task.getCalculatedTime());
                stmt.executeQuery("USE project_costing;");
                //stmt.executeUpdate(query);
                System.out.println("success...written to db");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //closeConnection();
    }

    private static String makeSelectTask(int id) {
        String select = "SELECT * FROM task WHERE ID = " + id + ";";

        return select;
    }

    private static String makeInsertQuery(String name, String type, String start, String end, int versionID, double duration) {
        String insert = "INSERT INTO task (Name, Type, Start, End, Duration, ProjectID, Resources) "
                + "VALUES ('" + name + "', '" + type + "', '" + start + "', '"
                + end + "', "  + versionID + ", " + duration + " );";

        return insert;
    }

    private void createTaskTable() {
        //create table query
        String createTable = "CREATE TABLE IF NOT EXISTS task "
                + "(ID INTEGER auto_increment not NULL, "
                + " Name VARCHAR(255), "
                + " Type VARCHAR(255), "
                + " Start DATE, End DATE, "
                + " VersionID INTEGER, "
                + " Duration double, "
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
