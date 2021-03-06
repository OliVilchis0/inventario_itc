package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class viewTipo extends javax.swing.JPanel {
    
    public DefaultTableModel modelo;
    
    public viewTipo() {
        initComponents();
        this.tablaPropiedades();
        this.tablaColum();
    }
    //Propiedades de la tabla
    public void tablaPropiedades(){
        //tabla
        modelo = new DefaultTableModel();
        //propiedades del header de la tabla
        JTableHeader THeader = this.JTabla.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.JTabla.setRowHeight(25);
        this.JTabla.setModel(modelo);
    }
    //Establecer columnas de la tabla
    public void tablaColum(){
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("DESCRIPCION");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEliminar = new javax.swing.JMenuItem();
        jpinsertar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        bntGuardar = new javax.swing.JButton();
        jpbuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCFilas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jptabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        jpinferior = new javax.swing.JPanel();
        lbFilas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        JPicono = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jmEliminar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jmEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar_azul.png"))); // NOI18N
        jmEliminar.setText("Eliimnar");
        jPopupMenu1.add(jmEliminar);

        setBackground(new java.awt.Color(255, 255, 255));

        jpinsertar.setBackground(new java.awt.Color(255, 255, 255));
        jpinsertar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nueva Categoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jpinsertar.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel5.setText("Nombre");
        jpinsertar.add(jLabel5);

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpinsertar.add(txtNombre);

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setText("Descripcion");
        jpinsertar.add(jLabel6);

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpinsertar.add(txtDescripcion);

        bntGuardar.setBackground(new java.awt.Color(52, 58, 64));
        bntGuardar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        bntGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bntGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        bntGuardar.setText("Guardar                                               ");
        bntGuardar.setBorderPainted(false);
        bntGuardar.setFocusable(false);
        bntGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpinsertar.add(bntGuardar);

        jpbuscar.setBackground(new java.awt.Color(255, 255, 255));
        jpbuscar.setLayout(new java.awt.GridLayout(1, 6));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setText("Mostrar");
        jpbuscar.add(jLabel1);

        jCFilas.setBackground(new java.awt.Color(255, 255, 255));
        jCFilas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jCFilas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "5", "10", "25", "50", "100" }));
        jpbuscar.add(jCFilas);

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("Registros");
        jpbuscar.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText("Buscar");
        jpbuscar.add(jLabel3);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpbuscar.add(txtBuscar);

        jptabla.setBackground(new java.awt.Color(255, 255, 255));
        jptabla.setLayout(new java.awt.GridLayout(1, 1));

        JTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        JTabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(JTabla);

        jptabla.add(jScrollPane1);

        jpinferior.setBackground(new java.awt.Color(255, 255, 255));
        jpinferior.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        lbFilas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jpinferior.add(lbFilas);

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

        JPicono.setBackground(new java.awt.Color(255, 255, 255));
        JPicono.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria_Grande.png"))); // NOI18N
        JPicono.add(jLabel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jptabla, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jpinferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpinsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPicono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpinsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPicono, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jptabla, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpinferior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPicono;
    public javax.swing.JTable JTabla;
    public javax.swing.JButton bntGuardar;
    public javax.swing.JButton btnPdf;
    public javax.swing.JButton jButton1;
    public javax.swing.JComboBox jCFilas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JMenuItem jmEliminar;
    private javax.swing.JPanel jpbuscar;
    private javax.swing.JPanel jpinferior;
    private javax.swing.JPanel jpinsertar;
    private javax.swing.JPanel jptabla;
    public javax.swing.JLabel lbFilas;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
