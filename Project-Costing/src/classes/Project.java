package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marinus Toman
 * Date: 16-Mar-2017
 */
public class Project {
    // Instance Fields
// instance fields
    private int projectID;
    private static int nextProjectID = 1;
    private String name;
    private Date startDate;
    private Date endDate;
    private double cost;
    private double duration;
    private ArrayList<Version> versions = new ArrayList<>();

    public Project() {
        projectID = nextProjectID++;
        name = "";
        startDate = new Date();
        cost = 0;
        duration = 0;
    }

    /**
     * Constructor for project
     *
     * @param name
     * @param startDate
     * @param task
     */
    public Project(String name, Date startDate, Version task) {
        projectID = nextProjectID++;
        this.name = name;
        this.startDate = startDate;
        //endDate = new Date(startDate.getDay(), startDate.getMonth(), startDate.getYear());
        versions.add(task);
        //noOfTasks = 1;
    }

    /**
     * Accessor method for name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator method for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor method for projectID
     *
     * @return
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * Accessor method for startDate
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    public double getDuration() {
        calculateDuration();
        return duration;
    }

    public Date getEndDate() {
        calcEndDate();
        return endDate;
    }

    /**
     * Accessor method for endDate
     *
     * @param version
     */
    public void assignVersion(Version version) {
        versions.add(version);
    }

    public void addVersion() {
        Version version = createVersion();
        versions.add(version);
    }
    
    /**
     * Accessor method for number of versions
     *
     * @return
     */
    public int getNoOfVersions() {
        return versions.size();
    }

    /**
     * Accessor method for cost
     *
     * @return
     */
    public double getCost() {
        calculateCost();
        return cost;
    }

    /**
     * Method to calculate cost
     */
    private void calculateCost() {
        cost = versions.get(versions.size() - 1).getCost();
    }

    public void calculateDuration() {
        duration = versions.get(versions.size() - 1).getDuration();
    }

    private void calcEndDate() {
        // get end date of last task
        endDate = versions.get(versions.size() - 1).getEndDate();
    }

    /**
     *
     */
    public void printVersions() {
        for (Version t : versions) {
            System.out.println(t.toString());
        }
    }
    
    public Version createVersion(){
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        char sentinel;
        Version v = null;
        do{
            try{
               v = new Version();
               v.read();
               System.out.print("Wanna Quit? [Y|N]");
               sentinel = in.nextLine().charAt(0);
               if(sentinel == 'y' || sentinel == 'Y')
                   quit = true;
            }catch(Exception e){
                System.out.println("Exception = " + e.getMessage());
            }
        }while(!quit);
        return v;
    }
//
//    public void read() {
//        Scanner in = new Scanner(System.in);
//        boolean quit = false;
//        char sentinel;
//        Task task;
//        do {
//            try {
//                System.out.println("\tENTER PROJECT DETAILS");
//                System.out.print("ENTER NAME: ");
//                setName(in.nextLine());
//                startDate.read();
//                do {
//                    // if task list is empty, 
//                    // then create task with same start date as project
//                    if (versions.isEmpty()) {
//                        task = new Task(startDate);
//                    } // otherwise create task with start date
//                    // same as end date of last task in list
//                    else {
//                        Date temp = versions.get(versions.size() - 1).getEndDate();
//
//                        task = new Task(temp);
//                    }
//                    task.read();
//                    versions.add(task);
//                    System.out.print("Do you want to add another task? [Y|N] ");
//                    sentinel = in.next().charAt(0);
//                } while (!(sentinel == 'N' || sentinel == 'n'));
//                calculateDuration();
//                calcEndDate();
//                quit = true;
//            } catch (IllegalArgumentException iae) {
//                System.out.println(iae.getMessage());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        } while (!quit);
//    }
}
