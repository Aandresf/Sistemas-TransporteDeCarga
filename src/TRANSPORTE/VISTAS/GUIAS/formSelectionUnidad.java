/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TRANSPORTE.VISTAS.GUIAS;

import TRANSPORTE.VISTAS.TRANSPORTISTAS.*;

/**
 *
 * @author arnal
 */
public class formSelectionUnidad extends javax.swing.JFrame {

    /**
     * Creates new form formPersonas
     */
    public formSelectionUnidad() {
        initComponents();
        lblEstatusPersona.setVisible(false);
        lblControlFormPersona.setVisible(false);
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
        lblTitlePersona = new javax.swing.JLabel();
        lblEstatusPersona = new javax.swing.JLabel();
        lblInfoPersona = new javax.swing.JLabel();
        lblControlFormPersona = new javax.swing.JLabel();
        lblCategoria7 = new javax.swing.JLabel();
        jcbxTipoPersona = new javax.swing.JComboBox<>();
        btnCancelFormPersona = new javax.swing.JButton();
        btnCleanFormPersona = new javax.swing.JButton();
        btnSetFormPersona = new javax.swing.JButton();
        lblCategoria9 = new javax.swing.JLabel();
        jcbxTipoPersona1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFormPersonas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlUser1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitlePersona.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        lblTitlePersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitlePersona.setText("SELECCIONAR UNIDAD");

        lblEstatusPersona.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblEstatusPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstatusPersona.setText("0");
        lblEstatusPersona.setEnabled(false);

        lblInfoPersona.setForeground(new java.awt.Color(255, 0, 51));
        lblInfoPersona.setText("* ");

        lblControlFormPersona.setText("1");

        lblCategoria7.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        lblCategoria7.setText("TIPO DE CARGA");

        jcbxTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERSONAS", "ANIMALES", "VARIOS SOLIDOS", "VARIOS LIQUIDOS", "VARIOS GASEOSOS" }));
        jcbxTipoPersona.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnCancelFormPersona.setBackground(new java.awt.Color(102, 0, 0));
        btnCancelFormPersona.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCancelFormPersona.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelFormPersona.setText("CANCELAR");
        btnCancelFormPersona.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelFormPersona.setIconTextGap(10);
        btnCancelFormPersona.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnCancelFormPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFormPersonaActionPerformed(evt);
            }
        });

        btnCleanFormPersona.setBackground(new java.awt.Color(230, 230, 230));
        btnCleanFormPersona.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCleanFormPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconMop.png"))); // NOI18N
        btnCleanFormPersona.setText("LIMPIAR");
        btnCleanFormPersona.setToolTipText("");
        btnCleanFormPersona.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCleanFormPersona.setIconTextGap(10);
        btnCleanFormPersona.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnCleanFormPersona.setMaximumSize(new java.awt.Dimension(125, 35));
        btnCleanFormPersona.setMinimumSize(new java.awt.Dimension(125, 35));
        btnCleanFormPersona.setPreferredSize(new java.awt.Dimension(125, 35));

        btnSetFormPersona.setBackground(new java.awt.Color(153, 255, 153));
        btnSetFormPersona.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSetFormPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconAdd.png"))); // NOI18N
        btnSetFormPersona.setText("REGISTRAR");
        btnSetFormPersona.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSetFormPersona.setIconTextGap(10);
        btnSetFormPersona.setMargin(new java.awt.Insets(0, 0, 0, 0));

        lblCategoria9.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        lblCategoria9.setText("TIPO DE UNIDAD");

        jcbxTipoPersona1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERRESTRE", "AEREA", "MARITIMA" }));
        jcbxTipoPersona1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tblFormPersonas.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        tblFormPersonas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFormPersonas.setRowHeight(40);
        tblFormPersonas.setRowMargin(10);
        jScrollPane4.setViewportView(tblFormPersonas);

        javax.swing.GroupLayout pnlUser1Layout = new javax.swing.GroupLayout(pnlUser1);
        pnlUser1.setLayout(pnlUser1Layout);
        pnlUser1Layout.setHorizontalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUser1Layout.createSequentialGroup()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(lblEstatusPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControlFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCleanFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(btnSetFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(pnlUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                        .addComponent(lblTitlePersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                                .addComponent(lblCategoria7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbxTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCategoria9)
                                .addGap(12, 12, 12)
                                .addComponent(jcbxTipoPersona1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(pnlUser1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblInfoPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane4)))
        );
        pnlUser1Layout.setVerticalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblControlFormPersona)
                    .addComponent(lblEstatusPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitlePersona)
                .addGap(18, 18, 18)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbxTipoPersona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCategoria9))
                    .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbxTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCategoria7)))
                .addGap(18, 18, 18)
                .addComponent(lblInfoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCleanFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelFormPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFormPersonaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelFormPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelFormPersona;
    public javax.swing.JButton btnCleanFormPersona;
    public javax.swing.JButton btnSetFormPersona;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JComboBox<String> jcbxTipoPersona;
    public javax.swing.JComboBox<String> jcbxTipoPersona1;
    public javax.swing.JLabel lblCategoria7;
    public javax.swing.JLabel lblCategoria9;
    public javax.swing.JLabel lblControlFormPersona;
    public javax.swing.JLabel lblEstatusPersona;
    public javax.swing.JLabel lblInfoPersona;
    public javax.swing.JLabel lblTitlePersona;
    public javax.swing.JPanel pnlUser1;
    public javax.swing.JTable tblFormPersonas;
    // End of variables declaration//GEN-END:variables
}
