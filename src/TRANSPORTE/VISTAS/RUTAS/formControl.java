/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TRANSPORTE.VISTAS.RUTAS;

/**
 *
 * @author arnal
 */
public class formControl extends javax.swing.JFrame {

    /**
     * Creates new form formPersonas
     */
    public formControl() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFormPersona = new javax.swing.JPanel();
        pnlUser1 = new javax.swing.JPanel();
        lblTitlePersona = new javax.swing.JLabel();
        lblEstatusPersona = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        lblCedula3 = new javax.swing.JLabel();
        txtDocumentoPersona = new javax.swing.JTextField();
        lblInfoPersona = new javax.swing.JLabel();
        lblControlFormPersona = new javax.swing.JLabel();
        btnCancelFormPersona = new javax.swing.JButton();
        btnCleanFormPersona = new javax.swing.JButton();
        btnSetFormPersona = new javax.swing.JButton();
        lblCedula4 = new javax.swing.JLabel();
        txtDocumentoPersona1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFormPersona.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormPersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUser1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitlePersona.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        lblTitlePersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitlePersona.setText("PUNTO DE CONTROL");

        lblEstatusPersona.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblEstatusPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstatusPersona.setText("0");
        lblEstatusPersona.setEnabled(false);

        lblNombre1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblNombre1.setText("DECRIPCION");

        txtNombrePersona.setBackground(new java.awt.Color(250, 250, 250));
        txtNombrePersona.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtNombrePersona.setCaretColor(new java.awt.Color(0, 0, 0));
        txtNombrePersona.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombrePersona.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombrePersona.setOpaque(true);

        lblCedula3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCedula3.setText("LATITUD");

        txtDocumentoPersona.setBackground(new java.awt.Color(250, 250, 250));
        txtDocumentoPersona.setForeground(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtDocumentoPersona.setCaretColor(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDocumentoPersona.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona.setOpaque(true);

        lblInfoPersona.setForeground(new java.awt.Color(255, 0, 51));
        lblInfoPersona.setText("* ");
        lblInfoPersona.setEnabled(false);

        lblControlFormPersona.setText("1");
        lblControlFormPersona.setEnabled(false);

        btnCancelFormPersona.setBackground(new java.awt.Color(102, 0, 0));
        btnCancelFormPersona.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCancelFormPersona.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelFormPersona.setText("CANCELAR");
        btnCancelFormPersona.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelFormPersona.setIconTextGap(10);
        btnCancelFormPersona.setMargin(new java.awt.Insets(2, 1, 3, 14));

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

        lblCedula4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCedula4.setText("LONGITUD");

        txtDocumentoPersona1.setBackground(new java.awt.Color(250, 250, 250));
        txtDocumentoPersona1.setForeground(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        txtDocumentoPersona1.setCaretColor(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDocumentoPersona1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDocumentoPersona1.setOpaque(true);

        javax.swing.GroupLayout pnlUser1Layout = new javax.swing.GroupLayout(pnlUser1);
        pnlUser1.setLayout(pnlUser1Layout);
        pnlUser1Layout.setHorizontalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCleanFormPersona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(btnCancelFormPersona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSetFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                        .addComponent(lblEstatusPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControlFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitlePersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumentoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblInfoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addComponent(lblCedula4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDocumentoPersona1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlUser1Layout.setVerticalGroup(
            pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUser1Layout.createSequentialGroup()
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblControlFormPersona)
                    .addComponent(lblEstatusPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lblTitlePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula3)
                    .addComponent(txtDocumentoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula4)
                    .addComponent(txtDocumentoPersona1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUser1Layout.createSequentialGroup()
                        .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInfoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCleanFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pnlFormPersona.add(pnlUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFormPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelFormPersona;
    public javax.swing.JButton btnCleanFormPersona;
    public javax.swing.JButton btnSetFormPersona;
    public javax.swing.JLabel lblCedula3;
    public javax.swing.JLabel lblCedula4;
    public javax.swing.JLabel lblControlFormPersona;
    public javax.swing.JLabel lblEstatusPersona;
    public javax.swing.JLabel lblInfoPersona;
    public javax.swing.JLabel lblNombre1;
    public javax.swing.JLabel lblTitlePersona;
    private javax.swing.JPanel pnlFormPersona;
    public javax.swing.JPanel pnlUser1;
    public javax.swing.JTextField txtDocumentoPersona;
    public javax.swing.JTextField txtDocumentoPersona1;
    public javax.swing.JTextField txtNombrePersona;
    // End of variables declaration//GEN-END:variables
}