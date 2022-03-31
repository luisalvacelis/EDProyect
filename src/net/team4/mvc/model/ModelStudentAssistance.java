package net.team4.mvc.model;

public class ModelStudentAssistance {
    
    private int id;
    private String dni;
    private int idClase;
    private String dia;
    private String fecha;

    public ModelStudentAssistance(int id, String dni, int idClase, String dia, String fecha) {
        this.id = id;
        this.dni = dni;
        this.idClase = idClase;
        this.dia = dia;
        this.fecha = fecha;
    }

    public ModelStudentAssistance(String dni, int idClase, String dia, String fecha) {
        this.dni = dni;
        this.idClase = idClase;
        this.dia = dia;
        this.fecha = fecha;
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

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
