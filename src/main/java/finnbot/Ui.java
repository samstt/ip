package finnbot;

import java.util.Scanner;

/**
 * Represents the user interface of Finnbot.
 * This class is responsible for interacting with the user, including displaying messages,
 * reading user input, and handling errors.
 */
public class Ui {
    private static final String line = "_*".repeat(60);
    private final Scanner scanner;

    /**
     * Constructs a new Ui object and initializes the scanner.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Greets the user with a welcome message when the program starts.
     */
    public void greetUser() {
        String greeting = "Meow! I'm Finnbot!" + System.lineSeparator() + "How can I help you?";
        System.out.println(line);
        System.out.println(greeting);
    }

    /**
     * Displays a goodbye message when the user exits the program.
     */
    public void goodbye() {
        String goodbye = "Purr.. Hope to see you again soon :3";
        System.out.println(goodbye);
    }

    /**
     * Prints a separator line to format the output.
     */
    public void printLine() {
        System.out.println(line);
    }

    /**
     * Reads the user's input from the console.
     *
     * @return The input string entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a general message to the user.
     *
     * @param message The message to be displayed.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

}
