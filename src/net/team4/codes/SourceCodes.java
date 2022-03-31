package net.team4.codes;

import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.team4.mvc.controller.ControllerLogin;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.view.ViewLogin;

public class SourceCodes {
    
    private static SourceCodes instance;
    private SecureRandom sr;
    
    public SourceCodes(){
        this.sr=new SecureRandom();
    }
   
    public static SourceCodes getInstance(){
        if(instance==null){
            instance=new SourceCodes();
        }
        return instance;
    }
    
    public String getWordRandom(){
        return new BigInteger(50,sr).toString(32);
    }
    
    public String getCurrentDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
    
    public void sendMessageError(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", 0, new ImageIcon(getClass().getResource("/net/team4/images/error32x32.png")));
    }
    
    public void sendMessageSuccess(String msg){
        JOptionPane.showMessageDialog(null, msg, "Correcto", 0, new ImageIcon(getClass().getResource("/net/team4/images/exito32x32.png")));
    }
    
    public void verifyTypeLetter(KeyEvent e){
        if(Character.isLetter(e.getKeyChar())){
            e.consume();
            this.sendMessageError("Error: Debe colocar solo números, no letras.");
        }
    }
    
    public void closeSession(JFrame jf){
        int result=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar sesión?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
        if(result==0){
            if(CreateFile.getInstance().isRememberAccountStatus()){
                this.resetLogin(0,jf);
            }else{
                this.resetLogin(1,jf);
            }
        }
    }
    
    private void resetLogin(int num, JFrame jf){
        try {
            if(num==0){
                if(CreateFile.getInstance().resetRememberAccount()){
                    jf.dispose();
                    ControllerLogin.getInstance(new ViewLogin(), new ModelLogin());
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: No se pudo resetear la cuenta, vuelva a intentarlo.");
                }
            }else if(num==1){
                jf.dispose();
                ControllerLogin.getInstance(new ViewLogin(), new ModelLogin());
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null,e);
        }
    }
    
}
