package vista;

import reportes.Exportar;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class viewInventario extends javax.swing.JPanel {
    
    public DefaultTableModel modelo;
    
    public viewInventario() {
        initComponents();
        this.tablaPropiedades();
        this.tablaColum();
    }
    //Propiedades de la tabla
    public void tablaPropiedades(){
        //tabla
        this.modelo = new DefaultTableModel();
        //propiedades del header de la tabla
        JTableHeader THeader = this.JTDatos.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        //Tamaño del renglon
        this.JTDatos.setRowHeight(25);
        
        //Añadir propiedades al modelo
        this.JTDatos.setModel(this.modelo);
    }
    //Columnas de la tabla
    public void tablaColum(){
        //columnas de las tablas
        this.modelo.addColumn("ID");
        this.modelo.addColumn("Tipo");
        this.modelo.addColumn("Descripción");
        this.modelo.addColumn("Marca");
        this.modelo.addColumn("Modelo");
        this.modelo.addColumn("Condición");
        this.modelo.addColumn("Área");
        this.modelo.addColumn("Encargado");
        this.modelo.addColumn("Detalles");
        //Ancho de la columna
        TableColumnModel columna = this.JTDatos.getColumnModel();
        columna.getColumn(0).setPreferredWidth(150);
        columna.getColumn(1).setPreferredWidth(150);
        columna.getColumn(2).setPreferredWidth(200);
        columna.getColumn(3).setPreferredWidth(200);
        columna.getColumn(4).setPreferredWidth(200);
        columna.getColumn(5).setPreferredWidth(110);
        columna.getColumn(6).setPreferredWidth(150);
        columna.getColumn(7).setPreferredWidth(260);
        columna.getColumn(8).setPreferredWidth(280);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submenuTabla = new javax.swing.JPopupMenu();
        jmCodigoT = new javax.swing.JMenuItem();
        jmcodigo = new javax.swing.JMenuItem();
        JMEliminar = new javax.swing.JMenuItem();
        JMPropiedades = new javax.swing.JMenuItem();
        jpinsetar = new javax.swing.JPanel();
        lbcodigo = new javax.swing.JLabel();
        jpcodigo = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JTextField();
        btnauto = new javax.swing.JToggleButton();
        lbcondicion = new javax.swing.JLabel();
        JCondicion = new javax.swing.JComboBox();
        btnguardar = new javax.swing.JButton();
        lbcategoria = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jccategoria = new javax.swing.JComboBox<String>();
        btnMasCateg = new javax.swing.JButton();
        lbarea = new javax.swing.JLabel();
        jparea = new javax.swing.JPanel();
        jcarea = new javax.swing.JComboBox<String>();
        btnMasArea = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbdescripcion = new javax.swing.JLabel();
        lbdescripcion1 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        lbencargado = new javax.swing.JLabel();
        jpencergado = new javax.swing.JPanel();
        jcencargado = new javax.swing.JComboBox<String>();
        btnMasEcgd = new javax.swing.JButton();
        bntmiltiple = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LbMarca = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        LbDetalles = new javax.swing.JLabel();
        txtdetalles = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LbModelo = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpbuscar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JCrows = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txttextoE = new javax.swing.JTextField();
        jptabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTDatos = new javax.swing.JTable();
        jpinferior = new javax.swing.JPanel();
        JLfilas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnexcel = new javax.swing.JButton();
        btnpdf = new javax.swing.JButton();

        submenuTabla.setBackground(new java.awt.Color(52, 58, 64));
        submenuTabla.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        submenuTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmCodigoT.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jmCodigoT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barras_azul.png"))); // NOI18N
        jmCodigoT.setText("Imprimir Todos ");
        submenuTabla.add(jmCodigoT);

        jmcodigo.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jmcodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barras_azul.png"))); // NOI18N
        jmcodigo.setText("Imprimir codigo");
        submenuTabla.add(jmcodigo);

        JMEliminar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        JMEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar_azul.png"))); // NOI18N
        JMEliminar.setText("Eliminar");
        submenuTabla.add(JMEliminar);

        JMPropiedades.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        JMPropiedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/detalles.png"))); // NOI18N
        JMPropiedades.setText("Propiedades");
        submenuTabla.add(JMPropiedades);

        setBackground(java.awt.Color.white);

        jpinsetar.setBackground(java.awt.Color.white);
        jpinsetar.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Nuevo"));
        jpinsetar.setLayout(new java.awt.GridLayout(5, 2, 10, 3));

        lbcodigo.setBackground(java.awt.Color.white);
        lbcodigo.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lbcodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbcodigo.setText("Codigo");
        lbcodigo.setAlignmentX(0.5F);
        jpinsetar.add(lbcodigo);

        jpcodigo.setBackground(new java.awt.Color(255, 255, 255));
        jpcodigo.setLayout(new javax.swing.BoxLayout(jpcodigo, javax.swing.BoxLayout.LINE_AXIS));

        txtcodigo.setEnabled(false);
        jpcodigo.add(txtcodigo);

        btnauto.setBackground(new java.awt.Color(0, 123, 255));
        btnauto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/codigo-de-barras.png"))); // NOI18N
        btnauto.setSelected(true);
        jpcodigo.add(btnauto);

        jpinsetar.add(jpcodigo);

        lbcondicion.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lbcondicion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbcondicion.setText("Condición");
        lbcondicion.setAlignmentX(0.5F);
        jpinsetar.add(lbcondicion);

        JCondicion.setBackground(new java.awt.Color(255, 255, 255));
        JCondicion.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        JCondicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bueno", "Regular  ", "Malo", " " }));
        jpinsetar.add(JCondicion);

        btnguardar.setBackground(new java.awt.Color(52, 58, 64));
        btnguardar.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("                 Guardar");
        btnguardar.setAutoscrolls(true);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpinsetar.add(btnguardar);

        lbcategoria.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lbcategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbcategoria.setText("Categoria");
        lbcategoria.setAlignmentX(0.5F);
        jpinsetar.add(lbcategoria);

        jPanel1.setMaximumSize(new java.awt.Dimension(10, 10));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jccategoria.setBackground(new java.awt.Color(255, 255, 255));
        jccategoria.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jPanel1.add(jccategoria);

        btnMasCateg.setBackground(new java.awt.Color(0, 123, 255));
        btnMasCateg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnMasCateg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnMasCateg);

        jpinsetar.add(jPanel1);

        lbarea.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lbarea.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbarea.setText("Área");
        lbarea.setAlignmentX(0.5F);
        jpinsetar.add(lbarea);

        jparea.setBackground(new java.awt.Color(255, 255, 255));
        jparea.setPreferredSize(new java.awt.Dimension(10, 20));
        jparea.setLayout(new javax.swing.BoxLayout(jparea, javax.swing.BoxLayout.LINE_AXIS));

        jcarea.setBackground(new java.awt.Color(255, 255, 255));
        jcarea.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jcarea.setPreferredSize(new java.awt.Dimension(54, 25));
        jparea.add(jcarea);

        btnMasArea.setBackground(new java.awt.Color(0, 123, 255));
        btnMasArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jparea.add(btnMasArea);

        jpinsetar.add(jparea);

        btnlimpiar.setBackground(new java.awt.Color(52, 58, 64));
        btnlimpiar.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btnlimpiar.setText("                  Limpiar");
        btnlimpiar.setBorderPainted(false);
        jpinsetar.add(btnlimpiar);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lbdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lbdescripcion.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbdescripcion.setText("Descripción");
        jPanel2.add(lbdescripcion);

        lbdescripcion1.setBackground(new java.awt.Color(255, 255, 255));
        lbdescripcion1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbdescripcion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbdescripcion1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lbdescripcion1);

        jpinsetar.add(jPanel2);
        jpinsetar.add(txtdescripcion);

        lbencargado.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lbencargado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbencargado.setText("Encargado");
        lbencargado.setAlignmentX(0.5F);
        jpinsetar.add(lbencargado);

        jpencergado.setBackground(new java.awt.Color(255, 255, 255));
        jpencergado.setLayout(new javax.swing.BoxLayout(jpencergado, javax.swing.BoxLayout.LINE_AXIS));

        jcencargado.setBackground(new java.awt.Color(255, 255, 255));
        jcencargado.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jcencargado.setPreferredSize(new java.awt.Dimension(54, 25));
        jpencergado.add(jcencargado);

        btnMasEcgd.setBackground(new java.awt.Color(0, 123, 255));
        btnMasEcgd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnMasEcgd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpencergado.add(btnMasEcgd);

        jpinsetar.add(jpencergado);

        bntmiltiple.setBackground(new java.awt.Color(52, 58, 64));
        bntmiltiple.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        bntmiltiple.setForeground(new java.awt.Color(255, 255, 255));
        bntmiltiple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multiples.png"))); // NOI18N
        bntmiltiple.setText("                  Multiple");
        jpinsetar.add(bntmiltiple);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel9.setText("Marca");
        jPanel3.add(jLabel9);

        LbMarca.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        LbMarca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(LbMarca);

        jpinsetar.add(jPanel3);
        jpinsetar.add(txtmarca);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel11.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel11.setText("Detalles");
        jPanel5.add(jLabel11);

        LbDetalles.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        LbDetalles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(LbDetalles);

        jpinsetar.add(jPanel5);
        jpinsetar.add(txtdetalles);
        jpinsetar.add(jLabel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel10.setText("Modelo");
        jPanel4.add(jLabel10);

        LbModelo.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        LbModelo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(LbModelo);

        jpinsetar.add(jPanel4);
        jpinsetar.add(txtmodelo);

        jLabel4.setAlignmentX(0.5F);
        jpinsetar.add(jLabel4);
        jpinsetar.add(jLabel5);

        jpbuscar.setBackground(java.awt.Color.white);
        jpbuscar.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jLabel7.setText("Mostrar");
        jpbuscar.add(jLabel7);

        JCrows.setBackground(new java.awt.Color(255, 255, 255));
        JCrows.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jpbuscar.add(JCrows);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jLabel8.setText("Registros");
        jpbuscar.add(jLabel8);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jLabel2.setText("Buscar");
        jpbuscar.add(jLabel2);
        jpbuscar.add(txttextoE);

        jptabla.setBackground(java.awt.Color.white);
        jptabla.setLayout(new java.awt.BorderLayout());

        JTDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTDatos.setComponentPopupMenu(submenuTabla);
        jScrollPane2.setViewportView(JTDatos);

        jptabla.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jpinferior.setBackground(new java.awt.Color(255, 255, 255));
        jpinferior.setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        JLfilas.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        JLfilas.setText("Mostrando 1 a 10 registros de 78");
        jpinferior.add(JLfilas);
        jpinferior.add(jLabel1);

        btnexcel.setBackground(new java.awt.Color(52, 58, 64));
        btnexcel.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnexcel.setForeground(new java.awt.Color(255, 255, 255));
        btnexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        btnexcel.setText("Excel");
        btnexcel.setBorderPainted(false);
        btnexcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexcel.setFocusPainted(false);
        btnexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcelActionPerformed(evt);
            }
        });
        jpinferior.add(btnexcel);

        btnpdf.setBackground(new java.awt.Color(52, 58, 64));
        btnpdf.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        btnpdf.setForeground(new java.awt.Color(255, 255, 255));
        btnpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnpdf.setText("PDF");
        btnpdf.setBorderPainted(false);
        btnpdf.setFocusPainted(false);
        jpinferior.add(btnpdf);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jptabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpinferior, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpinsetar, javax.swing.GroupLayout.PREFERRED_SIZE, 766, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jpbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jptabla, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpinferior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpinsetar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcelActionPerformed
        // TODO add your handling code here: Excel
        
        if (this.JTDatos.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            List tb = new ArrayList();
            List nom = new ArrayList();
            tb.add(this.JTDatos);
            nom.add("Compras por factura");
            String file = chooser.getSelectedFile().toString().concat(".xls");
            //Aqui se ejecuta el metodo
        try {
            Exportar e = new Exportar(new File(file), tb, nom);
        if (e.export()) {
            JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
     }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        }else{
        JOptionPane.showMessageDialog(this, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnexcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox JCondicion;
    public javax.swing.JComboBox<String> JCrows;
    public javax.swing.JLabel JLfilas;
    public javax.swing.JMenuItem JMEliminar;
    public javax.swing.JMenuItem JMPropiedades;
    public javax.swing.JTable JTDatos;
    public javax.swing.JLabel LbDetalles;
    public javax.swing.JLabel LbMarca;
    public javax.swing.JLabel LbModelo;
    public javax.swing.JButton bntmiltiple;
    public javax.swing.JButton btnMasArea;
    public javax.swing.JButton btnMasCateg;
    public javax.swing.JButton btnMasEcgd;
    public javax.swing.JToggleButton btnauto;
    private javax.swing.JButton btnexcel;
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btnlimpiar;
    public javax.swing.JButton btnpdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JComboBox<String> jcarea;
    public javax.swing.JComboBox<String> jccategoria;
    public javax.swing.JComboBox<String> jcencargado;
    public javax.swing.JMenuItem jmCodigoT;
    public javax.swing.JMenuItem jmcodigo;
    private javax.swing.JPanel jparea;
    private javax.swing.JPanel jpbuscar;
    private javax.swing.JPanel jpcodigo;
    private javax.swing.JPanel jpencergado;
    private javax.swing.JPanel jpinferior;
    private javax.swing.JPanel jpinsetar;
    private javax.swing.JPanel jptabla;
    private javax.swing.JLabel lbarea;
    private javax.swing.JLabel lbcategoria;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JLabel lbcondicion;
    private javax.swing.JLabel lbdescripcion;
    public javax.swing.JLabel lbdescripcion1;
    private javax.swing.JLabel lbencargado;
    private javax.swing.JPopupMenu submenuTabla;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtdetalles;
    public javax.swing.JTextField txtmarca;
    public javax.swing.JTextField txtmodelo;
    public javax.swing.JTextField txttextoE;
    // End of variables declaration//GEN-END:variables
}
