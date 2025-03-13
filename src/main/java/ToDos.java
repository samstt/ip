public class ToDos extends Tasks {
    //constructor for ToDos class
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
