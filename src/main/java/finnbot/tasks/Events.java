package finnbot.tasks;

/**
 * Represents an event task in the Finnbot application.
 * An event task consists of a description, a start time, and an end time.
 */
public class Events extends Tasks {

    protected String startTime;
    protected String endTime;

    /**
     * Constructs a new event task with the specified description, start time, and end time.
     * The task is initially marked as not done.
     *
     * @param description The description of the event.
     * @param startTime The start time of the event.
     * @param endTime The end time of the event.
     */
    public Events(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the string representation of the event, including its status icon, description,
     * start time, and end time.
     * The format is:
     * "[E] [status icon] [description] (from: [start time], to: [end time])"
     *
     * @return A string representing the event's status, description, start time, and end time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +"(from:" + startTime + ", to:" + endTime + ")";
    }

    /**
     * Returns a string representation of the event in a format suitable for saving to a file.
     * The format is:
     * "E | [status] | [description] | [start time]to[end time]"
     *
     * @return A string representation of the event for file storage.
     */
    @Override
    public String toFileString() {
        return "E | " + (getIsDone() ? "1" : "0") + " | " + description + " | " + startTime + "to" + endTime;
    }
}
