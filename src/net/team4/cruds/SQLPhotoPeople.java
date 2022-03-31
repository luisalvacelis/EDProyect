package net.team4.cruds;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.mvc.model.ModelPhotoPeople;

public class SQLPhotoPeople extends ConnectionSQL{
    
    private static SQLPhotoPeople instance;
    
    public SQLPhotoPeople(){
        super();
    }
    
    public static SQLPhotoPeople getInstance(){
        if(instance==null){
            instance=new SQLPhotoPeople();
        }
        return instance;
    }
    
    public ImageIcon getImageByDNI(String dni){
        ImageIcon image=null;
        try {
            String url="SELECT foto FROM people_photo WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                Blob blob=rs.getBlob("foto");
                byte[] data=blob.getBytes(1, (int)blob.length());
                BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                image=new ImageIcon(bi);
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return image;
    }
    
    public ModelPhotoPeople search(String dni){
        ModelPhotoPeople mpp=null;
        try {
            String url="SELECT * FROM people_photo WHERE dni='"+dni+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                Blob blob=rs.getBlob("foto");
                byte[] data=blob.getBytes(1, (int)blob.length());
                BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                mpp=new ModelPhotoPeople(rs.getInt(url), rs.getString("dni"), new ImageIcon(bi));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }finally{
            this.closeConnection();
        }
        return mpp;
    }
    
    public ArrayList<ModelPhotoPeople> getList(){
        ArrayList<ModelPhotoPeople> list=new ArrayList<>();
        try {
            String url="SELECT * FROM people_photo";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                Blob blob=rs.getBlob("foto");
                byte[] data=blob.getBytes(1, (int)blob.length());
                BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                list.add(new ModelPhotoPeople(rs.getInt("idSP"), rs.getString("dni"), new ImageIcon(bi)));
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
    
    public boolean insert(ModelPhotoPeople mpp){
        boolean status=false;
        try {
            String url="INSERT INTO people_photo(dni,foto) VALUES(?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mpp.getDni());
            ps.setBinaryStream(2, mpp.getImageFIS());
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
    
    public boolean update(ModelPhotoPeople mpp){
        boolean status=false;
        try {
            String url="UPDATE people_photo SET foto=? WHERE idSP="+mpp.getId();
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setBinaryStream(1, mpp.getImageFIS());
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
    
    public boolean remove(ModelPhotoPeople mpp){
        boolean status=false;
        try {
            String url="DELETE FROM people_photo WHERE idSP="+mpp.getId();
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
