import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final String FILEPATH = "./data.txt";

    public static void createFile() {
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


    public static void saveFile(List<Tasks> tasks, File file) {
        try {BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Tasks task : tasks) {
                if (task != null) {
                    bw.write(task.toFileString() + System.lineSeparator());
                }
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error saving file: ");
        }
    }


    public static List<Tasks> loadFile(String filename) {
        File file = new File(filename);
        List<Tasks> tasksList = new ArrayList<>();
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
            task = new Events(description, parts[2], parts[3]);
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





