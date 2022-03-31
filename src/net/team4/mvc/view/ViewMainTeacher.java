package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewMainTeacher extends javax.swing.JFrame {

    public ViewMainTeacher() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpEditNotes1 = new javax.swing.JPanel();
        jcbSelectClass1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jpEditStudentNote1 = new org.edisoncor.gui.panel.PanelImage();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel14 = new javax.swing.JLabel();
        jtfIDStudentSelected1 = new javax.swing.JTextField();
        jbtCancelEditNote1 = new javax.swing.JButton();
        jbtAssistance = new javax.swing.JButton();
        jpiMain = new org.edisoncor.gui.panel.PanelImage();
        jpOptions = new javax.swing.JPanel();
        jlImageProfile = new javax.swing.JLabel();
        jbtNotes = new javax.swing.JButton();
        jbtEditProfile = new javax.swing.JButton();
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
        jpEditNotes = new javax.swing.JPanel();
        jcbSelectClass = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jpEditStudentNote = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListStudentNotes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfIDStudentSelected = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfNewNote = new javax.swing.JTextField();
        jbtRegisterNoteStudent = new javax.swing.JButton();
        jbtCancelEditNote = new javax.swing.JButton();
        jmbMenus = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();

        jpEditNotes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpEditNotes1.setOpaque(false);
        jpEditNotes1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbSelectClass1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        jcbSelectClass1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSelectClass1.setFocusable(false);
        jpEditNotes1.add(jcbSelectClass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 660, 20));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seleccione clase:");
        jpEditNotes1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jpEditStudentNote1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpEditStudentNote1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpEditStudentNote1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Registrar nueva asistencia");
        jpEditStudentNote1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Modificar asistencia");
        jpEditStudentNote1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        panelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID del estuiante seleccionado:");
        panelImage1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, -1));

        jtfIDStudentSelected1.setEditable(false);
        panelImage1.add(jtfIDStudentSelected1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 190, -1));

        jbtCancelEditNote1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_OFF.png"))); // NOI18N
        jbtCancelEditNote1.setBorder(null);
        jbtCancelEditNote1.setBorderPainted(false);
        jbtCancelEditNote1.setContentAreaFilled(false);
        jbtCancelEditNote1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCancelEditNote1.setDefaultCapable(false);
        jbtCancelEditNote1.setFocusPainted(false);
        jbtCancelEditNote1.setFocusable(false);
        jbtCancelEditNote1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jbtCancelEditNote1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        panelImage1.add(jbtCancelEditNote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, -1));

        jpEditStudentNote1.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 940, 370));

        jpEditNotes1.add(jpEditStudentNote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 440));

        jbtAssistance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setassistance150x30_OFF.png"))); // NOI18N
        jbtAssistance.setBorder(null);
        jbtAssistance.setBorderPainted(false);
        jbtAssistance.setContentAreaFilled(false);
        jbtAssistance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtAssistance.setDefaultCapable(false);
        jbtAssistance.setEnabled(false);
        jbtAssistance.setFocusPainted(false);
        jbtAssistance.setFocusable(false);
        jbtAssistance.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setassistance150x30_ON.png"))); // NOI18N
        jbtAssistance.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setassistance150x30_ON.png"))); // NOI18N

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

        jbtNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setnotes150x30_OFF.png"))); // NOI18N
        jbtNotes.setBorder(null);
        jbtNotes.setBorderPainted(false);
        jbtNotes.setContentAreaFilled(false);
        jbtNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNotes.setDefaultCapable(false);
        jbtNotes.setFocusPainted(false);
        jbtNotes.setFocusable(false);
        jbtNotes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setnotes150x30_ON.png"))); // NOI18N
        jbtNotes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_setnotes150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

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
        jpOptions.add(jbtEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jpiMain.add(jpOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 520));

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

        jpEditNotes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpEditNotes.setOpaque(false);
        jpEditNotes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbSelectClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        jcbSelectClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSelectClass.setFocusable(false);
        jpEditNotes.add(jcbSelectClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 660, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione clase:");
        jpEditNotes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jpEditStudentNote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpEditStudentNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main.png"))); // NOI18N
        jpEditStudentNote.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtListStudentNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estudiante", "Estudiante", "Nota actual", "Fecha de registro", "Seleccionar"
            }
        ));
        jtListStudentNotes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtListStudentNotes);

        jpEditStudentNote.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 440, 400));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID del estuiante seleccionado:");
        jpEditStudentNote.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione estudiante:");
        jpEditStudentNote.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jtfIDStudentSelected.setEditable(false);
        jpEditStudentNote.add(jtfIDStudentSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 190, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ingrese nueva nota:");
        jpEditStudentNote.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));
        jpEditStudentNote.add(jtfNewNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 260, -1));

        jbtRegisterNoteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_note150x30_OFF.png"))); // NOI18N
        jbtRegisterNoteStudent.setBorder(null);
        jbtRegisterNoteStudent.setBorderPainted(false);
        jbtRegisterNoteStudent.setContentAreaFilled(false);
        jbtRegisterNoteStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterNoteStudent.setDefaultCapable(false);
        jbtRegisterNoteStudent.setFocusPainted(false);
        jbtRegisterNoteStudent.setFocusable(false);
        jbtRegisterNoteStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_note150x30_ON.png"))); // NOI18N
        jbtRegisterNoteStudent.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_note150x30_ON.png"))); // NOI18N
        jpEditStudentNote.add(jbtRegisterNoteStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jbtCancelEditNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_OFF.png"))); // NOI18N
        jbtCancelEditNote.setBorder(null);
        jbtCancelEditNote.setBorderPainted(false);
        jbtCancelEditNote.setContentAreaFilled(false);
        jbtCancelEditNote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCancelEditNote.setDefaultCapable(false);
        jbtCancelEditNote.setFocusPainted(false);
        jbtCancelEditNote.setFocusable(false);
        jbtCancelEditNote.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jbtCancelEditNote.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_cancel150x30_ON.png"))); // NOI18N
        jpEditStudentNote.add(jbtCancelEditNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        jpEditNotes.add(jpEditStudentNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 440));

        jpiMain.add(jpEditNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 990, 520));

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
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtAssistance;
    public javax.swing.JButton jbtCancel;
    public javax.swing.JButton jbtCancelEditNote;
    public javax.swing.JButton jbtCancelEditNote1;
    public javax.swing.JButton jbtCancelEditPhoto;
    public javax.swing.JButton jbtEdit;
    public javax.swing.JButton jbtEditPhotoProfile;
    public javax.swing.JButton jbtEditProfile;
    public javax.swing.JButton jbtExaminePhotoProfile;
    public javax.swing.JButton jbtNotes;
    public javax.swing.JButton jbtRegisterNoteStudent;
    public javax.swing.JComboBox<String> jcbSelectClass;
    public javax.swing.JComboBox<String> jcbSelectClass1;
    public javax.swing.JCheckBox jckbCheckEdit;
    public javax.swing.JCheckBox jckbShowPassword;
    public javax.swing.JLabel jlImageProfile;
    public javax.swing.JLabel jlPhotoEditProfile;
    public javax.swing.JMenu jmOptions;
    public javax.swing.JMenuBar jmbMenus;
    public javax.swing.JMenuItem jmiLogout;
    public javax.swing.JPanel jpEditNotes;
    public javax.swing.JPanel jpEditNotes1;
    public javax.swing.JPanel jpEditProfile;
    public org.edisoncor.gui.panel.PanelImage jpEditStudentNote;
    public org.edisoncor.gui.panel.PanelImage jpEditStudentNote1;
    private javax.swing.JPanel jpOptions;
    public javax.swing.JPasswordField jpfPassword;
    public org.edisoncor.gui.panel.PanelImage jpiMain;
    public javax.swing.JTable jtListStudentNotes;
    public javax.swing.JTextField jtfDNI;
    public javax.swing.JTextField jtfIDStudentSelected;
    public javax.swing.JTextField jtfIDStudentSelected1;
    public javax.swing.JTextField jtfLastnames;
    public javax.swing.JTextField jtfMail;
    public javax.swing.JTextField jtfNames;
    public javax.swing.JTextField jtfNewNote;
    public javax.swing.JTextField jtfTelcel;
    public javax.swing.JTextField jtfUsername;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
