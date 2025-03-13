package finnbot.tasks;

/**
 * Represents a generic task in the Finnbot application.
 * The task contains a description and a status indicating whether it is completed or not.
 */
public class Tasks {
    protected String description;
    public boolean isDone;

    /**
     * Constructs a new task with the specified description.
     * The task is initially marked as not done.
     *
     * @param description The description of the task.
     */
    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     * This method sets the {@code isDone} flag to {@code true}.
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Returns the status of the task.
     *
     * @return {@code true} if the task is marked as done, otherwise {@code false}.
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Returns the status icon of the task, which is either "[X]" for completed or "[ ]" for not completed.
     *
     * @return The status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    /**
     * Returns the string representation of the task, including its status icon and description.
     * The format is:
     * "[status icon] [description]"
     *
     * @return A string representing the task's status and description.
     */
    public String toString() {
        return getStatusIcon() + " " + description;
    }

    /**
     * Returns a string representation of the task in a format suitable for saving to a file.
     * This method should be overridden by subclasses to provide task-specific file storage formats.
     *
     * @return A string representation of the task for file storage.
     */
    public String toFileString() {
        return "";
    }

    public String getDescription() {
        return description;
    }
}






