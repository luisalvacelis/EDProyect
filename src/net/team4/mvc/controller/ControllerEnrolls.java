package net.team4.mvc.controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.team4.codes.ConnectionSQL;
import net.team4.codes.CreateFile;
import net.team4.cruds.SQLCalendar;
import net.team4.cruds.SQLStudentClass;
import net.team4.cruds.SQLUsers;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.model.ModelStudentClass;
import net.team4.mvc.view.ViewEnrolls;
import net.team4.mvc.view.ViewMainAdministrator;

public class ControllerEnrolls implements ActionListener{
    
    private static ControllerEnrolls instance;
    private ViewEnrolls varE;
    private ModelLogin ml;
    
    public ControllerEnrolls(ViewEnrolls ve){
        this.varE=ve;
        this.varE.setVisible(true);
        this.iniTable("");
        this.registerEvents();
    }
    
    public static ControllerEnrolls getInstance(ViewEnrolls ve){
        return instance=new ControllerEnrolls(ve);
    }
    
    public void setAccount(ModelLogin ml){
        this.ml=ml;
    }
    
    private void registerEvents(){
        this.varE.jbtPrint.addActionListener(this);
        
        this.varE.jtfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                iniTable(varE.jtfSearch.getText());
            }
        });
        
        this.varE.addWindowListener(new WindowAdapter() {
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
        if(varE.jbtPrint==e.getSource()){
            this.btnPrint();
        }
    }
    
    private void btnPrint(){
        try {
            this.varE.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            JasperReport jr=JasperCompileManager.compileReport("src/net/team4/reports/ReportEnrolls.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr, null,new ConnectionSQL().openConnection());
            JasperViewer.viewReport(jp,false);
            this.varE.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
    }
    
    private void iniTable(String search){
        String[] columns=new String[varE.jtListEnrolls.getModel().getColumnCount()];
        Object[] rows=new Object[varE.jtListEnrolls.getModel().getColumnCount()];
        for(int i=0;i<columns.length;i++){
            columns[i]=varE.jtListEnrolls.getModel().getColumnName(i);
        }
        DefaultTableModel dtm=new DefaultTableModel(null,columns){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        if(search.equalsIgnoreCase("")){
            for(ModelStudentClass aux1:SQLStudentClass.getInstance().getList()){
                int id=aux1.getId();
                String dni=aux1.getDni();
                int idClass=aux1.getIdClass();
                if(String.valueOf(id).equalsIgnoreCase(search) || String.valueOf(idClass).equalsIgnoreCase(search) || SQLUsers.getInstance().getFullNamesByDNI(dni).contains(search) || SQLUsers.getInstance().getFullNamesByDNI(SQLCalendar.getInstance().search(idClass).getDni()).contains(search)){
                    rows[0]=id;
                    rows[1]=idClass;
                    rows[2]=SQLUsers.getInstance().getFullNamesByDNI(dni);
                    rows[3]=SQLUsers.getInstance().getFullNamesByDNI(SQLCalendar.getInstance().search(idClass).getDni());
                    rows[4]=SQLCalendar.getInstance().search(idClass).getCourse();
                    rows[5]=SQLCalendar.getInstance().search(idClass).getTurn();
                    rows[6]=SQLCalendar.getInstance().search(idClass).getSection();
                    rows[7]=SQLCalendar.getInstance().search(idClass).getDay();
                    dtm.addRow(rows);
                }
            }
            this.varE.jtListEnrolls.setModel(dtm);
        }else{
            for(ModelStudentClass aux1:SQLStudentClass.getInstance().getList()){
                int id=aux1.getId();
                String dni=aux1.getDni();
                int idClass=aux1.getIdClass();
                rows[0]=id;
                rows[1]=idClass;
                rows[2]=SQLUsers.getInstance().getFullNamesByDNI(dni);
                rows[3]=SQLUsers.getInstance().getFullNamesByDNI(SQLCalendar.getInstance().search(idClass).getDni());
                rows[4]=SQLCalendar.getInstance().search(idClass).getCourse();
                rows[5]=SQLCalendar.getInstance().search(idClass).getTurn();
                rows[6]=SQLCalendar.getInstance().search(idClass).getSection();
                rows[7]=SQLCalendar.getInstance().search(idClass).getDay();
                dtm.addRow(rows);
            }
            this.varE.jtListEnrolls.setModel(dtm);
        }
    }
}
