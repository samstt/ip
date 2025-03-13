package finnbot.command;

import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;

/**
 * Represents a command that lists all tasks in the task list.
 */
public class ListCommand extends Command{

    /**
     * Executes the command by displaying all tasks in the task list.
     * If the list is empty, it notifies the user.
     *
     * @param tasks The task list to be displayed.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            ui.showMessage("Meow, you have no tasks in your list!");
        } else {
            ui.showMessage("Here are your tasks:");
            tasks.listTasks();
        }
    }

}

