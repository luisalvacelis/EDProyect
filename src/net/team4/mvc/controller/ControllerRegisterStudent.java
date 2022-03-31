package net.team4.mvc.controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.team4.codes.AccesoryTable;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLStudentClass;
import net.team4.cruds.SQLStudentGrade;
import net.team4.cruds.SQLStudentNotes;
import net.team4.cruds.SQLUsers;
import net.team4.mail.ControllerMail;
import net.team4.mail.Mail;
import net.team4.mvc.model.ModelCalendar;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelStudentClass;
import net.team4.mvc.model.ModelStudentGrade;
import net.team4.mvc.model.ModelStudentNotes;
import net.team4.mvc.model.ModelUsers;
import net.team4.mvc.view.ViewEnrolls;
import net.team4.mvc.view.ViewMainAdministrator;
import net.team4.mvc.view.ViewRegisterStudent;

public class ControllerRegisterStudent implements ActionListener{
    
    private static ControllerRegisterStudent instance;
    private ViewRegisterStudent varRS;
    private ModelLogin ml;
    private ModelUsers mu;
    private ModelStudentGrade msg;
    private ModelStudentClass msc;
    
    public ControllerRegisterStudent(ViewRegisterStudent vrs){
        this.varRS=vrs;
        this.varRS.setVisible(true);
        this.loadData();
        this.registerEvents();
    }
    
    public static ControllerRegisterStudent getInstance(ViewRegisterStudent vrs){
        return instance=new ControllerRegisterStudent(vrs);
    }
    
