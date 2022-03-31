package net.team4.mvc.model;

public class ModelCalendar{
    
    private int id;
    private String dni;
    private String course;
    private String turn;
    private String section;
    private String day;
    private String date;

    public ModelCalendar(int id, String dni, String course, String turn, String section, String day, String date) {
        this.id = id;
        this.dni = dni;
        this.course = course;
        this.turn = turn;
        this.section = section;
        this.day = day;
        this.date = date;
    }

    public ModelCalendar(String dni, String course, String turn, String section, String day, String date) {
        this.dni = dni;
        this.course = course;
        this.turn = turn;
        this.section = section;
        this.day = day;
        this.date = date;
    }

    public ModelCalendar(int id) {
        this.id = id;
    }

    public ModelCalendar() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
