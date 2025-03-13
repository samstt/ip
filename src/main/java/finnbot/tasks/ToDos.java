package finnbot.tasks;

/**
 * Represents a To-Do task in the Finnbot application.
 * A To-Do task consists of a description and its completion status.
 */
public class ToDos extends Tasks {

    /**
     * Constructs a new To-Do task with the specified description.
     * The task is initially marked as not done.
     *
     * @param description The description of the To-Do task.
     */
    public ToDos(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the To-Do task, including its status icon and description.
     * The format is:
     * "[T] [status icon]  [description]"
     *
     * @return A string representing the status and description of the To-Do task.
     */
    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + "  " + description;
    }

    /**
     * Returns a string representation of the To-Do task in a format suitable for saving to a file.
     * The format is:
     * "T | [status] | [description]"
     *
     * @return A string representation of the To-Do task for file storage.
     */
    @Override
    public String toFileString() {
        return "T | " + (getIsDone() ? "1" : "0") + " |  " + description;
    }
}
