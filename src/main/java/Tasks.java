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


    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }


    public String toString() {
        return getStatusIcon() + description;
    }




}





