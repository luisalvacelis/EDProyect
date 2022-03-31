package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelTeacherCourse;

public class SQLTeacherCourse extends ConnectionSQL{
    
    private static SQLTeacherCourse instance;
    
    public SQLTeacherCourse(){
        super();
    }
    
    public static SQLTeacherCourse getInstance(){
        if(instance==null){
            instance=new SQLTeacherCourse();
        }
        return instance;
    }
    
    public ArrayList<ModelTeacherCourse> getList(){
        ArrayList<ModelTeacherCourse> list=new ArrayList<>();
        try {
            String url="SELECT * FROM teacher_course";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelTeacherCourse(rs.getInt("idTC"),rs.getString("dni"), SQLUsers.getInstance().getFullNamesByDNI(rs.getString("dni")), rs.getString("asignatura"), rs.getString("fecha")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
        return list;
    }
    
    public boolean insert(ModelTeacherCourse mtc){
        boolean status=false;
        try {
            String url="INSERT INTO teacher_course(dni,asignatura,fecha) VALUES(?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mtc.getDNI());
            ps.setString(2, mtc.getCourse());
            ps.setString(3, mtc.getDate());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public boolean remove(ModelTeacherCourse mtc){
        boolean status=false;
        try {
            String url="DELETE FROM teacher_course WHERE idTC="+mtc.getId();
            PreparedStatement ps=openConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            closeConnection();
        }
        return status;
    }
}
