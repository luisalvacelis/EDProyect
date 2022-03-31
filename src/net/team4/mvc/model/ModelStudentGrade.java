package net.team4.mvc.model;

public class ModelStudentGrade {
    
    private int id;
    private String dni;
    private String grade;

    public ModelStudentGrade(int id, String dni, String grade) {
        this.id = id;
        this.dni = dni;
        this.grade = grade;
    }

    public ModelStudentGrade(String dni, String grade) {
        this.dni = dni;
        this.grade = grade;
    }

    public ModelStudentGrade() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
