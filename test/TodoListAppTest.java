import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.Assert.*;
public class TodoListAppTest {
    private TodoListApp todoListApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    public void setUp() {
        todoListApp = new TodoListApp();
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testAddTask() {
        todoListApp.addTask("Buy groceries");
        List<String> todoList = todoListApp.getTodoList();
        assertTrue(todoList.contains("Buy groceries"));
    }
    @Test
    public void testRemoveTask() {
        todoListApp.addTask("Buy groceries");
        todoListApp.removeTask(0);
        List<String> todoList = todoListApp.getTodoList();
        assertFalse(todoList.contains("Buy groceries"));
    }
    @Test
    public void testDisplayList() {
        TodoListApp todoListApp = new TodoListApp();

        todoListApp.addTask("Task 1");
        todoListApp.addTask("Task 2");
        todoListApp.addTask("Task 3");
        String expectedOutput = "This is not the expected output";
        todoListApp.displayList();
        String printedContent = "To-Do List:\n1. Task 1\n2. Task 2\n3. Task 3";
    }
}




