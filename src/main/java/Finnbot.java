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
    public static void addToList(String task){
        tasks[taskNumber] = new Tasks(task);
        taskNumber++;
    }

    public static void addToDos(String task){
        tasks[taskNumber] = new ToDos(task);
        taskNumber++;
    }

    public static void addDeadline(String task, String by){
        tasks[taskNumber] = new Deadlines(task, by);
        taskNumber++;
    }

    public static void addEvents(String task, String startTime, String endTime){
        tasks[taskNumber] = new Events(task, startTime, endTime);
        taskNumber++;
    }




    // list tasks
    public static void listTasks(){
        for (int i = 0; i < taskNumber; i++){
            System.out.println(i+1 + ". " + tasks[i].toString());
        }
    }

   // public static void markTask(int index)

    public static void botRespond() {
        Scanner in = new Scanner(System.in);
        String addedItem = "added: ";
        String responses;
        while (true) {
            responses = in.nextLine().trim().toLowerCase();
            System.out.println(line);
            if (responses.equals("bye")) {
                break;
            }
            else if (responses.equals("list")) {
                System.out.println("here is your to-do list meow");
                listTasks();
                System.out.println(line);
            }
            else if (responses.startsWith("mark")){
                int index = Integer.parseInt(responses.split(" ")[1]) - 1; //filter out the number in the string
                tasks[index].setDone();
                System.out.println("Meow! I marked this task as done:");
                System.out.println(tasks[index].toString());
            }
            else if (responses.startsWith("unmark")){
                int index = Integer.parseInt(responses.split(" ")[1]) - 1; //filter out the number in the string
                tasks[index].isDone = false;
                System.out.println("Meow! You unmarked this task:");
                System.out.println(tasks[index].toString());
            }
            else if (responses.startsWith("todo")) {
                responses = responses.replaceFirst("todo", "");
                Tasks todo = new ToDos(responses);
                addToDos(todo.description);
                System.out.println(todo);
                System.out.println(line);
            }
            else if (responses.startsWith("deadline")) {
                responses = responses.replaceFirst("deadline", "");
                String[] parts = responses.split("/by");
                responses = parts[0];
                String by = parts[1];
                Tasks deadline = new Deadlines(responses, by);
                addDeadline(deadline.description, by);
                System.out.println(deadline);
                System.out.println(line);
            }
            // bug in events
            else if (responses.startsWith("event")) {
                responses = responses.replaceFirst("Events", "");
                String[] parts = responses.split("/from|/to");
                responses = parts[0];
                String start = parts[1];
                String end = parts[2];
                Tasks events = new Events(responses, start, end);
                addEvents(events.description, start, end);
                System.out.println(events);
                System.out.println(line);
            }
            else {
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
