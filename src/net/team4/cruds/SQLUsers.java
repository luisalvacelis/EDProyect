package net.team4.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelUsers;

public class SQLUsers extends ConnectionSQL{
    
    private static SQLUsers instance;
    
    public SQLUsers(){
        super();
    }
    
    public static SQLUsers getInstance(){
        if(instance==null){
            instance=new SQLUsers();
        }
        return instance;
    }
    
    public String getFullNamesByDNI(String dni){
        return searchByDNI(dni).getLastnames()+", "+searchByDNI(dni).getNames();
    }
    
    public int getIDByDNI(String dni){
        int id=0;
        try {
            String url="SELECT * FROM register_users WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                id=rs.getInt("idUsuario");
            }
            rs.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return id;
    }
    
    public ModelUsers searchByDNI(String dni){
        ModelUsers mru=null;
        try {
            String url="SELECT * FROM register_users WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                mru=new ModelUsers(rs.getInt("idUsuario"), rs.getString("apellidos"), rs.getString("nombres"), rs.getString("dni"), rs.getString("telcel"), rs.getString("email"), rs.getString("usuario"), rs.getString("contra"), rs.getString("tipo"), rs.getString("detalle"), rs.getString("fecha"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return mru;
    }
    
    public boolean insert(ModelUsers mru){
        boolean status=false;
        try {
            String url="INSERT INTO register_users(apellidos,nombres,dni,telcel,email,usuario,contra,tipo,detalle,fecha) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mru.getLastnames());
            ps.setString(2, mru.getNames());
            ps.setString(3, mru.getDni());
            ps.setString(4, mru.getTelcel());
            ps.setString(5, mru.getEmail());
            ps.setString(6, mru.getUsername());
            ps.setString(7, mru.getPassword());
            ps.setString(8, mru.getType());
            ps.setString(9, mru.getDetails());
            ps.setString(10, mru.getDate());
            int result=ps.executeUpdate();
            ps.close();
            if(result>0){
                if(SQLLogin.getInstance().insert(new ModelLogin(mru.getDni(),mru.getUsername(), mru.getPassword(), mru.getType()))){
                    status=true;
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Cuenta de acceso del usuario "+mru.getType()+" no ingresada, vuelva a intentarlo.");
                }
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public boolean update(ModelUsers mru){
        boolean status=false;
        try {
            String url="UPDATE register_users SET apellidos=?, nombres=?,dni=?,telcel=?,email=?,usuario=?,contra=?,tipo=?,detalle=?,fecha=? WHERE idUsuario=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mru.getLastnames());
            ps.setString(2, mru.getNames());
            ps.setString(3, mru.getDni());
            ps.setString(4, mru.getTelcel());
            ps.setString(5, mru.getEmail());
            ps.setString(6, mru.getUsername());
            ps.setString(7, mru.getPassword());
            ps.setString(8, mru.getType());
            ps.setString(9, mru.getDetails());
            ps.setString(10, mru.getDate());
            ps.setInt(11, mru.getId());
            int result=ps.executeUpdate();
            if(result>0){
                if(SQLLogin.getInstance().update(new ModelLogin(mru.getDni(),mru.getUsername(), mru.getPassword(), mru.getType()))){
                    status=true;
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Cuenta de acceso del usuario "+mru.getDni()+" no actualizada, vuelva a intentarlo.");
                }
            }
            ps.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public boolean remove(ModelUsers mru){
        boolean status=false;
        try {
            String url="DELETE FROM register_users WHERE idUsuario="+mru.getId();
            PreparedStatement ps=openConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            ps.close();
            if(result>0){
                if(SQLLogin.getInstance().remove(new ModelLogin(mru.getUsername()))){
                    status=true;
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Cuenta de acceso del usuario '"+mru.getUsername()+"' no se pudo remover.\nError desconocido");
                }
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }finally{
            closeConnection();
        }
        return status;
    }
    
    public ArrayList<ModelUsers> getList(){
        ArrayList<ModelUsers> list=new ArrayList<>();
        try {
            String url="SELECT * FROM register_users";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                
                list.add(new ModelUsers(rs.getInt("idUsuario"),rs.getString("apellidos"),
                        rs.getString("nombres"), rs.getString("dni"), rs.getString("telcel"),
                        rs.getString("email"), rs.getString("usuario"), rs.getString("contra"), rs.getString("tipo"),
                        rs.getString("detalle"), rs.getString("fecha")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            CreateFile.getInstance().writeFileLogs("Error: List ModelUsers",e);
        }finally{
            closeConnection();
        }
        return list;
    }
}
