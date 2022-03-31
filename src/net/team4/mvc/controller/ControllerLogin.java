package net.team4.mvc.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLLogin;
import net.team4.dao.CreateDB;
import net.team4.dao.CreateDBInterface;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.view.ViewLogin;
import net.team4.mvc.view.ViewMainAdministrator;
import net.team4.mvc.view.ViewMainStudent;
import net.team4.mvc.view.ViewMainTeacher;

public class ControllerLogin implements ActionListener, FocusListener{
    
    private static ControllerLogin instance;
    private ViewLogin varVL;
    private ModelLogin modL;
    private CreateDBInterface cdbi;
    private int contImg=1;
    
    public ControllerLogin(ViewLogin vl, ModelLogin ml){
        this.varVL=vl;
        this.modL=ml;
        this.load();
    }
    
    public static ControllerLogin getInstance(ViewLogin vl,ModelLogin ml){
        return instance=new ControllerLogin(vl,ml);
    }
    
    private void load(){
        if(CreateFile.getInstance().isRememberAccountStatus()){
            this.passLogin();
        }else{
            this.cdbi=new CreateDB();
            this.varVL.setVisible(true);
            this.registerEvents();
            this.loadImages();
        }
    }
    
    private void passLogin(){
        try {
            CreateFile cf=new CreateFile();
            this.modL.setAccount(cf.getRememberAccount());
            this.modL.setPassword(cf.getRememberAccountPassword());
            this.modL.setType(cf.getRememberAccountType());
            if(modL.getType().equalsIgnoreCase("A")){
                ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(modL);
            }else if(modL.getType().equalsIgnoreCase("T")){
                ControllerMainTeacher.getInstance(new ViewMainTeacher(),modL);
            }else if(modL.getType().equalsIgnoreCase("S")){
                ControllerMainStudent.getInstance(new ViewMainStudent(),modL);
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void registerEvents(){
        this.varVL.jtfriUsername.addFocusListener(this);
        this.varVL.jpfriPassword.addFocusListener(this);
        
        this.varVL.jckbRememberAccount.addActionListener(this);
        this.varVL.jckbShowPassword.addActionListener(this);
        this.varVL.jbtLogin.addActionListener(this);
        
        this.varVL.jtfriUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==e.VK_ENTER){
                    varVL.jpfriPassword.requestFocus();
                }
            }
        });
        this.varVL.jpfriPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==e.VK_ENTER){
                    varVL.jbtLogin.doClick();
                }
            }
        });
        /*this.varVL.jlForgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                varVL.jlForgotPassword.setForeground(new Color(141, 144, 151));
            }
            @Override
            public void mouseExited(MouseEvent e){
                varVL.jlForgotPassword.setForeground(new Color(104,107,122));
            }
        });*/
    }
    
    private void loadImages(){
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                contImg++;
                if(contImg==5){
                    varVL.jpiBackground.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/al"+contImg+".jpg")));
                    varVL.jpiBackground.repaint();
                    contImg=1;
                }else{
                    varVL.jpiBackground.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/al"+contImg+".jpg")));
                    varVL.jpiBackground.repaint();
                }
            }
        };
        new Timer().scheduleAtFixedRate(timerTask, 3000, 3000);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(varVL.jckbRememberAccount==e.getSource()){
            this.btnRememberAccount();
        }else if(varVL.jckbShowPassword==e.getSource()){
            this.cbShowPassword();
        }else if(varVL.jbtLogin==e.getSource()){
            this.btnLogin();
        }
    }
    
    private void btnLogin(){
        try {
            if(!varVL.jtfriUsername.getText().equalsIgnoreCase("")){
                if(!varVL.jpfriPassword.getText().equalsIgnoreCase("")){
                    String account=varVL.jtfriUsername.getText();
                    String password=new String(varVL.jpfriPassword.getPassword());
                    if(account.equalsIgnoreCase("admin") && password.equalsIgnoreCase("ucv2020")){
                        if(varVL.jckbRememberAccount.isSelected()){
                            if(CreateFile.getInstance().saveRememberAccount(true, account, password,"A")){
                                this.modL.setAccount(account);
                                this.modL.setPassword(password);
                                this.modL.setType("A");
                                ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(modL);
                                this.varVL.dispose();
                            }else{
                                SourceCodes.getInstance().sendMessageError("Error: No se pudo guardar la cuenta, intentelo más tarde.");
                            }
                        }else{
                            this.modL.setAccount(account);
                            this.modL.setPassword(password);
                            this.modL.setType("A");
                            ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(modL);
                            this.varVL.dispose();
                        }
                    }else{
                        if(CreateFile.getInstance().isMySQLStatus()){
                            if(cdbi.verifyExistenceDB()){
                                if(SQLLogin.getInstance().getList().size()>0){
                                    boolean status=false;
                                    for(ModelLogin aux:SQLLogin.getInstance().getList()){
                                        if(aux.getAccount().equals(account) && aux.getPassword().equals(password)){
                                            status=true;
                                            this.modL=aux;
                                            break;
                                        }
                                    }
                                    if(status){
                                        if(varVL.jckbRememberAccount.isSelected()){
                                            if(CreateFile.getInstance().saveRememberAccount(true, account, password,modL.getType())){
                                                if(modL.getType().equalsIgnoreCase("A")){
                                                    ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(modL);
                                                    this.varVL.dispose();
                                                }else if(modL.getType().equalsIgnoreCase("T")){
                                                    ControllerMainTeacher.getInstance(new ViewMainTeacher(),modL);
                                                    this.varVL.dispose();
                                                }else if(modL.getType().equalsIgnoreCase("S")){
                                                    ControllerMainStudent.getInstance(new ViewMainStudent(),modL);
                                                    this.varVL.dispose();
                                                }
                                            }else{
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo guardar su cuenta, vuelva a intentarlo.");
                                            }
                                        }else{
                                            if(modL.getType().equalsIgnoreCase("A")){
                                                ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(modL);
                                                this.varVL.dispose();
                                            }else if(modL.getType().equalsIgnoreCase("T")){
                                                ControllerMainTeacher.getInstance(new ViewMainTeacher(),modL);
                                                this.varVL.dispose();
                                            }else if(modL.getType().equalsIgnoreCase("S")){
                                                ControllerMainStudent.getInstance(new ViewMainStudent(),modL);
                                                this.varVL.dispose();
                                            }
                                        }
                                    }else{
                                        SourceCodes.getInstance().sendMessageError("Error: Cuenta no registrada.");
                                    }
                                }else{
                                    SourceCodes.getInstance().sendMessageError("Error: Lista de usuarios vacia, vuelva a intentarlo.");
                                }
                            }else{
                                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, verifique el archivo 'logs.yml'");
                            }
                        }else{
                            SourceCodes.getInstance().sendMessageError("Error: No se pudo localizar la cuenta, debido a que la base de datos no fue registrado.");
                        }
                    }
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Contraseña no ingresada.");
                }
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Usuario no ingresado.");
            }
        } catch (Exception ex) {
            CreateFile.getInstance().writeFileLogs(null,ex);
        }
    }

    private void cbShowPassword(){
        if(varVL.jckbShowPassword.isSelected()){
            this.varVL.jckbShowPassword.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_ON.png")));
            this.varVL.jpfriPassword.setEchoChar((char)0);
        }else{
            this.varVL.jckbShowPassword.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png")));
            this.varVL.jpfriPassword.setEchoChar('•');
        }
    }
    
    private void btnRememberAccount(){
        if(varVL.jckbRememberAccount.isSelected()){
            this.varVL.jckbRememberAccount.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_ON.png")));
        }else{
            this.varVL.jckbRememberAccount.setIcon(new ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png")));
        }
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        if(varVL.jtfriUsername==e.getSource()){
            this.varVL.jtfriUsername.setBackground(new Color(29,32,49));
        }else if(varVL.jpfriPassword==e.getSource()){
            this.varVL.jpfriPassword.setBackground(new Color(29,32,49));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(varVL.jtfriUsername==e.getSource()){
            this.varVL.jtfriUsername.setBackground(new Color(53, 60, 79));
        }else if(varVL.jpfriPassword==e.getSource()){
            this.varVL.jpfriPassword.setBackground(new Color(53, 60, 79));
        }
    }
    
    
}
