package finnbot;

import finnbot.tasks.Tasks;

import java.util.ArrayList;
import java.util.List;


public class TasksList {
    private final ArrayList<Tasks> tasks;

    public TasksList(String fileName) {
        tasks = Storage.loadFile(fileName);
    }

    public void addTask(Tasks task) {
        tasks.add(task);
    }


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

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ". " + tasks.get(i));
        }
    }


    public int size() {
        return tasks.size();
    }

    public ArrayList<Tasks> getTasksList() {
        return tasks;
    }

    public void fileToTaskLoader() {
        List<Tasks> loadedTasks = Storage.loadFile("./data.txt");
        tasks.addAll(loadedTasks);
    }

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
