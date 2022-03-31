package net.team4.codes;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class CreateFile {
    
    private static CreateFile instance;
    private File directory;
    private File fileConfig;
    
    private File fileLogs;
    private YamlConfiguration ymlConfig;
    private YamlConfiguration ymlLogs;
    
    public CreateFile(){
        this.directory=new File("C:/Trilce");
        this.fileConfig=new File(directory, "config.yml");
        this.fileLogs=new File(directory,"logs.yml");
        this.ymlConfig=YamlConfiguration.loadConfiguration(fileConfig);
        this.ymlLogs=YamlConfiguration.loadConfiguration(fileLogs);
    }
    
    public static CreateFile getInstance(){
        if(instance==null){
            instance=new CreateFile();
        }
        return instance;
    }
    
    public boolean createFile(){
        boolean status=false;
        try {
            if(!fileConfig.exists()){
                this.directory.mkdir();
                this.fileConfig.createNewFile();
                this.ymlConfig.set("Remember-Account.status", false);
                this.ymlConfig.set("Remember-Account.account", "");
                this.ymlConfig.set("Remember-Account.password", "");
                this.ymlConfig.set("Remember-Account.type", "");
                this.ymlConfig.set("MySQL.status", false);
                this.ymlConfig.set("MySQL.ip", "");
                this.ymlConfig.set("MySQL.port", "");
                this.ymlConfig.set("MySQL.database", "");
                this.ymlConfig.set("MySQL.username", "");
                this.ymlConfig.set("MySQL.password", "");
                this.ymlConfig.save(fileConfig);
                if(!fileLogs.exists()){
                    this.fileLogs.createNewFile();
                    status=true;
                }else{
                    status=true;
                }
            }else{
                if(!fileLogs.exists()){
                    this.fileLogs.createNewFile();
                    status=true;
                }else{
                    status=true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public void writeFileLogs(Object obj, Exception ex){
        try {
            if(obj!=null && ex!=null){
                this.ymlLogs.set("Data.["+SourceCodes.getInstance().getCurrentDate()+"]", "General msj: "+obj+" \n Exception: "+"Location: "+ex.getLocalizedMessage()+" -  Message: "+ex.getMessage()+" - Cause: "+ex.getCause()+" - General: "+ex);
            }else if(obj!=null && ex==null){
                this.ymlLogs.set("Data.["+SourceCodes.getInstance().getCurrentDate()+"]", obj);
            }else if(obj==null && ex!=null){
                this.ymlLogs.set("Data.["+SourceCodes.getInstance().getCurrentDate()+"]", "Location: "+ex.getLocalizedMessage()+" -  Message: "+ex.getMessage()+" - Cause: "+ex.getCause()+" - General: "+ex);
            }
            this.ymlLogs.save(fileLogs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public YamlConfiguration getFileConfig(){
        return this.ymlConfig;
    }
    
    public boolean saveFileConfig(){
        boolean status=false;
        try {
            this.ymlConfig.save(fileConfig);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean isRememberAccountStatus(){
        return this.ymlConfig.getBoolean("Remember-Account.status");
    }
    
    public String getRememberAccount(){
        return this.ymlConfig.getString("Remember-Account.account");
    }
    
    public String getRememberAccountPassword(){
        return this.ymlConfig.getString("Remember-Account.password");
    }
    
    public String getRememberAccountType(){
        return this.ymlConfig.getString("Remember-Account.type");
    }
    
    public boolean saveRememberAccount(boolean status,String account,String password,String type){
        boolean saveStatus=false;
        try {
            this.ymlConfig.set("Remember-Account.status", status);
            this.ymlConfig.set("Remember-Account.account", account);
            this.ymlConfig.set("Remember-Account.password", password);
            this.ymlConfig.set("Remember-Account.type", type);
            this.ymlConfig.save(fileConfig);
            saveStatus=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveStatus;
    }
    
    public boolean resetRememberAccount(){
        boolean status=false;
        try {
            this.ymlConfig.set("Remember-Account.status", false);
            this.ymlConfig.set("Remember-Account.account", "");
            this.ymlConfig.set("Remember-Account.password", "");
            this.ymlConfig.set("Remember-Account.type", "");
            this.ymlConfig.save(fileConfig);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean isMySQLStatus(){
        return this.ymlConfig.getBoolean("MySQL.status");
    }
    
    public String getMySQLIp(){
        return this.ymlConfig.getString("MySQL.ip");
    }
    
    public String getMySQLPort(){
        return this.ymlConfig.getString("MySQL.port");
    }
    
    public String getMySQLDatabase(){
        return this.ymlConfig.getString("MySQL.database");
    }
    
    public String getMySQLUsername(){
        return this.ymlConfig.getString("MySQL.username");
    }
    
    public String getMySQLPassword(){
        return this.ymlConfig.getString("MySQL.password");
    }
    
    public boolean saveMySQL(boolean status,String ip,String port,String database,String username,String password){
        boolean statusSave=false;
        try {
            this.ymlConfig.set("MySQL.status", status);
            this.ymlConfig.set("MySQL.ip", ip);
            this.ymlConfig.set("MySQL.port", port);
            this.ymlConfig.set("MySQL.database", database);
            this.ymlConfig.set("MySQL.username", username);
            this.ymlConfig.set("MySQL.password", password);
            this.ymlConfig.save(fileConfig);
            statusSave=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusSave;
    }
    
}
