import java.util.Locale;
import java.util.Scanner;

public class Finnbot {
    private static final String line = "_*".repeat(60);
    private static String[] tasks = new String[100];
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

    public static void botRespond() {
        Scanner in = new Scanner(System.in);
        String addedItem = "added: ";
        String responses;
        while (true) {
            responses = in.nextLine().trim().toLowerCase();
            if (responses.equals("bye")) {
                break;
            }
            else if (responses.equals("list")) {
                listTasks();
                System.out.println(line);
            }
            else {
                addToList(responses);
                System.out.println(addedItem + responses);
                System.out.println(line);
            }
        }
    }

    // add tasks to list
    public static void addToList(String task){
        tasks[taskNumber] = task;
        taskNumber++;
    }

    public static void listTasks(){
        for (int i = 0; i < taskNumber; i++){
            System.out.println(i+1 + ": " + tasks[i]);
        }
    }


    public static void main(String[] args) {
        greetUser();
        botRespond();
        goodbye();
    }
}
