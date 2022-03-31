package net.team4.mvc.view;

import javax.swing.UIManager;

public class ViewCalendarTeachers extends javax.swing.JFrame {

    public ViewCalendarTeachers() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiMain = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/trilce-logo.png")).getImage());
        setResizable(false);

        jpiMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/team4/images/xd.png"))); // NOI18N
        jpiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Docente", "Asignatura", "Turno", "Sección", "Día", "Fecha de registro", "Remover"
            }
        ));
        jtList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtList);

        jpiMain.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1020, 340));

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");
        jpiMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jtfSearch.setBorder(null);
        jpiMain.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 240, 20));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de horarios");
        jpiMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

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
        jpiMain.add(jbtPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiMain, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtPrint;
    private org.edisoncor.gui.panel.PanelImage jpiMain;
    public javax.swing.JTable jtList;
    public javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
