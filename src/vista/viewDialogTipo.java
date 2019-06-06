package vista;

import java.awt.Color;
import javax.swing.BorderFactory;

public class viewDialogTipo extends javax.swing.JDialog {
    
    public boolean estado = false;
    
    public viewDialogTipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        btnGuradar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 58, 64));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jPanel2.setBackground(new java.awt.Color(52, 58, 64));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3);

        lbNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jPanel2.add(lbNombre);

        jPanel1.add(jPanel2);

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        jPanel1.add(txtNombre);

        jPanel3.setBackground(new java.awt.Color(52, 58, 64));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripcion");
        jPanel3.add(jLabel1);

        lbDescripcion.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jPanel3.add(lbDescripcion);

        jPanel1.add(jPanel3);
        jPanel1.add(txtDescripcion);

        btnCerrar.setBackground(new java.awt.Color(220, 53, 69));
        btnCerrar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cancelar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar);

        btnGuradar.setBackground(new java.awt.Color(0, 123, 255));
        btnGuradar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuradar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuradar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuradar.setText("Guardar");
        btnGuradar.setBorderPainted(false);
        btnGuradar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuradarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuradar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        estado = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuradarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuradarActionPerformed
        String nombre = this.txtNombre.getText();
        String descripcion = this.txtDescripcion.getText();
        if (nombre.equals("")) {
            this.lbNombre.setForeground(Color.red);
            this.lbNombre.setText("Obligatorio **");
        }else{
            estado = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuradarActionPerformed

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
            java.util.logging.Logger.getLogger(viewDialogTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDialogTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDialogTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDialogTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewDialogTipo dialog = new viewDialogTipo(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnGuradar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lbDescripcion;
    public javax.swing.JLabel lbNombre;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
