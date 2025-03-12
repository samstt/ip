public class Tasks {
    protected String description;
    protected boolean isDone;

    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void setDone() {
        this.isDone = true;
    }

    public boolean getIsDone() {
        return this.isDone;
    }


    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }


    public String toString() {
        return getStatusIcon() + " " + description;
    }

    public String toFileString() {
        return "";
    }

}






