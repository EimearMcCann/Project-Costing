package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marinus Toman
 * Date: 17-Mar-2017
 */
public class Task {
    // Instance Fields
    private final int taskID;
    private static int nextTaskID = 1;
    private Date startDate;
    private Date endDate;
    private String name;
    private String type;
    private double cost;
    private double totalDuration;
    private double calculatedTime;
    private ArrayList<Resource> resourcesAssigned;

    public Task(){
        taskID = nextTaskID++;
        name = null;
        type = null;
        cost = 0;
        totalDuration = 0;
        calculatedTime = 0;
        resourcesAssigned = new ArrayList();
    }
    
    public Task(Date start) {
        taskID = nextTaskID++;
        startDate = start;
        name = "";
        type = "";
        totalDuration = 0;
        resourcesAssigned = new ArrayList<>();
    }

    /**
     * @param name
     * @param type
     * @param startDate
     * @param duration
     * @param resource
     *
     */
    public Task(String name, String type, Date startDate, int duration, Resource resource) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        //endDate = new Date(startDate.getDay(), startDate.getMonth(), startDate.getYear());
        this.totalDuration = duration;
        resourcesAssigned = new ArrayList<>();
        resourcesAssigned.add(resource);
        taskID = nextTaskID++;
        //this.previous = previous;
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
     * Accessor method for duration
     *
     * @return
     */
    public double getDuration() {
        return totalDuration;
    }

    public void setDuration(double duration) {
        this.totalDuration = duration;
    }
    
    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate() {
        calcTime();
        endDate = new Date(startDate.getDay(), startDate.getMonth(), startDate.getYear());
        for (int i = 1; i < calculatedTime; i++) {
            endDate.addWorkDay();
        }
        return endDate;
    }

    public double getCalculatedTime() {
        calcTime();
        return calculatedTime;
    }

    /**
     * Mutator method for employee list
     *
     * @param resourcesAssigned
     *
     */
    public void setResourcesAssigned(ArrayList<Resource> resourcesAssigned) {
        this.resourcesAssigned = resourcesAssigned;
    }

    /**
     * Accessor method for resource list
     *
     * @return resourcesAssigned
     */
    public ArrayList<Resource> getResourcesAssigned() {
        return this.resourcesAssigned;
    }

    /**
     * Accessor method for task ID
     *
     * @return
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * Accessor method for task type
     *
     * @return
     */
    public String getTYPE() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
     * Method to assign resource to task
     *
     * @param resource Resource to assign
     */
    public void assignResource(Resource resource) {
        resourcesAssigned.add(resource);
    }

    /**
     * Method to calculate total cost of task
     */
    private void calculateCost() {
        cost = 0;
        for (Resource r : resourcesAssigned) {
            // calculate price of each resource per day
            cost += r.getPrice();
        }
        // calculate total cost of whole task
        cost = cost * getCalculatedTime();
    }

    private void calcTime() {
        calculatedTime = totalDuration / resourcesAssigned.size();
    }

    /**
     * toString method
     *
     * @return
     */

    public void read() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        char sentinel;
        Resource resource;
        String res;
        do {
            try {
                System.out.println("\tENTER TASK");
                System.out.print("ENTER NAME: ");
                setName(in.nextLine());
                System.out.print("ENTER TYPE: ");
                setType(in.nextLine());
                System.out.print("ENTER DURATION: ");
                setDuration(Double.parseDouble(in.nextLine()));
                do {
                    System.out.print("ENTER RESOURCE: ");
                    res = in.next();
                    switch (res.toLowerCase()) {
                        case "plumber":
                            resource = Resource.PLUMBER;
                            break;
                        case "electrician":
                            resource = Resource.ELECTRICIAN;
                            break;
                        case "carpenter":
                            resource = Resource.CARPENTER;
                            break;
                        case "mason":
                            resource = Resource.MASON;
                            break;
                        case "landscaper":
                            resource = Resource.LANDSCAPER;
                            break;
                        case "glazier":
                            resource = Resource.GLAZIER;
                            break;
                        case "labourer":
                            resource = Resource.LABOURER;
                            break;
                        case "painter":
                            resource = Resource.PAINTER;
                            break;
                        case "plant":
                            resource = Resource.PLANT;
                            break;
                        case "plasterer":
                            resource = Resource.PLASTERER;
                            break;
                        default:
                            resource = Resource.APPRENTICE;
                    }
                    resourcesAssigned.add(resource);
                    System.out.print("Do you want to add another resource? [Y|N] ");
                    sentinel = in.next().charAt(0);
                } while (!(sentinel == 'N' || sentinel == 'n'));
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter an integer value!!!");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valid);
    }

    public static void setNextID(int id){
        nextTaskID = id;
    }
    
    public int getResources(){
        if(!resourcesAssigned.isEmpty())
            return resourcesAssigned.size();
        return -1;
    }

    @Override
    public String toString() {
        return "Task{" + "taskID=" + taskID + ", startDate=" + startDate + ", endDate=" + endDate + ", name=" + name + ", type=" + type + ", cost=" + cost + ", totalDuration=" + totalDuration + ", calculatedTime=" + calculatedTime + ", resourcesAssigned=" + resourcesAssigned + '}';
    }
    
}
