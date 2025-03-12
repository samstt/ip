public class Deadlines extends Tasks {

    protected String by;
    public Deadlines(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (getIsDone() ? "1" : "0") + " |  " + description + " | " + by;
    }
}
