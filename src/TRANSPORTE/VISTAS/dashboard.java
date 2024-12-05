/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TRANSPORTE.VISTAS;

/**
 *
 * @author arnal
 */
public class dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public dashboard() {
        initComponents();

    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel() {
            @Override 
            protected void paintComponent(java.awt.Graphics g) { 
                super.paintComponent(g);
                g.drawImage(
                    new javax.swing.ImageIcon(getClass().getResource("/img/iconSistem.png")).getImage(),
                    0, 0, getWidth(), getHeight(), this);
            } 
        };
        btnNewCliente = new javax.swing.JButton();
        btnNewGuia = new javax.swing.JButton();
        btnNewUnidad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(684, 694));
        setName("prestamos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(684, 694));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(250, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(684, 694));
        pnlMain.setLayout(new java.awt.CardLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNewCliente.setBackground(new java.awt.Color(255, 255, 204));
        btnNewCliente.setFont(new java.awt.Font("Roboto Black", 2, 24)); // NOI18N
        btnNewCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconUsers.png"))); // NOI18N
        btnNewCliente.setText("<html>NUEVO<br>CLIENTE</html>");
        btnNewCliente.setToolTipText("");
        btnNewCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnNewCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewCliente.setIconTextGap(10);
        jPanel1.add(btnNewCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 200, 200));

        btnNewGuia.setBackground(new java.awt.Color(204, 255, 204));
        btnNewGuia.setFont(new java.awt.Font("Roboto Black", 2, 24)); // NOI18N
        btnNewGuia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconGuias.png"))); // NOI18N
        btnNewGuia.setText("<html>NUEVA<br>GUIA</html>");
        btnNewGuia.setToolTipText("");
        btnNewGuia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnNewGuia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewGuia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewGuia.setIconTextGap(20);
        jPanel1.add(btnNewGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 200, 200));

        btnNewUnidad.setBackground(new java.awt.Color(204, 255, 153));
        btnNewUnidad.setFont(new java.awt.Font("Roboto Black", 2, 24)); // NOI18N
        btnNewUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconUnidades.png"))); // NOI18N
        btnNewUnidad.setText("<html>REGISTRAR<br>UNIDAD</html>");
        btnNewUnidad.setToolTipText("");
        btnNewUnidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnNewUnidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewUnidad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewUnidad.setIconTextGap(10);
        jPanel1.add(btnNewUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 200, 200));

        jLabel1.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("CI 27.524.130 - José Alvarado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("CI 26.555.629 - Cesar Barrios");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("CI 27.747.762 - Arnaldo Flores");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, -1, -1));

        lblFecha.setFont(new java.awt.Font("Roboto", 2, 48)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 50));

        pnlMain.add(jPanel1, "card3");

        add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 730));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnNewCliente;
    public javax.swing.JButton btnNewGuia;
    public javax.swing.JButton btnNewUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblFecha;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}