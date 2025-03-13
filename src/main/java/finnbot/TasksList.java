package finnbot;

import finnbot.tasks.Tasks;
import java.util.ArrayList;

/**
 * Represents a list of tasks in the Finnbot application.
 * This class provides functionality for managing the tasks list such as adding, deleting, listing tasks,
 * and marking/unmarking tasks as done.
 */
public class TasksList {
    private final ArrayList<Tasks> tasks;

    /**
     * Constructs a new TasksList and loads tasks from a specified file.
     *
     * @param fileName The name of the file from which tasks are loaded.
     */
    public TasksList(String fileName) {
        tasks = Storage.loadFile(fileName);
    }

    /**
     * Adds a new task to the tasks list.
     *
     * @param task The task to be added.
     */
    public void addTask(Tasks task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the tasks list at the specified index.
     * If the index is invalid, a message is displayed indicating the issue.
     *
     * @param taskIndex The index of the task to be deleted.
     */
    public void deleteTask(int taskIndex) {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Uh oh, the task number you have given me is out of bounds");
            return;
        }
        Tasks removedTask = tasks.remove(taskIndex);
        System.out.println("Meow! I've removed this task for you: ");
        System.out.println(removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks");
    }

    /**
     * Lists all tasks in the tasks list, displaying each task's number and details.
     */
    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ". " + tasks.get(i));
        }
    }


    public ArrayList<Tasks> keywordFinder(String keyword) {
        ArrayList<Tasks> matchingTasks = new ArrayList<>();
        String lowerCaseKeyword = keyword.toLowerCase();

        for (Tasks task : tasks) {
            String[] words = task.getDescription().toLowerCase().split("\\s+");
            for (String word : words) {
                if (word.equals(lowerCaseKeyword)) {
                    matchingTasks.add(task);
                    break;
                }
            }
        }
        return matchingTasks;
    }


 /**
     * Returns the number of tasks in the tasks list.
     *
     * @return The size of the tasks list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the list of tasks.
     *
     * @return An ArrayList containing all tasks in the list.
     */
    public ArrayList<Tasks> getTasksList() {
        return tasks;
    }

    /**
     * Marks or unmarks a task as done based on the given index and boolean flag.
     * If the task index is invalid, a message is displayed indicating the issue.
     *
     * @param taskIndex The index of the task to be marked/unmarked.
     * @param isMarked A boolean flag indicating whether the task should be marked or unmarked.
     */
    public void taskMarker (int taskIndex, boolean isMarked) {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Uh oh! The task number you have given me isn't in the list!");
            return;
        }

        Tasks task = tasks.get(taskIndex);

        if (isMarked) {
            task.setDone();
            System.out.println("Meow! I marked this task as done:");
        } else {
            task.isDone = false;
            System.out.println("Meow! You unmarked this task:");
        }

        System.out.println(task);
    }
}
