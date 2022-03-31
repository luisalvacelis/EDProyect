package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewRegisterStudent extends javax.swing.JFrame {

    public ViewRegisterStudent() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpPanel = new javax.swing.JTabbedPane();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableStudent = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfSearchStudentTable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfLastnamesStudent = new javax.swing.JTextField();
        jtfNamesStudent = new javax.swing.JTextField();
        jtfDNIStudent = new javax.swing.JTextField();
        jtfTelCelStudent = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfEmailStudent = new javax.swing.JTextField();
        jbtRegisterStudent = new javax.swing.JButton();
        jbtNewStudent = new javax.swing.JButton();
        jbtUpdateStudent = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcbSelectGrade = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaDetailsStudent = new javax.swing.JTextArea();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListStudent = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfSearchStudentList = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtListClass = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jtfSearchClass = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtListEnroll = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtaPreparationEnroll = new javax.swing.JTextArea();
        jbtNewStudentEnroll = new javax.swing.JButton();
        jbtEnrollStudent = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtfSearchEnroll = new javax.swing.JTextField();
        jbtShowDetailsEnroll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jtpPanel.setFocusable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_register_students1300x700.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellidos y Nombres", "DNI", "Teléfono/Celular", "E-mail", "Grado", "Fecha de registro", "Seleccionar", "Remover"
            }
        ));
        jtTableStudent.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTableStudent);

        panelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1290, 250));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jtfSearchStudentTable.setBorder(null);
        panelImage1.add(jtfSearchStudentTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 220, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Datos del estudiante:");
        panelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese apellidos:");
        panelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese nombres:");
        panelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ingrese número de DNI:");
        panelImage1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingrese teléfono/celular:");
        panelImage1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jtfLastnamesStudent.setBorder(null);
        panelImage1.add(jtfLastnamesStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 200, 20));

        jtfNamesStudent.setBorder(null);
        panelImage1.add(jtfNamesStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 200, 20));

        jtfDNIStudent.setBorder(null);
        panelImage1.add(jtfDNIStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 200, 20));

        jtfTelCelStudent.setBorder(null);
        panelImage1.add(jtfTelCelStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 200, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingrese e-mail:");
        panelImage1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        jtfEmailStudent.setBorder(null);
        panelImage1.add(jtfEmailStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 200, 20));

        jbtRegisterStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_student150x30_OFF.png"))); // NOI18N
        jbtRegisterStudent.setBorder(null);
        jbtRegisterStudent.setBorderPainted(false);
        jbtRegisterStudent.setContentAreaFilled(false);
        jbtRegisterStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterStudent.setDefaultCapable(false);
        jbtRegisterStudent.setFocusPainted(false);
        jbtRegisterStudent.setFocusable(false);
        jbtRegisterStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_student150x30_ON.png"))); // NOI18N
        jbtRegisterStudent.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_student150x30_ON.png"))); // NOI18N
        panelImage1.add(jbtRegisterStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, -1, -1));

        jbtNewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewStudent.setBorder(null);
        jbtNewStudent.setBorderPainted(false);
        jbtNewStudent.setContentAreaFilled(false);
        jbtNewStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewStudent.setDefaultCapable(false);
        jbtNewStudent.setFocusPainted(false);
        jbtNewStudent.setFocusable(false);
        panelImage1.add(jbtNewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 100, -1, -1));

        jbtUpdateStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtUpdateStudent.setBorder(null);
        jbtUpdateStudent.setBorderPainted(false);
        jbtUpdateStudent.setContentAreaFilled(false);
        jbtUpdateStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtUpdateStudent.setDefaultCapable(false);
        jbtUpdateStudent.setEnabled(false);
        jbtUpdateStudent.setFocusPainted(false);
        jbtUpdateStudent.setFocusable(false);
        jbtUpdateStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtUpdateStudent.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        panelImage1.add(jbtUpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 140, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Seleccione grado:");
        panelImage1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jcbSelectGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----", "1 grado", "2 grado", "3 grado", "4 grado", "5 grado" }));
        jcbSelectGrade.setFocusable(false);
        panelImage1.add(jcbSelectGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 200, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ingrese detalle:");
        panelImage1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jtaDetailsStudent.setColumns(20);
        jtaDetailsStudent.setRows(5);
        jtaDetailsStudent.setBorder(null);
        jScrollPane3.setViewportView(jtaDetailsStudent);

        panelImage1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 310, -1));

        jtpPanel.addTab("Registro de estudiantes", panelImage1);

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_enrollstudent1300x700.png"))); // NOI18N
        panelImage2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtListStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellidos y Nombres", "Grado", "Seleccionar"
            }
        ));
        jtListStudent.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtListStudent);

        panelImage2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 190));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seleccione estudiante:");
        panelImage2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Seleccione clase:");
        panelImage2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar:");
        panelImage2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jtfSearchStudentList.setBorder(null);
        panelImage2.add(jtfSearchStudentList, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 20));

        jtListClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Docente", "Asignatura", "Turno", "Sección", "Día", "Seleccionar"
            }
        ));
        jtListClass.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtListClass);

        panelImage2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 750, 190));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Buscar:");
        panelImage2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        jtfSearchClass.setBorder(null);
        panelImage2.add(jtfSearchClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 200, 20));

        jtListEnroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID de Clase", "Estudiante", "Docente", "Asignatura", "Remover"
            }
        ));
        jScrollPane5.setViewportView(jtListEnroll);

        panelImage2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 990, 260));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Preparación:");
        panelImage2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jtaPreparationEnroll.setColumns(20);
        jtaPreparationEnroll.setRows(5);
        jtaPreparationEnroll.setBorder(null);
        jScrollPane6.setViewportView(jtaPreparationEnroll);

        panelImage2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 280, 90));

        jbtNewStudentEnroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewStudentEnroll.setBorder(null);
        jbtNewStudentEnroll.setBorderPainted(false);
        jbtNewStudentEnroll.setContentAreaFilled(false);
        jbtNewStudentEnroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewStudentEnroll.setDefaultCapable(false);
        jbtNewStudentEnroll.setFocusPainted(false);
        jbtNewStudentEnroll.setFocusable(false);
        jbtNewStudentEnroll.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNewStudentEnroll.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        panelImage2.add(jbtNewStudentEnroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jbtEnrollStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_enrollstudent150x30_OFF.png"))); // NOI18N
        jbtEnrollStudent.setBorder(null);
        jbtEnrollStudent.setBorderPainted(false);
        jbtEnrollStudent.setContentAreaFilled(false);
        jbtEnrollStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEnrollStudent.setDefaultCapable(false);
        jbtEnrollStudent.setFocusPainted(false);
        jbtEnrollStudent.setFocusable(false);
        jbtEnrollStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_enrollstudent150x30_ON.png"))); // NOI18N
        jbtEnrollStudent.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_enrollstudent150x30_ON.png"))); // NOI18N
        panelImage2.add(jbtEnrollStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Buscar por ID o ID de clase:");
        panelImage2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jtfSearchEnroll.setBorder(null);
        panelImage2.add(jtfSearchEnroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 200, 20));

        jbtShowDetailsEnroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_seedetails150x30_OFF.png"))); // NOI18N
        jbtShowDetailsEnroll.setBorder(null);
        jbtShowDetailsEnroll.setBorderPainted(false);
        jbtShowDetailsEnroll.setContentAreaFilled(false);
        jbtShowDetailsEnroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtShowDetailsEnroll.setDefaultCapable(false);
        jbtShowDetailsEnroll.setFocusPainted(false);
        jbtShowDetailsEnroll.setFocusable(false);
        jbtShowDetailsEnroll.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_seedetails150x30_ON.png"))); // NOI18N
        jbtShowDetailsEnroll.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_seedetails150x30_ON.png"))); // NOI18N
        panelImage2.add(jbtShowDetailsEnroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        jtpPanel.addTab("Matricula de estudiantes", panelImage2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1337, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JButton jbtEnrollStudent;
    public javax.swing.JButton jbtNewStudent;
    public javax.swing.JButton jbtNewStudentEnroll;
    public javax.swing.JButton jbtRegisterStudent;
    public javax.swing.JButton jbtShowDetailsEnroll;
    public javax.swing.JButton jbtUpdateStudent;
    public javax.swing.JComboBox<String> jcbSelectGrade;
    public javax.swing.JTable jtListClass;
    public javax.swing.JTable jtListEnroll;
    public javax.swing.JTable jtListStudent;
    public javax.swing.JTable jtTableStudent;
    public javax.swing.JTextArea jtaDetailsStudent;
    public javax.swing.JTextArea jtaPreparationEnroll;
    public javax.swing.JTextField jtfDNIStudent;
    public javax.swing.JTextField jtfEmailStudent;
    public javax.swing.JTextField jtfLastnamesStudent;
    public javax.swing.JTextField jtfNamesStudent;
    public javax.swing.JTextField jtfSearchClass;
    public javax.swing.JTextField jtfSearchEnroll;
    public javax.swing.JTextField jtfSearchStudentList;
    public javax.swing.JTextField jtfSearchStudentTable;
    public javax.swing.JTextField jtfTelCelStudent;
    public javax.swing.JTabbedPane jtpPanel;
    public org.edisoncor.gui.panel.PanelImage panelImage1;
    public org.edisoncor.gui.panel.PanelImage panelImage2;
    // End of variables declaration//GEN-END:variables
}
