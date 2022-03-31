package net.team4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;

public class CreateDB extends ConnectionSQL implements CreateDBInterface{
    
    private String ip,port,database,username,password;
    
    public CreateDB(){
        super();
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
    
    @Override
    public boolean verifyExistenceDB() {
        boolean status=false;
        try {
            if((ip!=null) && (port!=null) && (database!=null) && (username!=null) && (password!=null)){
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/?allowPublicKeyRetrieval=true&useSSL=false",username,password);
                Statement statement=connection.createStatement();
                ResultSet rs=statement.executeQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '"+database+"'");
                if(rs.next()){
                    status=true;
                }
                rs.close();
                statement.close();
                connection.close();
            }
        } catch (Exception e) {
            SourceCodes.getInstance().sendMessageError("Error al verificar existencia de una base de datos similar.");
            CreateFile.getInstance().writeFileLogs(null,e);
        }
        return status;
    }

    @Override
    public boolean createDB() {
        boolean status=false;
        try {
            if(!verifyExistenceDB()){
                Connection connection=DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/?useSSL=false",username,password);
                Statement statement=connection.createStatement();
                int result=statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+database);
                if(result>0){
                    if(createTables(0)){
                        if(createTables(1)){
                            if(createTables(2)){
                                if(createTables(3)){
                                    if(createTables(4)){
                                        if(createTables(5)){
                                            if(createTables(6)){
                                                if(createTables(7)){
                                                    if(createTables(8)){
                                                        if(createTables(9)){
                                                            if(createTables(10)){
                                                                status=true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                statement.close();
                connection.close();
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Base de datos ya creada anteriormente, verificando tablas.");
            }
        } catch (Exception e) {
            SourceCodes.getInstance().sendMessageError("Error al crear base de datos, verifique el archivo 'logs.yml'");
            CreateFile.getInstance().writeFileLogs(null,e);
        }
        return status;
    }

    @Override
    public boolean createTables(int num){
        boolean status=false;
        try {
            if(num==0){
                String url="CREATE TABLE IF NOT EXISTS login("
                        + "idLogin INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "usuario VARCHAR(30) NOT NULL,"
                        + "contra VARCHAR(30) NOT NULL,"
                        + "tipo CHAR(1) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==1){
                String url="CREATE TABLE IF NOT EXISTS register_users("
                        + "idUsuario INT PRIMARY KEY AUTO_INCREMENT ,"
                        + "apellidos NVARCHAR(100) NOT NULL,"
                        + "nombres NVARCHAR(100) NOT NULL,"
                        + "dni CHAR(20) NOT NULL,"
                        + "telcel VARCHAR(20) NOT NULL,"
                        + "email NVARCHAR(50) NOT NULL,"
                        + "usuario VARCHAR(30) NOT NULL,"
                        + "contra VARCHAR(30) NOT NULL,"
                        + "tipo CHAR(1) NOT NULL,"
                        + "detalle NVARCHAR(100) NOT NULL,"
                        + "fecha NVARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==2){
                String url="CREATE TABLE IF NOT EXISTS courses("
                        + "idCurso INT PRIMARY KEY AUTO_INCREMENT,"
                        + "codigo VARCHAR(20) NOT NULL,"
                        + "nombre VARCHAR(50) NOT NULL,"
                        + "categoria VARCHAR(20) NOT NULL,"
                        + "fecha NVARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==3){
                String url="CREATE TABLE IF NOT EXISTS category_courses("
                        + "idCategoria INT PRIMARY KEY AUTO_INCREMENT,"
                        + "nombre NVARCHAR(30) NOT NULL,"
                        + "observacion NVARCHAR(100) NOT NULL,"
                        + "fecha NVARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==4){
                String url="CREATE TABLE IF NOT EXISTS teacher_course("
                        + "idTC INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "asignatura NVARCHAR(30) NOT NULL,"
                        + "fecha NVARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==5){
                String url="CREATE TABLE IF NOT EXISTS teacher_course_calendar("
                        + "idTCC INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "asignatura NVARCHAR(30) NOT NULL,"
                        + "turno NVARCHAR(20) NOT NULL,"
                        + "seccion NVARCHAR(20) NOT NULL,"
                        + "dia NVARCHAR(20) NOT NULL,"
                        + "fecha NVARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==6){
                String url="CREATE TABLE IF NOT EXISTS student_grade("
                        + "idSG INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "grado NVARCHAR(10) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==7){
                String url="CREATE TABLE IF NOT EXISTS student_class("
                        + "idSC INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "idClass INT NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==8){
                String url="CREATE TABLE IF NOT EXISTS student_notes("
                        + "idSN INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "idClase INT NOT NULL,"
                        + "nota DOUBLE NOT NULL,"
                        + "fecha_de_registro VARCHAR(45) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==9){
                String url="CREATE TABLE IF NOT EXISTS people_photo ("
                        + "idSP INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "foto LONGBLOB NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }else if(num==10){
                String url="CREATE TABLE IF NOT EXISTS student_assistance("
                        + "idSA INT PRIMARY KEY AUTO_INCREMENT,"
                        + "dni CHAR(20) NOT NULL,"
                        + "idClase INT NOT NULL,"
                        + "dia VARCHAR(20) NOT NULL,"
                        + "fecha VARCHAR(20) NOT NULL);";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result>-1){
                    status=true;
                }
                statement.close();
            }
        } catch (Exception e) {
            SourceCodes.getInstance().sendMessageError("Error al crear tablas, verifique el archivo 'logs.yml'");
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    
    
}
