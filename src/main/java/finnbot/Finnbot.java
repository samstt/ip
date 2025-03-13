package finnbot;
import finnbot.command.Command;
import finnbot.exceptions.EmptyInputException;
import finnbot.exceptions.InvalidCommandException;

public class Finnbot {
    private static Ui ui;
    private Storage storage;
    private static TasksList tasks;

    public Finnbot(String filePath) {
        ui = new Ui();
        storage = new Storage();
        tasks = new TasksList(filePath);
    }

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



    public static void main(String[] args) {
       new Finnbot("./data.txt").run();
    }
}
