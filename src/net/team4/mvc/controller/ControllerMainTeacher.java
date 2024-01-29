package net.team4.mvc.controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.team4.codes.AccesoryTable;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLPhotoPeople;
import net.team4.cruds.SQLStudentClass;
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
import net.team4.mvc.view.ViewMainTeacher;

public class ControllerMainTeacher implements ActionListener{
    
    private static ControllerMainTeacher instance;
    private ViewMainTeacher varVT;
    private ModelLogin ml;
    
    public ControllerMainTeacher(ViewMainTeacher vmt,ModelLogin ml){
        this.varVT=vmt;
        this.ml=ml;
        this.loadData(1);
        this.loadData(2);
        this.closePanels();
        this.registerEvents();
        this.varVT.setVisible(true);
    }
    
    public static ControllerMainTeacher getInstance(ViewMainTeacher vmt,ModelLogin ml){
        return instance=new ControllerMainTeacher(vmt,ml);
    }
    
    private void registerEvents(){
        this.varVT.jmiLogout.addActionListener(this);
        this.varVT.jbtEditProfile.addActionListener(this);
        this.varVT.jbtExaminePhotoProfile.addActionListener(this);
        this.varVT.jbtCancelEditPhoto.addActionListener(this);
        this.varVT.jbtEditPhotoProfile.addActionListener(this);
        this.varVT.jckbCheckEdit.addActionListener(this);
        this.varVT.jbtCancel.addActionListener(this);
        this.varVT.jckbShowPassword.addActionListener(this);
        this.varVT.jbtEdit.addActionListener(this);
        this.varVT.jbtNotes.addActionListener(this);
        this.varVT.jbtRegisterNoteStudent.addActionListener(this);
        this.varVT.jbtCancelEditNote.addActionListener(this);
        this.varVT.jtListStudentNotes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                mcTableListStudentNotes(e);
            }
        });
        this.varVT.jcbSelectClass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cbSelectClass();
            }
        });
        this.varVT.jtfNewNote.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                SourceCodes.getInstance().verifyTypeLetter(e);
            }
        });
        this.varVT.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(varVT.jmiLogout==e.getSource()){
            SourceCodes.getInstance().closeSession(varVT);
        }else if(varVT.jbtEditProfile==e.getSource()){
            this.btnEditProfile();
        }else if(varVT.jbtExaminePhotoProfile==e.getSource()){
            this.btnExaminePhotoProfile();
        }else if(varVT.jbtCancelEditPhoto==e.getSource()){
            this.btnCancelEditPhoto();
        }else if(varVT.jbtEditPhotoProfile==e.getSource()){
            this.btnEditPhotoProfile();
        }else if(varVT.jckbCheckEdit==e.getSource()){
            this.ckbCheckEdit();
        }else if(varVT.jbtCancel==e.getSource()){
            this.btnCancel();
        }else if(varVT.jckbShowPassword==e.getSource()){
            this.ckbShowPassword();
        }else if(varVT.jbtEdit==e.getSource()){
            this.btnEdit();
        }else if(varVT.jbtNotes==e.getSource()){
            this.btnNotes();
        }else if(varVT.jbtRegisterNoteStudent==e.getSource()){
            this.btnRegisterNoteStudent();
        }else if(varVT.jbtCancelEditNote==e.getSource()){
            this.btnCancelEditNote();
        }
    }
    
    private void btnCancelEditNote(){
        this.loadData(2);
        this.varVT.jtfIDStudentSelected.setText(null);
        this.varVT.jtfNewNote.setText(null);
    }
    
    private void btnRegisterNoteStudent(){
        this.varVT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varVT.jtfIDStudentSelected.getText().equalsIgnoreCase("")){
            if(!varVT.jtfNewNote.getText().equalsIgnoreCase("")){
                String nameClass=varVT.jcbSelectClass.getSelectedItem().toString();
                nameClass=nameClass.substring(4,6);
                String idClassString="";
                for(int i=0;i<nameClass.length();i++){
                    char idChar=nameClass.charAt(i);
                    if(idChar!=' '){
                        idClassString=idClassString+idChar;
                    }
                }
                int idClass =Integer.parseInt(idClassString);
                int idStudent=Integer.parseInt(varVT.jtfIDStudentSelected.getText());
                double note=Double.parseDouble(varVT.jtfNewNote.getText());
                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                    if(aux.getId()==idStudent){
                        if(SQLStudentNotes.getInstance().update(new ModelStudentNotes(aux.getDni(), idClass, note, SourceCodes.getInstance().getCurrentDate()))){
                            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            this.initTable(idClassString, 1, varVT.jtListStudentNotes);
                            this.varVT.jtfIDStudentSelected.setText(null);
                            this.varVT.jtfNewNote.setText(null);
                            SourceCodes.getInstance().sendMessageSuccess("Nota del estudiante actualizada con éxito.");
                        }else{
                            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar la note del estudiante, vuelva a intentarlo.");
                        }
                        break;
                    }
                }
            }else{
                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Nota del estudiante no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Estudiante no seleccionado, vuelva a intentarlo.");
        }
    }
    
    private void mcTableListStudentNotes(MouseEvent e){
        int click=varVT.jtListStudentNotes.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(varVT.jtListStudentNotes.getValueAt(click, 0).toString());
        int column=varVT.jtListStudentNotes.getColumnModel().getColumnIndexAtX(e.getX());
        int columnCount=varVT.jtListStudentNotes.getColumnCount();
        int row=e.getY()/varVT.jtListStudentNotes.getRowHeight();
        int rowCount=varVT.jtListStudentNotes.getRowCount();
        if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
            Object value=varVT.jtListStudentNotes.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn=(JButton)value;
                if(btn.getName().equals("select")){
                    int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar a este estudiante?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                    if(result==0){
                        this.varVT.jtfIDStudentSelected.setText(String.valueOf(id));
                    }
                }
            }
        }
    }
    
    private void btnNotes(){
        this.varVT.jpEditNotes.setVisible(true);
        this.varVT.jpEditProfile.setVisible(false);
        this.varVT.repaint();
        this.loadData(2);
    }
    
    private void cbSelectClass(){
        this.varVT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(varVT.jcbSelectClass.getSelectedIndex()!=0){
            if(varVT.jcbSelectClass.getSelectedItem()!=null){
                String nameCourse=varVT.jcbSelectClass.getSelectedItem().toString();
                nameCourse=nameCourse.substring(4,6);
                String id="";
                for(int i=0;i<nameCourse.length();i++){
                    char idChar=nameCourse.charAt(i);
                    if(idChar!=' '){
                        id=id+idChar;
                    }
                }
                this.initTable(id, 1, varVT.jtListStudentNotes);
                this.varVT.jpEditStudentNote.setVisible(true);
                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }else{
            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.varVT.jpEditStudentNote.setVisible(false);
        }
    }
    
    private void btnEdit(){
        this.varVT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varVT.jtfLastnames.getText().equalsIgnoreCase("")){
            if(!varVT.jtfNames.getText().equalsIgnoreCase("")){
                if(!varVT.jtfTelcel.getText().equalsIgnoreCase("")){
                    if(!varVT.jtfMail.getText().equalsIgnoreCase("")){
                        if(!varVT.jtfUsername.getText().equalsIgnoreCase("")){
                            if(!varVT.jpfPassword.getText().equalsIgnoreCase("")){
                                String lastnames=varVT.jtfLastnames.getText();
                                String names=varVT.jtfNames.getText();
                                String telcel=varVT.jtfTelcel.getText();
                                String mail=varVT.jtfMail.getText();
                                String dni=varVT.jtfDNI.getText();
                                String username=varVT.jtfUsername.getText();
                                String password=varVT.jpfPassword.getText();
                                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                    if(aux.getDni().equalsIgnoreCase(dni)){
                                        if(SQLUsers.getInstance().update(new ModelUsers(aux.getId(), lastnames, names, dni, telcel, mail, username, password, "T", aux.getDetails(), SourceCodes.getInstance().getCurrentDate()))){
                                            if(ControllerMail.getInstance().sendMail(new Mail(CreateFile.getInstance().getAccountNotification(), CreateFile.getInstance().getAccountPasswordNotification(), aux.getEmail(), "Confirmación de edición del Perfil | Colegios Trilce ", "Estimado(a) "+aux.getLastnames()+", "+aux.getNames()+"\n\nSu cuenta ha sido modificada con éxito.\nSi no ha sido usted, contactenos para tomar cartas en el asunto.\n\nAtentamente:\n      Luis Alva Celis - Desarrollador del Sistema"))){
                                                if(ControllerMail.getInstance().sendMail(new Mail(CreateFile.getInstance().getAccountNotification(), CreateFile.getInstance().getAccountPasswordNotification(), mail, "Edición del perfil | Colegios Trilce", "Estimado(a) "+aux.getLastnames()+", "+aux.getNames()+", su cuenta ha sido modificada con éxito, estos son los nuevos datos: \n\nApellidos: "+lastnames+"\nNombres: "+names+"\nDNI: "+dni+"\nTeléfono / Celular: "+telcel+"\nE-mail: "+mail+"\nUsuario: "+username+"\nContraseña: "+password+"\n\n Actualizado en la fecha: "+SourceCodes.getInstance().getCurrentDate()+"\nAtentamente:      Luis Alva Celis - Desarrollador del Sistema"))){
                                                    this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageSuccess("Perfíl editado con éxito.");
                                                }else{
                                                    this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo con los datos actualizados, vuelva a intentarlo más tarde.");
                                                }
                                            }else{
                                                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo de confirmación de edición, vuelva a intentarlo de nuevo.");
                                            }
                                        }else{
                                            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar los datos del perfil, vuelva a intentarlo de nuevo.");
                                        }
                                        break;
                                    }
                                }
                            }else{
                                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Contraseña no ingresado, vuelva a intentarlo.");
                            }
                        }else{
                            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Usuario no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: E-mail no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Teléfono / Celular no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Nombre no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Apellido no incresado, vuelva a intentarlo.");
        }
    }
    
    private void ckbShowPassword(){
        if(varVT.jckbShowPassword.isSelected()){
            this.varVT.jpfPassword.setEchoChar((char)0);
        }else{
            this.varVT.jpfPassword.setEchoChar('•');
        }
    }
    
    private void btnCancel(){
        for(ModelUsers aux1:SQLUsers.getInstance().getList()){
            if(aux1.getUsername().equalsIgnoreCase(ml.getAccount())){
                this.varVT.jtfLastnames.setText(aux1.getLastnames());
                this.varVT.jtfNames.setText(aux1.getNames());
                this.varVT.jtfTelcel.setText(aux1.getTelcel());
                this.varVT.jtfMail.setText(aux1.getEmail());
                this.varVT.jtfUsername.setText(aux1.getUsername());
                this.varVT.jpfPassword.setText(aux1.getPassword());
                this.varVT.jtfDNI.setText(aux1.getDni());
                if(SQLPhotoPeople.getInstance().getImageByDNI(aux1.getDni())!=null){
                    this.varVT.jlImageProfile.setIcon(new ImageIcon(SQLPhotoPeople.getInstance().getImageByDNI(aux1.getDni()).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));
                }
                break;
            }
        }
        this.varVT.jbtCancel.setVisible(false);
        this.varVT.jbtEdit.setVisible(false);
        this.varVT.jckbCheckEdit.setSelected(false);
        this.ckbCheckEdit();
    }
    
    private void ckbCheckEdit(){
        if(varVT.jckbCheckEdit.isSelected()){
            this.varVT.jtfLastnames.setEditable(true);
            this.varVT.jtfNames.setEditable(true);
            this.varVT.jtfTelcel.setEditable(true);
            this.varVT.jtfMail.setEditable(true);
            this.varVT.jtfUsername.setEditable(true);
            this.varVT.jtfUsername.setEditable(true);
            this.varVT.jpfPassword.setEditable(true);
            this.varVT.jbtCancel.setVisible(true);
            this.varVT.jbtEdit.setVisible(true);
        }else{
            this.varVT.jtfLastnames.setEditable(false);
            this.varVT.jtfNames.setEditable(false);
            this.varVT.jtfTelcel.setEditable(false);
            this.varVT.jtfMail.setEditable(false);
            this.varVT.jtfUsername.setEditable(false);
            this.varVT.jtfUsername.setEditable(false);
            this.varVT.jpfPassword.setEditable(false);
            this.varVT.jbtCancel.setVisible(false);
            this.varVT.jbtEdit.setVisible(false);
        }
    }
    
    private void btnEditPhotoProfile(){
        this.varVT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(varVT.jlPhotoEditProfile.getIcon()!=null){
            for(ModelUsers aux1:SQLUsers.getInstance().getList()){
                if(aux1.getUsername().equalsIgnoreCase(ml.getAccount())){
                    try {
                        File file=new File(varVT.jlPhotoEditProfile.getName());
                        FileInputStream fis=new FileInputStream(file);
                        if(SQLPhotoPeople.getInstance().getImageByDNI(aux1.getDni()) !=null){
                            for(ModelPhotoPeople aux2:SQLPhotoPeople.getInstance().getList()){
                                if(aux2.getDni().equalsIgnoreCase(aux1.getDni())){
                                    if(SQLPhotoPeople.getInstance().update(new ModelPhotoPeople(aux2.getId(), fis))){
                                        this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageSuccess("Foto de perfil actualizada con éxito.");
                                        this.varVT.jbtCancelEditPhoto.doClick();
                                        this.loadData(1);
                                    }else{
                                        this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar la foto de perfil, vuelva a intentarlo.");
                                    }
                                    break;
                                }
                            }
                        }else{
                            if(SQLPhotoPeople.getInstance().insert(new ModelPhotoPeople(aux1.getDni(), fis))){
                                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageSuccess("Foto del perfil registrada con éxito.");
                                this.varVT.jbtCancelEditPhoto.doClick();
                                this.loadData(1);
                            }else{
                                this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la foto del perfil, vuelva a intentarlo.");
                            }
                        }
                    } catch (Exception e) {
                        this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        CreateFile.getInstance().writeFileLogs(null, e);
                    }
                    break;
                }
            }
        }else{
            this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Imagen de perfíl no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void btnCancelEditPhoto(){
        this.varVT.jlPhotoEditProfile.setIcon(null);
        this.varVT.jlPhotoEditProfile.setName(null);
        this.varVT.jbtEditPhotoProfile.setVisible(false);
        this.varVT.jbtCancelEditPhoto.setVisible(false);
    }
    
    private void btnExaminePhotoProfile(){
        JFileChooser jfc=new JFileChooser();
        if(jfc.showDialog(this.varVT, "Seleccione imagen (.jpg, .png, .gif)")==JFileChooser.APPROVE_OPTION){
            File file=jfc.getSelectedFile();
            if(file.canRead()){
                if(file.getName().endsWith("jpg") || file.getName().endsWith("png") || file.getName().endsWith("gif")){
                    this.varVT.jlPhotoEditProfile.setName(file.getAbsolutePath());
                    this.varVT.jlPhotoEditProfile.setIcon(new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(220, 150, Image.SCALE_DEFAULT)));
                    this.varVT.jbtEditPhotoProfile.setVisible(true);
                    this.varVT.jbtCancelEditPhoto.setVisible(true);
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Archivo no admitido, vuelva a intentarlo.");
                }
            }else{
                SourceCodes.getInstance().sendMessageError("Error: No se puede reconocer el archivo, vuelva a intentarlo.");
            }
        }
    }
    
    private void btnEditProfile(){
        this.varVT.jpEditProfile.setVisible(true);
        this.varVT.jpEditNotes.setVisible(false);
        this.varVT.repaint();
    }
    
    private void loadData(int num){
        if(num==1){
            this.varVT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            this.varVT.jbtCancelEditPhoto.setVisible(false);
            this.varVT.jbtEditPhotoProfile.setVisible(false);
            this.ckbCheckEdit();
            for(ModelUsers aux1:SQLUsers.getInstance().getList()){
                if(aux1.getUsername().equalsIgnoreCase(ml.getAccount())){
                    this.varVT.jtfLastnames.setText(aux1.getLastnames());
                    this.varVT.jtfNames.setText(aux1.getNames());
                    this.varVT.jtfTelcel.setText(aux1.getTelcel());
                    this.varVT.jtfMail.setText(aux1.getEmail());
                    this.varVT.jtfUsername.setText(aux1.getUsername());
                    this.varVT.jpfPassword.setText(aux1.getPassword());
                    this.varVT.jtfDNI.setText(aux1.getDni());
                    if(SQLPhotoPeople.getInstance().getImageByDNI(aux1.getDni())!=null){
                        this.varVT.jlImageProfile.setIcon(new ImageIcon(SQLPhotoPeople.getInstance().getImageByDNI(aux1.getDni()).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));
                    }
                    this.varVT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    break;
                }
            }
        }else if(num==2){
            this.varVT.jpEditStudentNote.setVisible(false);
            this.varVT.jcbSelectClass.removeAllItems();
            this.varVT.jcbSelectClass.addItem("---- Seleccione ----");
            for(ModelUsers aux1:SQLUsers.getInstance().getList()){
                if(aux1.getUsername().equalsIgnoreCase(ml.getAccount())){
                    for(ModelCalendar aux2:SQLCalendar.getInstance().getList()){
                        if(aux2.getDni().equalsIgnoreCase(aux1.getDni())){
                            this.varVT.jcbSelectClass.addItem("ID: "+aux2.getId()+" - Curso: "+aux2.getCourse()+" - Turno: "+aux2.getTurn()+" - Sección: "+aux2.getSection()+" - Día: "+aux2.getDay());
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void closePanels(){
        this.varVT.jpEditNotes.setVisible(false);
        this.varVT.jpEditProfile.setVisible(false);
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
        JButton jb1=new JButton("Seleccionar");
        jb1.setName("select");
        JButton jb2=new JButton("Remover");
        jb2.setName("remove");
        if(num==1){
            if(!search.equalsIgnoreCase("")){
                for(ModelStudentClass aux:SQLStudentClass.getInstance().getList()){
                    if(String.valueOf(aux.getIdClass()).equalsIgnoreCase(search)){
                        String dni=aux.getDni();
                        rows[0]=SQLUsers.getInstance().getIDByDNI(dni);
                        rows[1]=SQLUsers.getInstance().getFullNamesByDNI(dni);
                        rows[2]=SQLStudentNotes.getInstance().getNoteByDNI(aux.getDni(), aux.getIdClass());
                        rows[3]=SQLStudentNotes.getInstance().getDateByDNI(dni, aux.getIdClass());
                        rows[4]=jb1;
                        dtm.addRow(rows);
                    }
                }
                table.setModel(dtm);
            }
        }else if(num==2){
            
        }
    }
}
