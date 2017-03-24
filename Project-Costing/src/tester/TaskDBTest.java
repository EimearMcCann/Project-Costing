package tester;

import classes.Resource;
import classes.Task;
import dao.TaskDB;

/**
 * @author Marinus Toman Date: 24-Mar-2017
 */
public class TaskDBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Task t1 = new Task("Painting", "Decor", "2017-04-03", 6, "PAINTER");
        t1.assignResource(Resource.LABOURER);
        
        Task t2 = new Task("Carpeting", "Decor", t1.getEndDate().toString(), 7, Resource.LABOURER);

        TaskDB db = new TaskDB("remoteuser", "password");

        db.write(t1, 1);
        db.write(t2, 1);
        System.out.println("Success, Written to DB");
    }

}
