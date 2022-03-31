package net.team4.mvc.model;

public class ModelTeacherCourse{
    
    private int id;
    private String dni;
    private String teacher;
    private String course;
    private String date;

    public ModelTeacherCourse(int id, String dni,String teacher, String course,String date) {
        this.id = id;
        this.dni=dni;
        this.teacher = teacher;
        this.course = course;
        this.date = date;
    }

    public ModelTeacherCourse(String dni,String teacher, String course,String date) {
        this.dni=dni;
        this.teacher = teacher;
        this.course = course;
        this.date = date;
    }

    public ModelTeacherCourse(int id) {
        this.id = id;
    }

    public ModelTeacherCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDNI(){
        return dni;
    }
    
    public void setDNI(String dni){
        this.dni=dni;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
