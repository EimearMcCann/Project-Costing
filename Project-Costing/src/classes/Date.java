package classes;

import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 * @author Marinus Toman Date: 16-Mar-2017
 */
public class Date {

    // Instance Fields
    private DateTime date;
    private int year, month, day;
    private HashMap<String, DateTime> holidays;

    // Constructors
    public Date() {
        this.holidays = new HashMap();
        this.date = null;
        year = 0;
        month = 0;
        day = 0;
    }

    public Date(int day, int month, int year) {
        this.holidays = new HashMap();
        this.date = new DateTime(year, month, day, 0, 0);
        populateNumbers();
        populateHolidays();
    }

    public Date(int day, int month, int year, int hour, int minute) {
        this.holidays = new HashMap();
        this.date = new DateTime(day, month, year, hour, minute);
        populateNumbers();
        populateHolidays();
    }

    // Methods
    public int getYear() {
        populateNumbers();
        return year;
    }

    public int getMonth() {
        populateNumbers();
        return month;
    }

    public int getDay() {
        populateNumbers();
        return day;
    }

    public void addWorkDay() {
        // if its a public holiday, keep adding
        do {
            // get day of week
            String dayOfWeek = date.dayOfWeek().getAsText();
            // test if its the weekend
            switch (dayOfWeek.toLowerCase()) {
                case "friday":
                    date = date.plusDays(3);
                    break;
                case "saturday":
                    date = date.plusDays(2);
                    break;
                default:
                    date = date.plusDays(1);
                    break;
            }
        } while (holidays.containsValue(date));
    }

    public void read() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        do{
        try {
            year = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Enter the year", "Enter Year", JOptionPane.INFORMATION_MESSAGE));
            month = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Enter the month", "Enter Month", JOptionPane.INFORMATION_MESSAGE));
            day = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Enter the day", "Enter Day", JOptionPane.INFORMATION_MESSAGE));
            valid = true;
        } catch (NumberFormatException nfe) {
            System.out.print("Not a number " + nfe.getMessage());
        } catch (Exception e) {
            System.out.print("Something else went wrong " + e.getMessage());
        }
        }while(!valid);
    }
    
    @Override
    public String toString() {
        int year, month, day;
        year = date.year().get();
        month = date.monthOfYear().get();
        day = date.getDayOfMonth();
        String sqlDateFormat = year + "-"
                + ((month < 10) ? "0" : "") + month + "-"
                + ((day < 10) ? "0" : "") + day;

        return sqlDateFormat;
    }

    private void populateHolidays() {
        populateNumbers();
        // populate hashmap with this year and next year holidays
        holidays.put("New Years Day", new DateTime(year, 1, 1, 0, 0));
        holidays.put("Next New Years Day", new DateTime(year + 1, 1, 1, 0, 0));
        holidays.put("New Years Holiday", new DateTime(year, 1, 2, 0, 0));
        holidays.put("Next New Years Holiday", new DateTime(year + 1, 1, 2, 0, 0));
        holidays.put("St Patricks Day", new DateTime(year, 3, 17, 0, 0));
        holidays.put("Next St Patricks Day", new DateTime(year + 1, 3, 17, 0, 0)); 
        holidays.put("Good Friday", new DateTime(year, 4, 14, 0, 0));
        holidays.put("Next Good Friday", new DateTime(year + 1, 4, 14, 0, 0));
        holidays.put("Easter Monday", new DateTime(year, 4, 17, 0, 0));
        holidays.put("Next Easter Monday", new DateTime(year + 1, 4, 17, 0, 0));
        holidays.put("May Bank Holiday", new DateTime(year, 5, 1, 0, 0));
        holidays.put("Next May Bank Holiday", new DateTime(year + 1, 5, 1, 0, 0));
        holidays.put("June Bank Holiday", new DateTime(year, 6, 5, 0, 0));
        holidays.put("August Bank Holiday", new DateTime(year, 8, 7, 0, 0));
        holidays.put("October Bank Holiday", new DateTime(year, 10, 30, 0, 0));
        holidays.put("Christmas Day", new DateTime(year, 12, 25, 0, 0));
        holidays.put("St Stephens Day", new DateTime(year, 12, 26, 0, 0));
        holidays.put("December Bank Holiday", new DateTime(year, 12, 27, 0, 0));
        
    }
    
    private void populateNumbers(){
        year = date.year().get();
        month = date.monthOfYear().get();
        day = date.dayOfMonth().get();
    }
}
