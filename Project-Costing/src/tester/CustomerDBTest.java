package tester;

import classes.Customer;
import dao.CustomerDB;

/**
 * @author Marinus Toman Date: 17-Mar-2017
 */
public class CustomerDBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer c = new Customer();
        CustomerDB db = new CustomerDB("remoteuser", "password");

        c.read();
        db.write(c);
        System.out.println("Success, Written to DB");
        
        Customer c1 = new Customer();
        c1.read();
        db.update(c1, 6);

        Customer c2 = db.read(6);
        System.out.println("Reading from DB");
        if (c2 != null) {
            System.out.println(c2.toString());
        }

    }

}
