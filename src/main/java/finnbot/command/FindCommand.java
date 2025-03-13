package finnbot.command;

import finnbot.*;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.Tasks;

import java.util.ArrayList;

public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(TasksList tasks, Ui ui, Storage storage) {
        ArrayList<Tasks> matchingTasks = tasks.keywordFinder(keyword);

        if (matchingTasks.isEmpty()) {
            ui.showMessage("Meoww 3: I couldn't find any tasks with that keyword :(");
        } else {
            ui.showMessage("Meowzzers! Here are the matching tasks:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                ui.showMessage((i+1) + ". " + matchingTasks.get(i));
            }
        }
    }
}
