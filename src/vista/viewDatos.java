package vista;

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class viewDatos extends javax.swing.JDialog {
    
    public DefaultListModel modelo;
    
    public viewDatos(java.awt.Frame parent, boolean modal,String[] datos) {
        super(parent, modal);
        initComponents();
        /*lista = new JList(datos);
        JScrollPane barraDesplazamiento = new JScrollPane(lista); 
        barraDesplazamiento.setBounds(10,30,200,110); 
        this.jPanelLista.add(barraDesplazamiento);*/
        this.listar(datos);
    }
    //Listar los datos en la lista
    public void listar(String[] datos){
        modelo = new DefaultListModel();
        for (int i = 0; i < datos.length; i++) {
            modelo.addElement(datos[i]);
        }
        this.Jlista.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jlista = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelLista.setBackground(new java.awt.Color(52, 58, 64));
        jPanelLista.setLayout(new java.awt.GridLayout(1, 1));

        Jlista.setBackground(new java.awt.Color(52, 58, 64));
        Jlista.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        Jlista.setForeground(new java.awt.Color(255, 255, 255));
        Jlista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jlista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jlista);

        jPanelLista.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlistaMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_JlistaMouseClicked

    
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
            java.util.logging.Logger.getLogger(viewDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String[] datos = {};
                viewDatos dialog = new viewDatos(new javax.swing.JFrame(), true,datos);
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
    public javax.swing.JList Jlista;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
