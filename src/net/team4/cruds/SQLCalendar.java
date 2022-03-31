package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelCalendar;

public class SQLCalendar extends ConnectionSQL{
    
    private static SQLCalendar instance;
    
    public SQLCalendar(){
        super();
    }
    
    public static SQLCalendar getInstance(){
        if(instance==null){
            instance=new SQLCalendar();
        }
        return instance;
    }
    
    public ArrayList<ModelCalendar> getList(){
        ArrayList<ModelCalendar> list=new ArrayList<>();
        try {
            String url="SELECT * FROM teacher_course_calendar";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelCalendar(rs.getInt("idTCC"), rs.getString("dni"), rs.getString("asignatura"), rs.getString("turno"), rs.getString("seccion"), rs.getString("dia"), rs.getString("fecha")));
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
    
    public boolean insert(ModelCalendar mrc){
        boolean status=false;
        try {
            String url="INSERT INTO teacher_course_calendar(dni,asignatura,turno,seccion,dia,fecha) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mrc.getDni());
            ps.setString(2, mrc.getCourse());
            ps.setString(3, mrc.getTurn());
            ps.setString(4, mrc.getSection());
            ps.setString(5, mrc.getDay());
            ps.setString(6, mrc.getDate());
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
    
    public boolean remove(ModelCalendar mrc){
        boolean status=false;
        try {
            String url="DELETE FROM teacher_course_calendar WHERE idTCC="+mrc.getId();
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
    
    public ModelCalendar search(int id){
        ModelCalendar mrc=null;
        try {
            String url="SELECT * FROM teacher_course_calendar WHERE idTCC="+id;
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                mrc=new ModelCalendar(rs.getInt("idTCC"), rs.getString("dni"), rs.getString("asignatura"), rs.getString("turno"), rs.getString("seccion"), rs.getString("dia"), rs.getString("fecha"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return mrc;
    }
}
