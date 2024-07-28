import java.util.Date;

public class Task {
    private String taskName;
    private int priority; //1 = High, 2 = Medium, 3 = Low
    private Date dueDate;
    private String category;

    public Task(String name, int priority, Date dueDate, String category) {
        this.taskName = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task: " + taskName + " of priority " + priority + ", due " + dueDate + " in category " + category + ".";
    }
}
