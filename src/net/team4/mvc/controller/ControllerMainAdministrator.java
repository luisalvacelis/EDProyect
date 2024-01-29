package net.team4.mvc.controller;

import java.awt.Cursor;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.team4.codes.AccesoryTable;
import net.team4.codes.CreateFile;
import net.team4.codes.MoveComponents;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLCategoryCourse;
import net.team4.cruds.SQLCourses;
import net.team4.cruds.SQLTeacherCourse;
import net.team4.cruds.SQLUsers;
import net.team4.dao.CreateDB;
import net.team4.dao.CreateDBInterface;
import net.team4.mail.ControllerMail;
import net.team4.mail.Mail;
import net.team4.mvc.model.ModelCalendar;
import net.team4.mvc.model.ModelCategoryCourses;
import net.team4.mvc.model.ModelCourses;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelUsers;
import net.team4.mvc.model.ModelTeacherCourse;
import net.team4.mvc.view.ViewCalendarTeachers;
import net.team4.mvc.view.ViewMainAdministrator;
import net.team4.mvc.view.ViewRegisterCategoryCourses;
import net.team4.mvc.view.ViewRegisterSQL;
import net.team4.mvc.view.ViewRegisterStudent;

public class ControllerMainAdministrator implements ActionListener{
    
    private static ControllerMainAdministrator instance;
    private ViewMainAdministrator varVM;
    private CreateDBInterface cdbi;
    private ModelLogin ml;
    private ModelUsers mu;
    private ModelTeacherCourse mtc;
    private ModelCourses mc;
    private ModelCalendar mc2;
    
