package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewLogin extends javax.swing.JFrame {

    public ViewLogin() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiBackground = new org.edisoncor.gui.panel.PanelImage();
        piBackgroundContainer = new org.edisoncor.gui.panel.PanelImage();
        jckbRememberAccount = new javax.swing.JCheckBox();
        jckbShowPassword = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jtfriUsername = new org.edisoncor.gui.textField.TextFieldRectIcon();
        jpfriPassword = new org.edisoncor.gui.passwordField.PasswordFieldRectIcon();
        jbtLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/al1.jpg"))); // NOI18N
        jpiBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        piBackgroundContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bgLogin-Container.png"))); // NOI18N
        piBackgroundContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jckbRememberAccount.setForeground(new java.awt.Color(249, 253, 253));
        jckbRememberAccount.setText("Recordar cuenta");
        jckbRememberAccount.setContentAreaFilled(false);
        jckbRememberAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jckbRememberAccount.setFocusPainted(false);
        jckbRememberAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png"))); // NOI18N
        piBackgroundContainer.add(jckbRememberAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jckbShowPassword.setForeground(new java.awt.Color(249, 253, 253));
        jckbShowPassword.setText("Mostrar contraseña");
        jckbShowPassword.setContentAreaFilled(false);
        jckbShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jckbShowPassword.setFocusPainted(false);
        jckbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/ckbLogin20x20_OFF.png"))); // NOI18N
        piBackgroundContainer.add(jckbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 253, 253));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Iniciar sesión en el Sistema");
        piBackgroundContainer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 290, 30));

        jtfriUsername.setBackground(new java.awt.Color(53, 60, 79));
        jtfriUsername.setBorder(null);
        jtfriUsername.setForeground(new java.awt.Color(249, 253, 253));
        jtfriUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfriUsername.setColorDeBorde(new java.awt.Color(51, 54, 71));
        jtfriUsername.setFocusCycleRoot(true);
        jtfriUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/usuario64x64.png"))); // NOI18N
        piBackgroundContainer.add(jtfriUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 350, 35));

        jpfriPassword.setBackground(new java.awt.Color(53, 60, 79));
        jpfriPassword.setForeground(new java.awt.Color(249, 253, 253));
        jpfriPassword.setAlignmentX(2.0F);
        jpfriPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        jpfriPassword.setColorDeBorde(new java.awt.Color(51, 54, 71));
        jpfriPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/password64x64.png"))); // NOI18N
        piBackgroundContainer.add(jpfriPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 350, 35));

        jbtLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnLogin_OFF.png"))); // NOI18N
        jbtLogin.setBorderPainted(false);
        jbtLogin.setContentAreaFilled(false);
        jbtLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtLogin.setDefaultCapable(false);
        jbtLogin.setFocusPainted(false);
        jbtLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnLogin_ON.png"))); // NOI18N
        jbtLogin.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btnLogin_ON.png"))); // NOI18N
        piBackgroundContainer.add(jbtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 215, 350, 40));

        jpiBackground.add(piBackgroundContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 420, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    public javax.swing.JButton jbtLogin;
    public javax.swing.JCheckBox jckbRememberAccount;
    public javax.swing.JCheckBox jckbShowPassword;
    public org.edisoncor.gui.passwordField.PasswordFieldRectIcon jpfriPassword;
    public org.edisoncor.gui.panel.PanelImage jpiBackground;
    public org.edisoncor.gui.textField.TextFieldRectIcon jtfriUsername;
    private org.edisoncor.gui.panel.PanelImage piBackgroundContainer;
    // End of variables declaration//GEN-END:variables
}
