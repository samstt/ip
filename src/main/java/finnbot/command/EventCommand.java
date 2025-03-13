package finnbot.command;

import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.Events;
import java.io.File;

/**
 * Represents a command that adds an event task to the task list.
 */
public class EventCommand extends Command {
    private final String description;
    private final String startTime;
    private final String endTime;

    /**
     * Constructs an EventCommand with the specified task description, start time, and end time.
     *
     * @param description The description of the event task.
     * @param startTime The start time of the event.
     * @param endTime The end time of the event.
     */
    public EventCommand(String description, String startTime, String endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Executes the command by adding an event task to the task list,
     * displaying a confirmation message, and saving the updated list to storage.
     *
     * @param tasks The task list where the event will be added.
     * @param ui The user interface to handle output messages.
     * @param storage The storage system to save task data.
     */
    @Override
    public void execute(TasksList tasks, Ui ui, Storage storage) {
        Events event = new Events(description, startTime, endTime);
        tasks.addTask(event);
        ui.showMessage("Added event:");
        ui.showMessage(String.valueOf(event));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }

}
