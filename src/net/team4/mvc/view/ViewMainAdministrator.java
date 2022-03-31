package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewMainAdministrator extends javax.swing.JFrame {

    public ViewMainAdministrator() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiAdministrator = new org.edisoncor.gui.panel.PanelImage();
        jpOptions = new org.edisoncor.gui.panel.PanelImage();
        jbtRegisterSQL = new javax.swing.JButton();
        jbtTeacher = new javax.swing.JButton();
        jbtConfigTeacherCourse = new javax.swing.JButton();
        jbtCourse = new javax.swing.JButton();
        jbtConfigCalendar = new javax.swing.JButton();
        jbtStudents = new javax.swing.JButton();
        jpTeachers = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListTeachers = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfTelCel = new javax.swing.JTextField();
        jtfDNI = new javax.swing.JTextField();
        jtfNames = new javax.swing.JTextField();
        jtfLastnames = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfDetails = new javax.swing.JTextField();
        jbtRegisterTeacher = new javax.swing.JButton();
        jbtNewTeacher = new javax.swing.JButton();
        jbtModifyTeacher = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtfSearchTeacher = new javax.swing.JTextField();
        jpCourses = new org.edisoncor.gui.panel.PanelImage();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfCodeCourse = new javax.swing.JTextField();
        jtfNameCourse = new javax.swing.JTextField();
        jcbCategoryCourses = new javax.swing.JComboBox<>();
        jbtRegisterCourse = new javax.swing.JButton();
        jbtNewCourse = new javax.swing.JButton();
        jbtModifyCourse = new javax.swing.JButton();
        jbtRegisterCategoryCourses = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListCourses = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jtfSearchCourse = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jpAssignTeacherCourse = new org.edisoncor.gui.panel.PanelImage();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTableTeachers = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTableCourses = new javax.swing.JTable();
        jtfTeachers = new javax.swing.JTextField();
        jtfCourses = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtTableTeacherCourse = new javax.swing.JTable();
        jbtRegisterTeacherCourse = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtaCurrentTeacher = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jtfSearchTC = new javax.swing.JTextField();
        jbtNewTeacherCourse = new javax.swing.JButton();
        jpAssignCalendar = new org.edisoncor.gui.panel.PanelImage();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jcbSelectDay = new javax.swing.JComboBox<>();
        jcbSelectSection = new javax.swing.JComboBox<>();
        jcbSelectTurn = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtTableListTeacherCourse = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jtfSearchTeacherCourse = new javax.swing.JTextField();
        jbtRegisterCalendar = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtaPreparationCalendar = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jbtNewCalendar = new javax.swing.JButton();
        jbtViewCalendarTeachers = new javax.swing.JButton();
        jmbMenus = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiAdministrator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpiAdministrator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpiAdministrator.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones Administrativas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Californian FB", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jpOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtRegisterSQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnAccessRegisterMySQL200x40_OFF.png"))); // NOI18N
        jbtRegisterSQL.setToolTipText("");
        jbtRegisterSQL.setBorder(null);
        jbtRegisterSQL.setBorderPainted(false);
        jbtRegisterSQL.setContentAreaFilled(false);
        jbtRegisterSQL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterSQL.setDefaultCapable(false);
        jbtRegisterSQL.setFocusPainted(false);
        jbtRegisterSQL.setFocusable(false);
        jbtRegisterSQL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnAccessRegisterMySQL200x40_ON.png"))); // NOI18N
        jbtRegisterSQL.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnAccessRegisterMySQL200x40_ON.png"))); // NOI18N
        jpOptions.add(jbtRegisterSQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, -1, -1));

        jbtTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveTeachers200x40_OFF.png"))); // NOI18N
        jbtTeacher.setBorder(null);
        jbtTeacher.setBorderPainted(false);
        jbtTeacher.setContentAreaFilled(false);
        jbtTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtTeacher.setDefaultCapable(false);
        jbtTeacher.setFocusPainted(false);
        jbtTeacher.setFocusable(false);
        jbtTeacher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveTeachers200x40_ON.png"))); // NOI18N
        jbtTeacher.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveTeachers200x40_ON.png"))); // NOI18N
        jpOptions.add(jbtTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jbtConfigTeacherCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigTeacherCourse270x40_OFF.png"))); // NOI18N
        jbtConfigTeacherCourse.setBorder(null);
        jbtConfigTeacherCourse.setBorderPainted(false);
        jbtConfigTeacherCourse.setContentAreaFilled(false);
        jbtConfigTeacherCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtConfigTeacherCourse.setDefaultCapable(false);
        jbtConfigTeacherCourse.setFocusPainted(false);
        jbtConfigTeacherCourse.setFocusable(false);
        jbtConfigTeacherCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigTeacherCourse270x40_ON.png"))); // NOI18N
        jbtConfigTeacherCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigTeacherCourse270x40_ON.png"))); // NOI18N
        jpOptions.add(jbtConfigTeacherCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jbtCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveCourses200x40_OFF.png"))); // NOI18N
        jbtCourse.setBorder(null);
        jbtCourse.setBorderPainted(false);
        jbtCourse.setContentAreaFilled(false);
        jbtCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCourse.setDefaultCapable(false);
        jbtCourse.setFocusPainted(false);
        jbtCourse.setFocusable(false);
        jbtCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveCourses200x40_ON.png"))); // NOI18N
        jbtCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveCourses200x40_ON.png"))); // NOI18N
        jpOptions.add(jbtCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jbtConfigCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigCalendar230x40_OFF.png"))); // NOI18N
        jbtConfigCalendar.setBorder(null);
        jbtConfigCalendar.setBorderPainted(false);
        jbtConfigCalendar.setContentAreaFilled(false);
        jbtConfigCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtConfigCalendar.setDefaultCapable(false);
        jbtConfigCalendar.setFocusPainted(false);
        jbtConfigCalendar.setFocusable(false);
        jbtConfigCalendar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigCalendar230x40_ON.png"))); // NOI18N
        jbtConfigCalendar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveConfigCalendar230x40_ON.png"))); // NOI18N
        jpOptions.add(jbtConfigCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jbtStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveStudent_200x40_OFF.png"))); // NOI18N
        jbtStudents.setBorder(null);
        jbtStudents.setBorderPainted(false);
        jbtStudents.setContentAreaFilled(false);
        jbtStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtStudents.setDefaultCapable(false);
        jbtStudents.setFocusPainted(false);
        jbtStudents.setFocusable(false);
        jbtStudents.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveStudent_200x40_ON.png"))); // NOI18N
        jbtStudents.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnMoveStudent_200x40_ON.png"))); // NOI18N
        jpOptions.add(jbtStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, -1, -1));

        jpiAdministrator.add(jpOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1260, 130));

        jpTeachers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpTeachers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpTeachers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtListTeachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellidos", "Nombres", "DNI", "Teléfono/Celular", "E-mail", "Fecha de registro/modificación", "Modificar", "Remover"
            }
        ));
        jtListTeachers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtListTeachers);

        jpTeachers.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1210, 240));

        jLabel11.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Datos del docente");
        jpTeachers.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese apellidos:");
        jpTeachers.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese nombres:");
        jpTeachers.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese número de DNI:");
        jpTeachers.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jtfTelCel.setBorder(null);
        jpTeachers.add(jtfTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 190, 20));

        jtfDNI.setBorder(null);
        jpTeachers.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 210, 20));

        jtfNames.setBorder(null);
        jpTeachers.add(jtfNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 210, 20));

        jtfLastnames.setBorder(null);
        jpTeachers.add(jtfLastnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 210, 20));

        jLabel4.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese número de teléfono/celular:");
        jpTeachers.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ingrese E-mail:");
        jpTeachers.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingrese detalles:");
        jpTeachers.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jtfEmail.setBorder(null);
        jpTeachers.add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 190, 20));

        jtfDetails.setBorder(null);
        jpTeachers.add(jtfDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 190, 20));

        jbtRegisterTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_teacher150x30_OFF.png"))); // NOI18N
        jbtRegisterTeacher.setBorder(null);
        jbtRegisterTeacher.setBorderPainted(false);
        jbtRegisterTeacher.setContentAreaFilled(false);
        jbtRegisterTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterTeacher.setDefaultCapable(false);
        jbtRegisterTeacher.setFocusPainted(false);
        jbtRegisterTeacher.setFocusable(false);
        jbtRegisterTeacher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_teacher150x30_ON.png"))); // NOI18N
        jbtRegisterTeacher.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_teacher150x30_ON.png"))); // NOI18N
        jpTeachers.add(jbtRegisterTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, -1));

        jbtNewTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewTeacher.setBorder(null);
        jbtNewTeacher.setBorderPainted(false);
        jbtNewTeacher.setContentAreaFilled(false);
        jbtNewTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewTeacher.setDefaultCapable(false);
        jbtNewTeacher.setFocusPainted(false);
        jbtNewTeacher.setFocusable(false);
        jbtNewTeacher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNewTeacher.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jpTeachers.add(jbtNewTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

        jbtModifyTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtModifyTeacher.setBorder(null);
        jbtModifyTeacher.setBorderPainted(false);
        jbtModifyTeacher.setContentAreaFilled(false);
        jbtModifyTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtModifyTeacher.setDefaultCapable(false);
        jbtModifyTeacher.setEnabled(false);
        jbtModifyTeacher.setFocusPainted(false);
        jbtModifyTeacher.setFocusable(false);
        jbtModifyTeacher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtModifyTeacher.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jpTeachers.add(jbtModifyTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Buscar docente:");
        jpTeachers.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jtfSearchTeacher.setBorder(null);
        jpTeachers.add(jtfSearchTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 210, 20));

        jpiAdministrator.add(jpTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1270, 140, 1260, 440));

        jpCourses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpCourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingrese código:");
        jpCourses.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingrese nombre:");
        jpCourses.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Seleccione categoría:");
        jpCourses.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jtfCodeCourse.setBorder(null);
        jpCourses.add(jtfCodeCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 270, 20));

        jtfNameCourse.setBorder(null);
        jpCourses.add(jtfNameCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 270, 20));

        jcbCategoryCourses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        jcbCategoryCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbCategoryCourses.setFocusable(false);
        jpCourses.add(jcbCategoryCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 270, -1));

        jbtRegisterCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_course150x30_OFF.png"))); // NOI18N
        jbtRegisterCourse.setBorder(null);
        jbtRegisterCourse.setBorderPainted(false);
        jbtRegisterCourse.setContentAreaFilled(false);
        jbtRegisterCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterCourse.setDefaultCapable(false);
        jbtRegisterCourse.setFocusPainted(false);
        jbtRegisterCourse.setFocusable(false);
        jbtRegisterCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_course150x30_ON.png"))); // NOI18N
        jbtRegisterCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_course150x30_ON.png"))); // NOI18N
        jpCourses.add(jbtRegisterCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        jbtNewCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewCourse.setBorder(null);
        jbtNewCourse.setBorderPainted(false);
        jbtNewCourse.setContentAreaFilled(false);
        jbtNewCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewCourse.setDefaultCapable(false);
        jbtNewCourse.setFocusPainted(false);
        jbtNewCourse.setFocusable(false);
        jbtNewCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNewCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jpCourses.add(jbtNewCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        jbtModifyCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtModifyCourse.setBorder(null);
        jbtModifyCourse.setBorderPainted(false);
        jbtModifyCourse.setContentAreaFilled(false);
        jbtModifyCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtModifyCourse.setDefaultCapable(false);
        jbtModifyCourse.setEnabled(false);
        jbtModifyCourse.setFocusPainted(false);
        jbtModifyCourse.setFocusable(false);
        jbtModifyCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtModifyCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jpCourses.add(jbtModifyCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        jbtRegisterCategoryCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_OFF.png"))); // NOI18N
        jbtRegisterCategoryCourses.setBorder(null);
        jbtRegisterCategoryCourses.setBorderPainted(false);
        jbtRegisterCategoryCourses.setContentAreaFilled(false);
        jbtRegisterCategoryCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterCategoryCourses.setDefaultCapable(false);
        jbtRegisterCategoryCourses.setFocusPainted(false);
        jbtRegisterCategoryCourses.setFocusable(false);
        jbtRegisterCategoryCourses.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_ON.png"))); // NOI18N
        jbtRegisterCategoryCourses.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_ON.png"))); // NOI18N
        jpCourses.add(jbtRegisterCategoryCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jtListCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Nombres", "Categoría", "Fecha de registro/modificación", "Modificar", "Remover"
            }
        ));
        jtListCourses.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtListCourses);

        jpCourses.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1220, 220));

        jLabel10.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar asignatura:");
        jpCourses.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jtfSearchCourse.setBorder(null);
        jpCourses.add(jtfSearchCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 280, 20));

        jLabel13.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Registro de asignatura:");
        jpCourses.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jpiAdministrator.add(jpCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1270, 140, 1260, 440));

        jpAssignTeacherCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpAssignTeacherCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpAssignTeacherCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Docentes:");
        jpAssignTeacherCourse.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtTableTeachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Docente", "DNI", "Seleccionar"
            }
        ));
        jtTableTeachers.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtTableTeachers);

        jpAssignTeacherCourse.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 140));

        jLabel15.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cursos:");
        jpAssignTeacherCourse.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jtTableCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Seleccionar"
            }
        ));
        jtTableCourses.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtTableCourses);

        jpAssignTeacherCourse.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 440, 140));
        jpAssignTeacherCourse.add(jtfTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, -1));
        jpAssignTeacherCourse.add(jtfCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 250, -1));

        jLabel16.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Preparación");
        jpAssignTeacherCourse.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jtTableTeacherCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Docente", "Curso", "Fecha de registro", "Remover"
            }
        ));
        jtTableTeacherCourse.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtTableTeacherCourse);

        jpAssignTeacherCourse.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 780, 200));

        jbtRegisterTeacherCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_relation150x30_OFF.png"))); // NOI18N
        jbtRegisterTeacherCourse.setBorder(null);
        jbtRegisterTeacherCourse.setBorderPainted(false);
        jbtRegisterTeacherCourse.setContentAreaFilled(false);
        jbtRegisterTeacherCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterTeacherCourse.setDefaultCapable(false);
        jbtRegisterTeacherCourse.setFocusPainted(false);
        jbtRegisterTeacherCourse.setFocusable(false);
        jbtRegisterTeacherCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_relation150x30_ON.png"))); // NOI18N
        jbtRegisterTeacherCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_relation150x30_ON.png"))); // NOI18N
        jpAssignTeacherCourse.add(jbtRegisterTeacherCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jtaCurrentTeacher.setEditable(false);
        jtaCurrentTeacher.setColumns(20);
        jtaCurrentTeacher.setRows(5);
        jScrollPane6.setViewportView(jtaCurrentTeacher);

        jpAssignTeacherCourse.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 360, 90));

        jLabel23.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Buscar:");
        jpAssignTeacherCourse.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));
        jpAssignTeacherCourse.add(jtfSearchTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 230, -1));

        jbtNewTeacherCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewTeacherCourse.setBorder(null);
        jbtNewTeacherCourse.setBorderPainted(false);
        jbtNewTeacherCourse.setContentAreaFilled(false);
        jbtNewTeacherCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewTeacherCourse.setDefaultCapable(false);
        jbtNewTeacherCourse.setFocusPainted(false);
        jbtNewTeacherCourse.setFocusable(false);
        jbtNewTeacherCourse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNewTeacherCourse.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jpAssignTeacherCourse.add(jbtNewTeacherCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jpiAdministrator.add(jpAssignTeacherCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1270, 140, 1260, 460));

        jpAssignCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpAssignCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpAssignCalendar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Seleccionar turno");
        jpAssignCalendar.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel18.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Seleccionar sección");
        jpAssignCalendar.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel19.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Seleccionar día");
        jpAssignCalendar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jcbSelectDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----", "Lunes", "Martes", "Miércoles", "Viernes" }));
        jcbSelectDay.setEnabled(false);
        jcbSelectDay.setFocusable(false);
        jpAssignCalendar.add(jcbSelectDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 170, -1));

        jcbSelectSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----", "1 - A", "1 - B", "1 - C", "2 - A", "2 - B", "2 - C", "3 - A", "3 - B", "3 - C", "4 - A", "4 - B", "4 - C", "5 - A", "5 - B", "5 - C" }));
        jcbSelectSection.setEnabled(false);
        jcbSelectSection.setFocusable(false);
        jpAssignCalendar.add(jcbSelectSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 170, -1));

        jcbSelectTurn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccionar ----", "Mañana", "Tarde" }));
        jcbSelectTurn.setEnabled(false);
        jcbSelectTurn.setFocusable(false);
        jpAssignCalendar.add(jcbSelectTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 170, -1));

        jLabel20.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Seleccione docente con asignatura");
        jpAssignCalendar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtTableListTeacherCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Docente", "Curso", "Fecha", "Seleccionar"
            }
        ));
        jScrollPane7.setViewportView(jtTableListTeacherCourse);

        jpAssignCalendar.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1160, 200));

        jLabel21.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Buscar:");
        jpAssignCalendar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jtfSearchTeacherCourse.setBorder(null);
        jpAssignCalendar.add(jtfSearchTeacherCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 240, 20));

        jbtRegisterCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_calendar150x30_OFF.png"))); // NOI18N
        jbtRegisterCalendar.setBorder(null);
        jbtRegisterCalendar.setBorderPainted(false);
        jbtRegisterCalendar.setContentAreaFilled(false);
        jbtRegisterCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterCalendar.setDefaultCapable(false);
        jbtRegisterCalendar.setFocusPainted(false);
        jbtRegisterCalendar.setFocusable(false);
        jbtRegisterCalendar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_calendar150x30_ON.png"))); // NOI18N
        jbtRegisterCalendar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_calendar150x30_ON.png"))); // NOI18N
        jpAssignCalendar.add(jbtRegisterCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        jtaPreparationCalendar.setEditable(false);
        jtaPreparationCalendar.setColumns(20);
        jtaPreparationCalendar.setRows(5);
        jScrollPane8.setViewportView(jtaPreparationCalendar);

        jpAssignCalendar.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 370, 90));

        jLabel22.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Preparación");
        jpAssignCalendar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jbtNewCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNewCalendar.setBorder(null);
        jbtNewCalendar.setBorderPainted(false);
        jbtNewCalendar.setContentAreaFilled(false);
        jbtNewCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNewCalendar.setDefaultCapable(false);
        jbtNewCalendar.setFocusPainted(false);
        jbtNewCalendar.setFocusable(false);
        jbtNewCalendar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNewCalendar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jpAssignCalendar.add(jbtNewCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        jbtViewCalendarTeachers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_calendars150x30_OFF.png"))); // NOI18N
        jbtViewCalendarTeachers.setBorder(null);
        jbtViewCalendarTeachers.setBorderPainted(false);
        jbtViewCalendarTeachers.setContentAreaFilled(false);
        jbtViewCalendarTeachers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtViewCalendarTeachers.setDefaultCapable(false);
        jbtViewCalendarTeachers.setFocusPainted(false);
        jbtViewCalendarTeachers.setFocusable(false);
        jbtViewCalendarTeachers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_calendars150x30_ON.png"))); // NOI18N
        jbtViewCalendarTeachers.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_calendars150x30_ON.png"))); // NOI18N
        jpAssignCalendar.add(jbtViewCalendarTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, -1, -1));

        jpiAdministrator.add(jpAssignCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1270, 140, 1260, 440));

        jmbMenus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jmOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/options32x32.png"))); // NOI18N
        jmOptions.setText("Opciones");

        jmiLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/logout24x24.png"))); // NOI18N
        jmiLogout.setText("Cerrar sesión");
        jmOptions.add(jmiLogout);

        jmbMenus.add(jmOptions);

        setJMenuBar(jmbMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpiAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JButton jbtConfigCalendar;
    public javax.swing.JButton jbtConfigTeacherCourse;
    public javax.swing.JButton jbtCourse;
    public javax.swing.JButton jbtModifyCourse;
    public javax.swing.JButton jbtModifyTeacher;
    public javax.swing.JButton jbtNewCalendar;
    public javax.swing.JButton jbtNewCourse;
    public javax.swing.JButton jbtNewTeacher;
    public javax.swing.JButton jbtNewTeacherCourse;
    public javax.swing.JButton jbtRegisterCalendar;
    public javax.swing.JButton jbtRegisterCategoryCourses;
    public javax.swing.JButton jbtRegisterCourse;
    public javax.swing.JButton jbtRegisterSQL;
    public javax.swing.JButton jbtRegisterTeacher;
    public javax.swing.JButton jbtRegisterTeacherCourse;
    public javax.swing.JButton jbtStudents;
    public javax.swing.JButton jbtTeacher;
    public javax.swing.JButton jbtViewCalendarTeachers;
    public javax.swing.JComboBox<String> jcbCategoryCourses;
    public javax.swing.JComboBox<String> jcbSelectDay;
    public javax.swing.JComboBox<String> jcbSelectSection;
    public javax.swing.JComboBox<String> jcbSelectTurn;
    public javax.swing.JMenu jmOptions;
    public javax.swing.JMenuBar jmbMenus;
    public javax.swing.JMenuItem jmiLogout;
    public org.edisoncor.gui.panel.PanelImage jpAssignCalendar;
    public org.edisoncor.gui.panel.PanelImage jpAssignTeacherCourse;
    public org.edisoncor.gui.panel.PanelImage jpCourses;
    public org.edisoncor.gui.panel.PanelImage jpOptions;
    public org.edisoncor.gui.panel.PanelImage jpTeachers;
    public org.edisoncor.gui.panel.PanelImage jpiAdministrator;
    public javax.swing.JTable jtListCourses;
    public javax.swing.JTable jtListTeachers;
    public javax.swing.JTable jtTableCourses;
    public javax.swing.JTable jtTableListTeacherCourse;
    public javax.swing.JTable jtTableTeacherCourse;
    public javax.swing.JTable jtTableTeachers;
    public javax.swing.JTextArea jtaCurrentTeacher;
    public javax.swing.JTextArea jtaPreparationCalendar;
    public javax.swing.JTextField jtfCodeCourse;
    public javax.swing.JTextField jtfCourses;
    public javax.swing.JTextField jtfDNI;
    public javax.swing.JTextField jtfDetails;
    public javax.swing.JTextField jtfEmail;
    public javax.swing.JTextField jtfLastnames;
    public javax.swing.JTextField jtfNameCourse;
    public javax.swing.JTextField jtfNames;
    public javax.swing.JTextField jtfSearchCourse;
    public javax.swing.JTextField jtfSearchTC;
    public javax.swing.JTextField jtfSearchTeacher;
    public javax.swing.JTextField jtfSearchTeacherCourse;
    public javax.swing.JTextField jtfTeachers;
    public javax.swing.JTextField jtfTelCel;
    // End of variables declaration//GEN-END:variables
}
