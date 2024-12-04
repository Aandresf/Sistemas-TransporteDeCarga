/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TRANSPORTE.VISTAS.GUIAS;

/**
 *
 * @author milag
 */
public class formCostoOperativos extends javax.swing.JPanel {

    /**
     * Creates new form formCostoOperativos
     */
    public formCostoOperativos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUser1 = new javax.swing.JPanel();
        lblNombreGastoOperativo = new javax.swing.JLabel();
        txtNombreGastoOperativo = new javax.swing.JTextField();
        lblCodigoGastoOperativo = new javax.swing.JLabel();
        txtCodigoGastoOperativo = new javax.swing.JTextField();
        txtDescripcionGastoOperativo = new javax.swing.JTextField();
        lblDescripGastoOperativo = new javax.swing.JLabel();
        lblInfoTipoServicio = new javax.swing.JLabel();
        btnCancelFormGastoOperativo = new javax.swing.JButton();
        btnCleanFormGastoOperativo = new javax.swing.JButton();
        btnSetFormGastoOperativo = new javax.swing.JButton();
        lblTitleMantemimiento = new javax.swing.JLabel();
        btnEliminarFormGastoOperativo = new javax.swing.JButton();
        btnSearchTipoServicio = new javax.swing.JLabel();

        pnlUser1.setBackground(new java.awt.Color(255, 255, 255));

        lblNombreGastoOperativo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblNombreGastoOperativo.setText("NOMBRE");

        txtNombreGastoOperativo.setBackground(new java.awt.Color(250, 250, 250));
        txtNombreGastoOperativo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtNombreGastoOperativo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreGastoOperativo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreGastoOperativo.setOpaque(true);

        lblCodigoGastoOperativo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCodigoGastoOperativo.setText("CODIGO");

        txtCodigoGastoOperativo.setBackground(new java.awt.Color(250, 250, 250));
        txtCodigoGastoOperativo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtCodigoGastoOperativo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigoGastoOperativo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigoGastoOperativo.setOpaque(true);

        txtDescripcionGastoOperativo.setBackground(new java.awt.Color(250, 250, 250));
        txtDescripcionGastoOperativo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtDescripcionGastoOperativo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescripcionGastoOperativo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescripcionGastoOperativo.setOpaque(true);

        lblDescripGastoOperativo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblDescripGastoOperativo.setText("DESCRIPCION");

        lblInfoTipoServicio.setForeground(new java.awt.Color(255, 0, 51));
        lblInfoTipoServicio.setText("* ");

        btnCancelFormGastoOperativo.setBackground(new java.awt.Color(102, 0, 0));
        btnCancelFormGastoOperativo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCancelFormGastoOperativo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelFormGastoOperativo.setText("CANCELAR");
        btnCancelFormGastoOperativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelFormGastoOperativo.setIconTextGap(10);
        btnCancelFormGastoOperativo.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnCancelFormGastoOperativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFormGastoOperativoActionPerformed(evt);
            }
        });

        btnCleanFormGastoOperativo.setBackground(new java.awt.Color(230, 230, 230));
        btnCleanFormGastoOperativo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCleanFormGastoOperativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconMop.png"))); // NOI18N
        btnCleanFormGastoOperativo.setText("LIMPIAR");
        btnCleanFormGastoOperativo.setToolTipText("");
        btnCleanFormGastoOperativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCleanFormGastoOperativo.setIconTextGap(10);
        btnCleanFormGastoOperativo.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnCleanFormGastoOperativo.setMaximumSize(new java.awt.Dimension(125, 35));
        btnCleanFormGastoOperativo.setMinimumSize(new java.awt.Dimension(125, 35));
        btnCleanFormGastoOperativo.setPreferredSize(new java.awt.Dimension(125, 35));

        btnSetFormGastoOperativo.setBackground(new java.awt.Color(153, 255, 153));
        btnSetFormGastoOperativo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSetFormGastoOperativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconAdd.png"))); // NOI18N
        btnSetFormGastoOperativo.setText("REGISTRAR");
        btnSetFormGastoOperativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSetFormGastoOperativo.setIconTextGap(10);
        btnSetFormGastoOperativo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        lblTitleMantemimiento.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        lblTitleMantemimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleMantemimiento.setText("GASTOS OPERATIVOS");

        btnEliminarFormGastoOperativo.setBackground(new java.awt.Color(102, 0, 0));
        btnEliminarFormGastoOperativo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEliminarFormGastoOperativo.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarFormGastoOperativo.setText("ELIMINAR");
        btnEliminarFormGastoOperativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminarFormGastoOperativo.setIconTextGap(10);
        btnEliminarFormGastoOperativo.setMargin(new java.awt.Insets(2, 1, 3, 14));

        btnSearchTipoServicio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSearchTipoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconSearch.png"))); // NOI18N
        btnSearchTipoServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchTipoServicio.setOpaque(true);

        javax.swing.GroupLayout pnlUser1Layout = new javax.swing.GroupLayout(pnlUser1);
        pnlUser1.setLayout(pnlUser1Layout);
        pnlUser1Layout.setHorizontalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUser1Layout.createSequentialGroup()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoTipoServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescripGastoOperativo)
                                .addGroup(pnlUser1Layout.createSequentialGroup()
                                    .addComponent(lblCodigoGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSearchTipoServicio)))
                            .addComponent(btnCancelFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescripcionGastoOperativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(txtCodigoGastoOperativo))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                                .addComponent(btnCleanFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUser1Layout.createSequentialGroup()
                                .addComponent(lblNombreGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(txtNombreGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUser1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnEliminarFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnSetFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlUser1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitleMantemimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUser1Layout.setVerticalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleMantemimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigoGastoOperativo)
                        .addComponent(txtCodigoGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombreGastoOperativo)
                        .addComponent(txtNombreGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcionGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripGastoOperativo))
                .addGap(35, 35, 35)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCleanFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetFormGastoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelFormGastoOperativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFormGastoOperativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelFormGastoOperativoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelFormGastoOperativo;
    public javax.swing.JButton btnCleanFormGastoOperativo;
    public javax.swing.JButton btnEliminarFormGastoOperativo;
    private javax.swing.JLabel btnSearchTipoServicio;
    public javax.swing.JButton btnSetFormGastoOperativo;
    public javax.swing.JLabel lblCodigoGastoOperativo;
    public javax.swing.JLabel lblDescripGastoOperativo;
    public javax.swing.JLabel lblInfoTipoServicio;
    public javax.swing.JLabel lblNombreGastoOperativo;
    public javax.swing.JLabel lblTitleMantemimiento;
    public javax.swing.JPanel pnlUser1;
    public javax.swing.JTextField txtCodigoGastoOperativo;
    public javax.swing.JTextField txtDescripcionGastoOperativo;
    public javax.swing.JTextField txtNombreGastoOperativo;
    // End of variables declaration//GEN-END:variables
}
