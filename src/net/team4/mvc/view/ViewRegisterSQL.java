package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewRegisterSQL extends javax.swing.JFrame {

    public ViewRegisterSQL() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiBackground = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfIp = new javax.swing.JTextField();
        jtfPort = new javax.swing.JTextField();
        jtfDatabase = new javax.swing.JTextField();
        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jckbShowPassword = new javax.swing.JCheckBox();
        jbtRegisterSQL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_main_invert.png"))); // NOI18N
        jpiBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro SQL");
        jpiBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel2.setText("Ip:");
        jpiBackground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel3.setText("Port:");
        jpiBackground.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel4.setText("Database:");
        jpiBackground.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel5.setText("Username:");
        jpiBackground.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel6.setText("Password:");
        jpiBackground.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jtfIp.setBorder(null);
        jpiBackground.add(jtfIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 190, 20));

        jtfPort.setBorder(null);
        jpiBackground.add(jtfPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 190, 20));

        jtfDatabase.setBorder(null);
        jpiBackground.add(jtfDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 190, 20));

        jtfUsername.setBorder(null);
        jpiBackground.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 190, 20));

        jpfPassword.setBorder(null);
        jpiBackground.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 190, 20));

        jckbShowPassword.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jckbShowPassword.setText("Mostra contraseña");
        jckbShowPassword.setContentAreaFilled(false);
        jckbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png"))); // NOI18N
        jckbShowPassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_ON.png"))); // NOI18N
        jpiBackground.add(jckbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jbtRegisterSQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_mysql150x30_OFF.png"))); // NOI18N
        jbtRegisterSQL.setBorder(null);
        jbtRegisterSQL.setBorderPainted(false);
        jbtRegisterSQL.setContentAreaFilled(false);
        jbtRegisterSQL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtRegisterSQL.setDefaultCapable(false);
        jbtRegisterSQL.setFocusPainted(false);
        jbtRegisterSQL.setFocusable(false);
        jbtRegisterSQL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_mysql150x30_ON.png"))); // NOI18N
        jbtRegisterSQL.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_mysql150x30_ON.png"))); // NOI18N
        jpiBackground.add(jbtRegisterSQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JButton jbtRegisterSQL;
    public javax.swing.JCheckBox jckbShowPassword;
    public javax.swing.JPasswordField jpfPassword;
    private org.edisoncor.gui.panel.PanelImage jpiBackground;
    public javax.swing.JTextField jtfDatabase;
    public javax.swing.JTextField jtfIp;
    public javax.swing.JTextField jtfPort;
    public javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
