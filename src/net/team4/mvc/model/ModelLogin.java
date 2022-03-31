package net.team4.mvc.model;

public class ModelLogin{
    
    private int id;
    private String dni;
    private String account;
    private String password;
    private String type;
    
    public ModelLogin(int id,String dni,String account,String password,String type){
        this.dni=dni;
        this.account=account;
        this.password=password;
        this.type=type;
    }
    
    public ModelLogin(String dni,String account,String password,String type){
        super();
        this.dni=dni;
        this.account=account;
        this.password=password;
        this.type=type;
    }
    
    public ModelLogin(String account){
        this.account=account;
    }
    
    public ModelLogin(){}
    
    public void setDni(String dni){
        this.dni=dni;
    }
    
    public String getDni(){
        return this.dni;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setAccount(String account){
        this.account=account;
    }
    
    public String getAccount(){
        return this.account;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    
}
