package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class viewAreas extends javax.swing.JPanel {
    
    public DefaultTableModel modelo;
    
    public viewAreas() {
        initComponents();
        this.tablaPropiedades();
        this.tablaColum();
    }
    //Propiedaddes de la tabla
    public void tablaPropiedades(){
        modelo = new DefaultTableModel();
        //propiedades del header de la tabla
        JTableHeader THeader = this.jtarea.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.jtarea.setRowHeight(25);
        this.jtarea.setModel(modelo);
    }
    //Establecer columnas de la tabla
    public void tablaColum(){
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jpEliminar = new javax.swing.JMenuItem();
        jpinsertar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNuevaArea = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jpbuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcFilas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jptabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtarea = new javax.swing.JTable();
        jpimagen = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jpinferior = new javax.swing.JPanel();
        lbTotalRow = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();

        jpEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar_azul.png"))); // NOI18N
        jpEliminar.setText("Eliminar");
        jPopupMenu1.add(jpEliminar);

        setBackground(new java.awt.Color(255, 255, 255));

        jpinsertar.setBackground(new java.awt.Color(255, 255, 255));
        jpinsertar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nueva Área", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jpinsertar.setMinimumSize(new java.awt.Dimension(250, 400));
        jpinsertar.setLayout(new java.awt.GridLayout(6, 1, 0, 10));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setText("Nombre");
        jpinsertar.add(jLabel1);

        txtNuevaArea.setBackground(new java.awt.Color(255, 255, 255));
        txtNuevaArea.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpinsertar.add(txtNuevaArea);

        btnguardar.setBackground(new java.awt.Color(52, 58, 64));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar                                               ");
        btnguardar.setBorderPainted(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setDefaultCapable(false);
        btnguardar.setFocusable(false);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpinsertar.add(btnguardar);

        jpbuscar.setBackground(new java.awt.Color(255, 255, 255));
        jpbuscar.setPreferredSize(new java.awt.Dimension(0, 26));
        jpbuscar.setLayout(new java.awt.GridLayout(1, 6, 10, 5));

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("Mostrar");
        jpbuscar.add(jLabel2);

        jcFilas.setBackground(new java.awt.Color(255, 255, 255));
        jcFilas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jcFilas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "5", "10", "25", "50", "100" }));
        jcFilas.setBorder(null);
        jpbuscar.add(jcFilas);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText("Registros");
        jpbuscar.add(jLabel3);

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel5.setText("Buscar");
        jpbuscar.add(jLabel5);

        txtbuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtbuscar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpbuscar.add(txtbuscar);

        jptabla.setBackground(new java.awt.Color(255, 255, 255));
        jptabla.setLayout(new java.awt.GridLayout(1, 1));

        jtarea.setModel(new javax.swing.table.DefaultTableModel(
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
        jtarea.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jtarea);

        jptabla.add(jScrollPane2);

        jpimagen.setBackground(new java.awt.Color(255, 255, 255));
        jpimagen.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/areas_grande.png"))); // NOI18N
        jLabel6.setFocusTraversalPolicyProvider(true);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpimagen.add(jLabel6);

        jpinferior.setBackground(new java.awt.Color(255, 255, 255));
        jpinferior.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        lbTotalRow.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpinferior.add(lbTotalRow);

        jButton1.setBackground(new java.awt.Color(52, 58, 64));
        jButton1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        jButton1.setText("Excel");
        jButton1.setBorderPainted(false);
        jpinferior.add(jButton1);

        btnPdf.setBackground(new java.awt.Color(52, 58, 64));
        btnPdf.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPdf.setText("PDF");
        btnPdf.setBorderPainted(false);
        jpinferior.add(btnPdf);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jptabla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jpbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpinferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpinsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpinsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jptabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpinferior, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnPdf;
    public javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JComboBox jcFilas;
    public javax.swing.JMenuItem jpEliminar;
    private javax.swing.JPanel jpbuscar;
    private javax.swing.JPanel jpimagen;
    private javax.swing.JPanel jpinferior;
    private javax.swing.JPanel jpinsertar;
    private javax.swing.JPanel jptabla;
    public javax.swing.JTable jtarea;
    public javax.swing.JLabel lbTotalRow;
    public javax.swing.JTextField txtNuevaArea;
    public javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
