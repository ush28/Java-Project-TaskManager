import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        boolean isRunning = true;

        while(isRunning == true) {
            System.out.println("Welcome to the Task Manager!");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. View Tasks by Priority");
            System.out.println("6. View Tasks by Due Date");
            System.out.println("7. Search For A Task");
            System.out.println("8. Search For A Category");
            System.out.println("9. Exit");
            System.out.println("Please select an option");
            int menuOption = input.nextInt();
            input.nextLine();

            switch (menuOption) {
                case 1:
                    System.out.println("Enter the task description:");
                    String description = input.nextLine();
                    System.out.println("Enter priority (1 = High, 2 = Medium, 3 = Low)");
                    int priority = 0;
                    while (priority == 0) {
                        if (input.hasNextInt()) {
                            int inputNum = input.nextInt();
                            if (inputNum >= 1 && inputNum <= 3) {
                                priority = inputNum;
                                break;
                            } else {
                                System.out.println("Invalid priority number. Choose between 1 and 3!");
                            }
                        } else {
                            System.out.println("This is not a number! Choose between 1 and 3!");
                            input.next();
                        }
                    }
                    input.nextLine();
                    System.out.println("Enter due date (dd/mm/yyyy hh:mm)");
                    String dueDateString = input.nextLine();
                    Date dueDate = null;
                    try {
                        dueDate = dateFormat.parse(dueDateString);
                    } catch (Exception e) {
                        System.out.println("Date entered incorrectly!");
                        break;
                    }
                    System.out.println("Enter category:");
                    String category = input.nextLine();
                    Task task = new Task(description, priority, dueDate, category);
                    taskManager.addTask(task);
                    break;
                case 2:
                    taskManager.printAllTasks();
                    System.out.println("Enter task index to update:");
                    int indexToUpdate = input.nextInt();
                    if (indexToUpdate >= 0 && indexToUpdate < taskManager.getSize()) {
                        input.nextLine();
                        System.out.println("Enter a new description");
                        String newDescription = input.nextLine();
                        System.out.println("Enter priority (1 = High, 2 = Medium, 3 = Low)");
                        int newPriority = 0;
                        while (newPriority == 0) {
                            if (input.hasNextInt()) {
                                int changedInput = input.nextInt();
                                if (changedInput >= 1 && changedInput <= 3) {
                                    newPriority = changedInput;
                                    break;
                                } else {
                                    System.out.println("Invalid priority number. Choose between 1 and 3!");
                                }
                            } else {
                                System.out.println("This is not a number! Choose between 1 and 3!");
                                input.next();
                            }
                        }
                        input.nextLine();
                        System.out.println("Enter due date (dd/mm/yyyy hh:mm)");
                        String newDueDateString = input.nextLine();
                        Date newDueDate = null;
                        try {
                            newDueDate = dateFormat.parse(newDueDateString);
                        } catch (Exception e) {
                            System.out.println("Date entered incorrectly!");
                            break;
                        }
                        System.out.println("Enter category:");
                        String newCategory = input.nextLine();
                        Task updatedTask = new Task(newDescription, newPriority, newDueDate, newCategory);
                        taskManager.updateTask(indexToUpdate, updatedTask);
                    }
                    else {
                        System.out.println("Invalid index number!");
                    }
                    break;
                case 3:
                    taskManager.printAllTasks();
                    System.out.println("Enter task index to delete, or input -1 to exit the delete module: ");
                    int indexToDelete = input.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < taskManager.getSize()) {
                        taskManager.removeTask(indexToDelete);
                        System.out.println("Task deleted.");
                    }
                    else if (indexToDelete == -1) {
                        break;
                    }
                    else {
                        System.out.println("Invalid index number!");
                        break;
                    }
                case 4:
                    System.out.println("Printing all tasks:");
                    taskManager.printAllTasks();
                    break;
                case 5:
                    System.out.println("Printing tasks by priority:");
                    taskManager.printByPriority();
                    break;
                case 6:
                    System.out.println("Printing tasks by due date:");
                    taskManager.printByDueDate();
                    break;
                case 7:
                    System.out.println("Please input the name of the task you want to search for:");
                    String searchDesc = input.nextLine();
                    taskManager.searchForDescription(searchDesc);
                    break;
                case 8:
                    System.out.println("Please input the category of tasks you'd like to search for:");
                    String searchCat = input.nextLine();
                    taskManager.searchForCategory(searchCat);
                    break;
                case 9:
                    System.out.println("Exiting task manager!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("This is not an option!");
                    break;
            }
        }

    }
}
