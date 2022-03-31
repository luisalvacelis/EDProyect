package net.team4.mvc.controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.team4.codes.AccesoryTable;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLPhotoPeople;
import net.team4.cruds.SQLStudentClass;
import net.team4.cruds.SQLStudentGrade;
import net.team4.cruds.SQLStudentNotes;
import net.team4.cruds.SQLUsers;
import net.team4.mail.ControllerMail;
import net.team4.mail.Mail;
import net.team4.mvc.model.ModelCalendar;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelPhotoPeople;
import net.team4.mvc.model.ModelStudentClass;
import net.team4.mvc.model.ModelStudentNotes;
import net.team4.mvc.model.ModelUsers;
import net.team4.mvc.view.ViewMainStudent;

public class ControllerMainStudent implements ActionListener{
    
    private static ControllerMainStudent instance;
    private ViewMainStudent varME;
    private ModelLogin ml;
    
    public ControllerMainStudent(ViewMainStudent vs,ModelLogin ml){
        this.varME=vs;
        this.ml=ml;
        this.loadConfig();
        this.registerEvents();
        this.varME.setVisible(true);
    }
    
    public static ControllerMainStudent getInstance(ViewMainStudent vs,ModelLogin ml){
        return instance=new ControllerMainStudent(vs,ml);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void registerEvents(){
        this.varME.jmiLogout.addActionListener(this);
        this.varME.jbtShowEnrolledCourses.addActionListener(this);
        this.varME.jbtShowNotes.addActionListener(this);
        this.varME.jbtEditProfile.addActionListener(this);
        this.varME.jbtReloadEnrolls.addActionListener(this);
        this.varME.jbtReloadNotes.addActionListener(this);
        this.varME.jckbCheckEdit.addActionListener(this);
        this.varME.jckbShowPassword.addActionListener(this);
        this.varME.jbtCancel.addActionListener(this);
        this.varME.jbtEdit.addActionListener(this);
        this.varME.jbtExaminePhotoProfile.addActionListener(this);
        this.varME.jbtEditPhotoProfile.addActionListener(this);
        this.varME.jbtCancelEditPhoto.addActionListener(this);
        this.varME.jcbSelectCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(varME.jcbSelectCourse.getSelectedIndex()!=0){
                    String course=varME.jcbSelectCourse.getSelectedItem().toString();
                    
                }
            }
        });
        this.varME.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(varME.jmiLogout==e.getSource()){
            SourceCodes.getInstance().closeSession(varME);
        }else if(varME.jbtShowEnrolledCourses==e.getSource()){
            this.btnShowEnrolledCourses();
        }else if(varME.jbtShowNotes==e.getSource()){
            this.btnShowNotes();
        }else if(varME.jbtEditProfile==e.getSource()){
            this.btnEditProfile();
        }else if(varME.jbtReloadEnrolls==e.getSource()){
            this.btnReloadEnrolls();
        }else if(varME.jbtReloadNotes==e.getSource()){
            this.btnReloadNotes();
        }else if(varME.jckbCheckEdit==e.getSource()){
            this.ckbCheckEdit();
        }else if(varME.jckbShowPassword==e.getSource()){
            this.ckbShowPassword();
        }else if(varME.jbtCancel==e.getSource()){
            this.btnCancel();
        }else if(varME.jbtEdit==e.getSource()){
            this.btnEdit();
        }else if(varME.jbtExaminePhotoProfile==e.getSource()){
            this.btnExaminePhotoProfile();
        }else if(varME.jbtEditPhotoProfile==e.getSource()){
            this.btnEditPhotoProfile();
        }else if(varME.jbtCancelEditPhoto==e.getSource()){
            this.btnCancelEditPhoto();
        }
    }
    
    private void btnCancelEditPhoto(){
        this.varME.jlPhotoEditProfile.setIcon(null);
        this.varME.jlPhotoEditProfile.setName(null);
        this.varME.jbtEditPhotoProfile.setVisible(false);
        this.varME.jbtCancelEditPhoto.setVisible(false);
    }
    
    private void btnEditPhotoProfile(){
        if(varME.jlPhotoEditProfile.getIcon()!=null){
            for(ModelUsers aux:SQLUsers.getInstance().getList()){
                if(aux.getUsername().equalsIgnoreCase(ml.getAccount())){
                    try {
                        File file=new File(varME.jlPhotoEditProfile.getName());
                        FileInputStream fis=new FileInputStream(file);
                        if(SQLPhotoPeople.getInstance().search(aux.getDni())!=null){
                            for(ModelPhotoPeople aux2:SQLPhotoPeople.getInstance().getList()){
                                if(aux2.getDni().equalsIgnoreCase(aux.getDni())){
                                    if(SQLPhotoPeople.getInstance().update(new ModelPhotoPeople(aux2.getId(), fis))){
                                        this.varME.jlImageProfile.setIcon(new ImageIcon(new ImageIcon(varME.jlPhotoEditProfile.getName()).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));
                                        this.varME.jbtEditPhotoProfile.setVisible(false);
                                        this.varME.jbtCancelEditPhoto.setVisible(false);
                                        this.varME.jlPhotoEditProfile.setIcon(null);
                                        SourceCodes.getInstance().sendMessageSuccess("Foto de perfil actualizado con éxito.");
                                    }else{
                                        SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar la foto de perfil, vuelva a intentarlo.");
                                    }
                                }
                            }
                        }else{
                            if(SQLPhotoPeople.getInstance().insert(new ModelPhotoPeople(aux.getDni(), fis))){
                                this.varME.jlImageProfile.setIcon(new ImageIcon(new ImageIcon(varME.jlPhotoEditProfile.getName()).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));
                                this.varME.jbtEditPhotoProfile.setVisible(false);
                                this.varME.jbtCancelEditPhoto.setVisible(false);
                                this.varME.jlPhotoEditProfile.setIcon(null);
                                SourceCodes.getInstance().sendMessageSuccess("Foto del perfil registrado con éxito.");
                            }else{
                                SourceCodes.getInstance().sendMessageSuccess("Error: No se pudo registrar la foto del perfil, vuelva a intentarlo.");
                            }
                        }
                    } catch (Exception e) {
                        CreateFile.getInstance().writeFileLogs(null, e);
                    }
                    break;
                }
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: Imagen no seleccionada, vuelva a intentarlo.");
        }
    }
    
    private void btnExaminePhotoProfile(){
        JFileChooser jfc=new JFileChooser();
        if(jfc.showDialog(this.varME, "Seleccione imagen (.jpg, .png, .gif)")==JFileChooser.APPROVE_OPTION){
            File file=jfc.getSelectedFile();
            if(file.canRead()){
                if(file.getName().endsWith("jpg") || file.getName().endsWith("png") || file.getName().endsWith("gif")){
                    this.varME.jlPhotoEditProfile.setName(file.getAbsolutePath());
                    this.varME.jlPhotoEditProfile.setIcon(new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(220, 150, Image.SCALE_DEFAULT)));
                    this.varME.jbtEditPhotoProfile.setVisible(true);
                    this.varME.jbtCancelEditPhoto.setVisible(true);
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Archivo no admitido, vuelva a intentarlo.");
                }
            }
        }
        
    }
    
    private void btnEdit(){
        this.varME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varME.jtfLastnames.getText().equalsIgnoreCase("")){
            if(!varME.jtfNames.getText().equalsIgnoreCase("")){
                if(!varME.jtfTelcel.getText().equalsIgnoreCase("")){
                    if(!varME.jtfMail.getText().equalsIgnoreCase("")){
                        if(!varME.jtfUsername.getText().equalsIgnoreCase("")){
                            if(!varME.jpfPassword.getText().equalsIgnoreCase("")){
                                String lastnames=varME.jtfLastnames.getText();
                                String names=varME.jtfNames.getText();
                                String telcel=varME.jtfTelcel.getText();
                                String mail=varME.jtfMail.getText();
                                String dni=varME.jtfDNI.getText();
                                String username=varME.jtfUsername.getText();
                                String password=varME.jpfPassword.getText();
                                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                    if(aux.getDni().equalsIgnoreCase(dni)){
                                        if(SQLUsers.getInstance().update(new ModelUsers(aux.getId(), lastnames, names, dni, telcel, mail, username, password, "S", aux.getDetails(), SourceCodes.getInstance().getCurrentDate()))){
                                            if(ControllerMail.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", aux.getEmail(), "Confirmación de edición del Perfil | Colegios Trilce ", "Estimado(a) "+aux.getLastnames()+", "+aux.getNames()+"\n\nSu cuenta ha sido modificada con éxito.\nSi no ha sido usted, contactenos para tomar cartas en el asunto.\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio. \n\nAtentamente:\n      Luis Alva Celis - Desarrollador del Sistema"))){
                                                if(ControllerMail.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", mail, "Edición del perfil | Colegios Trilce", "Estimado(a) "+aux.getLastnames()+", "+aux.getNames()+", su cuenta ha sido modificada con éxito, estos son los nuevos datos: \n\nApellidos: "+lastnames+"\nNombres: "+names+"\nDNI: "+dni+"\nTeléfono / Celular: "+telcel+"\nE-mail: "+mail+"\nUsuario: "+username+"\nContraseña: "+password+"\n\n Actualizado en la fecha: "+SourceCodes.getInstance().getCurrentDate()+"\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio.\n\nAtentamente:\n      Luis Alva Celis - Desarrollador del Sistema"))){
                                                    this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageSuccess("Perfíl editado con éxito.");
                                                }else{
                                                    this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo con los datos actualizados, vuelva a intentarlo más tarde.");
                                                }
                                            }else{
                                                this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo de confirmación de edición, vuelva a intentarlo de nuevo.");
                                            }
                                        }else{
                                            this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar los datos del perfil, vuelva a intentarlo de nuevo.");
                                        }
                                        break;
                                    }
                                }
                            }else{
                                this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Contraseña no ingresado, vuelva a intentarlo.");
                            }
                        }else{
                            this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Usuario no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: E-mail no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Teléfono / Celular no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Nombre no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Apellido no incresado, vuelva a intentarlo.");
        }
    }
    
    private void btnCancel(){
        for(ModelUsers aux:SQLUsers.getInstance().getList()){
            if(aux.getUsername().equalsIgnoreCase(ml.getAccount())){
                this.varME.jtfDNI.setText(aux.getDni());
                this.varME.jtfLastnames.setText(aux.getLastnames());
                this.varME.jtfNames.setText(aux.getNames());
                this.varME.jtfTelcel.setText(aux.getTelcel());
                this.varME.jtfMail.setText(aux.getEmail());
                this.varME.jtfUsername.setText(aux.getUsername());
                this.varME.jpfPassword.setText(aux.getPassword());
                break;
            }
        }
        this.varME.jckbCheckEdit.setSelected(false);
        this.ckbCheckEdit();
    }
    
    private void ckbShowPassword(){
        if(varME.jckbShowPassword.isSelected()){
            this.varME.jpfPassword.setEchoChar((char)0);
        }else{
            this.varME.jpfPassword.setEchoChar('•');
        }
    }
    
    private void ckbCheckEdit(){
        if(varME.jckbCheckEdit.isSelected()){
            this.varME.jtfLastnames.setEditable(true);
            this.varME.jtfNames.setEditable(true);
            this.varME.jtfTelcel.setEditable(true);
            this.varME.jtfMail.setEditable(true);
            this.varME.jtfUsername.setEditable(true);
            this.varME.jpfPassword.setEditable(true);
            this.varME.jbtEdit.setVisible(true);
            this.varME.jbtCancel.setVisible(true);
        }else{
            this.varME.jtfDNI.setEditable(false);
            this.varME.jtfLastnames.setEditable(false);
            this.varME.jtfNames.setEditable(false);
            this.varME.jtfTelcel.setEditable(false);
            this.varME.jtfMail.setEditable(false);
            this.varME.jtfUsername.setEditable(false);
            this.varME.jpfPassword.setEditable(false);
            this.varME.jbtEdit.setVisible(false);
            this.varME.jbtCancel.setVisible(false);
        }
    }
    
    private void btnReloadEnrolls(){
        this.initTable("", 1, varME.jtTableEnrolledCourse);
        SourceCodes.getInstance().sendMessageSuccess("Matriculas recargadas exitosamente.");
    }
    
    private void btnReloadNotes(){
        this.initTable("", 2, varME.jtTableNotes);
        SourceCodes.getInstance().sendMessageSuccess("Notas recargadas exitosamente.");
    }
    
    private void btnShowEnrolledCourses(){
        this.varME.jpEnrolledCourses.setVisible(true);
        this.varME.jpNotes.setVisible(false);
        this.varME.jpEditProfile.setVisible(false);
        this.initTable("", 1, varME.jtTableEnrolledCourse);
        this.varME.repaint();
    }
    
    private void btnShowNotes(){
        this.varME.jpNotes.setVisible(true);
        this.varME.jpEnrolledCourses.setVisible(false);
        this.varME.jpEditProfile.setVisible(false);
        this.initTable("", 2, varME.jtTableNotes);
        this.varME.repaint();
    }
    
    private void btnEditProfile(){
        this.varME.jpEditProfile.setVisible(true);
        this.varME.jpEnrolledCourses.setVisible(false);
        this.varME.jpNotes.setVisible(false);
        this.varME.jbtEditPhotoProfile.setVisible(false);
        this.varME.jbtCancelEditPhoto.setVisible(false);
        this.btnCancel();
        this.varME.repaint();
    }
    
    private void initTable(String search,int num,JTable table){
        String[] columns=new String[table.getModel().getColumnCount()];
        Object[] rows=new Object[table.getModel().getColumnCount()];
        table.setDefaultRenderer(Object.class, new AccesoryTable());
        for(int i=0;i<columns.length;i++){
            columns[i]=table.getModel().getColumnName(i);
        }
        DefaultTableModel dtm=new DefaultTableModel(null,columns){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        JButton jbt1=new JButton("Seleccionar");
        jbt1.setName("select");
        JButton jbt2=new JButton("Remover");
        jbt2.setName("remove");
        switch(num){
            case 1:{
                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                    if(aux.getUsername().equalsIgnoreCase(ml.getAccount())){
                        for(ModelStudentClass aux2:SQLStudentClass.getInstance().getList()){
                            if(aux2.getDni().equalsIgnoreCase(aux.getDni())){
                                for(ModelCalendar aux3:SQLCalendar.getInstance().getList()){
                                    if(aux3.getId()==aux2.getIdClass()){
                                        rows[0]=aux2.getId();
                                        rows[1]=aux3.getCourse();
                                        rows[2]=SQLUsers.getInstance().getFullNamesByDNI(aux3.getDni());
                                        rows[3]=SQLStudentGrade.getInstance().search(aux.getDni()).getGrade();
                                        rows[4]=aux3.getSection();
                                        rows[5]=aux3.getDay();
                                        rows[6]=aux3.getTurn();
                                        dtm.addRow(rows);
                                    }
                                }
                            }
                        }
                    }
                }
                table.setModel(dtm);
                break;
            }
            case 2:{
                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                    if(aux.getUsername().equalsIgnoreCase(ml.getAccount())){
                        for(ModelStudentNotes aux2:SQLStudentNotes.getInstance().getList()){
                            for(ModelStudentClass aux3:SQLStudentClass.getInstance().getList()){
                                if(aux2.getDni().equalsIgnoreCase(aux.getDni()) && aux3.getIdClass()==aux2.getIdClass()){
                                    for(ModelCalendar aux4:SQLCalendar.getInstance().getList()){
                                        if(aux4.getId()==aux3.getIdClass()){
                                            rows[0]=aux2.getId();
                                            rows[1]=aux2.getIdClass();
                                            rows[2]=aux4.getCourse();
                                            rows[3]=SQLUsers.getInstance().getFullNamesByDNI(aux4.getDni());
                                            rows[4]=aux2.getNote();
                                            rows[5]=aux2.getDate();
                                            dtm.addRow(rows);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
                table.setModel(dtm);
                break;
            }
            case 3:{
                for(ModelUsers aux1:SQLUsers.getInstance().getList()){
                    if(aux1.getUsername().equalsIgnoreCase(ml.getAccount())){
                        for(ModelStudentClass aux2:SQLStudentClass.getInstance().getList()){
                            if(aux2.getDni().equalsIgnoreCase(aux1.getDni())){
                                 
                            }
                        }
                    }
                }
                break;
            }
            default:
                break;
        }
    }
    
    private void loadConfig(){
        this.varME.jpEnrolledCourses.setVisible(false);
        this.varME.jpNotes.setVisible(false);
        this.varME.jpEditProfile.setVisible(false);
        this.varME.jScrollPane3.setVisible(false);
        this.ckbCheckEdit();
        for(ModelUsers aux:SQLUsers.getInstance().getList()){
            if(aux.getUsername().equalsIgnoreCase(ml.getAccount())){
                if(SQLPhotoPeople.getInstance().getImageByDNI(aux.getDni())!=null){
                    varME.jlImageProfile.setIcon(new ImageIcon(SQLPhotoPeople.getInstance().getImageByDNI(aux.getDni()).getImage().getScaledInstance(250, 150,Image.SCALE_DEFAULT)));
                }
                break;
            }
        }
    }
}