    public ControllerMainAdministrator(ViewMainAdministrator vm){
        this.varVM=vm;
        this.loadConfigs();
        this.registerEvents();
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                this.varVM.jcbCategoryCourses.removeAllItems();
                this.varVM.jcbCategoryCourses.addItem("---- Seleccione ----");
                for(ModelCategoryCourses aux:SQLCategoryCourse.getInstance().getList()){
                    this.varVM.jcbCategoryCourses.addItem(aux.getName());
                }
            }
        }
        this.varVM.setVisible(true);
    }
    
    public static ControllerMainAdministrator getInstance(ViewMainAdministrator vm){
        return instance=new ControllerMainAdministrator(vm);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void loadConfigs(){
        this.cdbi=new CreateDB();
        this.mu=new ModelUsers();
        this.mc=new ModelCourses();
        this.mc2=new ModelCalendar();
        this.mtc=new ModelTeacherCourse();
        this.iniTable(1,"",varVM.jtListTeachers);
        this.iniTable(2,"",varVM.jtListCourses);
        this.iniTable(3,"",varVM.jtTableTeachers);
        this.iniTable(4,"",varVM.jtTableCourses);
        this.iniTable(4,"",varVM.jtTableCourses);
        this.iniTable(5,"",varVM.jtTableTeacherCourse);
        this.iniTable(6,"",varVM.jtTableListTeacherCourse);
    }
    
    private void registerEvents(){
        this.varVM.jmiLogout.addActionListener(this);
        this.varVM.jbtRegisterSQL.addActionListener(this);
        this.varVM.jbtTeacher.addActionListener(this);
        this.varVM.jbtRegisterTeacher.addActionListener(this);
        this.varVM.jbtNewTeacher.addActionListener(this);
        this.varVM.jbtModifyTeacher.addActionListener(this);
        this.varVM.jbtCourse.addActionListener(this);
        this.varVM.jbtRegisterCourse.addActionListener(this);
        this.varVM.jbtNewCourse.addActionListener(this);
        this.varVM.jbtModifyCourse.addActionListener(this);
        this.varVM.jbtRegisterCategoryCourses.addActionListener(this);
        this.varVM.jbtConfigTeacherCourse.addActionListener(this);
        this.varVM.jbtRegisterTeacherCourse.addActionListener(this);
        this.varVM.jbtNewCalendar.addActionListener(this);
        this.varVM.jbtNewTeacherCourse.addActionListener(this);
        this.varVM.jbtConfigCalendar.addActionListener(this);
        this.varVM.jbtRegisterCalendar.addActionListener(this);
        this.varVM.jbtViewCalendarTeachers.addActionListener(this);
        this.varVM.jbtStudents.addActionListener(this);
        
        this.varVM.jcbSelectTurn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String text=varVM.jtaPreparationCalendar.getText();
                String previous=null;
                String current=null;
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    if(!e.getItem().toString().equalsIgnoreCase("---- Seleccione ----")){
                        previous=e.getItem().toString();
                    }
                }else if(e.getStateChange() == ItemEvent.SELECTED){
                    if(!e.getItem().toString().equalsIgnoreCase("---- Seleccione ----")){
                        current=e.getItem().toString();
                    }
                }
                if(!text.contains("Turno:")){
                    varVM.jtaPreparationCalendar.append("Turno: "+current+"\n");
                }else{
                    varVM.jtaPreparationCalendar.setText(varVM.jtaPreparationCalendar.getText().replaceAll("Turno: "+previous+"\n", "Turno: "+current+"\n"));
                }
                mc2.setTurn(current);
            }
        });
        this.varVM.jcbSelectSection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String text=varVM.jtaPreparationCalendar.getText();
                String previous=null;
                String current=null;
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    previous=e.getItem().toString();
                }else if(e.getStateChange() == ItemEvent.SELECTED){
                    current=e.getItem().toString();
                }
                if(!text.contains("Sección:")){
                    varVM.jtaPreparationCalendar.append("Sección: "+current+"\n");
                }else{
                    varVM.jtaPreparationCalendar.setText(varVM.jtaPreparationCalendar.getText().replaceAll("Sección: "+previous+"\n", "Sección: "+current+"\n"));
                }
                mc2.setSection(current);
            }
        });
        this.varVM.jcbSelectDay.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String text=varVM.jtaPreparationCalendar.getText();
                String previous=null;
                String current=null;
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    previous=e.getItem().toString();
                }else if(e.getStateChange() == ItemEvent.SELECTED){
                    current=e.getItem().toString();
                }
                if(!text.contains("Día:")){
                    varVM.jtaPreparationCalendar.append("Día: "+current+"\n");
                }else{
                    varVM.jtaPreparationCalendar.setText(varVM.jtaPreparationCalendar.getText().replaceAll("Día: "+previous+"\n", "Día: "+current+"\n"));
                }
                mc2.setDay(current);
            }
        });
        
        this.varVM.jtfSearchTeacherCourse.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(6, varVM.jtfSearchTeacherCourse.getText(), varVM.jtTableListTeacherCourse);
            }
        });
        this.varVM.jtfSearchTC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(5, varVM.jtfSearchTC.getText(), varVM.jtTableTeacherCourse);
            }
        });
        this.varVM.jtfSearchTeacher.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(1, varVM.jtfSearchTeacher.getText(),varVM.jtListTeachers);
            }
        });
        this.varVM.jtfSearchCourse.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(2, varVM.jtfSearchCourse.getText(),varVM.jtListCourses);
            }
        });
        this.varVM.jtfTeachers.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(3, varVM.jtfTeachers.getText(),varVM.jtTableTeachers);
            }
        });
        this.varVM.jtfCourses.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(4, varVM.jtfCourses.getText(),varVM.jtTableCourses);
            }
        });
        this.varVM.jtfDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                SourceCodes.getInstance().verifyTypeLetter(e);
            }
        });
        this.varVM.jtfTelCel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                SourceCodes.getInstance().verifyTypeLetter(e);
            }
        });
        
        this.varVM.jtListTeachers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableTeachers(1, e);
            }
        });
        this.varVM.jtTableTeachers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableTeachers(2, e);
            }
        });
        this.varVM.jtListCourses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableCourses(1, e);
            }
        });
        this.varVM.jtTableCourses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableCourses(2, e);
            }
        });
        this.varVM.jtTableTeacherCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableTeacherCourse(1,e);
            }
        });
        this.varVM.jtTableListTeacherCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTableTeacherCourse(2,e);
            }
        });
        
        this.varVM.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(varVM.jbtStudents==e.getSource()){
            this.btnStudents();
        }else if(varVM.jbtViewCalendarTeachers==e.getSource()){
            this.btnViewCalendarTeachers();
        }else if(varVM.jbtRegisterCalendar==e.getSource()){
            this.btnRegisterCalendar();
        }else if(varVM.jbtConfigCalendar==e.getSource()){
            this.btnMovePanelConfigCalendar();
        }else if(varVM.jbtRegisterTeacherCourse==e.getSource()){
            this.btnRegisterTeacherCourse();
        }else if(varVM.jbtRegisterCategoryCourses==e.getSource()){
            this.btnRegisterCategoryCourses();
        }else if(varVM.jbtModifyCourse==e.getSource()){
            this.btnModifyCourse();
        }else if(varVM.jbtRegisterCourse==e.getSource()){
            this.btnRegisterCourse();
        }else if(varVM.jbtModifyTeacher==e.getSource()){
            this.btnModifyTeacher();
        }else if(varVM.jbtRegisterTeacher==e.getSource()){
            this.btnRegisterTeacher();
        }else if(varVM.jbtCourse==e.getSource()){
            this.btnMovePanelCourse();
        }else if(varVM.jbtTeacher==e.getSource()){
            this.btnMovePanelTeacher();
        }else if(varVM.jbtConfigTeacherCourse==e.getSource()){
            this.btnMovePanelTeacherCourse();
        }else if(varVM.jbtRegisterSQL==e.getSource()){
            this.btnRegisterSQL();
        }else if(varVM.jmiLogout==e.getSource()){
            SourceCodes.getInstance().closeSession(varVM);
        }else if(varVM.jbtNewTeacher==e.getSource()){
            this.clear(1);
        }else if(varVM.jbtNewCourse==e.getSource()){
            this.clear(2);
        }else if(varVM.jbtNewCalendar==e.getSource()){
            this.clear(3);
        }else if(varVM.jbtNewTeacherCourse==e.getSource()){
            this.clear(4);
        }
    }
    
    
    /*ANIMATIONS*/
    private void btnMovePanelConfigCalendar(){
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                MoveComponents.getInstance().moveComponentXRight(-1270, 20, 1, 10, varVM.jpAssignCalendar,varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpCourses, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpTeachers, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignTeacherCourse, varVM);
                this.varVM.repaint();
                this.loadConfigs();
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, vuelva a intentarlo.");
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: MySQL no registrado, vuelva a intentarlo.");
        }
    }
    
    private void btnMovePanelTeacherCourse(){
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                MoveComponents.getInstance().moveComponentXRight(-1270, 20, 1, 10, varVM.jpAssignTeacherCourse,varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpCourses, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpTeachers, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignCalendar, varVM);
                this.varVM.repaint();
                this.loadConfigs();
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, vuelva a intentarlo.");
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: MySQL no registrado, vuelva a intentarlo.");
        }
        
    }
    
    private void btnMovePanelTeacher(){
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                MoveComponents.getInstance().moveComponentXRight(-1270, 20, 1, 10, varVM.jpTeachers,varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpCourses, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignTeacherCourse, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignCalendar, varVM);
                this.varVM.repaint();
                this.loadConfigs();
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, vuelva a intentarlo.");
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: MySQL no registrado, vuelva a intentarlo.");
        }
        
    }
    
    private void btnMovePanelCourse(){
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                MoveComponents.getInstance().moveComponentXRight(-1270, 20, 1, 10, varVM.jpCourses,varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpTeachers, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignTeacherCourse, varVM);
                MoveComponents.getInstance().moveComponentXLeft(20, -1270, 1, 10, varVM.jpAssignCalendar, varVM);
                this.varVM.repaint();
                this.loadConfigs();
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, vuelva a intentarlo.");
            }
        }else{
            SourceCodes.getInstance().sendMessageError("Error: MySQL no registrado, vuelva a intentarlo.");
        }
        
    }
    
    
    /*BUTTONS*/
    private void btnStudents(){
        try {
            if(CreateFile.getInstance().isMySQLStatus()){
                if(cdbi.verifyExistenceDB()){
                    ControllerRegisterStudent.getInstance(new ViewRegisterStudent()).setAccount(ml);
                    this.varVM.dispose();
                }else{
                    SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada, vuelva a intentarlo.");
                }
            }else{
                SourceCodes.getInstance().sendMessageError("Error: MySQL no registrada, vuelva a intentarlo.");
            }
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void btnViewCalendarTeachers(){
        try {
            ControllerCalendarTeachers.getInstance(new ViewCalendarTeachers()).setAccount(ml);
            this.varVM.dispose();
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void btnRegisterCalendar(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(mtc.getId()!=0){
            if(varVM.jcbSelectTurn.getSelectedIndex()!=0){
                if(varVM.jcbSelectSection.getSelectedIndex()!=0){
                    if(varVM.jcbSelectDay.getSelectedIndex()!=0){
                        this.mc2.setDate(SourceCodes.getInstance().getCurrentDate());
                        boolean status=false;
                        for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                            if(aux.getSection().equals(mc2.getSection()) && aux.getDay().equals(mc2.getDay()) && aux.getTurn().equals(mc2.getTurn())){
                                status=true;
                                break;
                            }else if(aux.getDni().equalsIgnoreCase(mc2.getDni()) && aux.getDay().equalsIgnoreCase(mc2.getDay()) && aux.getTurn().equalsIgnoreCase(mc2.getTurn())){
                                status=true;
                                break;
                            }else if(aux.getDni().equalsIgnoreCase(mc2.getDni()) && aux.getCourse().equalsIgnoreCase(mc2.getCourse()) && aux.getDay().equalsIgnoreCase(mc2.getDay()) && aux.getTurn().equalsIgnoreCase(mc2.getTurn())){
                                status=true;
                                break;
                            }
                        }
                        if(!status){
                            if(SQLCalendar.getInstance().insert(mc2)){
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                this.varVM.jbtNewCalendar.doClick();
                                SourceCodes.getInstance().sendMessageSuccess("Horario del docente-asignatura registrada con éxito.");
                            }else{
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar el horario del docente-asignatura.");
                            }
                        }else{
                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Horario ya ocupado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Día no seleccionado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Sección no seleccionada, vuelva a intentarlo.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Turno no seleccionado, vuelva a intentarlo.");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Docente-Asignatura no seleccionado, vuelva a intentarlo.");
        }
    }
    
    private void btnRegisterTeacherCourse(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(mtc.getDNI()!=null){
            if(mtc.getCourse()!=null){
                this.mtc.setDate(SourceCodes.getInstance().getCurrentDate());
                boolean found=false;
                for(ModelTeacherCourse aux:SQLTeacherCourse.getInstance().getList()){
                    if(aux.getTeacher().equals(mtc.getTeacher()) && aux.getCourse().equals(mtc.getCourse())){
                        found=true;
                    }
                }
                if(!found){
                    if(SQLTeacherCourse.getInstance().insert(mtc)){
                        this.clear(4);
                        this.clear(-1);
                        this.mtc=new ModelTeacherCourse();
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageSuccess("Docente con asignatura relacionado con éxito.");
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: No se pudo almacenar la relación en la base de datos, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: La asignación ya se ha relacionado anteriormente.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Asignatura no seleccionada, vuelva a intentarlo.");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Docente no seleccionado, vuelva a intentarlo.");
        }
    }
    
    private void btnRegisterCategoryCourses(){
        try {
            ControllerCategoryCourses.getInstance(new ViewRegisterCategoryCourses()).setAccount(ml);
            this.varVM.dispose();
        } catch (Exception ex) {
            CreateFile.getInstance().writeFileLogs(null, ex);
        }
    }
    
    private void btnRegisterSQL(){
        try {
            ControllerRegisterSQL.getInstance(new ViewRegisterSQL()).setAccount(ml);
            this.varVM.dispose();
        } catch (Exception ex) {
            CreateFile.getInstance().writeFileLogs(null,ex);
        }
    }
    
    private void btnModifyCourse(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                if(!varVM.jtfCodeCourse.getText().equalsIgnoreCase("")){
                    if(!varVM.jtfNameCourse.getText().equalsIgnoreCase("")){
                        if(varVM.jcbCategoryCourses.getSelectedIndex()!=0){
                            if(varVM.jtfCodeCourse.getText().length()<=20){
                                if(varVM.jtfNameCourse.getText().length()<=50){
                                    String code=varVM.jtfCodeCourse.getText();
                                    String name=varVM.jtfNameCourse.getText();
                                    String category=varVM.jcbCategoryCourses.getSelectedItem().toString();
                                    for(ModelCourses aux:SQLCourses.getInstance().getList()){
                                        if(aux.getId()==mc.getId()){
                                            if(SQLCourses.getInstance().update(new ModelCourses(mc.getId(), code, name, category, SourceCodes.getInstance().getCurrentDate()))){
                                                this.varVM.jbtNewCourse.doClick();
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageSuccess("Asignatura actualizada con éxito.");
                                                break;
                                            }else{
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo actualizar la asignatura, vuelva a aintentarlo.");
                                                break;
                                            }
                                        }
                                    }
                                }else{
                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Nombre del curso no válido. (<50)");
                                }
                            }else{
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Código del curso no válido. (<20)");
                            }
                        }else{
                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Categoría del curso no seleccionado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Nombre del curso no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Código del curso no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada.");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Base de datos no registrada.");
        }
    }
    
    private void btnRegisterCourse(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                if(!varVM.jtfCodeCourse.getText().equalsIgnoreCase("")){
                    if(!varVM.jtfNameCourse.getText().equalsIgnoreCase("")){
                        if(varVM.jcbCategoryCourses.getSelectedIndex()!=0){
                            if(varVM.jtfCodeCourse.getText().length()<=20){
                                if(varVM.jtfNameCourse.getText().length()<=50){
                                    String code=varVM.jtfCodeCourse.getText();
                                    String name=varVM.jtfNameCourse.getText();
                                    String category=varVM.jcbCategoryCourses.getSelectedItem().toString();
                                    ModelCourses mcAux=new ModelCourses(code, name, category, SourceCodes.getInstance().getCurrentDate());
                                    boolean status=false;
                                    if(SQLCourses.getInstance().getList().size()>0){
                                        for(ModelCourses aux:SQLCourses.getInstance().getList()){
                                            if(aux.getCode().equalsIgnoreCase(code)){
                                                status=true;
                                                break;
                                            }
                                        }
                                        if(!status){
                                            if(SQLCourses.getInstance().insert(mcAux)){
                                                this.varVM.jbtNewCourse.doClick();
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageSuccess("Asignatura registrada con éxito.");
                                            }else{
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la asignatura, vuelva a intentarlo.");
                                            }
                                        }else{
                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: Asignatura ya registrada anteriormente.");
                                        }
                                    }else{
                                        if(SQLCourses.getInstance().insert(mcAux)){
                                            this.varVM.jbtNewCourse.doClick();
                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageSuccess("Asignatura registrada con éxito.");
                                        }else{
                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la asignatura, vuelva a intentarlo.");
                                        }
                                    }
                                }else{
                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Nombre del curso no válido. (<50)");
                                }
                            }else{
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: Código del curso no válido. (<20)");
                            }
                        }else{
                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: Categoría del curso no seleccionado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Nombre del curso no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Código del curso no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Base de datos no registrada.");
        }
    }
    
    private void btnModifyTeacher(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                if(!varVM.jtfLastnames.getText().equalsIgnoreCase("")){
                    if(!varVM.jtfNames.getText().equalsIgnoreCase("")){
                        if(!varVM.jtfDNI.getText().equalsIgnoreCase("")){
                            if(varVM.jtfDNI.getText().length()>=8 && varVM.jtfDNI.getText().length()<20){
                                if(!varVM.jtfTelCel.getText().equalsIgnoreCase("")){
                                    if(!varVM.jtfEmail.getText().equalsIgnoreCase("")){
                                        if(!varVM.jtfDetails.getText().equalsIgnoreCase("")){
                                            if(varVM.jtfLastnames.getText().length()<=100){
                                                if(varVM.jtfNames.getText().length()<=100){
                                                    if(varVM.jtfTelCel.getText().length()<=20){
                                                        if(varVM.jtfEmail.getText().length()<=50){
                                                            if(varVM.jtfDetails.getText().length()<=100){
                                                                if(varVM.jtfEmail.getText().endsWith("@gmail.com") || varVM.jtfEmail.getText().endsWith("@hotmail.com")){
                                                                    String lastnames=varVM.jtfLastnames.getText();
                                                                    String names=varVM.jtfNames.getText();
                                                                    String dni=varVM.jtfDNI.getText();
                                                                    String telcel=varVM.jtfTelCel.getText();
                                                                    String email=varVM.jtfEmail.getText();
                                                                    String details=varVM.jtfDetails.getText();
                                                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                                                        if(aux.getId()==mu.getId()){
                                                                            if(SQLUsers.getInstance().update(new ModelUsers(mu.getId(),lastnames, names, dni, telcel, email, aux.getUsername(), aux.getPassword(), "T", details, SourceCodes.getInstance().getCurrentDate()))){
                                                                                this.varVM.jbtNewTeacher.doClick();
                                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                SourceCodes.getInstance().sendMessageSuccess("Docente actualizado con éxito.");
                                                                                break;
                                                                            }else{
                                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar al docente, vuelva a intentarlo.");
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                    SourceCodes.getInstance().sendMessageError("Error: Email del docente no valido, vuelva a intentarlo.");
                                                                }
                                                            }else{
                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del detalle del docente no válido. (<100)");
                                                            }
                                                        }else{
                                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                            SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del e-mail del docente no válido. (<50)");
                                                        }
                                                    }else{
                                                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                        SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del teléfono/celular del docente no válido. (<20)");
                                                    }
                                                }else{
                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del nombre del docente no válido. (<100)");
                                                }
                                            }else{
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del apellido del docente no válidos. (<100)");
                                            }
                                        }else{
                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Erro: Detalle del docente no ingresado, vuelva a intentarlo.");
                                        }
                                    }else{
                                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageError("Error: E-mail del docente no ingresado, vuelva a intentarlo.");
                                    }
                                }else{
                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Número de teléfono/celulra dle docente no ingresado, vuelva a intentarlo.");
                                }
                            }else{
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: DNI del docente no válido, vuelva a intentarlo.");
                            }
                        }else{
                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: DNI del docente no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Nombre del docente no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Apellidos del docente no ingresados, vuelva a intentarlo.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada.");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Base de datos no registrada.");
        }
    }
    
    private void btnRegisterTeacher(){
        this.varVM.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                if(!varVM.jtfLastnames.getText().equalsIgnoreCase("")){
                    if(!varVM.jtfNames.getText().equalsIgnoreCase("")){
                        if(!varVM.jtfDNI.getText().equalsIgnoreCase("")){
                            if(varVM.jtfDNI.getText().length()>=8 && varVM.jtfDNI.getText().length()<20){
                                if(!varVM.jtfTelCel.getText().equalsIgnoreCase("")){
                                    if(!varVM.jtfEmail.getText().equalsIgnoreCase("")){
                                        if(!varVM.jtfDetails.getText().equalsIgnoreCase("")){
                                            if(varVM.jtfLastnames.getText().length()<=100){
                                                if(varVM.jtfNames.getText().length()<=100){
                                                    if(varVM.jtfTelCel.getText().length()<=20){
                                                        if(varVM.jtfEmail.getText().length()<=50){
                                                            if(varVM.jtfDetails.getText().length()<=100){
                                                                if(varVM.jtfEmail.getText().endsWith("@gmail.com") || varVM.jtfEmail.getText().endsWith("@hotmail.com")){
                                                                    String lastnames=varVM.jtfLastnames.getText();
                                                                    String names=varVM.jtfNames.getText();
                                                                    String dni=varVM.jtfDNI.getText();
                                                                    String telcel=varVM.jtfTelCel.getText();
                                                                    String email=varVM.jtfEmail.getText();
                                                                    String details=varVM.jtfDetails.getText();
                                                                    String username=SourceCodes.getInstance().getWordRandom();
                                                                    String password=SourceCodes.getInstance().getWordRandom();
                                                                    ModelUsers mruAux=new ModelUsers(0,lastnames, names, dni, telcel, email, username, password, "T", details, SourceCodes.getInstance().getCurrentDate());
                                                                    boolean status=false;
                                                                    if(SQLUsers.getInstance().getList().size()>0){
                                                                        for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                                                            if(aux.getDni().equalsIgnoreCase(dni)){
                                                                                status=true;
                                                                                break;
                                                                            }
                                                                        }
                                                                        if(!status){
                                                                            if(SQLUsers.getInstance().insert(mruAux)){
                                                                                if(ControllerMail.getInstance().sendMail(new Mail(CreateFile.getInstance().getAccountNotification(), CreateFile.getInstance().getAccountPasswordNotification(), email, "SISTEMA DE COLÉGIOS TRILCE", "Bienvenido al Sistema TRILCE\nEstimado(a) "+lastnames.toUpperCase()+", "+names.toUpperCase()+"\nEsta será su cuenta de acceso al sistema\n\nUsuario: "+username+"\nContraseña "+password+"\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio.\n\nAtte: Colegios TRILCE"))){
                                                                                    this.varVM.jbtNewTeacher.doClick();
                                                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                    SourceCodes.getInstance().sendMessageSuccess("Cuenta de acceso del docente ha sido enviado con éxito.");
                                                                                    SourceCodes.getInstance().sendMessageSuccess("Docente registrado con éxito.");
                                                                                }else{
                                                                                    this.varVM.jbtNewTeacher.doClick();
                                                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                    SourceCodes.getInstance().sendMessageSuccess("Docente registrado con éxito.");
                                                                                    SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar la cuenta de acceso al docente.");
                                                                                }
                                                                            }else{
                                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar al docente, vuelva a intentarlo.");
                                                                            }
                                                                        }else{
                                                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                            SourceCodes.getInstance().sendMessageError("Error: Usuario ya registrado anteriormente, vuelva a intentarlo.");
                                                                        }
                                                                    }else{
                                                                        if(SQLUsers.getInstance().insert(mruAux)){
                                                                            this.varVM.jbtNewTeacher.doClick();
                                                                            if(ControllerMail.getInstance().sendMail(new Mail(CreateFile.getInstance().getAccountNotification(), CreateFile.getInstance().getAccountPasswordNotification(), email, "SISTEMA DE COLÉGIOS TRICE", "Bienvenido al Sistema TRILCE\nEstimado(a) "+lastnames.toUpperCase()+", "+names.toUpperCase()+"\nEsta será su cuenta de acceso al sistema\n\nUsuario: "+username+"\nContraseña "+password+"\nCon este link: https://drive.google.com/drive/folders/1dNxo5r2KHAjA-xitksibXUoqVcid9zhV?usp=sharing \nPodrá descargar el aplicativo de escritorio.\n\nAtte: Colegios TRILCE"))){
                                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                SourceCodes.getInstance().sendMessageSuccess("Cuenta de acceso del docente ha sido enviado con éxito.");
                                                                                SourceCodes.getInstance().sendMessageSuccess("Docente registrado con éxito.");
                                                                            }else{
                                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                SourceCodes.getInstance().sendMessageSuccess("Docente registrado con éxito.");
                                                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo enviar la cuenta de acceso al docente.");
                                                                            }
                                                                        }else{
                                                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar al docente, vuelva a intentarlo.");
                                                                        }
                                                                    }
                                                                }else{
                                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                    SourceCodes.getInstance().sendMessageError("Error: Email del docente no valido, vuelva a intentarlo.");
                                                                }
                                                            }else{
                                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del detalle del docente no válido. (<100)");
                                                            }
                                                        }else{
                                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                            SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del e-mail del docente no válido. (<50)");
                                                        }
                                                    }else{
                                                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                        SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del teléfono/celular del docente no válido. (<20)");
                                                    }
                                                }else{
                                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del nombre del docente no válido. (<100)");
                                                }
                                            }else{
                                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                SourceCodes.getInstance().sendMessageError("Error: Número de caractéres del apellido del docente no válidos. (<100)");
                                            }
                                        }else{
                                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            SourceCodes.getInstance().sendMessageError("Erro: Detalle del docente no ingresado, vuelva a intentarlo.");
                                        }
                                    }else{
                                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        SourceCodes.getInstance().sendMessageError("Error: E-mail del docente no ingresado, vuelva a intentarlo.");
                                    }
                                }else{
                                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    SourceCodes.getInstance().sendMessageError("Error: Número de teléfono/celulra dle docente no ingresado, vuelva a intentarlo.");
                                }
                            }else{
                                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                SourceCodes.getInstance().sendMessageError("Error: DNI del docente no válido, vuelva a intentarlo.");
                            }
                        }else{
                            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: DNI del docente no ingresado, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Nombre del docente no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    SourceCodes.getInstance().sendMessageError("Error: Apellidos del docente no ingresados, vuelva a intentarlo.");
                }
            }else{
                this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Base de datos no encontrada.");
            }
        }else{
            this.varVM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Base de datos no registrada.");
        }
    }
    
    
    /*LOAD INFORMATION TABLES*/
    private void iniTable(int num,String search,JTable table){
        if(CreateFile.getInstance().isMySQLStatus()){
            if(cdbi.verifyExistenceDB()){
                String[] columns=new String[table.getModel().getColumnCount()];
                Object[] row=new Object[table.getModel().getColumnCount()];
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
                    for(ModelUsers mruAux:SQLUsers.getInstance().getList()){
                        if(mruAux.getType().equalsIgnoreCase("T")){
                            if(!search.equalsIgnoreCase("")){
                                if(SQLUsers.getInstance().getFullNamesByDNI(mruAux.getDni()).contains(search) ||  String.valueOf(mruAux.getId()).equalsIgnoreCase(search)){
                                    row[0]=mruAux.getId();
                                    row[1]=mruAux.getLastnames();
                                    row[2]=mruAux.getNames();
                                    row[3]=mruAux.getDni();
                                    row[4]=mruAux.getTelcel();
                                    row[5]=mruAux.getEmail();
                                    row[6]=mruAux.getDate();
                                    row[7]=jb1;
                                    row[8]=jb2;
                                    dtm.addRow(row);
                                }
                            }else{
                                row[0]=mruAux.getId();
                                row[1]=mruAux.getLastnames();
                                row[2]=mruAux.getNames();
                                row[3]=mruAux.getDni();
                                row[4]=mruAux.getTelcel();
                                row[5]=mruAux.getEmail();
                                row[6]=mruAux.getDate();
                                row[7]=jb1;
                                row[8]=jb2;
                                dtm.addRow(row);
                            }
                        }
                    }
                    table.setModel(dtm);
                }else if(num==2){
                    for(ModelCourses mcAux:SQLCourses.getInstance().getList()){
                        if(!search.equalsIgnoreCase("")){
                            if(search.equalsIgnoreCase(mcAux.getCode()) || search.equalsIgnoreCase(mcAux.getName()) || search.equalsIgnoreCase(mcAux.getCategory())){
                                row[0]=mcAux.getId();
                                row[1]=mcAux.getCode();
                                row[2]=mcAux.getName();
                                row[3]=mcAux.getCategory();
                                row[4]=mcAux.getDate();
                                row[5]=jb1;
                                row[6]=jb2;
                                dtm.addRow(row);
                            }
                        }else{
                            row[0]=mcAux.getId();
                            row[1]=mcAux.getCode();
                            row[2]=mcAux.getName();
                            row[3]=mcAux.getCategory();
                            row[4]=mcAux.getDate();
                            row[5]=jb1;
                            row[6]=jb2;
                            dtm.addRow(row);
                        }
                    }
                    table.setModel(dtm);
                }else if(num==3){
                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                        if(aux.getType().equalsIgnoreCase("T")){
                            if(!search.equalsIgnoreCase("")){
                                if(String.valueOf(aux.getId()).equals(search) || SQLUsers.getInstance().getFullNamesByDNI(aux.getDni()).contains(search)){
                                    row[0]=aux.getId();
                                    row[1]=aux.getLastnames()+", "+aux.getNames();
                                    row[2]=aux.getDni();
                                    row[3]=jb1;
                                    dtm.addRow(row);
                                    break;
                                }
                            }else{
                                row[0]=aux.getId();
                                row[1]=aux.getLastnames()+", "+aux.getNames();
                                row[2]=aux.getDni();
                                row[3]=jb1;
                                dtm.addRow(row);
                            }
                        }
                    }
                    table.setModel(dtm);
                }else if(num==4){
                    for(ModelCourses aux:SQLCourses.getInstance().getList()){
                        if(!search.equalsIgnoreCase("")){
                            if(search.equalsIgnoreCase(aux.getName()) || search.equalsIgnoreCase(aux.getCategory())){
                                row[0]=aux.getId();
                                row[1]=aux.getName();
                                row[2]=aux.getCategory();
                                row[3]=jb1;
                                dtm.addRow(row);
                                break;
                            }
                        }else{
                            row[0]=aux.getId();
                            row[1]=aux.getName();
                            row[2]=aux.getCategory();
                            row[3]=jb1;
                            dtm.addRow(row);
                        }
                    }
                    table.setModel(dtm);
                }else if(num==5){
                    for(ModelTeacherCourse aux:SQLTeacherCourse.getInstance().getList()){
                        if(!search.equalsIgnoreCase("")){
                            if(SQLUsers.getInstance().getFullNamesByDNI(aux.getDNI()).contains(search) || String.valueOf(aux.getId()).equals(search)){
                                row[0]=aux.getId();
                                row[1]=aux.getDNI();
                                row[2]=aux.getTeacher();
                                row[3]=aux.getCourse();
                                row[4]=aux.getDate();
                                row[5]=jb2;
                                dtm.addRow(row);
                                break;
                            }
                        }else{
                            row[0]=aux.getId();
                            row[1]=aux.getDNI();
                            row[2]=aux.getTeacher();
                            row[3]=aux.getCourse();
                            row[4]=aux.getDate();
                            row[5]=jb2;
                            dtm.addRow(row);
                        }
                    }
                    table.setModel(dtm);
                }else if(num==6){
                    for(ModelTeacherCourse aux:SQLTeacherCourse.getInstance().getList()){
                        if(!search.equalsIgnoreCase("")){
                            if(SQLUsers.getInstance().getFullNamesByDNI(aux.getDNI()).contains(search) || search.equals(aux.getId()) || aux.getCourse().contains(search)){
                                row[0]=aux.getId();
                                row[1]=aux.getTeacher();
                                row[2]=aux.getCourse();
                                row[3]=aux.getDate();
                                row[4]=jb1;
                                dtm.addRow(row);
                                break;
                            }
                        }else{
                            row[0]=aux.getId();
                            row[1]=aux.getTeacher();
                            row[2]=aux.getCourse();
                            row[3]=aux.getDate();
                            row[4]=jb1;
                            dtm.addRow(row);
                        }
                    }
                    table.setModel(dtm);
                }
            }
        }
    }
    
    
    /*CLEAN COMPONENTS*/
    private void clear(int num){
        switch(num){
            case 1:
                this.varVM.jtfLastnames.setText(null);
                this.varVM.jtfNames.setText(null);
                this.varVM.jtfDNI.setText(null);
                this.varVM.jtfTelCel.setText(null);
                this.varVM.jtfEmail.setText(null);
                this.varVM.jtfDetails.setText(null);
                this.varVM.jtfLastnames.requestFocus();
                this.varVM.jbtModifyTeacher.setEnabled(false);
                this.varVM.jbtRegisterTeacher.setEnabled(true);
                this.varVM.jtfDNI.setEditable(true);
                this.loadConfigs();
                break;
            case 2:
                this.varVM.jtfCodeCourse.setText(null);
                this.varVM.jtfNameCourse.setText(null);
                this.varVM.jcbCategoryCourses.setSelectedIndex(0);
                this.varVM.jtfCodeCourse.requestFocus();
                if(varVM.jbtModifyCourse.isEnabled()){
                    this.varVM.jbtModifyCourse.setEnabled(false);
                    this.varVM.jbtRegisterCourse.setEnabled(true);
                }
                this.loadConfigs();
                break;
            case 3:
                this.varVM.jtTableListTeacherCourse.clearSelection();
                this.varVM.jcbSelectTurn.setSelectedIndex(0);
                this.varVM.jcbSelectSection.setSelectedIndex(0);
                this.varVM.jcbSelectDay.setSelectedIndex(0);
                this.varVM.jcbSelectTurn.setEnabled(false);
                this.varVM.jcbSelectSection.setEnabled(false);
                this.varVM.jcbSelectDay.setEnabled(false);
                this.varVM.jtaPreparationCalendar.setText(null);
                this.varVM.jtfSearchTeacherCourse.setText(null);
                this.loadConfigs();
                break;
            case 4:
                this.varVM.jtTableTeachers.clearSelection();
                this.varVM.jtTableCourses.clearSelection();
                this.varVM.jtaCurrentTeacher.setText(null);
                this.loadConfigs();
                break;
            default:
                break;
        }
    }
    
    
    /*CLICK ON TABLES*/
    private void clickTableTeachers(int num, MouseEvent e){
        switch(num){
            case 1:{
                int click=varVM.jtListTeachers.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtListTeachers.getValueAt(click, 0).toString());
                int column=varVM.jtListTeachers.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtListTeachers.getColumnCount();
                int row=e.getY()/varVM.jtListTeachers.getRowHeight();
                int rowCount=varVM.jtListTeachers.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtListTeachers.getValueAt(row, column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        switch(btn.getName()){
                            case "select":{
                                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                    if(aux.getId()==id){
                                        this.mu.setId(id);
                                        this.varVM.jtfLastnames.setText(aux.getLastnames());
                                        this.varVM.jtfNames.setText(aux.getNames());
                                        this.varVM.jtfDNI.setText(aux.getDni());
                                        this.varVM.jtfTelCel.setText(aux.getTelcel());
                                        this.varVM.jtfEmail.setText(aux.getEmail());
                                        this.varVM.jtfDetails.setText(aux.getDetails());
                                        this.varVM.jbtRegisterTeacher.setEnabled(false);
                                        this.varVM.jbtModifyTeacher.setEnabled(true);
                                        this.varVM.jtfDNI.setEditable(false);
                                        break;
                                    }
                                }
                                break;
                            }
                            case "remove":{
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover a este docente?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==id){
                                            if(SQLUsers.getInstance().remove(new ModelUsers(id,aux.getUsername()))){
                                                this.iniTable(1,"",varVM.jtListTeachers);
                                                this.clear(1);
                                                SourceCodes.getInstance().sendMessageSuccess("Docente removido con éxito.");
                                                break;
                                            }else{
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo remover al docente, vuelva a intentarlo.");
                                                break;
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
                }
                break;
            }
            case 2:{
                int click=varVM.jtTableTeachers.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtTableTeachers.getValueAt(click, 0).toString());
                int column=varVM.jtTableTeachers.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtTableTeachers.getColumnCount();
                int row=e.getY()/varVM.jtTableTeachers.getRowHeight();
                int rowCount=varVM.jtTableTeachers.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtTableTeachers.getValueAt(row, column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        if(btn.getName().equals("select")){
                            int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar a este docente?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                            if(result==0){
                                for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                    if(aux.getId()==id){
                                        this.mtc.setDNI(aux.getDni());
                                        String docente=aux.getLastnames()+", "+aux.getNames();
                                        if(mtc.getCourse()!=null){
                                            this.varVM.jtaCurrentTeacher.setText("Docente: "+docente+"\nAsignatura: "+mtc.getCourse());
                                        }else{
                                            this.varVM.jtaCurrentTeacher.setText("Docente: "+docente);
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            }
            default:{
                SourceCodes.getInstance().sendMessageError("Error: Tabla no reconocida, vuelva a intentarlo.");
                break;
            }
        }
    }
    
    private void clickTableCourses(int num, MouseEvent e){
        switch(num){
            case 1:{
                int click=varVM.jtListCourses.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtListCourses.getValueAt(click, 0).toString());
                int column=varVM.jtListCourses.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtListCourses.getColumnCount();
                int row=e.getY()/varVM.jtListCourses.getRowHeight();
                int rowCount=varVM.jtListCourses.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtListCourses.getValueAt(row, column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        switch(btn.getName()){
                            case "select":{
                                for(ModelCourses aux:SQLCourses.getInstance().getList()){
                                    if(aux.getId()==id){
                                        this.mc.setId(id);
                                        this.varVM.jtfCodeCourse.setText(aux.getCode());
                                        this.varVM.jtfNameCourse.setText(aux.getName());
                                        this.varVM.jcbCategoryCourses.setSelectedItem(aux.getCategory());
                                        this.varVM.jbtRegisterCourse.setEnabled(false);
                                        this.varVM.jbtModifyCourse.setEnabled(true);
                                        break;
                                    }
                                }
                                break;
                            }
                            case "remove":{
                                int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover a este docente?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                                if(result==0){
                                    for(ModelUsers aux:SQLUsers.getInstance().getList()){
                                        if(aux.getId()==id){
                                            if(SQLUsers.getInstance().remove(new ModelUsers(id,aux.getUsername()))){
                                                this.iniTable(1,"",varVM.jtListTeachers);
                                                SourceCodes.getInstance().sendMessageSuccess("Docente removido con éxito.");
                                                break;
                                            }else{
                                                SourceCodes.getInstance().sendMessageError("Error: No se pudo remover al docente, vuelva a intentarlo.");
                                                break;
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
                }
                break;
            }
            case 2:{
                int click=varVM.jtTableCourses.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtTableCourses.getValueAt(click, 0).toString());
                int column=varVM.jtTableCourses.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtTableCourses.getColumnCount();
                int row=e.getY()/varVM.jtTableCourses.getRowHeight();
                int rowCount=varVM.jtTableCourses.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtTableCourses.getValueAt(row, column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        if(btn.getName().equals("select")){
                            int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar esta asignatura?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                            if(result==0){
                                for(ModelCourses aux:SQLCourses.getInstance().getList()){
                                    if(aux.getId()==id){
                                        this.mtc.setCourse(aux.getName());
                                        if(mtc.getDNI()!=null){
                                            for(ModelUsers aux2:SQLUsers.getInstance().getList()){
                                                if(aux2.getDni().equals(mtc.getDNI())){
                                                    this.varVM.jtaCurrentTeacher.setText("Docente: "+aux2.getLastnames()+", "+aux2.getNames()+"\nAsignatura: "+aux.getName());
                                                    break;
                                                }
                                            }
                                        }else{
                                            this.varVM.jtaCurrentTeacher.setText("Signatura: "+aux.getName());
                                        }
                                        break;
                                    }
                                }
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
    
    private void clickTableTeacherCourse(int num,MouseEvent e){
        switch(num){
            case 1:{
                int click=varVM.jtTableTeacherCourse.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtTableTeacherCourse.getValueAt(click, 0).toString());
                int column=varVM.jtTableTeacherCourse.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtTableTeacherCourse.getColumnCount();
                int row=e.getY()/varVM.jtTableTeacherCourse.getRowHeight();
                int rowCount=varVM.jtTableTeacherCourse.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtTableTeacherCourse.getValueAt(row,column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        if(btn.getName().equals("remove")){
                            int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover esta relación de docente-asignatura?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                            if(result==0){
                                for(ModelTeacherCourse aux:SQLTeacherCourse.getInstance().getList()){
                                    if(aux.getId()==id){
                                        if(SQLTeacherCourse.getInstance().remove(aux)){
                                            
                                            this.iniTable(5,"",varVM.jtTableTeacherCourse);
                                            SourceCodes.getInstance().sendMessageSuccess("Relación removido con éxito.");
                                        }else{
                                            SourceCodes.getInstance().sendMessageError("Error: No se pudo remover esta relación docente-asignatura, vuelva a intentarlo.");
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            }
            case 2:{
                int click=varVM.jtTableListTeacherCourse.rowAtPoint(e.getPoint());
                int id=Integer.parseInt(varVM.jtTableListTeacherCourse.getValueAt(click, 0).toString());
                int column=varVM.jtTableListTeacherCourse.getColumnModel().getColumnIndexAtX(e.getX());
                int columnCount=varVM.jtTableListTeacherCourse.getColumnCount();
                int row=e.getY()/varVM.jtTableListTeacherCourse.getRowHeight();
                int rowCount=varVM.jtTableListTeacherCourse.getRowCount();
                if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
                    Object value=varVM.jtTableListTeacherCourse.getValueAt(row, column);
                    if(value instanceof JButton){
                        ((JButton)value).doClick();
                        JButton btn=(JButton)value;
                        if(btn.getName().equals("select")){
                            int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar esta asignatura?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                            if(result==0){
                                for(ModelTeacherCourse aux:SQLTeacherCourse.getInstance().getList()){
                                    if(aux.getId()==id){
                                        this.mtc.setId(id);
                                        this.mc2.setCourse(aux.getCourse());
                                        this.mc2.setDni(aux.getDNI());
                                        this.varVM.jtaPreparationCalendar.setText("Docente: "+aux.getTeacher()+"\nAsignatura: "+aux.getCourse()+"\n");
                                        this.varVM.jcbSelectTurn.setEnabled(true);
                                        this.varVM.jcbSelectSection.setEnabled(true);
                                        this.varVM.jcbSelectDay.setEnabled(true);
                                        break;
                                    }
                                }
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
}
