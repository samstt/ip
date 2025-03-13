package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.ToDos;

import java.io.File;

public class ToDoCommand extends Command {
    private final String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        ToDos todoTask = new ToDos(description);
        tasks.addTask(todoTask);
        ui.showMessage("Added todo task: ");
        ui.showMessage(String.valueOf(todoTask));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
