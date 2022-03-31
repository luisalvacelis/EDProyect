package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewRegisterCategoryCourses extends javax.swing.JFrame {

    public ViewRegisterCategoryCourses() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiBackground = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jpOptions = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfObservation = new javax.swing.JTextField();
        jbtNew = new javax.swing.JButton();
        jbtRegister = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();
        jbtUpdateList = new javax.swing.JButton();
        jbtPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/bg_register_categorys_courses.png"))); // NOI18N
        jpiBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Observación", "Seleccionar", "Remover"
            }
        ));
        jtList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtList);

        jpiBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 620, 210));

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");
        jpiBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jtfSearch.setBorder(null);
        jpiBackground.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 190, 20));

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de categoría de asignaturas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Californian FB", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jpOptions.setOpaque(false);
        jpOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese nombre:");
        jpOptions.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese observación");
        jpOptions.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jtfName.setBorder(null);
        jpOptions.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, 20));

        jtfObservation.setBorder(null);
        jpOptions.add(jtfObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, 20));

        jbtNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_OFF.png"))); // NOI18N
        jbtNew.setBorder(null);
        jbtNew.setBorderPainted(false);
        jbtNew.setContentAreaFilled(false);
        jbtNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNew.setDefaultCapable(false);
        jbtNew.setFocusPainted(false);
        jbtNew.setFocusable(false);
        jbtNew.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jbtNew.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_nuevo150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jbtRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_OFF.png"))); // NOI18N
        jbtRegister.setBorder(null);
        jbtRegister.setBorderPainted(false);
        jbtRegister.setContentAreaFilled(false);
        jbtRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegister.setDefaultCapable(false);
        jbtRegister.setFocusPainted(false);
        jbtRegister.setFocusable(false);
        jbtRegister.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_ON.png"))); // NOI18N
        jbtRegister.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_register_categories150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 150, -1));

        jbtUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_OFF.png"))); // NOI18N
        jbtUpdate.setBorder(null);
        jbtUpdate.setBorderPainted(false);
        jbtUpdate.setContentAreaFilled(false);
        jbtUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtUpdate.setDefaultCapable(false);
        jbtUpdate.setEnabled(false);
        jbtUpdate.setFocusPainted(false);
        jbtUpdate.setFocusable(false);
        jbtUpdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jbtUpdate.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update150x30_ON.png"))); // NOI18N
        jpOptions.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jpiBackground.add(jpOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 150));

        jbtUpdateList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update_list150x30_OFF.png"))); // NOI18N
        jbtUpdateList.setBorder(null);
        jbtUpdateList.setBorderPainted(false);
        jbtUpdateList.setContentAreaFilled(false);
        jbtUpdateList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtUpdateList.setDefaultCapable(false);
        jbtUpdateList.setFocusPainted(false);
        jbtUpdateList.setFocusable(false);
        jbtUpdateList.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update_list150x30_ON.png"))); // NOI18N
        jbtUpdateList.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_update_list150x30_ON.png"))); // NOI18N
        jpiBackground.add(jbtUpdateList, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jbtPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_print150x30_OFF.png"))); // NOI18N
        jbtPrint.setBorder(null);
        jbtPrint.setBorderPainted(false);
        jbtPrint.setContentAreaFilled(false);
        jbtPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtPrint.setDefaultCapable(false);
        jbtPrint.setFocusPainted(false);
        jbtPrint.setFocusable(false);
        jbtPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_print150x30_ON.png"))); // NOI18N
        jbtPrint.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/btn_print150x30_ON.png"))); // NOI18N
        jpiBackground.add(jbtPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtNew;
    public javax.swing.JButton jbtPrint;
    public javax.swing.JButton jbtRegister;
    public javax.swing.JButton jbtUpdate;
    public javax.swing.JButton jbtUpdateList;
    private javax.swing.JPanel jpOptions;
    private org.edisoncor.gui.panel.PanelImage jpiBackground;
    public javax.swing.JTable jtList;
    public javax.swing.JTextField jtfName;
    public javax.swing.JTextField jtfObservation;
    public javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
