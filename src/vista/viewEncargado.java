package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class viewEncargado extends javax.swing.JPanel {
    
    public DefaultTableModel modelo;
    
    public viewEncargado() {
        initComponents();
        this.tablaPropiedades();
        this.tablaColum();
    }
    //Propiedades de la tabla
    public void tablaPropiedades(){
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
        modelo.addColumn("Primer Apellido");
        modelo.addColumn("Segundo Apellido");
        modelo.addColumn("Cargo");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEliminar = new javax.swing.JMenuItem();
        JPInsertar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAp1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAp2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        JPBuscar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jCFilas = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        JPTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        JPInferior = new javax.swing.JPanel();
        lbFilas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        JPIcono = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jmEliminar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jmEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar_azul.png"))); // NOI18N
        jmEliminar.setText("Eliminar");
        jPopupMenu1.add(jmEliminar);

        setBackground(new java.awt.Color(255, 255, 255));

        JPInsertar.setBackground(new java.awt.Color(255, 255, 255));
        JPInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nuevo Encargado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        JPInsertar.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("Nombre");
        JPInsertar.add(jLabel2);

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        JPInsertar.add(txtNombre);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText("Primer Apellido");
        JPInsertar.add(jLabel3);

        txtAp1.setBackground(new java.awt.Color(255, 255, 255));
        JPInsertar.add(txtAp1);

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel4.setText("Segundo Apellido");
        JPInsertar.add(jLabel4);

        txtAp2.setBackground(new java.awt.Color(255, 255, 255));
        JPInsertar.add(txtAp2);

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel5.setText("Cargo");
        JPInsertar.add(jLabel5);

        txtCargo.setBackground(new java.awt.Color(255, 255, 255));
        JPInsertar.add(txtCargo);

        btnGuardar.setBackground(new java.awt.Color(52, 58, 64));
        btnGuardar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar                              ");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        JPInsertar.add(btnGuardar);

        JPBuscar.setBackground(new java.awt.Color(255, 255, 255));
        JPBuscar.setLayout(new java.awt.GridLayout(1, 5));

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setText("Mostrar");
        JPBuscar.add(jLabel6);

        jCFilas.setBackground(new java.awt.Color(255, 255, 255));
        jCFilas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jCFilas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "5", "10", "25", "50", "100" }));
        JPBuscar.add(jCFilas);

        jLabel7.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel7.setText("Registros");
        JPBuscar.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel8.setText("Buscar");
        JPBuscar.add(jLabel8);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        JPBuscar.add(txtBuscar);

        JPTabla.setBackground(new java.awt.Color(255, 255, 255));
        JPTabla.setLayout(new java.awt.GridLayout(1, 0));

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

        JPTabla.add(jScrollPane1);

        JPInferior.setBackground(new java.awt.Color(255, 255, 255));
        JPInferior.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        lbFilas.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        JPInferior.add(lbFilas);

        jButton1.setBackground(new java.awt.Color(52, 58, 64));
        jButton1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        jButton1.setText("Excel");
        jButton1.setBorderPainted(false);
        JPInferior.add(jButton1);

        btnPdf.setBackground(new java.awt.Color(52, 58, 64));
        btnPdf.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPdf.setText("PDF");
        btnPdf.setBorderPainted(false);
        JPInferior.add(btnPdf);

        JPIcono.setBackground(new java.awt.Color(255, 255, 255));
        JPIcono.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/encargado.png"))); // NOI18N
        JPIcono.add(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(JPInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(JPInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPBuscar;
    private javax.swing.JPanel JPIcono;
    private javax.swing.JPanel JPInferior;
    private javax.swing.JPanel JPInsertar;
    private javax.swing.JPanel JPTabla;
    public javax.swing.JTable JTabla;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox jCFilas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JMenuItem jmEliminar;
    public javax.swing.JLabel lbFilas;
    public javax.swing.JTextField txtAp1;
    public javax.swing.JTextField txtAp2;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCargo;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
