package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;
import java.io.File;

public class DeleteCommand extends Command {

    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        tasks.deleteTask(taskIndex);
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
