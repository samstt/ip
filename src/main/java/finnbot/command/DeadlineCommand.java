package finnbot.command;

import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.Deadlines;
import java.io.File;

/**
 * Represents a command that adds a deadline task to the task list.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Constructs a DeadlineCommand with the specified task description and deadline.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the deadline task.
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the command by adding a deadline task to the task list,
     * displaying a confirmation message, and saving the updated list to storage.
     *
     * @param tasks The task list where the deadline will be added.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system to save task data.
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        Deadlines deadlineTask = new Deadlines(description, by);
        tasks.addTask(deadlineTask);
        ui.showMessage("Added deadline: ");
        ui.showMessage(String.valueOf(deadlineTask));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
