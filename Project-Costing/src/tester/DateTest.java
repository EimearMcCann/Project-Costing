package tester;

import classes.Date;

/**
 * @author Marinus Toman
 *  Date: 17-Mar-2017
 */
public class DateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date d1 = new Date(2017,3,15,0,0);
        Date d2 = new Date(2017,12,21,0,0);
        
        // print current date
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        
        // add work days
        for(int i = 0; i < 11; i++){
            d1.addWorkDay();
            System.out.println(d1.toString());
        }
        System.out.println("Finished");
        // print new date
        System.out.println(d1.toString());
        System.out.println();
        
        for(int i = 0; i < 11; i++){
            d2.addWorkDay();
            System.out.println(d2.toString());
        }
        System.out.println("Finished");
        // print new date
        System.out.println(d2.toString());
    }

}
