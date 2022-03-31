package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewMainStudent extends javax.swing.JFrame {

    public ViewMainStudent() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpAssistance = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jcbSelectCourse = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTableAssistance = new javax.swing.JTable();
        jbtShowAssistance = new javax.swing.JButton();
        jpiMain = new org.edisoncor.gui.panel.PanelImage();
        jpOptions = new javax.swing.JPanel();
        jlImageProfile = new javax.swing.JLabel();
        jbtEditProfile = new javax.swing.JButton();
        jbtShowEnrolledCourses = new javax.swing.JButton();
        jbtShowNotes = new javax.swing.JButton();
        jpEnrolledCourses = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableEnrolledCourse = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jbtReloadEnrolls = new javax.swing.JButton();
        jpEditProfile = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlPhotoEditProfile = new javax.swing.JLabel();
        jbtExaminePhotoProfile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfLastnames = new javax.swing.JTextField();
        jtfNames = new javax.swing.JTextField();
        jtfTelcel = new javax.swing.JTextField();
        jtfMail = new javax.swing.JTextField();
        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jckbCheckEdit = new javax.swing.JCheckBox();
        jbtEdit = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jckbShowPassword = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jbtEditPhotoProfile = new javax.swing.JButton();
        jbtCancelEditPhoto = new javax.swing.JButton();
        jpNotes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTableNotes = new javax.swing.JTable();
        jbtReloadNotes = new javax.swing.JButton();
        jmbMenus = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();

        jpAssistance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpAssistance.setOpaque(false);
        jpAssistance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Seleccione curso:");
        jpAssistance.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jcbSelectCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        jcbSelectCourse.setFocusable(false);
        jpAssistance.add(jcbSelectCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 460, -1));

        jtTableAssistance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jtTableAssistance);

        jpAssistance.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 950, 410));

        jbtShowAssistance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_assistance150x30_OFF.png"))); // NOI18N
        jbtShowAssistance.setBorder(null);
        jbtShowAssistance.setBorderPainted(false);
        jbtShowAssistance.setContentAreaFilled(false);
        jbtShowAssistance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtShowAssistance.setDefaultCapable(false);
        jbtShowAssistance.setEnabled(false);
        jbtShowAssistance.setFocusPainted(false);
        jbtShowAssistance.setFocusable(false);
        jbtShowAssistance.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_assistance150x30_ON.png"))); // NOI18N
        jbtShowAssistance.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_assistance150x30_ON.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpOptions.setOpaque(false);
        jpOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlImageProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImageProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpOptions.add(jlImageProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 150));

        jbtEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_OFF.png"))); // NOI18N
        jbtEditProfile.setBorder(null);
        jbtEditProfile.setBorderPainted(false);
        jbtEditProfile.setContentAreaFilled(false);
        jbtEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEditProfile.setDefaultCapable(false);
        jbtEditProfile.setFocusPainted(false);
        jbtEditProfile.setFocusable(false);
        jbtEditProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_ON.png"))); // NOI18N
        jbtEditProfile.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jbtShowEnrolledCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_courseenroll150x30_OFF.png"))); // NOI18N
        jbtShowEnrolledCourses.setBorder(null);
        jbtShowEnrolledCourses.setBorderPainted(false);
        jbtShowEnrolledCourses.setContentAreaFilled(false);
        jbtShowEnrolledCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtShowEnrolledCourses.setDefaultCapable(false);
        jbtShowEnrolledCourses.setFocusPainted(false);
        jbtShowEnrolledCourses.setFocusable(false);
        jbtShowEnrolledCourses.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_courseenroll150x30_ON.png"))); // NOI18N
        jbtShowEnrolledCourses.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_courseenroll150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtShowEnrolledCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jbtShowNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_notes150x30_OFF.png"))); // NOI18N
        jbtShowNotes.setBorder(null);
        jbtShowNotes.setBorderPainted(false);
        jbtShowNotes.setContentAreaFilled(false);
        jbtShowNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtShowNotes.setDefaultCapable(false);
        jbtShowNotes.setFocusPainted(false);
        jbtShowNotes.setFocusable(false);
        jbtShowNotes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_notes150x30_ON.png"))); // NOI18N
        jbtShowNotes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_show_notes150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtShowNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jpiMain.add(jpOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 520));

        jpEnrolledCourses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpEnrolledCourses.setOpaque(false);
        jpEnrolledCourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTableEnrolledCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Asignatura", "Docente", "Grado", "Sección", "Día", "Turno"
            }
        ));
        jtTableEnrolledCourse.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTableEnrolledCourse);

        jpEnrolledCourses.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 940, 360));

        jLabel2.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cusos matriculados:");
        jpEnrolledCourses.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jbtReloadEnrolls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtReloadEnrolls.setBorder(null);
        jbtReloadEnrolls.setBorderPainted(false);
        jbtReloadEnrolls.setContentAreaFilled(false);
        jbtReloadEnrolls.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtReloadEnrolls.setDefaultCapable(false);
        jbtReloadEnrolls.setFocusPainted(false);
        jbtReloadEnrolls.setFocusable(false);
        jbtReloadEnrolls.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtReloadEnrolls.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jpEnrolledCourses.add(jbtReloadEnrolls, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jpiMain.add(jpEnrolledCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 990, 520));

        jpEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpEditProfile.setOpaque(false);
        jpEditProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Datos del perfil:");
        jpEditProfile.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jlPhotoEditProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPhotoEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpEditProfile.add(jlPhotoEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 220, 150));

        jbtExaminePhotoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_examine150x30_OFF.png"))); // NOI18N
        jbtExaminePhotoProfile.setBorder(null);
        jbtExaminePhotoProfile.setBorderPainted(false);
        jbtExaminePhotoProfile.setContentAreaFilled(false);
        jbtExaminePhotoProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtExaminePhotoProfile.setDefaultCapable(false);
        jbtExaminePhotoProfile.setFocusPainted(false);
        jbtExaminePhotoProfile.setFocusable(false);
        jbtExaminePhotoProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_examine150x30_ON.png"))); // NOI18N
        jbtExaminePhotoProfile.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_examine150x30_ON.png"))); // NOI18N
        jpEditProfile.add(jbtExaminePhotoProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellidos:");
        jpEditProfile.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombres:");
        jpEditProfile.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono / Celular:");
        jpEditProfile.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("E-mail:");
        jpEditProfile.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario:");
        jpEditProfile.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contraseña:");
        jpEditProfile.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jtfLastnames.setEditable(false);
        jpEditProfile.add(jtfLastnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 200, 20));

        jtfNames.setEditable(false);
        jpEditProfile.add(jtfNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 20));

        jtfTelcel.setEditable(false);
        jpEditProfile.add(jtfTelcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 200, 20));

        jtfMail.setEditable(false);
        jpEditProfile.add(jtfMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 200, 20));

        jtfUsername.setEditable(false);
        jpEditProfile.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 200, 20));

        jpfPassword.setEditable(false);
        jpEditProfile.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 200, 20));

        jckbCheckEdit.setForeground(new java.awt.Color(255, 255, 255));
        jckbCheckEdit.setText("Habilitar edición");
        jckbCheckEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png"))); // NOI18N
        jckbCheckEdit.setOpaque(false);
        jckbCheckEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_ON.png"))); // NOI18N
        jpEditProfile.add(jckbCheckEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jbtEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_OFF.png"))); // NOI18N
        jbtEdit.setBorder(null);
        jbtEdit.setBorderPainted(false);
        jbtEdit.setContentAreaFilled(false);
        jbtEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEdit.setDefaultCapable(false);
        jbtEdit.setFocusPainted(false);
        jbtEdit.setFocusable(false);
        jbtEdit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_ON.png"))); // NOI18N
        jbtEdit.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_profile150x30_ON.png"))); // NOI18N
        jpEditProfile.add(jbtEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jbtCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_OFF.png"))); // NOI18N
        jbtCancel.setBorder(null);
        jbtCancel.setBorderPainted(false);
        jbtCancel.setContentAreaFilled(false);
        jbtCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCancel.setDefaultCapable(false);
        jbtCancel.setFocusPainted(false);
        jbtCancel.setFocusable(false);
        jbtCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jbtCancel.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jpEditProfile.add(jbtCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jckbShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jckbShowPassword.setText("Mostrar contraseña");
        jckbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png"))); // NOI18N
        jckbShowPassword.setOpaque(false);
        jckbShowPassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_ON.png"))); // NOI18N
        jpEditProfile.add(jckbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DNI:");
        jpEditProfile.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jtfDNI.setEditable(false);
        jpEditProfile.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 200, 20));

        jbtEditPhotoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_photo150x30_OFF.png"))); // NOI18N
        jbtEditPhotoProfile.setBorder(null);
        jbtEditPhotoProfile.setBorderPainted(false);
        jbtEditPhotoProfile.setContentAreaFilled(false);
        jbtEditPhotoProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEditPhotoProfile.setDefaultCapable(false);
        jbtEditPhotoProfile.setFocusPainted(false);
        jbtEditPhotoProfile.setFocusable(false);
        jbtEditPhotoProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_photo150x30_ON.png"))); // NOI18N
        jbtEditPhotoProfile.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_edit_photo150x30_ON.png"))); // NOI18N
        jpEditProfile.add(jbtEditPhotoProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, -1, -1));

        jbtCancelEditPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_OFF.png"))); // NOI18N
        jbtCancelEditPhoto.setBorder(null);
        jbtCancelEditPhoto.setBorderPainted(false);
        jbtCancelEditPhoto.setContentAreaFilled(false);
        jbtCancelEditPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCancelEditPhoto.setDefaultCapable(false);
        jbtCancelEditPhoto.setFocusPainted(false);
        jbtCancelEditPhoto.setFocusable(false);
        jbtCancelEditPhoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jbtCancelEditPhoto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jpEditProfile.add(jbtCancelEditPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, -1, -1));

        jpiMain.add(jpEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 990, 520));

        jpNotes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpNotes.setOpaque(false);
        jpNotes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Notas:");
        jpNotes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtTableNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Clase", "Asignatura", "Docente", "Nota", "Fecha"
            }
        ));
        jtTableNotes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtTableNotes);

        jpNotes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 920, 290));

        jbtReloadNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtReloadNotes.setBorder(null);
        jbtReloadNotes.setBorderPainted(false);
        jbtReloadNotes.setContentAreaFilled(false);
        jbtReloadNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtReloadNotes.setDefaultCapable(false);
        jbtReloadNotes.setFocusPainted(false);
        jbtReloadNotes.setFocusable(false);
        jbtReloadNotes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtReloadNotes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jpNotes.add(jbtReloadNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jpiMain.add(jpNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 990, 520));

        jmOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/options32x32.png"))); // NOI18N
        jmOptions.setText("Opciones");

        jmiLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/logout24x24.png"))); // NOI18N
        jmiLogout.setText("Cerrar Sesión");
        jmOptions.add(jmiLogout);

        jmbMenus.add(jmOptions);

        setJMenuBar(jmbMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton jbtCancel;
    public javax.swing.JButton jbtCancelEditPhoto;
    public javax.swing.JButton jbtEdit;
    public javax.swing.JButton jbtEditPhotoProfile;
    public javax.swing.JButton jbtEditProfile;
    public javax.swing.JButton jbtExaminePhotoProfile;
    public javax.swing.JButton jbtReloadEnrolls;
    public javax.swing.JButton jbtReloadNotes;
    private javax.swing.JButton jbtShowAssistance;
    public javax.swing.JButton jbtShowEnrolledCourses;
    public javax.swing.JButton jbtShowNotes;
    public javax.swing.JComboBox<String> jcbSelectCourse;
    public javax.swing.JCheckBox jckbCheckEdit;
    public javax.swing.JCheckBox jckbShowPassword;
    public javax.swing.JLabel jlImageProfile;
    public javax.swing.JLabel jlPhotoEditProfile;
    public javax.swing.JMenu jmOptions;
    public javax.swing.JMenuBar jmbMenus;
    public javax.swing.JMenuItem jmiLogout;
    private javax.swing.JPanel jpAssistance;
    public javax.swing.JPanel jpEditProfile;
    public javax.swing.JPanel jpEnrolledCourses;
    public javax.swing.JPanel jpNotes;
    private javax.swing.JPanel jpOptions;
    public javax.swing.JPasswordField jpfPassword;
    public org.edisoncor.gui.panel.PanelImage jpiMain;
    public javax.swing.JTable jtTableAssistance;
    public javax.swing.JTable jtTableEnrolledCourse;
    public javax.swing.JTable jtTableNotes;
    public javax.swing.JTextField jtfDNI;
    public javax.swing.JTextField jtfLastnames;
    public javax.swing.JTextField jtfMail;
    public javax.swing.JTextField jtfNames;
    public javax.swing.JTextField jtfTelcel;
    public javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
