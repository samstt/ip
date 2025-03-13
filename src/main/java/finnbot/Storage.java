package finnbot;

import finnbot.tasks.Events;
import finnbot.tasks.Tasks;
import finnbot.tasks.ToDos;
import finnbot.tasks.Deadlines;
import java.io.*;
import java.util.ArrayList;

/**
 * Represents a storage system for saving and loading tasks in the Finnbot application.
 * This class handles the creation of the save file, reading tasks from it, and writing tasks back into the file.
 * The tasks are stored in a file formatted as plain text.
 */
public class Storage {
    public static final String FILEPATH = "./data.txt";

    /**
     * Constructs a new Storage object and creates a new file at the specified location if it doesn't exist.
     * Prints a message indicating the file's creation status.
     */
    public Storage() {
        try {
            File f = new File(FILEPATH);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + f.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: ");
        }
    }

    /**
     * Saves the current list of tasks to a specified file.
     * Writes each task's details to the file in a specific format.
     *
     * @param tasks The list of tasks to save.
     * @param file The file to which the tasks will be written.
     */
    public static void saveFile(TasksList tasks, File file) {
        try {BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Tasks task : tasks.getTasksList()) {
                if (task != null) {
                    bw.write(task.toFileString() + System.lineSeparator());
                }
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error saving file: ");
        }
    }

    /**
     * Loads tasks from a file and returns them as an ArrayList.
     * If the file does not exist, an empty task list is returned.
     *
     * @param filename The name of the file to load tasks from.
     * @return An ArrayList containing the tasks loaded from the file.
     */
    public static ArrayList<Tasks> loadFile(String filename) {
        File file = new File(filename);
        ArrayList<Tasks> tasksList = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("No save file found! We'll start with a new list!");
            return tasksList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasksList.add(parseTask(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading file...");
        }
        return tasksList;
    }


    /**
     * Parses a line from the saved file into a task object.
     * Determines the task type (ToDos, Deadline, Event) based on the format in the file.
     *
     * @param line The line representing a task in the file.
     * @return A Tasks object representing the parsed task.
     * @throws IllegalArgumentException If the task format is invalid.
     */
    private static Tasks parseTask(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length <= 2 ) {
            throw new IllegalArgumentException("Invalid task format: " + line);
        }

        String taskType = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];
        Tasks task;

        switch (taskType) {
        case "T":
            task = new ToDos(description);
            break;

        case "D":
            task = new Deadlines(description, parts[3]);
            break;

        case "E":
            String[] splitTimes = parts[3].split("to");
            String startTime = splitTimes[0];
            String endTime = splitTimes[1];
            task = new Events(description, startTime, endTime);
            break;

        default:
            throw new IllegalArgumentException("Invalid task type: " + taskType);
        }

        if(isDone) {
            task.setDone();
        }

        return task;
    }
}





