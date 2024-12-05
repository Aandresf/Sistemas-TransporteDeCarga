/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TRANSPORTE.VISTAS.CLIENTES;

/**
 *
 * @author arnal
 */
public class mainClientes extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */

    public mainClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        btnHeader1 = new javax.swing.JToggleButton();
        pnlMain = new javax.swing.JPanel();
        pnlMain1 = new javax.swing.JPanel();
        checkEstado2 = new javax.swing.JCheckBox();
        btnModificarSede1 = new javax.swing.JButton();
        btnDeleteFromTable = new javax.swing.JButton();
        btnFormModifyTransportista = new javax.swing.JButton();
        txtFilterSede1 = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSedes1 = new javax.swing.JTable();
        btnRecargar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(684, 694));
        setName("prestamos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(684, 694));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHeader1.setBackground(new java.awt.Color(248, 248, 248));
        btnHeader1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnHeader1.setSelected(true);
        btnHeader1.setText("CLIENTES");
        btnHeader1.setBorder(null);
        btnHeader1.setBorderPainted(false);
        btnHeader1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHeader.add(btnHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 212, 70));

        add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        pnlMain.setPreferredSize(new java.awt.Dimension(684, 694));
        pnlMain.setLayout(new java.awt.CardLayout());

        pnlMain1.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain1.setMinimumSize(new java.awt.Dimension(684, 685));
        pnlMain1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkEstado2.setText("NO DISPONIBLE");
        pnlMain1.add(checkEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        btnModificarSede1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnModificarSede1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconTableEdit.png"))); // NOI18N
        btnModificarSede1.setText("MODIFICAR");
        btnModificarSede1.setToolTipText("");
        btnModificarSede1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnModificarSede1.setIconTextGap(10);
        btnModificarSede1.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnModificarSede1.setMaximumSize(new java.awt.Dimension(125, 35));
        btnModificarSede1.setMinimumSize(new java.awt.Dimension(125, 35));
        btnModificarSede1.setPreferredSize(new java.awt.Dimension(125, 35));
        pnlMain1.add(btnModificarSede1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 160, 40));

        btnDeleteFromTable.setBackground(new java.awt.Color(102, 0, 0));
        btnDeleteFromTable.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnDeleteFromTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteFromTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ligth/iconTrash.png"))); // NOI18N
        btnDeleteFromTable.setText("ELIMINAR");
        btnDeleteFromTable.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDeleteFromTable.setIconTextGap(10);
        btnDeleteFromTable.setMargin(new java.awt.Insets(2, 1, 3, 14));
        pnlMain1.add(btnDeleteFromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 610, 160, 40));

        btnFormModifyTransportista.setBackground(new java.awt.Color(153, 255, 153));
        btnFormModifyTransportista.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnFormModifyTransportista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconAdd.png"))); // NOI18N
        btnFormModifyTransportista.setText("<html>REGISTAR<br>CLIENTE</html>");
        btnFormModifyTransportista.setToolTipText("");
        btnFormModifyTransportista.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFormModifyTransportista.setIconTextGap(10);
        btnFormModifyTransportista.setMargin(new java.awt.Insets(2, 1, 3, 14));
        pnlMain1.add(btnFormModifyTransportista, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 160, 60));

        txtFilterSede1.setBackground(new java.awt.Color(242, 242, 242));
        txtFilterSede1.setBorder(null);
        txtFilterSede1.setMargin(new java.awt.Insets(0, 10, 0, 0));
        txtFilterSede1.setOpaque(true);
        pnlMain1.add(txtFilterSede1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 40));

        btnSearch2.setBackground(new java.awt.Color(242, 242, 242));
        btnSearch2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconSearch.png"))); // NOI18N
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.setOpaque(true);
        pnlMain1.add(btnSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 40, 40));

        tblSedes1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tblSedes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSedes1.setRowHeight(35);
        jScrollPane3.setViewportView(tblSedes1);

        pnlMain1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 980, 490));

        btnRecargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconRefresh.png"))); // NOI18N
        btnRecargar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMain1.add(btnRecargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        pnlMain.add(pnlMain1, "card2");

        add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 660));
    }// </editor-fold>//GEN-END:initComponents
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDeleteFromTable;
    public javax.swing.JButton btnFormModifyTransportista;
    public javax.swing.JToggleButton btnHeader1;
    public javax.swing.JButton btnModificarSede1;
    public javax.swing.JButton btnRecargar;
    private javax.swing.JLabel btnSearch2;
    public javax.swing.JCheckBox checkEstado2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    public javax.swing.JPanel pnlMain1;
    public javax.swing.JTable tblSedes1;
    public javax.swing.JTextField txtFilterSede1;
    // End of variables declaration//GEN-END:variables
}
