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
        Project p1 = new Project();
        
        Project p2 = new Project();

        ProjectDB db = new ProjectDB("remoteuser", "password");

        db.write(p1, 2);
        db.write(p2, 2);
        System.out.println("Success, Written Projects to DB");
    }

}
