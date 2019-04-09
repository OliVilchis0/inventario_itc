package vista;

public class viewInicio extends javax.swing.JFrame {

    public viewInicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPFondo = new javax.swing.JPanel();
        JPSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bntInicio = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnareas = new javax.swing.JButton();
        btnEcds = new javax.swing.JButton();
        btncat = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        JPTitulo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JPPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        JPFondo.setBackground(new java.awt.Color(255, 255, 255));

        JPSidebar.setBackground(new java.awt.Color(52, 58, 64));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/itc.png"))); // NOI18N
        JPSidebar.add(jLabel1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea.png"))); // NOI18N
        JPSidebar.add(jLabel2);

        bntInicio.setBackground(new java.awt.Color(52, 58, 64));
        bntInicio.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        bntInicio.setForeground(new java.awt.Color(255, 255, 255));
        bntInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        bntInicio.setText("Inicio                              ");
        bntInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 18, 18)));
        bntInicio.setBorderPainted(false);
        bntInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntInicio.setDefaultCapable(false);
        bntInicio.setFocusable(false);
        bntInicio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        bntInicio.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(bntInicio);

        btnInventario.setBackground(new java.awt.Color(52, 58, 64));
        btnInventario.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo-de-caja-negra.png"))); // NOI18N
        btnInventario.setText("Inventario                        ");
        btnInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnInventario.setBorderPainted(false);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setDefaultCapable(false);
        btnInventario.setFocusable(false);
        btnInventario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnInventario.setMaximumSize(new java.awt.Dimension(183, 26));
        btnInventario.setMinimumSize(new java.awt.Dimension(183, 26));
        btnInventario.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(btnInventario);

        btnareas.setBackground(new java.awt.Color(52, 58, 64));
        btnareas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnareas.setForeground(new java.awt.Color(255, 255, 255));
        btnareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/areas.png"))); // NOI18N
        btnareas.setText(" Areas                                 ");
        btnareas.setToolTipText("");
        btnareas.setBorderPainted(false);
        btnareas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnareas.setDefaultCapable(false);
        btnareas.setDoubleBuffered(true);
        btnareas.setFocusable(false);
        btnareas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnareas.setMaximumSize(new java.awt.Dimension(183, 26));
        btnareas.setMinimumSize(new java.awt.Dimension(183, 26));
        btnareas.setPreferredSize(new java.awt.Dimension(200, 40));
        btnareas.setRolloverEnabled(true);
        JPSidebar.add(btnareas);

        btnEcds.setBackground(new java.awt.Color(52, 58, 64));
        btnEcds.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnEcds.setForeground(new java.awt.Color(255, 255, 255));
        btnEcds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios-multiples-en-silueta.png"))); // NOI18N
        btnEcds.setText("Encargados                      ");
        btnEcds.setBorderPainted(false);
        btnEcds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEcds.setDefaultCapable(false);
        btnEcds.setDoubleBuffered(true);
        btnEcds.setFocusable(false);
        btnEcds.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEcds.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(btnEcds);

        btncat.setBackground(new java.awt.Color(52, 58, 64));
        btncat.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btncat.setForeground(new java.awt.Color(255, 255, 255));
        btncat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N
        btncat.setText("Categorias                         ");
        btncat.setBorderPainted(false);
        btncat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncat.setDefaultCapable(false);
        btncat.setFocusable(false);
        btncat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btncat.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(btncat);

        jPanel16.setBackground(new java.awt.Color(0, 123, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 40));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reportes");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPSidebar.add(jPanel16);

        jButton3.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        jButton3.setText("Excel                                 ");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(jButton3);

        jButton9.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        jButton9.setText("Pdf                                     ");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton9.setPreferredSize(new java.awt.Dimension(200, 40));
        JPSidebar.add(jButton9);

        JPTitulo.setBackground(new java.awt.Color(255, 255, 255));
        JPTitulo.setPreferredSize(new java.awt.Dimension(60, 60));
        JPTitulo.setLayout(new java.awt.GridLayout(1, 0));
        JPTitulo.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 2, 18)); // NOI18N
        jLabel5.setText("INVENTARIO FISICO GENERAL");
        JPTitulo.add(jLabel5);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CMIC.png"))); // NOI18N
        JPTitulo.add(jLabel7);

        JPPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        JPPrincipal.setPreferredSize(new java.awt.Dimension(500, 200));

        javax.swing.GroupLayout JPPrincipalLayout = new javax.swing.GroupLayout(JPPrincipal);
        JPPrincipal.setLayout(JPPrincipalLayout);
        JPPrincipalLayout.setHorizontalGroup(
            JPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );
        JPPrincipalLayout.setVerticalGroup(
            JPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JPFondoLayout = new javax.swing.GroupLayout(JPFondo);
        JPFondo.setLayout(JPFondoLayout);
        JPFondoLayout.setHorizontalGroup(
            JPFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPFondoLayout.createSequentialGroup()
                .addComponent(JPSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPFondoLayout.createSequentialGroup()
                        .addComponent(JPTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(JPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)))
        );
        JPFondoLayout.setVerticalGroup(
            JPFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPFondoLayout.createSequentialGroup()
                .addComponent(JPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
            .addComponent(JPSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(JPFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPFondo;
    public javax.swing.JPanel JPPrincipal;
    public javax.swing.JPanel JPSidebar;
    public javax.swing.JPanel JPTitulo;
    public javax.swing.JButton bntInicio;
    public javax.swing.JButton btnEcds;
    public javax.swing.JButton btnInventario;
    public javax.swing.JButton btnareas;
    public javax.swing.JButton btncat;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel16;
    // End of variables declaration//GEN-END:variables
}
