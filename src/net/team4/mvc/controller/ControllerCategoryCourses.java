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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.team4.codes.AccesoryTable;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCategoryCourse;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelCategoryCourses;
import net.team4.mvc.view.ViewMainAdministrator;
import net.team4.mvc.view.ViewRegisterCategoryCourses;

public class ControllerCategoryCourses implements ActionListener{
    
    private static ControllerCategoryCourses instance;
    private ViewRegisterCategoryCourses varVRCC;
    private ModelCategoryCourses mcc;
    private TableRowSorter trs;
    private ModelLogin ml;
    
    public ControllerCategoryCourses(ViewRegisterCategoryCourses vrcc){
        this.varVRCC=vrcc;
        this.mcc=new ModelCategoryCourses();
        this.initTable();
        this.registerEvents();
        this.varVRCC.setVisible(true);
    }
    
    public static ControllerCategoryCourses getInstance(ViewRegisterCategoryCourses vrcc){
        return instance=new ControllerCategoryCourses(vrcc);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void registerEvents(){
        this.varVRCC.jbtNew.addActionListener(this);
        this.varVRCC.jbtRegister.addActionListener(this);
        this.varVRCC.jbtUpdate.addActionListener(this);
        this.varVRCC.jbtUpdateList.addActionListener(this);
        this.varVRCC.jbtPrint.addActionListener(this);
        
        this.varVRCC.jtList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.varVRCC.jtfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                trs.setRowFilter(RowFilter.regexFilter(varVRCC.jtfSearch.getText(), 1));
            }
        });
        this.varVRCC.addWindowListener(new WindowAdapter() {
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
        if(varVRCC.jbtNew==e.getSource()){
            this.btnNew();
        }else if(varVRCC.jbtRegister==e.getSource()){
            this.btnRegister();
        }else if(varVRCC.jbtUpdate==e.getSource()){
            this.btnUpdate();
        }else if(varVRCC.jbtUpdateList==e.getSource()){
            this.initTable();
            SourceCodes.getInstance().sendMessageSuccess("Lista actualizada con éxito.");
        }else if(varVRCC.jbtPrint==e.getSource()){
            this.btnPrint();
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=varVRCC.jtList.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(varVRCC.jtList.getValueAt(click, 0).toString());
        int column=varVRCC.jtList.getColumnModel().getColumnIndexAtX(e.getX());
        int columnCount=varVRCC.jtList.getColumnCount();
        int row=e.getY()/varVRCC.jtList.getRowHeight();
        int rowCount=varVRCC.jtList.getRowCount();
        if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
            Object value=varVRCC.jtList.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn=(JButton)value;
                switch(btn.getName()){
                    case "select":{
                        int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere seleccionar a esta categoría?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                        if(result==0){
                            for(ModelCategoryCourses aux:SQLCategoryCourse.getInstance().getList()){
                                if(aux.getId()==id){
                                    this.mcc.setId(id);
                                    this.varVRCC.jtfName.setText(aux.getName());
                                    this.varVRCC.jtfObservation.setText(aux.getObservation());
                                    this.varVRCC.jbtRegister.setEnabled(false);
                                    this.varVRCC.jbtUpdate.setEnabled(true);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    case "remove":{
                        int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover a esta categoría?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                        if(result==0){
                            if(SQLCategoryCourse.getInstance().remove(new ModelCategoryCourses(id))){
                                this.initTable();
                                this.btnNew();
                                SourceCodes.getInstance().sendMessageSuccess("Categoría removida con éxito.");
                            }else{
                                SourceCodes.getInstance().sendMessageError("Error: No se pudo remover la categoría, vuelva a intentarlo.");
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }
    
    private void btnPrint(){
        try {
            this.varVRCC.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            JasperReport jr=JasperCompileManager.compileReport("src/net/team4/reports/ReportCategories.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr, null,new ConnectionSQL().openConnection());
            JasperViewer.viewReport(jp,false);
            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void btnNew(){
        this.varVRCC.jtfName.setText(null);
        this.varVRCC.jtfObservation.setText(null);
        this.varVRCC.jtfSearch.setText(null);
        this.varVRCC.jbtUpdate.setEnabled(false);
        this.varVRCC.jbtRegister.setEnabled(true);
        this.varVRCC.jtList.clearSelection();
    }
    
    private void btnRegister(){
        this.varVRCC.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varVRCC.jtfName.getText().equalsIgnoreCase("")){
            if(!varVRCC.jtfObservation.getText().equalsIgnoreCase("")){
                String name=varVRCC.jtfName.getText();
                String obs=varVRCC.jtfObservation.getText();
                ModelCategoryCourses mrccAux=new ModelCategoryCourses(name, obs, SourceCodes.getInstance().getCurrentDate());
                boolean status=false;
                if(SQLCategoryCourse.getInstance().getList().size()>0){
                    for(ModelCategoryCourses aux:SQLCategoryCourse.getInstance().getList()){
                        if(aux.getName().equalsIgnoreCase(name)){
                            status=true;
                            break;
                        }
                    }
                    if(!status){
                        if(SQLCategoryCourse.getInstance().insert(mrccAux)){
                            this.varVRCC.jbtNew.doClick();
                            this.initTable();
                            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageSuccess("Nueva categoría registrar con éxito.");
                        }else{
                            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la nueva categoría, vuelva a intentarlo.");
                        }
                    }else{
                        this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: Categoría ya registrada anteriormente, actualizelo o ingrese otra categoría.");
                    }
                }else{
                    if(SQLCategoryCourse.getInstance().insert(mrccAux)){
                        this.varVRCC.jbtNew.doClick();
                        this.initTable();
                        this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageSuccess("Nueva categoría registrar con éxito.");
                    }else{
                        this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        SourceCodes.getInstance().sendMessageError("Error: No se pudo registrar la nueva categoría, vuelva a intentarlo.");
                    }
                }
            }else{
                this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                SourceCodes.getInstance().sendMessageError("Error: Observación de la categoría no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Nombre de categoría no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void btnUpdate(){
        this.varVRCC.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(!varVRCC.jtfName.getText().equalsIgnoreCase("")){
            if(!varVRCC.jtfObservation.getText().equalsIgnoreCase("")){
                String name=varVRCC.jtfName.getText();
                String obs=varVRCC.jtfObservation.getText();
                for(ModelCategoryCourses aux:SQLCategoryCourse.getInstance().getList()){
                    if(aux.getId()==mcc.getId()){
                        ModelCategoryCourses mrccAux=new ModelCategoryCourses(mcc.getId(), name, obs, SourceCodes.getInstance().getCurrentDate());
                        if(SQLCategoryCourse.getInstance().update(mrccAux)){
                            this.btnNew();
                            this.initTable();
                            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageSuccess("Categoría actualizada con éxito.");
                            break;
                        }else{
                            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            SourceCodes.getInstance().sendMessageError("Error: No se pudo remover la categoría, vuelva a intentarlo.");
                            break;
                        }
                    }
                }
            }else{
                SourceCodes.getInstance().sendMessageError("Error: Observación de la categoría no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.varVRCC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            SourceCodes.getInstance().sendMessageError("Error: Nombre de categoría no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void initTable(){
        String[] columns=new String[varVRCC.jtList.getModel().getColumnCount()];
        Object[] rows=new Object[varVRCC.jtList.getModel().getColumnCount()];
        this.varVRCC.jtList.setDefaultRenderer(Object.class, new AccesoryTable());
        for(int i=0;i<columns.length;i++){
            columns[i]=varVRCC.jtList.getModel().getColumnName(i);
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
        if(SQLCategoryCourse.getInstance().getList().size()>0){
            for(ModelCategoryCourses mrccAux:SQLCategoryCourse.getInstance().getList()){
                rows[0]=mrccAux.getId();
                rows[1]=mrccAux.getName();
                rows[2]=mrccAux.getObservation();
                rows[3]=jb1;
                rows[4]=jb2;
                dtm.addRow(rows);
            }
            this.varVRCC.jtList.setModel(dtm);
            this.trs=new TableRowSorter(varVRCC.jtList.getModel());
            this.varVRCC.jtList.setRowSorter(trs);
        }else{
            CreateFile.getInstance().writeFileLogs("Error: Tabla register_category_courses", null);
        }
            
    }
}
