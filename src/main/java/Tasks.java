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
        return (isDone ? "[X] " : "[ ] "); // mark done task with X
    }



}


   /* add tasks to list
    public static void addToList(String task){
        tasks[taskNumber] = task;
        taskNumber++;
    }

    public static void listTasks(){
        for (int i = 0; i < taskNumber; i++){
            System.out.println(i+1 + ": " + tasks[i]);
        }
    }



    */


