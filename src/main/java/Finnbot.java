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

    public static void taskMarker(String responses, boolean isMarked) {
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

    public static void todoHandler(String response) {
        try {
            String description = response.replaceFirst("todo", "").trim();
            if (description.isEmpty()) {
                throw new IllegalArgumentException("Todo description is empty, why don't you add something :3");
            }
            Tasks todo = new ToDos(description);
            addToDos(todo.description);
            System.out.println(todo);
            System.out.println(line);
        } catch (IllegalArgumentException e) {
            System.out.println("Uh oh! The description you have given is invalid!");
        }
    }

    public static void deadlineHandler(String response) {
        try {
            String description = response.replaceFirst("deadline", "").trim();
            String[] deadlineParts = description.split("/by");
            String deadlineDescription = deadlineParts[0];
            String by = deadlineParts[1];
            Tasks deadline = new Deadlines(deadlineDescription, by);
            addDeadline(deadline.description, by);
            System.out.println(deadline);
            System.out.println(line);
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Deadline format should be: deadline [description] /by [date], why don't you try it again?");
        }
    }

    public static void eventHandler(String response) {
        try {
            response = response.replaceFirst("events", "");
            String[] parts = response.split("/from|/to");
            String eventDescription = parts[0];
            String start = parts[1];
            String end = parts[2];
            Tasks events = new Events(eventDescription, start, end);
            addEvents(events.description, start, end);
            System.out.println(events);
            System.out.println(line);
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Event format should be: event [description] /from [start] /to [end] , why don't you try again? :3");
        }
    }

    public static void inputValidator (String response) throws EmptyInputException, InvalidCommandException {
        if (response.trim().isEmpty()) {
            throw new EmptyInputException("Uh oh, you didn't type anything in so why don't you add something!");
        }

        String[] validCommands = {"todo", "deadline", "event", "list", "mark", "unmark", "bye"};
        String command = response.split(" ")[0].toLowerCase();

        boolean isValidCommand = false;
        for (String validCommand : validCommands) {
            if (validCommand.equals(command)) {
                isValidCommand = true;
            } else {
                break;
            }
        }

        if (!isValidCommand) {
            throw new InvalidCommandException("Meooow :( I don't think I understand what you mean, input a valid command instead");
        }
    }
    //problem with default handler
    public static void defaultHandler(String response) {
        try {
            inputValidator(response);

        } catch (EmptyInputException | InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void botRespond() {
        Scanner in = new Scanner(System.in);
        String response;

        while (true) {
            response = in.nextLine().trim().toLowerCase();
            System.out.println(line);
            String[] splitResponses = response.split(" ");
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
                taskMarker(response, true);
                break;

            case "unmark":
               taskMarker(response, false);
                break;

            case "todo":
                todoHandler(response);
                break;

            case "deadline":
                deadlineHandler(response);
                break;

            case "event":
                eventHandler(response);
                break;

                default:
                    defaultHandler(response);
                    break;

            }
        }
    }



    public static void main(String[] args) {
        greetUser();
        botRespond();
        goodbye();
    }
}
