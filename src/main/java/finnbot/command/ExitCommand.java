package finnbot.command;

import finnbot.*;

/**
 * Represents a command that exits the program.
 */
public class ExitCommand extends Command {

    /**
     * Executes the command by displaying a goodbye message.
     *
     * @param tasks The task list (not used in this command).
     * @param ui The user interface to handle output messages.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        ui.goodbye();
    }

    /**
     * Returns true to indicate that this command will terminate the program.
     *
     * @return true, since this command exits the program.
     */
    public boolean isExit() {
        return true;
    }
}
