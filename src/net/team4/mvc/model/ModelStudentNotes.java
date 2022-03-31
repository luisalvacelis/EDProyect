package net.team4.mvc.model;

public class ModelStudentNotes {
    
    private int id;
    private String dni;
    private int idClass;
    private double note;
    private String date;

    public ModelStudentNotes(int id, String dni, int idClass, double note,String date) {
        this.id = id;
        this.dni = dni;
        this.idClass = idClass;
        this.note = note;
        this.date=date;
    }

    public ModelStudentNotes(String dni, int idClass, double note,String date) {
        this.dni = dni;
        this.idClass = idClass;
        this.note = note;
        this.date=date;
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

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
