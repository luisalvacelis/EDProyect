package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelCategoryCourses;

public class SQLCategoryCourse extends ConnectionSQL{
    
    private static SQLCategoryCourse instance;
    
    public SQLCategoryCourse(){
        super();
    }
    
    public static SQLCategoryCourse getInstance(){
        if(instance==null){
            instance=new SQLCategoryCourse();
        }
        return instance;
    }
    
    public ModelCategoryCourses search(int id){
        ModelCategoryCourses mrcc=null;
        try {
            String url="SELECT * FROM category_courses WHERE idCategoria="+id;
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                mrcc=new ModelCategoryCourses(rs.getInt("idCategoria"), rs.getString("nombre"),rs.getString("observacion"), rs.getString("fecha"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            closeConnection();
        }
        return mrcc;
    }
    
    public ArrayList<ModelCategoryCourses> getList(){
        ArrayList<ModelCategoryCourses> list=new ArrayList<>();
        try {
            String url="SELECT * FROM category_courses";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelCategoryCourses(rs.getInt("idCategoria"), rs.getString("nombre"), rs.getString("observacion"),rs.getString("fecha")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            closeConnection();
        }
        return list;
    }
    
    public boolean insert(ModelCategoryCourses mrcc){
        boolean status=false;
        try {
            String url="INSERT INTO category_courses(nombre,observacion,fecha) VALUES(?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mrcc.getName());
            ps.setString(2, mrcc.getObservation());
            ps.setString(3, mrcc.getDate());
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
    
    public boolean update(ModelCategoryCourses mrcc){
        boolean status=false;
        try {
            String url="UPDATE category_courses SET nombre='"+mrcc.getName()+"',observacion='"+mrcc.getObservation()+"',fecha='"+mrcc.getDate()+"' WHERE idCategoria="+mrcc.getId();
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
    
    public boolean remove(ModelCategoryCourses mrcc){
        boolean status=false;
        try {
            String url="DELETE FROM category_courses WHERE idCategoria="+mrcc.getId();
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
