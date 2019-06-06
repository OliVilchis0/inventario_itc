package vista;

import java.awt.Color;
import javax.swing.BorderFactory;

public class viewDialogArea extends javax.swing.JDialog {

    public byte estado = -1;
    
    public viewDialogArea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnGuardarA = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 58, 64));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jPanel6.setBackground(new java.awt.Color(52, 58, 64));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);

        jPanel2.setBackground(new java.awt.Color(52, 58, 64));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 10, 10));

        jPanel4.setBackground(new java.awt.Color(52, 58, 64));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        jPanel4.add(jLabel1);

        lbNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jPanel4.add(lbNombre);

        jPanel2.add(jPanel4);

        txtNombre.setBackground(new java.awt.Color(52, 58, 64));
        txtNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 123, 255)));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        jPanel2.add(txtNombre);

        jPanel1.add(jPanel2);

        jPanel5.setBackground(new java.awt.Color(52, 58, 64));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(52, 58, 64));
        jPanel3.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        btnCancelar.setBackground(new java.awt.Color(220, 53, 69));
        btnCancelar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);

        btnGuardarC.setBackground(new java.awt.Color(0, 123, 255));
        btnGuardarC.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuardarC.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardarC.setText("Guardar y cerrar");
        btnGuardarC.setBorderPainted(false);
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardarC);

        btnGuardarA.setBackground(new java.awt.Color(0, 123, 255));
        btnGuardarA.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuardarA.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnGuardarA.setText("Guardar y agregar");
        btnGuardarA.setBorderPainted(false);
        btnGuardarA.setPreferredSize(new java.awt.Dimension(30, 32));
        btnGuardarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardarA);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = -1;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (this.txtNombre.getText().equals("")) {
            this.lbNombre.setForeground(Color.red);
            this.lbNombre.setText("Obligatorio **");
        } else {
            estado = 0;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnGuardarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAActionPerformed
        if (this.txtNombre.getText().equals("")) {
            this.lbNombre.setForeground(Color.red);
            this.lbNombre.setText("Obligatorio **");
        }else{
            estado = 1;
            this.setVisible(false);     
        }
    }//GEN-LAST:event_btnGuardarAActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        this.lbNombre.setText("");
    }//GEN-LAST:event_txtNombreFocusGained

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
            java.util.logging.Logger.getLogger(viewDialogArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDialogArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDialogArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDialogArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewDialogArea dialog = new viewDialogArea(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarA;
    public javax.swing.JButton btnGuardarC;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JLabel lbNombre;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
