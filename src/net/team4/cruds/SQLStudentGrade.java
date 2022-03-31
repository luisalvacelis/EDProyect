package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelStudentGrade;

public class SQLStudentGrade extends ConnectionSQL{
    
    private static SQLStudentGrade instance;
    
    public SQLStudentGrade(){
        super();
    }
    
    public static SQLStudentGrade getInstance(){
        if(instance==null){
            instance=new SQLStudentGrade();
        }
        return instance;
    }
    
    public ModelStudentGrade search(String dni){
        ModelStudentGrade msg=null;
        try {
            String url="SELECT * FROM student_grade WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                msg=new ModelStudentGrade(rs.getInt("idSG"), rs.getString("dni"), rs.getString("grado"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return msg;
    }
    
    public boolean insert(ModelStudentGrade msg){
        boolean status=false;
        try {
            String url="INSERT INTO student_grade(dni,grado) VALUES(?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, msg.getDni());
            ps.setString(2, msg.getGrade());
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
    
    public boolean update(ModelStudentGrade msg){
        boolean status=false;
        try {
            String url="UPDATE student_grade SET dni='"+msg.getDni()+"', grado='"+msg.getGrade()+"'";
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
    
    public boolean remove(ModelStudentGrade msg){
        boolean status=false;
        try {
            String url="DELETE FROM student_grade WHERE idSG="+msg.getId();
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
