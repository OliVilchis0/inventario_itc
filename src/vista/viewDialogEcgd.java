package vista;

import java.awt.Color;
import javax.swing.BorderFactory;

public class viewDialogEcgd extends javax.swing.JDialog {
    
    public byte estado = -1;

    public viewDialogEcgd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));
        this.txtAp1.setCaretColor(new Color(0,123,255));
        this.txtAp2.setCaretColor(new Color(0,123,255));
        this.txtCargo.setCaretColor(new Color(0,123,255));
        this.txtNombre.setCaretColor(new Color(0,123,255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbAp1 = new javax.swing.JLabel();
        txtAp1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbAp2 = new javax.swing.JLabel();
        txtAp2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnGuardarA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 58, 64));
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        jPanel6.setBackground(new java.awt.Color(52, 58, 64));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(52, 58, 64));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        jPanel7.add(jLabel1);
        jPanel7.add(lbNombre);

        jPanel6.add(jPanel7);

        txtNombre.setBackground(new java.awt.Color(181, 184, 177));
        txtNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 123, 255)));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        jPanel6.add(txtNombre);

        jPanel1.add(jPanel6);

        jPanel5.setBackground(new java.awt.Color(52, 58, 64));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setBackground(new java.awt.Color(52, 58, 64));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido Paterno");
        jPanel8.add(jLabel2);
        jPanel8.add(lbAp1);

        jPanel5.add(jPanel8);

        txtAp1.setBackground(new java.awt.Color(181, 184, 177));
        txtAp1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtAp1.setForeground(new java.awt.Color(255, 255, 255));
        txtAp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 123, 255)));
        txtAp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAp1FocusGained(evt);
            }
        });
        jPanel5.add(txtAp1);

        jPanel1.add(jPanel5);

        jPanel4.setBackground(new java.awt.Color(52, 58, 64));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(52, 58, 64));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido Materno");
        jPanel9.add(jLabel3);
        jPanel9.add(lbAp2);

        jPanel4.add(jPanel9);

        txtAp2.setBackground(new java.awt.Color(181, 184, 177));
        txtAp2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtAp2.setForeground(new java.awt.Color(255, 255, 255));
        txtAp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 123, 255)));
        txtAp2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAp2FocusGained(evt);
            }
        });
        jPanel4.add(txtAp2);

        jPanel1.add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(52, 58, 64));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel10.setBackground(new java.awt.Color(52, 58, 64));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cargo");
        jPanel10.add(jLabel4);
        jPanel10.add(lbCargo);

        jPanel3.add(jPanel10);

        txtCargo.setBackground(new java.awt.Color(181, 184, 177));
        txtCargo.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtCargo.setForeground(new java.awt.Color(255, 255, 255));
        txtCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 123, 255)));
        txtCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCargoFocusGained(evt);
            }
        });
        jPanel3.add(txtCargo);

        jPanel1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(52, 58, 64));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        jButton1.setBackground(new java.awt.Color(220, 53, 69));
        jButton1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        btnGuardarC.setBackground(new java.awt.Color(0, 123, 255));
        btnGuardarC.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuardarC.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardarC.setText("Guardar y cerrar");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarC);

        btnGuardarA.setBackground(new java.awt.Color(0, 123, 255));
        btnGuardarA.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuardarA.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnGuardarA.setText("Guardar y agregar");
        btnGuardarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarA);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAActionPerformed
        if(this.txtNombre.getText().equals("")){
            this.lbNombre.setForeground(Color.red);
            this.lbNombre.setText("Obligatorio **");
        }
        else if(this.txtAp1.getText().equals("")){
            this.lbAp1.setForeground(Color.red);
            this.lbAp1.setText("Obligatorio **");
        }
        else if (this.txtAp2.getText().equals("")) {
            this.lbAp2.setForeground(Color.red);
            this.lbAp2.setText("Obligatorio **");
        }
        else if (this.txtCargo.getText().equals("")) {
            this.lbCargo.setForeground(Color.red);
            this.lbCargo.setText("Obligatorio **");
        }else{
            estado = 1;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        estado = -1;
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if(this.txtNombre.getText().equals("")){
            this.lbNombre.setForeground(Color.red);
            this.lbNombre.setText("Obligatorio **");
        }
        else if(this.txtAp1.getText().equals("")){
            this.lbAp1.setForeground(Color.red);
            this.lbAp1.setText("Obligatorio **");
        }
        else if (this.txtAp2.getText().equals("")) {
            this.lbAp2.setForeground(Color.red);
            this.lbAp2.setText("Obligatorio **");
        }
        else if (this.txtCargo.getText().equals("")) {
            this.lbCargo.setForeground(Color.red);
            this.lbCargo.setText("Obligatorio **");
        }else{
            estado = 0;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        this.lbNombre.setText("");
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtAp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAp1FocusGained
        this.lbAp1.setText("");
    }//GEN-LAST:event_txtAp1FocusGained

    private void txtAp2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAp2FocusGained
        this.lbAp2.setText("");
    }//GEN-LAST:event_txtAp2FocusGained

    private void txtCargoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCargoFocusGained
        this.lbCargo.setText("");
    }//GEN-LAST:event_txtCargoFocusGained

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewDialogEcgd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDialogEcgd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDialogEcgd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDialogEcgd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewDialogEcgd dialog = new viewDialogEcgd(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardarA;
    public javax.swing.JButton btnGuardarC;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbAp1;
    private javax.swing.JLabel lbAp2;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbNombre;
    public javax.swing.JTextField txtAp1;
    public javax.swing.JTextField txtAp2;
    public javax.swing.JTextField txtCargo;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
