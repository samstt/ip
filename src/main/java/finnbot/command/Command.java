package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;

/**
 * Represents an abstract command that can be executed by Finnbot.
 * Subclasses should implement the execute method to define specific behaviors.
 */

public abstract class Command {

    /**
     * Executes the command with the given task list, user interface, and storage.
     *
     * @param tasks The list of tasks to operate on.
     * @param ui The user interface for interacting with the user.
     * @param storage The storage handler for reading and writing task data to external file.
     */
    public abstract void execute(TasksList tasks, Ui ui, Storage storage);

    /**
     * Determines whether the command should terminate the program.
     *
     * @return {@code true} if the command terminates the program, {@code false} otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
