package tester;

import classes.Version;
import dao.VersionDB;

/**
 * @author Marinus Toman
 *  Date: 24-Mar-2017
 */
public class VersionDBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Version t1 = new Version();
        
        Version t2 = new Version();

        VersionDB db = new VersionDB("remoteuser", "password");

        db.write(t1, 1);
        db.write(t2, 1);
        System.out.println("Success, Written to DB");
    }

}
