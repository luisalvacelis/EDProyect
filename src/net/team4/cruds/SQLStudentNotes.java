package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelStudentNotes;

public class SQLStudentNotes extends ConnectionSQL{
    
    private static SQLStudentNotes instance;
    
    public SQLStudentNotes(){
        super();
    }
    
    public static SQLStudentNotes getInstance(){
        if(instance==null){
            instance=new SQLStudentNotes();
        }
        return instance;
    }
    
    public String getDateByDNI(String dni,int id){
        String date=null;
        try {
            String url="SELECT * FROM student_notes WHERE dni='"+dni+"' AND idClase="+id;
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                date=rs.getString("fecha_de_registro");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return date;
    }
    
    public double getNoteByDNI(String dni, int id){
        double note=0;
        try {
            String url="SELECT * FROM student_notes WHERE dni='"+dni+"' AND idClase="+id;
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                note=rs.getDouble("nota");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return note;
    }
    
    public ArrayList<ModelStudentNotes> getList(){
        ArrayList<ModelStudentNotes> list=new ArrayList<>();
        try {
            String url="SELECT * FROM student_notes";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelStudentNotes(rs.getInt("idSN"), rs.getString("dni"), rs.getInt("idClase"), rs.getDouble("nota"),rs.getString("fecha_de_registro")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return list;
    }
    
    public boolean insert(ModelStudentNotes msn){
        boolean status=false;
        try {
            String url="INSERT INTO student_notes(dni,idClase,nota,fecha_de_registro) VALUES(?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, msn.getDni());
            ps.setInt(2, msn.getIdClass());
            ps.setDouble(3, msn.getNote());
            ps.setString(4, msn.getDate());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return status;
    }
    
    public boolean update(ModelStudentNotes msn){
         boolean status=false;
         try {
            String url="UPDATE student_notes SET nota="+msn.getNote()+", fecha_de_registro='"+msn.getDate()+"' WHERE dni='"+msn.getDni()+"' AND idClase="+msn.getIdClass();
            PreparedStatement ps=openConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
             this.closeConnection();
         }
         return status;
    }
    
    public boolean remove(ModelStudentNotes msn){
        boolean status=false;
        try {
            String url="DELETE FROM student_notes WHERE idSN="+msn.getId();
            PreparedStatement ps=openConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return status;
    }
}
