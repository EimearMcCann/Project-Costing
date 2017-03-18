package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marinus Toman
 * Date: 16-Mar-2017
 */
public class Project {
    // Instance Fields
    private int projectID;
    private static int nextProjectID = 1;
    private String name;
    private Date startDate;
    private Date endDate;
    private double cost;
    private double duration;
    private ArrayList<Version> versions = new ArrayList<>();

    /**
     * Default constructor
     */
    public Project() {
        projectID = nextProjectID++;
        name = "";
        startDate = new Date();
        cost = 0;
        duration = 0;
    }
    
    /**
     * Constructs new Project with name and startDate
     * @param name
     * @param date 
     */
    public Project(String name, String date){
        projectID = nextProjectID++;
        this.name = name;
        startDate = Date.parseDate(date);
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
        versions.add(task);
        endDate = task.getEndDate();
        calculateCost();
        calculateDuration();
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
    
    /**
     * 
     * @param date
     */
    public void setStartDate(String date){
        startDate = Date.parseDate(date);
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
    
    public Version getLastVersion(){
        return versions.get(versions.size() - 1);
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

    private void calculateDuration() {
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
}
