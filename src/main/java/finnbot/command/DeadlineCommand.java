package finnbot.command;

import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.Deadlines;
import java.io.File;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        Deadlines deadlineTask = new Deadlines(description, by);
        tasks.addTask(deadlineTask);
        ui.showMessage("Added deadline: ");
        ui.showMessage(String.valueOf(deadlineTask));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
