package net.team4.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.dao.CreateDBInterface;
import net.team4.dao.CreateDB;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.view.ViewMainAdministrator;
import net.team4.mvc.view.ViewRegisterSQL;

public class ControllerRegisterSQL implements ActionListener{
    
    private static ControllerRegisterSQL instance;
    private ViewRegisterSQL varRSQL;
    private ModelLogin ml;
    
    public ControllerRegisterSQL(ViewRegisterSQL vrsql){
        this.varRSQL=vrsql;
        this.varRSQL.setVisible(true);
        this.registerEvents();
    }
    
    public static ControllerRegisterSQL getInstance(ViewRegisterSQL vrsql){
        return instance=new ControllerRegisterSQL(vrsql);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void registerEvents(){
        this.varRSQL.jbtRegisterSQL.addActionListener(this);
        this.varRSQL.jckbShowPassword.addActionListener(this);
        this.varRSQL.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(ml);
                } catch (Exception ex) {
                    CreateFile.getInstance().writeFileLogs(null, ex);
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(varRSQL.jckbShowPassword==e.getSource()){
            this.btnShowPassword();
        }else if(varRSQL.jbtRegisterSQL==e.getSource()){
            this.btnRegisterSQL();
        }
    }
    
    private void btnShowPassword(){
        if(varRSQL.jckbShowPassword.isSelected()){
            this.varRSQL.jpfPassword.setEchoChar((char)0);
        }else{
            this.varRSQL.jpfPassword.setEchoChar('•');
        }
    }
    
    private void btnRegisterSQL(){
        if(!varRSQL.jtfIp.getText().equalsIgnoreCase("")){
            if(!varRSQL.jtfPort.getText().equalsIgnoreCase("")){
                if(!varRSQL.jtfDatabase.getText().equalsIgnoreCase("")){
                    if(!varRSQL.jtfUsername.getText().equalsIgnoreCase("")){
                        if(!varRSQL.jpfPassword.getText().equalsIgnoreCase("")){
                            String ip=varRSQL.jtfIp.getText();
                            String port=varRSQL.jtfPort.getText();
                            String database=varRSQL.jtfDatabase.getText();
                            String username=varRSQL.jtfUsername.getText();
                            String password=new String(varRSQL.jpfPassword.getPassword());
                            try {
                                if(CreateFile.getInstance().saveMySQL(true, ip, port, database, username, password)){
                                    CreateDBInterface cdbi=new CreateDB();
                                    if(cdbi.createDB()){
                                        SourceCodes.getInstance().sendMessageSuccess("Base de datos registrada con éxito.");
                                        this.clear();
                                    }else{
                                        SourceCodes.getInstance().sendMessageError("Error: No se pudo crear la base de datos.");
                                    }
                                }else{
                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo almacenar la cuenta de la base de datos.");
                                }
                            } catch (Exception ex) {
                                CreateFile.getInstance().writeFileLogs(null,ex);
                            }
                        }else{
                            SourceCodes.getInstance().sendMessageError("Error: Password (Contraseña) no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        SourceCodes.getInstance().sendMessageError("Error: Username (Nombre de usuario) no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Database (Base de datos) no ingresada, vuelva a intentarlo.");
                }
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Port (Puerto) no ingresado, vuelva a intentarlo.");
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: Ip no ingresada, vuelva a intentarlo.");
        }
    }
    
    private void clear(){
        this.varRSQL.jtfIp.setText(null);
        this.varRSQL.jtfPort.setText(null);
        this.varRSQL.jtfDatabase.setText(null);
        this.varRSQL.jtfUsername.setText(null);
        this.varRSQL.jpfPassword.setText(null);
        this.varRSQL.requestFocus();
    }
    
}
