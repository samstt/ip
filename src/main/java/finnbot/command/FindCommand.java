package finnbot.command;

import finnbot.*;
import finnbot.TasksList;
import finnbot.Ui;
import finnbot.tasks.Tasks;

import java.util.ArrayList;

/**
 * The {@code FindCommand} class allows searching for tasks that contain a specific keyword.
 * It interacts with the {@link TasksList} to find matching tasks and displays them using the UI.
 */
public class FindCommand extends Command {

    private final String keyword;

    /**
     * Constructs a {@code FindCommand} with the specified keyword.
     *
     * @param keyword The keyword to search for in the task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command, searching for tasks that contain the keyword.
     * If matching tasks are found, they are displayed using the provided {@code Ui}.
     * Otherwise, a message indicating no matches are found is displayed.
     *
     * @param tasks   The task list to search.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage component (not used in this method, but included for consistency).
     */
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
