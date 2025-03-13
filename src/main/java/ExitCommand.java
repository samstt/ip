public class ExitCommand extends Command {

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        ui.goodbye();
    }

    public boolean isExit() {
        return true;
    }
}
