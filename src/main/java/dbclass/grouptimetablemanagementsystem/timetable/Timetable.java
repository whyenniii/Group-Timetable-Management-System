package dbclass.grouptimetablemanagementsystem.timetable;

public class Timetable {
    private Long id;
    private int week;
    private String day;
    private int startTime;
    private int endTime;
    private int studentId;


    public Timetable(final int week, final String day, final int startTime, final int endTime, final int studentId) {
        this.week = week;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentId = studentId;
    }

    public Timetable(final Long id, final int week, final String day, final int startTime, final int endTime, final int studentId) {
        this.id = id;
        this.week = week;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(final int week) {
        this.week = week;
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

    @Override
    public String toString() {
        return "Timetable { " +
                "id = " + id +
                ", week = " + week +
                ", day = " + day + '\'' +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                ", studentId = " + studentId +
                " }";
    }

}
