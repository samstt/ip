package finnbot.tasks;

/**
 * Represents a deadline task in the Finnbot application.
 * A deadline task is a task that has a description and a due date.
 * It extends from the {@link Tasks} class, inheriting common task properties.
 */
public class Deadlines extends Tasks {
    protected String by;

    /**
     * Constructs a new Deadline task with a description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date for the deadline task.
     */
    public Deadlines(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string representation of the deadline task.
     * The format includes the task type, task status, description, and due date.
     *
     * @return A string representing the deadline task, including its description and due date.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by + ")";
    }

    /**
     * Returns a string representation of the deadline task in a format suitable for saving to a file.
     * The format is:
     * "D | [task status] | [description] | [due date]"
     *
     * @return A string representation of the deadline task for file storage.
     */
    @Override
    public String toFileString() {
        return "D | " + (getIsDone() ? "1" : "0") + " | " + description + " | " + by;
    }
}
