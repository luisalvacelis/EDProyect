package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelLogin;

public class SQLLogin extends ConnectionSQL{
    
    private static SQLLogin instance;
    
    public SQLLogin(){
        super();
    }
    
    public static SQLLogin getInstance(){
        if(instance==null){
            instance=new SQLLogin();
        }
        return instance;
    }
    
    public boolean insert(ModelLogin ml){
        boolean status=false;
        try {
            String url="INSERT INTO login(dni,usuario,contra,tipo) VALUES(?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, ml.getDni());
            ps.setString(2, ml.getAccount());
            ps.setString(3, ml.getPassword());
            ps.setString(4, ml.getType());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public boolean update(ModelLogin ml){
        boolean status=false;
        try {
            String url="UPDATE login SET usuario='"+ml.getAccount()+"', contra='"+ml.getPassword()+"', tipo='"+ml.getType()+"' WHERE dni="+ml.getDni();
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
    
    public boolean remove(ModelLogin ml){
        boolean status=false;
        try {
            String url="DELETE FROM login WHERE usuario='"+ml.getAccount()+"'";
            PreparedStatement ps=openConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public ArrayList<ModelLogin> getList(){
        ArrayList<ModelLogin> list=new ArrayList<>();
        try {
            String url="SELECT * FROM login";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new ModelLogin(rs.getInt("idLogin"),rs.getString("dni"),rs.getString("usuario"), rs.getString("contra"),rs.getString("tipo")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return list;
    }
}
