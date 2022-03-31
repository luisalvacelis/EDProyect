package net.team4.mvc.model;

public class ModelStudentClass {
    
    private int id;
    private String dni;
    private int idClass;
    
    public ModelStudentClass(int id,String dni,int idClass){
        this.id=id;
        this.dni=dni;
        this.idClass=idClass;
    }
    
    public ModelStudentClass(String dni,int idClass){
        this.dni=dni;
        this.idClass=idClass;
    }
    
    public ModelStudentClass(){
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
}
