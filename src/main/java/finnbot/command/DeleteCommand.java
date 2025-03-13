package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import java.io.File;

/**
 * Represents a command that deletes a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be deleted.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by deleting a task from the task list,
     * displaying a confirmation message, and saving the updated list to storage.
     *
     * @param tasks The task list from which the task will be deleted.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system to save task data.
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        tasks.deleteTask(taskIndex);
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
