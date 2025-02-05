import java.util.Scanner;

public class Finnbot {
    private static final String line = "_".repeat(60);


    public static void greetUser() {
        String greeting = "Meow! I'm Finnbot!" + System.lineSeparator() + "How can I help you?";
        System.out.println(line);
        System.out.println(greeting);
        System.out.println(line);
    }

    public static void goodbye() {
        String goodbye = "Bye. Hope to see you again soon!";
        System.out.println(goodbye);
        System.out.println(line);
    }

    public static void botRespond() {
        String responses;
        Scanner in = new Scanner(System.in);
        responses = in.nextLine();
        System.out.println(responses);
        System.out.println(line);
    }

    public static void main(String[] args) {
        greetUser();
        botRespond();
        goodbye();
    }
}
