import java.io.File;

public class MarkCommand extends Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        tasks.taskMarker(taskIndex, true);
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }

}
