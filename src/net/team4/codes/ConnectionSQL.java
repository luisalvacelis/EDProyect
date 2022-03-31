package net.team4.codes;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQL {
    
    private static ConnectionSQL instance;
    private static Connection connection;
    private String ip;
    private String port;
    private String database;
    private String username;
    private String password;
    
    public ConnectionSQL(){
        CreateFile cf=new CreateFile();
        if(cf.isMySQLStatus()){
            this.ip=cf.getMySQLIp();
            this.port=cf.getMySQLPort();
            this.database=cf.getMySQLDatabase();
            this.username=cf.getMySQLUsername();
            this.password=cf.getMySQLPassword();
        }else{
            this.ip=null;
            this.port=null;
            this.database=null;
            this.username=null;
            this.password=null;
        }
    }
    
    public static ConnectionSQL getInstance(){
        if(instance==null){
            instance=new ConnectionSQL();
        }
        return instance;
    }
    
    public Connection openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if((ip!=null) && (port!=null) && (database!=null) && (username!=null) && (password!=null)){
                String url="jdbc:mysql://"+ip+":"+port+"/"+database+"?allowPublicKeyRetrieval=true&useSSL=false";
                connection=DriverManager.getConnection(url,username,password);
            }else{
                CreateFile.getInstance().writeFileLogs("Error: Database no registrada, por lo cual no se puede establecer la conexión.",null);
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }
        return connection;
    }
    
    public void closeConnection(){
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }
    }
    
}
