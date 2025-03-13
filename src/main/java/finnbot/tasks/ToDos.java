package finnbot.tasks;

public class ToDos extends Tasks {

    public ToDos(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + "  " + description;
    }

    public String toFileString() {
        return "T | " + (getIsDone() ? "1" : "0") + " |  " + description;
    }
}
