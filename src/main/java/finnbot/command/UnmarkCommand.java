package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;

import java.io.File;

/**
 * Represents a command that marks a task as undone in the task list.
 */
public class UnmarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a UnmarkCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be marked as undone.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by marking a task as undone in the task list,
     * displaying a confirmation message, and saving the updated list to storage.
     *
     * @param tasks The task list where the task will be marked as undone.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system to save task data.
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        tasks.taskMarker(taskIndex, false);
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
