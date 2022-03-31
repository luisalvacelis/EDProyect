package net.team4.mvc.model;

public class ModelUsers{
    
    private int id;
    private String lastnames;
    private String names;
    private String dni;
    private String telcel;
    private String email;
    private String username;
    private String password;
    private String type;
    private String details;
    private String date;
    
    public ModelUsers(int id,String lastnames, String names, String dni, String telcel, 
            String email, String username, String password, String type, String details, String date) {
        this.id=id;
        this.lastnames = lastnames;
        this.names = names;
        this.dni = dni;
        this.telcel = telcel;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
        this.details = details;
        this.date = date;
    }
    public ModelUsers(String lastnames, String names, String dni, String telcel, String email, String username, String password, String type, String details, String date) {
        this.lastnames = lastnames;
        this.names = names;
        this.dni = dni;
        this.telcel = telcel;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
        this.details = details;
        this.date = date;
    }
    
    public ModelUsers(int id){
        this.id=id;
    }
    
    public ModelUsers(int id,String username){
        this.id=id;
        this.username=username;
    }

    public ModelUsers() {}
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelcel() {
        return telcel;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
