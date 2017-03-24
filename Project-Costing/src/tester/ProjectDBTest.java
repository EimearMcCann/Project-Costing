package tester;

import classes.Project;
import dao.ProjectDB;

/**
 * @author Marinus Toman
 *  Date: 24-Mar-2017
 */
public class ProjectDBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Project t1 = new Project();
        
        Project t2 = new Project();

        ProjectDB db = new ProjectDB("remoteuser", "password");

        db.write(t1, 1);
        db.write(t2, 1);
        System.out.println("Success, Written to DB");
    }

}
