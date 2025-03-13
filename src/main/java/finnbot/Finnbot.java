package finnbot;
import finnbot.command.Command;
import finnbot.exceptions.EmptyInputException;
import finnbot.exceptions.InvalidCommandException;

/**
 * Represents the main logic of the Finnbot application.
 * This class handles the initialization of components, the execution of commands, and the
 * interaction with the user through the command-line interface.
 * The bot processes user inputs and performs actions based on parsed commands.
 */
public class Finnbot {
    private static Ui ui;
    private Storage storage;
    private static TasksList tasks;

    /**
     * Constructs a {@code Finnbot} instance with the specified file path.
     * Initializes the user interface, storage, and task list.
     *
     * @param filePath The file path where the tasks are stored.
     */
    public Finnbot(String filePath) {
        ui = new Ui();
        storage = new Storage();
        tasks = new TasksList(filePath);
    }

    /**
     * Starts the main loop of the Finnbot application.
     * Greets the user, continuously reads and processes commands,
     * executes tasks, and handles errors.
     * The loop continues until an exit condition is met.
     */
    public void run() {
        ui.greetUser();
        ui.printLine();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.printLine();
                Command c = Parser.parse(fullCommand);

                c.execute(tasks, ui, storage);
                isExit = c.isExit();

            } catch (ArrayIndexOutOfBoundsException e) {
                ui.showError("The given number is not within bounds meoww :3");
            } catch (NumberFormatException e) {
                ui.showError("Purr please try again");
            } catch (IndexOutOfBoundsException e) {
                ui.showError("HISSSS, you've given me an invalid command");
            } catch (InvalidCommandException | EmptyInputException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.printLine();
            }
        }
    }

    /**
     * The entry point for running the Finnbot application.
     * Initializes the Finnbot instance and begins its execution.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
       new Finnbot("./data.txt").run();
    }
}
