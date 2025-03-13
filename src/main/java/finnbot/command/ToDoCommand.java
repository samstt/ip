package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.ToDos;
import java.io.File;

/**
 * Represents a command that adds a to-do task to the task list.
 */
public class ToDoCommand extends Command {
    private final String description;

    /**
     * Constructs a ToDoCommand with the specified task description.
     *
     * @param description The description of the to-do task.
     */
    public ToDoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by adding a to-do task to the task list,
     * displaying a confirmation message, and saving the updated list to storage.
     *
     * @param tasks The task list where the to-do task will be added.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system to save task data.
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        ToDos todoTask = new ToDos(description);
        tasks.addTask(todoTask);
        ui.showMessage("Added todo task: ");
        ui.showMessage(String.valueOf(todoTask));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
