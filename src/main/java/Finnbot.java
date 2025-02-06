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

//
    public static void addToList(String task){
        tasks[taskNumber] = new Tasks(task);
        taskNumber++;
    }

    public static void listTasks(){
        for (int i = 0; i < taskNumber; i++){
            System.out.println(i+1 + ". " + tasks[i].getStatusIcon() + tasks[i].description);
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
                System.out.println(tasks[index].getStatusIcon() + tasks[index].description);
            }
            else if (responses.startsWith("unmark")){
                int index = Integer.parseInt(responses.split(" ")[1]) - 1; //filter out the number in the string
                tasks[index].isDone = false;
                System.out.println("Meow! You unmarked this task:");
                System.out.println(tasks[index].getStatusIcon() + tasks[index].description);
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
