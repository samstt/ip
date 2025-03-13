package finnbot;

import java.util.Scanner;

public class Ui {
    private static final String line = "_*".repeat(60);
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }
    public void greetUser() {
        String greeting = "Meow! I'm Finnbot!" + System.lineSeparator() + "How can I help you?";
        System.out.println(line);
        System.out.println(greeting);
    }

    public void goodbye() {
        String goodbye = "Purr.. Hope to see you again soon :3";
        System.out.println(goodbye);
    }

    public void printLine() {
        System.out.println(line);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
