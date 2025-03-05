public class Events extends Tasks {

    protected String startTime;
    protected String endTime;

    public Events(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() +"(from:" + startTime + ", to:" + endTime + ")";
    }
}
