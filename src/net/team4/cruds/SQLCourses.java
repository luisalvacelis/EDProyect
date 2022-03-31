package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelCourses;

public class SQLCourses extends ConnectionSQL{
    
    private static SQLCourses instance;
    
    public SQLCourses(){
        super();
    }
    
    public static SQLCourses getInstance(){
        if(instance==null){
            instance=new SQLCourses();
        }
        return instance;
    }
    
    public boolean insert(ModelCourses mc){
        boolean status=false;
        try {
            String url="INSERT INTO courses(codigo,nombre,categoria,fecha) VALUES(?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mc.getCode());
            ps.setString(2, mc.getName());
            ps.setString(3, mc.getCategory());
            ps.setString(4, mc.getDate());
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
    
    public boolean remove(ModelCourses mc){
        boolean status=false;
        try {
            String url="DELETE FROM courses WHERE idCurso="+mc.getId();
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
    
    public boolean update(ModelCourses mc){
        boolean status=false;
        try {
            String url="UPDATE courses SET codigo='"+mc.getCode()+"', nombre='"+mc.getName()+"', categoria='"+mc.getCategory()+"', fecha='"+mc.getDate()+"' WHERE idCurso="+mc.getId();
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
    
    public ArrayList<ModelCourses> getList(){
        ArrayList<ModelCourses> list=new ArrayList<>();
        try {
            String url="SELECT * FROM courses";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelCourses(rs.getInt("idCurso"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"),rs.getString("fecha")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs("Error: List Courses", e);
        }finally{
            closeConnection();
        }
        return list;
    }
}
