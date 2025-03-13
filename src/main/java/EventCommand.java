import java.io.File;

public class EventCommand extends Command {
    private final String description;
    private final String startTime;
    private final String endTime;

    public EventCommand(String description, String startTime, String endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        Events event = new Events(description, startTime, endTime);
        tasks.addTask(event);
        ui.showMessage("Added event:");
        ui.showMessage(String.valueOf(event));
        storage.saveFile(tasks, new File(Storage.FILEPATH));
    }

}
