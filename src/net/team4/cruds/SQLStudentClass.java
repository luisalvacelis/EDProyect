package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelStudentClass;

public class SQLStudentClass extends ConnectionSQL{
    
    private static SQLStudentClass instance;
    
    public SQLStudentClass(){
        super();
    }
    
    public static SQLStudentClass getInstance(){
        if(instance==null){
            instance=new SQLStudentClass();
        }
        return instance;
    }
    
    public ModelStudentClass search(String dni){
        ModelStudentClass msc=null;
        try {
            String url="SELECT * FROM student_class WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                msc=new ModelStudentClass(rs.getInt("idSC"), rs.getString("dni"), rs.getInt("idClass"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return msc;
    }
    
    public ArrayList<ModelStudentClass> getList(){
        ArrayList<ModelStudentClass> list=new ArrayList<>();
        try {
            String url="SELECT * FROM student_class";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelStudentClass(rs.getInt("idSC"),rs.getString("dni"),rs.getInt("idClass")));
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
    
    public boolean insert(ModelStudentClass msc){
        boolean status=false;
        try {
            String url="INSERT INTO student_class(dni,idClass) VALUES(?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, msc.getDni());
            ps.setInt(2, msc.getIdClass());
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
    
    public boolean update(ModelStudentClass msc){
        boolean status=false;
        try {
            String url="UPDATE student_class SET dni='"+msc.getDni()+"', idClass="+msc.getIdClass()+" WHERE idSC="+msc.getId();
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
    
    public boolean remove(ModelStudentClass msc){
        boolean status=false;
        try {
            String url="DELETE FROM student_class WHERE idSC="+msc.getId();
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
