package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewEnrolls extends javax.swing.JFrame {

    public ViewEnrolls() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiMain = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jbtPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListEnrolls = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/xd.png"))); // NOI18N
        jpiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de matriculas");
        jpiMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");
        jpiMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jtfSearch.setBorder(null);
        jpiMain.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 260, 20));

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
        jpiMain.add(jbtPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, -1, -1));

        jtListEnrolls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID de Clase", "Estudiante", "Docente", "Asignatura", "Turno", "Sección", "Día"
            }
        ));
        jtListEnrolls.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtListEnrolls);

        jpiMain.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1070, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1095, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtPrint;
    public org.edisoncor.gui.panel.PanelImage jpiMain;
    public javax.swing.JTable jtListEnrolls;
    public javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
