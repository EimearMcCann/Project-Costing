package classes;

import java.util.ArrayList;

/**
 * @author Marinus Toman Date: 17-Mar-2017
 */
public class Version {

    // Instance Fields
    private final int number;
    private static int nextNumber = 1;
    private ArrayList<Task> tasks;

    // Constructors
    public Version() {
        number = nextNumber++;
        tasks = new ArrayList();
    }

    // Methods
    public void addTask(Task t) {
        tasks.add(t);
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        Task temp = null;
        if (id > 0) {
            // search for task id
            for (Task t : tasks) {
                if (t.getTaskID() == id) {
                    temp = t;
                }
            }
        }
        return temp;
    }
}
