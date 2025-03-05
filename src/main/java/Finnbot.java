import java.util.Scanner;

public class Finnbot {
    private static final String line = "_*".repeat(60);
    private static Tasks[] tasks = new Tasks[100];
    private static int taskNumber = 0;


    public static void greetUser() {
        String greeting = "Meow! I'm Finnbot!" + System.lineSeparator() + "How can I help you?";
        System.out.println(line);
        System.out.println(greeting);
        System.out.println(line);
    }

    public static void goodbye() {
        String goodbye = "Purr.. Hope to see you again soon :3";
        System.out.println(goodbye);
        System.out.println(line);
    }

//initialise new task object and add to existing array of tasks
    public static void addToList(String task) {
        tasks[taskNumber] = new Tasks(task);
        taskNumber++;
    }

    public static void addToDos(String task) {
        tasks[taskNumber] = new ToDos(task);
        taskNumber++;
    }

    public static void addDeadline(String task, String by) {
        tasks[taskNumber] = new Deadlines(task, by);
        taskNumber++;
    }

    public static void addEvents(String task, String startTime, String endTime) {
        tasks[taskNumber] = new Events(task, startTime, endTime);
        taskNumber++;
    }

    public static void listTasks() {
        for (int i = 0; i < taskNumber; i++) {
            System.out.println(i+1 + ". " + tasks[i].toString());
        }
    }

    public static void markOrUnmarkTask(String responses, boolean isMarked) {
        try {
            int taskIndex = Integer.parseInt(responses.split(" ")[1]) - 1;

            if (isMarked) {
                tasks[taskIndex].setDone();
                System.out.println("Meow! I marked this task as done:");
            } else {
                tasks[taskIndex].isDone = false;
                System.out.println("Meow! You unmarked this task:");
            }
            System.out.println(tasks[taskIndex].toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Uh oh! The task number you have given me isn't in the list!");
        } catch (NumberFormatException e) {
            System.out.println("Uh oh! The task number you have given is invalid!");
        } catch (NullPointerException e) {
            System.out.println("There are no tasks in your list yet.. Why don't you add some first");
        }
    }


    public static void botRespond() {
        Scanner in = new Scanner(System.in);
        String addedItem = "added: ";
        String responses;

        while (true) {
            responses = in.nextLine().trim().toLowerCase();
            System.out.println(line);
            String[] splitResponses = responses.split(" ");
            String command = splitResponses[0].toLowerCase();

            switch (command) {
            case "bye":
                return;

            case "list":
                System.out.println("here is your to-do list meow");
                listTasks();
                System.out.println(line);
                break;

            case "mark":
                markOrUnmarkTask(responses, true);
                break;

            case "unmark":
               markOrUnmarkTask(responses, false);
                break;

            case "todo":
                responses = responses.replaceFirst("todo", "");
                Tasks todo = new ToDos(responses);
                addToDos(todo.description);
                System.out.println(todo);
                System.out.println(line);
                break;

            case "deadline":
                responses = responses.replaceFirst("deadline", "");
                String[] deadlineParts = responses.split("/by");
                String deadlineDescription = deadlineParts[0];
                String by = deadlineParts[1];
                Tasks deadline = new Deadlines(deadlineDescription, by);
                addDeadline(deadline.description, by);
                System.out.println(deadline);
                System.out.println(line);
                break;

            case "event":
                responses = responses.replaceFirst("events", "");
                String[] parts = responses.split("/from|/to");
                String eventDescription = parts[0];
                String start = parts[1];
                String end = parts[2];
                Tasks events = new Events(eventDescription, start, end);
                addEvents(events.description, start, end);
                System.out.println(events);
                System.out.println(line);
                break;

                default:
                addToList(responses);
                System.out.println(addedItem + responses);
                System.out.println(line);
            }
        }
    }



    public static void main(String[] args) {
        greetUser();
        botRespond();
        goodbye();
    }
}
