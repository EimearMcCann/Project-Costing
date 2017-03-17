package classes;

import java.util.ArrayList;

/**
 * @author Marinus Toman Date: 17-Mar-2017
 */
public class Version {

    // Instance Fields
    private final int number;
    private static int nextNumber = 1;
    private String name;
    private Date startDate;
    private Date endDate;
    private double cost;
    private double duration;
    private ArrayList<Task> tasks;

    // Constructors
    public Version(String name) {
        number = nextNumber++;
        this.name = name;
        startDate = new Date();
        duration = 0;
        cost = 0;
        endDate = null;
        tasks = new ArrayList();
    }

    // Methods
    public void addTask(Task t) {
        tasks.add(t);
    }

    public int getNumber() {
        return number;
    }

    public static void setNextNumber(int nextNumber) {
        Version.nextNumber = nextNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getCost() {
        return cost;
    }

    public double getDuration() {
        return duration;
    }
    

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        Task temp = null;
        // test if id is valid
        if (id > 0) {
            // if task list isn't empty
            if (!tasks.isEmpty()) {
                // search for task id
                for (Task t : tasks) {
                    if (t.getTaskID() == id) {
                        temp = t;
                    }
                }
            }
        }
        return temp;
    }
    
    public boolean removeTask(int id){
        boolean removed = false;
        Task temp = getTask(id);
        if(temp != null){
            removed = tasks.remove(temp);
        }
        return removed;
    }
    
    public void printTasks() {
        for (Task t : tasks) {
            System.out.println(t.toString());
        }
    }
}
