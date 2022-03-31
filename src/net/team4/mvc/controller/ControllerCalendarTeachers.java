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
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.team4.codes.AccesoryTable;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLUsers;
import net.team4.mvc.model.ModelCalendar;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.view.ViewCalendarTeachers;
import net.team4.mvc.view.ViewMainAdministrator;

public class ControllerCalendarTeachers implements ActionListener{
    
    private static ControllerCalendarTeachers instance;
    private ViewCalendarTeachers varCT;
    private ModelLogin ml;
            
    public ControllerCalendarTeachers(ViewCalendarTeachers vct){
        this.varCT=vct;
        this.iniTable("");
        this.registerEvents();
        this.varCT.setVisible(true);
    }
    
    public static ControllerCalendarTeachers getInstance(ViewCalendarTeachers vct){
        return instance=new ControllerCalendarTeachers(vct);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void registerEvents(){
        this.varCT.jbtPrint.addActionListener(this);
        
        this.varCT.jtfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(varCT.jtfSearch.getText());
            }
        });
        
        this.varCT.jtList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.varCT.addWindowListener(new WindowAdapter() {
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
        if(varCT.jbtPrint==e.getSource()){
            this.btnPrint();
        }
    }
    
    private void btnPrint(){
        try {
            this.varCT.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            JasperReport jr=JasperCompileManager.compileReport("src/net/team4/reports/ReportCalendarTeachers.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr, null,new ConnectionSQL().openConnection());
            JasperViewer.viewReport(jp,false);
            this.varCT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=varCT.jtList.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(varCT.jtList.getValueAt(click, 0).toString());
        int column=varCT.jtList.getColumnModel().getColumnIndexAtX(e.getX());
        int columnCount=varCT.jtList.getColumnCount();
        int row=e.getY()/varCT.jtList.getRowHeight();
        int rowCount=varCT.jtList.getRowCount();
        if((row<rowCount && row>=0) && (column<columnCount && column>=0)){
            Object value=varCT.jtList.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn=(JButton)value;
                switch(btn.getName()){
                    case "remove":{
                        int result=JOptionPane.showConfirmDialog(null,"¿Seguro que quiere remover este horario?","Confirmar",0,0,new ImageIcon(getClass().getResource("/net/team4/images/archivos32x32.png")));
                        if(result==0){
                            for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                                if(aux.getId()==id){
                                    if(SQLCalendar.getInstance().remove(aux)){
                                        this.iniTable("");
                                        SourceCodes.getInstance().sendMessageSuccess("Horario removido con éxito.");
                                    }else{
                                        SourceCodes.getInstance().sendMessageError("Error: No se pudo remover el horario del docente, vuelva a intentarlo.");
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    default:
                        break;
                }
            }
        }
    }
    
    private void iniTable(String search){
        String[] columns=new String[varCT.jtList.getModel().getColumnCount()];
        Object[] rows=new Object[varCT.jtList.getModel().getColumnCount()];
        this.varCT.jtList.setDefaultRenderer(Object.class, new AccesoryTable());
        for(int i=0;i<columns.length;i++){
            columns[i]=varCT.jtList.getModel().getColumnName(i);
        }
        DefaultTableModel dtm=new DefaultTableModel(null,columns){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        JButton jb1=new JButton("Remover");
        jb1.setName("remove");
        if(!search.equalsIgnoreCase("")){
            for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                if(String.valueOf(aux.getId()).equalsIgnoreCase(search) || (SQLUsers.getInstance().getFullNamesByDNI(aux.getDni()).contains(search)) || aux.getCourse().contains(search)){
                    rows[0]=aux.getId();
                    rows[1]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                    rows[2]=aux.getCourse();
                    rows[3]=aux.getTurn();
                    rows[4]=aux.getSection();
                    rows[5]=aux.getDay();
                    rows[6]=aux.getDate();
                    rows[7]=jb1;
                    dtm.addRow(rows);
                }
            }
        }else{
            for(ModelCalendar aux:SQLCalendar.getInstance().getList()){
                rows[0]=aux.getId();
                rows[1]=SQLUsers.getInstance().getFullNamesByDNI(aux.getDni());
                rows[2]=aux.getCourse();
                rows[3]=aux.getTurn();
                rows[4]=aux.getSection();
                rows[5]=aux.getDay();
                rows[6]=aux.getDate();
                rows[7]=jb1;
                dtm.addRow(rows);
            }
        }
        this.varCT.jtList.setModel(dtm);
    }
}
