package tester;

import classes.Date;
import classes.Resource;
import classes.Task;

/**
 * @author Marinus Toman
 *  Date: 17-Mar-2017
 */
public class TaskTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date d = new Date();
        Task t1 = new Task("Elctrical", "Phase 1", new Date(6,2,2017), 10, Resource.ELECTRICIAN);
        Task t2 = new Task("Plumbing", "Phase 1", d, 5, Resource.PLUMBER);
        Task t3 = new Task(d);
        
        System.out.println(t1.getCost());
        System.out.println(t1.getCalculatedTime());
        System.out.println(t1.getEndDate().toString());
        System.out.println(t1.toString());
        
        t2.assignResource(Resource.LABOURER);
        System.out.println(t2.getCost());
        System.out.println(t2.getCalculatedTime());
        System.out.println(t2.getEndDate().toString());
        System.out.println(t2.toString());

        t3.read();
        System.out.println(t3.toString());
    }

}
