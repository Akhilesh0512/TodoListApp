import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TodoListApp {
    private ArrayList<String> todoList = new ArrayList<>();
    public void displayList() {
        System.out.println("To-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }
    public void addTask(String task) {
        todoList.add(task);
        System.out.println("Task added: " + task);
    }
    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < todoList.size()) {
            String removedTask = todoList.remove(taskIndex);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index. No task removed.");
        }
    }
    public static void main(String[] args) {
        TodoListApp todoListApp = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        int choice = 2;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display To-Do List");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        todoListApp.displayList();
                        break;
                    case 2:
                        System.out.print("Enter the task to add: ");
                        String taskToAdd = scanner.nextLine();
                        todoListApp.addTask(taskToAdd);
                        break;
                    case 3:
                        System.out.print("Enter the task index to remove: ");
                        if (scanner.hasNextInt()) {
                            int taskIndexToRemove = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            todoListApp.removeTask(taskIndexToRemove - 1); // Adjust for 0-based index
                        } else {
                            System.out.println("Invalid input. Please enter a valid task index.");
                            scanner.nextLine(); // Consume the newline character
                        }
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine(); // Consume the newline character
            }
        } while (choice != 4);
        scanner.close();
    }
    public List<String> getTodoList() {
        return todoList;
    }
}
