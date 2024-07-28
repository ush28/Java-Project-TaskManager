import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(int index, Task task) {
        if (0 <= index && index < tasks.size()) {
            tasks.set(index, task);
        }
    }

    public void removeTask(int index) {
        if (0 <= index && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void printAtIndex(int index) {
        if (0 <= index && index < tasks.size()) {
            System.out.println(tasks.get(index));
        }
        System.out.println("\n");
    }

    public void printAllTasks() {
        for (int i = 0; i < tasks.size(); ++i) {
            System.out.println("At index " + i + ": ");
            System.out.println(tasks.get(i));
        }
        System.out.println("\n");
    }


    public void printByPriority() {
        System.out.println("High Priority Tasks:");
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getPriority() == 1) {
                System.out.println("At index " + i + ": ");
                System.out.println(tasks.get(i));
            }
        }
        System.out.println("\n");
        System.out.println("Medium Priority Tasks:");
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getPriority() == 2) {
                System.out.println("At index " + i + ": ");
                System.out.println(tasks.get(i));
            }
        }
        System.out.println("\n");
        System.out.println("Low Priority Tasks:");
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getPriority() == 3) {
                System.out.println("At index " + i + ": ");
                System.out.println(tasks.get(i));
            }
        }
        System.out.println("\n");
    }

    public void printByDueDate() {
        List<Task> cloneList = new ArrayList<>(tasks);
        //bubble sorting, easier to just use the builtin Date comparison methods
        int n = cloneList.size();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - j; ++j) {
                if(cloneList.get(j).getDueDate().after(cloneList.get(j+1).getDueDate())) {
                    Task temp = cloneList.get(j);
                    cloneList.set(j, cloneList.get(j+1));
                    cloneList.set(j+1, temp);
                }
            }
        }

        for (Task i : cloneList) {
            System.out.println(i);
        }
        System.out.println("\n");
    }

    public void searchForDescription(String searchStr) {
        boolean isFound = false;
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getTaskName().equals(searchStr)) {
                System.out.println("Task found!");
                System.out.println("At index " + i + ":");
                System.out.println(tasks.get(i));
                isFound = true;
            }
        }
        if (isFound == false) {
            System.out.println("Task was not found");
        }
        System.out.println("\n");
    }

    public void searchForCategory(String searchCat) {
        boolean catFound = false;
        System.out.println("Tasks under the category '" + searchCat + "':");
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getCategory().equals(searchCat)) {
                catFound = true;
                System.out.println("At index " + i + ":");
                System.out.println(tasks.get(i));
            }
        }
        if (catFound == false) {
            System.out.println("No tasks exist under category '" + searchCat + "'.");
        }
        System.out.println("\n");
    }

    public int getSize() {
        return tasks.size();
    }

}
