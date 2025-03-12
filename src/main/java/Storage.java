import java.io.*;

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

    public static void deleteFile() {
        File f = new File(FILEPATH);
        if (f.delete()) {
            System.out.println("File deleted: " + f.getAbsolutePath());
        } else {
            System.out.println("File could not be deleted: " + f.getAbsolutePath());
        }
    }

    public static void saveFile(Tasks[] tasks, File file) {
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


    public static Tasks[] loadFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No save file found! We'll start with a new list!");
            return new Tasks[100];
        }

        Tasks[] tasks = new Tasks[100];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = br.readLine()) != null && index < tasks.length) {
                tasks[index] = parseTask(line);
                index++;
            }
        } catch (IOException e) {
            System.out.println("Error loading file...");
        }
        return tasks;
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