    private void registerEvents(){
        this.varRS.jbtNewStudent.addActionListener(this);
        this.varRS.jbtRegisterStudent.addActionListener(this);
        this.varRS.jbtUpdateStudent.addActionListener(this);
        this.varRS.jbtNewStudentEnroll.addActionListener(this);
        this.varRS.jbtEnrollStudent.addActionListener(this);
        this.varRS.jbtShowDetailsEnroll.addActionListener(this);
        this.varRS.jtfSearchStudentTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                initTable(varRS.jtfSearchStudentTable.getText(), 1, varRS.jtTableStudent);
            }
        });
        this.varRS.jtfSearchStudentList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                initTable(varRS.jtfSearchStudentList.getText(), 2, varRS.jtListStudent);
            }
        });
        this.varRS.jtfSearchClass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                initTable(varRS.jtfSearchClass.getText(), 3, varRS.jtListClass);
            }
        });
        this.varRS.jtfSearchEnroll.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                initTable(varRS.jtfSearchEnroll.getText(), 4, varRS.jtListEnroll);
            }
        });
        this.varRS.jtTableStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 1, varRS.jtTableStudent);
            }
        });
        this.varRS.jtListStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 2, varRS.jtListStudent);
            }
        });
        this.varRS.jtListClass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 3, varRS.jtListClass);
            }
        });
        this.varRS.jtListEnroll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 2, varRS.jtListEnroll);
            }
        });
        this.varRS.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    ControllerMainAdministrator.getInstance(new ViewMainAdministrator()).setAccount(ml);
                    varRS.dispose();
                } catch (Exception ex) {
                    CreateFile.getInstance().writeFileLogs(null, ex);
                }
            }
        });
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(varRS.jbtNewStudentEnroll==e.getSource()){
            this.btnNewStudentEnroll();
        }else if(varRS.jbtEnrollStudent==e.getSource()){
            this.btnEnrollStudent();
        }else if(varRS.jbtShowDetailsEnroll==e.getSource()){
            this.btnShowDetailsEnroll();
        }else if(varRS.jbtNewStudent==e.getSource()){
            this.btnNewStudent();
        }else if(varRS.jbtRegisterStudent==e.getSource()){
            this.btnRegisterStudent();
        }else if(varRS.jbtUpdateStudent==e.getSource()){
            this.btnUpdateStudent();
        }
    }
    
    private void btnNewStudentEnroll(){
        this.varRS.jtfSearchStudentList.setText(null);
        this.varRS.jtfSearchClass.setText(null);
        this.varRS.jtfSearchEnroll.setText(null);
        this.varRS.jtaPreparationEnroll.setText(null);
        this.varRS.jtListStudent.clearSelection();
        this.varRS.jtListClass.clearSelection();
        this.varRS.jtListEnroll.clearSelection();
        this.loadData();
    }
    
    private void btnEnrollStudent(){
        this.varRS.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(msc.getDni()!=null){
            if(msc.getIdClass()!=0){
                boolean status=false;
                for(ModelStudentClass aux:SQLStudentClass.getInstance().getList()){
                    if(aux.getDni().equalsIgnoreCase(msc.getDni()) && aux.getIdClass()==msc.getIdClass()){
                        status=true;
                        break;
                    }
                }
                if(!status){
                    if(SQLStudentClass.getInstance().insert(msc)){
                        if(SQLStudentNotes.getInstance().insert(new ModelStudentNotes(msc.getDni(), msc.getIdClass(), 0, SourceCodes.getInstance().getCurrentDate()))){
                            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            this.varRS.jbtNewStudentEnroll.doClick();
                            SourceCodes.getInstance().sendMessageSuccess("Matricula registrada con éxito.");
                        }else{
                            SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la matricula en la tabla de student_notes.");
                        }
                    }else{
                        this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la matricula del estudiante identificado con el DNI '"+msc.getDni()+"', vuelva a intentarlo.");
                    }
                }else{
                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Estudiante ya matriculado en esa clase, vuelva a intentarlo.");
                }
            }else{
                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Clase no seleccionada, vuelva a intentarlo.");
            }
        }else{
            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Estudiante no seleccionado, vuelva a intentarlo.");
        }
    }
    
    private void btnShowDetailsEnroll(){
        try {
            ControllerEnrolls.getInstance(new ViewEnrolls()).setAccount(ml);
            this.varRS.dispose();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void btnNewStudent(){
        this.varRS.jbtUpdateStudent.setEnabled(false);
        this.varRS.jbtRegisterStudent.setEnabled(true);
        this.varRS.jtfLastnamesStudent.setText(null);
        this.varRS.jtfNamesStudent.setText(null);
        this.varRS.jtfDNIStudent.setText(null);
        this.varRS.jtfTelCelStudent.setText(null);
        this.varRS.jtfEmailStudent.setText(null);
        this.varRS.jcbSelectGrade.setSelectedIndex(0);
        this.varRS.jtTableStudent.clearSelection();
        this.varRS.jtListClass.clearSelection();
        this.varRS.jtListStudent.clearSelection();
        this.varRS.jtfSearchClass.setText(null);
        this.varRS.jtfSearchStudentList.setText(null);
        this.varRS.jtfSearchStudentTable.setText(null);
        this.varRS.jtaDetailsStudent.setText(null);
        this.varRS.jtfDNIStudent.setEnabled(true);
        this.loadData();
    }
    
    private void btnRegisterStudent(){
        this.varRS.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varRS.jtfLastnamesStudent.getText().equalsIgnoreCase("")){
            if(!varRS.jtfNamesStudent.getText().equalsIgnoreCase("")){
                if(!varRS.jtfDNIStudent.getText().equalsIgnoreCase("")){
                    if(!varRS.jtfTelCelStudent.getText().equalsIgnoreCase("")){
                        if(!varRS.jtfEmailStudent.getText().equalsIgnoreCase("")){
                            if(varRS.jcbSelectGrade.getSelectedIndex()!=0){
                                if(!varRS.jtaDetailsStudent.getText().equalsIgnoreCase("")){
                                    String lastnames=varRS.jtfLastnamesStudent.getText();
                                    String names=varRS.jtfNamesStudent.getText();
                                    String dni=varRS.jtfDNIStudent.getText();
                                    String telcel=varRS.jtfTelCelStudent.getText();
                                    String email=varRS.jtfEmailStudent.getText();
                                    String user=SourceCodes.getInstance().getWordRandom();
                                    String pass=SourceCodes.getInstance().getWordRandom();
                                    String type="S";
                                    String details=varRS.jtaDetailsStudent.getText();
                                    String date=SourceCodes.getInstance().getCurrentDate();
                                    String grade=varRS.jcbSelectGrade.getSelectedItem().toString();
                                    if(SQLUsers.getInstance().searchByDNI(dni)==null){
                                        if(SQLUsers.getInstance().insert(new ModelUsers(lastnames, names, dni, telcel, email, user, pass, type, details, date))){
                                            if(SQLStudentGrade.getInstance().insert(new ModelStudentGrade(dni, grade))){
                                                if(ControllerMail.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", email, "Colegio Trilce", "¡Bievenido al sistema del colegio Trilce!\n\nEstimado(a) "+lastnames.toUpperCase()+", "+names.toUpperCase()+"\nEsperamos que su estancia con nosotros sea de su agrado y aprenda mucho.\nA continuación se le mostrará los detalles de su cuenta.\n\nUsuario: "+user+"\nClave: "+pass+"\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio.\n\nAtentamente: \n      Luis Alva Celis - Desarrollador del sistema."))){
                                                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    this.varRS.jbtNewStudent.doClick();
                                                    SourceCodes.getInstance().sendMessageSuccess("Estudiante registrado con éxito.");
                                                }else{
                                                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo al estudiante, vuelva a intentarlo.");
                                                }
                                            }else{
                                                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar el grado del estudiante, vuelva a intentarlo.");
                                            }
                                        }else{
                                            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar al estudiante, vuelva a intentarlo.");
                                        }
                                    }else{
                                        this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageError("Error: Usuario ya ha sido registrado anteriormente en el sistema, vuelva a intentarlo.");
                                    }
                                }else{
                                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Detalle del estudiante no ingresado, vuelva a intentarlo.");
                                }
                            }else{
                                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Grado del estudiante no ingresado, vuelva a intentarlo.");
                            }
                        }else{
                            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Email del estudiante no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Teléfono/Celular no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: DNI del estudiante no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Nombre del estudiante no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Apellidos del estudiante no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void btnUpdateStudent(){
        this.varRS.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varRS.jtfLastnamesStudent.getText().equalsIgnoreCase("")){
            if(!varRS.jtfNamesStudent.getText().equalsIgnoreCase("")){
                if(!varRS.jtfDNIStudent.getText().equalsIgnoreCase("")){
                    if(!varRS.jtfTelCelStudent.getText().equalsIgnoreCase("")){
                        if(!varRS.jtfEmailStudent.getText().equalsIgnoreCase("")){
                            if(varRS.jcbSelectGrade.getSelectedIndex()!=0){
                                if(!varRS.jtaDetailsStudent.getText().equalsIgnoreCase("")){
                                    String lastnames=varRS.jtfLastnamesStudent.getText();
                                    String names=varRS.jtfNamesStudent.getText();
                                    String dni=varRS.jtfDNIStudent.getText();
                                    String telcel=varRS.jtfTelCelStudent.getText();
                                    String email=varRS.jtfEmailStudent.getText();
                                    String user=SourceCodes.getInstance().getWordRandom();
                                    String pass=SourceCodes.getInstance().getWordRandom();
                                    String type="S";
                                    String details=varRS.jtaDetailsStudent.getText();
                                    String date=SourceCodes.getInstance().getCurrentDate();
                                    String grade=varRS.jcbSelectGrade.getSelectedItem().toString();
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==mu.getId()){
                                            if(ControllerMail.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", aux.getEmail(), "Colegio Trilce", "Estimado(a) "+aux.getLastnames()+", "+aux.getNames()+"\nSu cuenta ha sido modificada.\nSi no ha sido usted pongase en contacto con el colegio para verificar el caso.\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio.\n\nAtentamente: \n      Luis Alva Celis - Desarrollador del sistema."))){
                                                CreateFile.getInstance().writeFileLogs("Notificación enviada al estudiante con el ID "+aux.getId(), null);
                                                break;
                                            }else{
                                                CreateFile.getInstance().writeFileLogs("Error: No se pudo enviar la notificación al estudiante con el ID '"+aux.getId()+"'", null);
                                                break;
                                            }
                                        }
                                    }
                                    
                                    if(SQLUsers.getInstance().update(new ModelUsers(mu.getId(),lastnames, names, dni, telcel, email, user, pass, type, details, date))){
                                        if(SQLStudentGrade.getInstance().update(new ModelStudentGrade(msg.getId(),dni, grade))){
                                            if(ControllerMail.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", email, "Colegio Trilce", "Estimado(a) estudiante identificado con el ID '"+mu.getId()+"'\nSu cuenta ha sido actualizada.\nA continuación se le mostrará los detalles de su cuenta.\n\nApellidos: "+lastnames+"\nNombre: "+names+"\nDNI: "+dni+"\nTeléfono / Celular: "+telcel+"\nGrado: "+grade+"\nUsuario: "+user+"\nClave: "+pass+"\n\nAtentamente: \n      Luis Alva Celis - Desarrollador del sistema."))){
                                                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                this.varRS.jbtNewStudent.doClick();
                                                this.initTable("", 1, varRS.jtTableStudent);
                                                this.initTable("", 2, varRS.jtListStudent);
                                                SourceCodes.getInstance().sendMessageSuccess("Estudiante actualizado con éxito.");
                                            }else{
                                                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar el correo al estudiante, vuelva a intentarlo.");
                                            }
                                        }else{
                                            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar el grado del estudiante, vuelva a intentarlo.");
                                        }
                                    }else{
                                        this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar al estudiante, vuelva a intentarlo.");
                                    }
                                }else{
                                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Detalle del estudiante no ingresado, vuelva a intentarlo.");
                                }
                            }else{
                                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Grado del estudiante no ingresado, vuelva a intentarlo.");
                            }
                        }else{
                            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Email del estudiante no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Teléfono/Celular no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: DNI del estudiante no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Nombre del estudiante no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varRS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Apellidos del estudiante no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void loadData(){
        this.mu=new ModelUsers();
        this.msg=new ModelStudentGrade();
        this.msc=new ModelStudentClass();
        this.initTable("", 1,varRS.jtTableStudent);
        this.initTable("", 2,varRS.jtListStudent);
        this.initTable("", 3,varRS.jtListClass);
        this.initTable("", 4, varRS.jtListEnroll);
        this.varRS.jtpPanel.setIconAt(0, new ImageIcon(getClass().getResource("/net/team4/images/estudiante.png")));
        this.varRS.jtpPanel.setIconAt(1, new ImageIcon(getClass().getResource("/net/team4/images/prueba.png")));
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
        switch(num){
            case 1:{
                if(search.equalsIgnoreCase("")){
                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                        if(aux.getType().equalsIgnoreCase("S")){
                            rows[0]=aux.getId();
                            rows[1]=aux.getLastnames()+", "+aux.getNames();
                            rows[2]=aux.getDni();
                            rows[3]=aux.getTelcel();
                            rows[4]=aux.getEmail();
                            rows[5]=SQLStudentGrade.getInstance().search(aux.getDni()).getGrade();
                            rows[6]=aux.getDate();
                            rows[7]=jb1;
                            rows[8]=jb2;
                            dtm.addRow(rows);
                        }
                    }
                    table.setModel(dtm);
                }else{
                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                        if(aux.getType().equalsIgnoreCase("S")){
                            if(SQLUsers.getInstance().getFullNamesByDNI(aux.getDni()).contains(search) || String.valueOf(aux.getId()).equalsIgnoreCase(search) || aux.getDni().equalsIgnoreCase(search) || aux.getEmail().equalsIgnoreCase(search)){
                                rows[0]=aux.getId();
                                rows[1]=aux.getLastnames()+", "+aux.getNames();
                                rows[2]=aux.getDni();
                                rows[3]=aux.getTelcel();
                                rows[4]=aux.getEmail();
                                rows[5]=SQLStudentGrade.getInstance().search(aux.getDni()).getGrade();
                                rows[6]=aux.getDate();
                                rows[7]=jb1;
                                rows[8]=jb2;
                                dtm.addRow(rows);
                            }
                        }
                    }
                    table.setModel(dtm);
                }
                break;
            }
            case 2:{
                if(search.equalsIgnoreCase("")){
                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                        if(aux.getType().equalsIgnoreCase("S")){
                            rows[0]=aux.getId();
                            rows[1]=aux.getLastnames()+", "+aux.getNames();
                            rows[2]=SQLStudentGrade.getInstance().search(aux.getDni()).getGrade();
                            rows[3]=jb1;
                            dtm.addRow(rows);
                        }
                    }
                    table.setModel(dtm);
                }else{
                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                        if(aux.getType().equalsIgnoreCase("S")){
                            if(SQLUsers.getInstance().getFullNamesByDNI(aux.getDni()).contains(search) || String.valueOf(aux.getId()).equalsIgnoreCase(search) || SQLStudentGrade.getInstance().search(aux.getDni()).getGrade().equalsIgnoreCase(search)){
                                rows[0]=aux.getId();
                                rows[1]=aux.getLastnames()+", "+aux.getNames();
                                rows[2]=SQLStudentGrade.getInstance().search(aux.getDni()).getGrade();
                                rows[3]=jb1;
                                dtm.addRow(rows);
                            }
                        }
                    }
                    table.setModel(dtm);
                }
                break;
            }
            case 3:{
                if(search.equalsIgnoreCase("")){
                    for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                        rows[0]=aux.getId();
                        rows[1]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                        rows[2]=aux.getCourse();
                        rows[3]=aux.getTurn();
                        rows[4]=aux.getSection();
                        rows[5]=aux.getDay();
                        rows[6]=jb1;
                        dtm.addRow(rows);
                    }
                    table.setModel(dtm);
                }else{
                    for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                        if(String.valueOf(aux.getId()).equalsIgnoreCase(search) || SQLUsers.getInstance().getFullNamesByDNI(aux.getDni()).contains(search) || aux.getCourse().contains(search) || aux.getTurn().equalsIgnoreCase(search) || aux.getSection().equalsIgnoreCase(search) || aux.getDay().equalsIgnoreCase(search)){
                            rows[0]=aux.getId();
                            rows[1]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                            rows[2]=aux.getCourse();
                            rows[3]=aux.getTurn();
                            rows[4]=aux.getSection();
                            rows[5]=aux.getDay();
                            rows[6]=jb1;
                            dtm.addRow(rows);
                        }
                    }
                    table.setModel(dtm);
                }
                break;
            }
            case 4:{
                if(search.equalsIgnoreCase("")){
                    for(ModelStudentClass aux:SQLStudentClass.getInstance().getList()){
                        rows[0]=aux.getId();
                        rows[1]=aux.getIdClass();
                        rows[2]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                        for(ModelCalendar auxmc:SQLCalendar.getInstance().getList()){
                            if(auxmc.getId()==aux.getIdClass()){
                                rows[3]=SQLUsers.getInstance().getFullNamesByDNI(auxmc.getDni());
                                rows[4]=auxmc.getCourse();
                                break;
                            }
                        }
                        rows[5]=jb2;
                        dtm.addRow(rows);
                    }
                    table.setModel(dtm);
                }else{
                    for(ModelStudentClass aux:SQLStudentClass.getInstance().getList()){
                        if(String.valueOf(aux.getId()).equalsIgnoreCase(search) || String.valueOf(aux.getIdClass()).equalsIgnoreCase(search)){
                            rows[0]=aux.getId();
                            rows[1]=aux.getIdClass();
                            rows[2]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                            for(ModelCalendar auxmc:SQLCalendar.getInstance().getList()){
                                if(auxmc.getId()==aux.getIdClass()){
                                    rows[3]=SQLUsers.getInstance().getFullNamesByDNI(auxmc.getDni());
                                    rows[4]=auxmc.getCourse();
                                    break;
                                }
                            }
                            rows[5]=jb2;
                            dtm.addRow(rows);
                        }
                    }
                    table.setModel(dtm);
                }
                break;
            }
            default:
                break;
        }
    }
    
    private void clickTable(MouseEvent e, int num, JTable table){
        int click=table.rowAtPoint(e.getPoint());
        int column=table.getColumnModel().getColumnIndexAtX(e.getX());
        int columnCount=table.getColumnCount();
        int row=e.getY()/table.getRowHeight();
        int rowCount=table.getRowCount();
        if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
            Object value=table.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn=(JButton)value;
                switch(btn.getName()){
                    case "select":{
                        switch(num){
                            case 1:{
                                int id=Integer.parseInt(table.getValueAt(click, 0).toString());
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar a este estudiante?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==id){
                                            this.mu.setId(id);
                                            this.varRS.jtfLastnamesStudent.setText(aux.getLastnames());
                                            this.varRS.jtfNamesStudent.setText(aux.getNames());
                                            this.varRS.jtfDNIStudent.setText(aux.getDni());
                                            this.varRS.jtfDNIStudent.setEnabled(false);
                                            this.varRS.jtfTelCelStudent.setText(aux.getTelcel());
                                            this.varRS.jtfEmailStudent.setText(aux.getEmail());
                                            this.varRS.jcbSelectGrade.setSelectedItem(SQLStudentGrade.getInstance().search(aux.getDni()).getGrade());
                                            this.varRS.jtaDetailsStudent.setText(aux.getDetails());
                                            this.varRS.jbtRegisterStudent.setEnabled(false);
                                            this.varRS.jbtUpdateStudent.setEnabled(true);
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:{
                                int id=Integer.parseInt(table.getValueAt(click, 0).toString());
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar a este estudiante?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==id){
                                            String text=varRS.jtaPreparationEnroll.getText();
                                            if(!text.contains("Estudiante sleeccionado:")){
                                                this.varRS.jtaPreparationEnroll.append("Estudiante seleccionado: "+SQLUsers.getInstance().getFullNamesByDNI(aux.getDni())+"\n");
                                                this.msc.setDni(aux.getDni());
                                            }else{
                                                this.varRS.jtaPreparationEnroll.setText(text.replaceAll("Estudiante seleccionado: "+SQLUsers.getInstance().getFullNamesByDNI(msc.getDni())+"\n", "Estudiante seleccionado: "+SQLUsers.getInstance().getFullNamesByDNI(aux.getDni())+"\n"));
                                                this.msc.setDni(aux.getDni());
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 3:{
                                int id=Integer.parseInt(table.getValueAt(click, 0).toString());
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar esta clase?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                                        if(aux.getId()==id){
                                            String text=varRS.jtaPreparationEnroll.getText();
                                            if(!text.contains("Clase seleccionada:")){
                                                this.varRS.jtaPreparationEnroll.append("Clase seleccionada: "+aux.getId()+"\n");
                                                this.msc.setIdClass(aux.getId());
                                            }else{
                                                this.varRS.jtaPreparationEnroll.setText(text.replaceAll("Clase seleccionada: "+msc.getId()+"\n", "Estudiante seleccionado: "+aux.getId()+"\n"));
                                                this.msc.setIdClass(aux.getId());
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case "remove":{
                        switch(num){
                            case 1:{
                                int id=Integer.parseInt(table.getValueAt(click, 0).toString());
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover este estudiante?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==id){
                                            String dni=aux.getDni();
                                            if(SQLUsers.getInstance().remove(aux)){
                                                if(SQLStudentGrade.getInstance().remove(SQLStudentGrade.getInstance().search(dni))){
                                                    this.initTable("", 1, varRS.jtTableStudent);
                                                    SourceCodes.getInstance().sendMessageSuccess("Estudiante removido con éxito");
                                                }else{
                                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo remover el grado del estudiante del sistema, vuelva a intentarlo.");
                                                }
                                            }else{
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo remover al usuario del sistema, vuelva a intentarlo.");
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:{
                                int id=Integer.parseInt(table.getValueAt(click, 0).toString());
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover esta matricula?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelStudentClass aux:SQLStudentClass.getInstance().getList()){
                                        if(aux.getId()==id){
                                            if(SQLStudentClass.getInstance().remove(aux)){
                                                this.initTable("", 4, varRS.jtTableStudent);
                                                SourceCodes.getInstance().sendMessageSuccess("Matricula removido con éxito.");
                                            }else{
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo remover esta matricula, vuelva a intentarlo.");
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }
}
