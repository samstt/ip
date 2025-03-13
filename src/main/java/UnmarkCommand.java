import java.io.File;

public class UnmarkCommand extends Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        tasks.taskMarker(taskIndex, false);
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }
}
