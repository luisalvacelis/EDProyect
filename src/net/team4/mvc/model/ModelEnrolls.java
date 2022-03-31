package net.team4.mvc.model;

public class ModelEnrolls {
    
    private int id;
    private int idClass;
    private String student;
    private String teacher;
    private String course;
    private String turn;
    private String section;
    private String day;

    public ModelEnrolls(int id, int idClass, String student, String teacher, String course, String turn, String section, String day) {
        this.id = id;
        this.idClass = idClass;
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.turn = turn;
        this.section = section;
        this.day = day;
    }

    public ModelEnrolls(int idClass, String student, String teacher, String course, String turn, String section, String day) {
        this.idClass = idClass;
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.turn = turn;
        this.section = section;
        this.day = day;
    }

    public ModelEnrolls() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
