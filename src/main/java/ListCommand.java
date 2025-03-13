public class ListCommand extends Command{

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            ui.showMessage("Meow, you have no tasks in your list!");
        } else {
            ui.showMessage("Here are your tasks:");
            tasks.listTasks();
        }
    }

}

