package dbclass.grouptimetablemanagementsystem.timetable;

public class TimetableRequest {
    private String day;
    private int startTime;
    private int endTime;
    private int studentId;

    public TimetableRequest() {}

    public TimetableRequest(String day, int startTime, int endTime, int studentId) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentId = studentId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(final String day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(final int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(final int endTime) {
        this.endTime = endTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(final int studentId) {
        this.studentId = studentId;
    }
}
