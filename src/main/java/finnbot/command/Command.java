package finnbot.command;
import finnbot.Storage;
import finnbot.TasksList;
import finnbot.Ui;

public abstract class Command {
    public abstract void execute(TasksList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return false;
    }
}
