package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import modelo.*;
import vista.viewAreaAD;
import vista.viewCateAD;
//import vista.viewCateAD;
import vista.viewEncarAD;
import vista.viewInventario;

public class ctrlInventario implements ActionListener,KeyListener {
    private InventarioCrud consul;
    private viewInventario ventana;
    private TipoCrud tipoC;
    private AreaCrud areaC;
    private EncargadoCrud encargadoC;
    DefaultTableModel modelo;

    public ctrlInventario(viewInventario ventana,InventarioCrud consul) {
        this.ventana = ventana;
        this.ventana.setSize(829,431);
        this.ventana.setLocation(1,1);
        //this.ventana.setLayout(new Layout());
        this.consul = consul;
        this.tabla(this.ventana.JTDatos);
        //Llamar metodo para asignar propiedades de jcombo
        this.jcombo();
        //Activar botones para lanzar eventos
        this.ventana.btnlimpiar.addActionListener(this);
        this.ventana.bntmiltiple.addActionListener(this);
        this.ventana.btnauto.addActionListener(this);
        this.ventana.btnguardar.addActionListener(this);
        this.ventana.btnMasArea.addActionListener(this);
        this.ventana.btnMasEcgd.addActionListener(this);
        this.ventana.btnMasCateg.addActionListener(this);
        this.ventana.txttextoE.addKeyListener(this);
    }
    //Lista todos los registros en una tabla
    public void tabla(JTable tabla){
        //propiedades del header de la tabla
        JTableHeader THeader = tabla.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        
        //tabla
        this.modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("Tipo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Condicion");
        modelo.addColumn("Area");
        modelo.addColumn("Encargado");
        modelo.addColumn("Detalles");
        Object[] columna = new Object[9];
        //Obtener al tamano de la lista 
        int numRegistros = consul.consulta_m().size();
        //Recorrer la lista
        for (int i = 0; i < numRegistros ; i++) {
            columna[0] = consul.consulta_m().get(i).getId().toUpperCase();
            columna[1] = consul.consulta_m().get(i).getId_tipo();
            columna[2] = consul.consulta_m().get(i).getDescripcion().toUpperCase();
            columna[3] = consul.consulta_m().get(i).getMarca().toUpperCase();
            columna[4] = consul.consulta_m().get(i).getModelo().toUpperCase();
            //Identificar el tipo de condicion
            if (consul.consulta_m().get(i).getE_fisico() != -1) {
                if (consul.consulta_m().get(i).getE_fisico() != 0) {
                    columna[5] = "Bueno".toUpperCase();
                }else{
                    columna[5] = "Regular".toUpperCase();
                }
            } else {
                columna[5] = "Malo".toUpperCase();
            }
            columna[6] = consul.consulta_m().get(i).getId_area();
            columna[7] = consul.consulta_m().get(i).getId_encargado();
            columna[8] = consul.consulta_m().get(i).getDetalles().toUpperCase();
            modelo.addRow(columna);
        }
    } 
    /* Método filtro*/
    private void filtro(String consulta, JTable jtableBuscar){
            modelo = (DefaultTableModel) jtableBuscar.getModel();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
            jtableBuscar.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    //Propiedades de jcombo
    public void jcombo(){
        //Propiedades de Jcombox categoria
        //Instanciar TipoCrus
        tipoC = new TipoCrud();
        //Obtener tamaño del array de tipocrud
        int registros = tipoC.consulta().size();
        //Recorrer los datos de tipo
        for (int i = 0; i < registros; i++) {
            //Establecer datos de tipo a jcombo
            this.ventana.jccategoria.addItem(tipoC.consulta().get(i).getNombre());   
        }
        //Propiedades de Jcombox area
        //Instanciar Area
        areaC = new AreaCrud();
        //Obtener Tamaño del areglo
        int registrosA = areaC.consulta().size();
        //Recorrer los datos de area
        for (int i = 0; i < registrosA; i++) {
            //Establecer datos de area a jcombox
            this.ventana.jcarea.addItem(areaC.consulta().get(i).getDescripcion());
        }
        //Propiedades de Jcombox Encargado
        //Instanciar encargado
        encargadoC = new EncargadoCrud();
        //Obtener Tamaño del areglo
        int registrosE = encargadoC.consulta().size();
        //Recorrer los datos de area
        for (int i = 0; i < registrosE; i++) {
            //Establecer datos de area a jcombox
            this.ventana.jcencargado.addItem(encargadoC.consulta().get(i).getNombre());
        }
    }
    //Metodo para lanzar un evento dependiendo el boton que se oprima
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == this.ventana.bntmiltiple) {
            System.out.println("funciona boton muliple");
        }
        if (e.getSource() == this.ventana.btnguardar) {
            Inventario invent = new Inventario();
            invent.setId("1");
            if (this.consul.buscar(invent)) {
                System.out.println("ID:\t"+invent.getId()+"Tipo:\t"+invent.getId_tipo()+"descripcion:\t"+invent.getDescripcion());
            }
        }
        //Mandar a traer el metodo Limpiar 
        if (e.getSource() == this.ventana.btnlimpiar) {
            this.Limpiar();
        }
        //Configurar multiples registro de caracteristicas semejantes
        if (e.getSource() == this.ventana.btnauto) {
            if (this.ventana.btnauto.isSelected()) {
                this.ventana.txtcodigo.setEnabled(false);
            }else{
                this.ventana.txtcodigo.setEnabled(true);
            }
        }
        //Lanzar ventana para agregar nueva area
        if (e.getSource() == this.ventana.btnMasArea) {
            //instanciar vista
            viewAreaAD viewA = new viewAreaAD();
            //Instanciar modelo
            AreaCrud areaC = new AreaCrud();
            //Instanciar el controlador
            ctrlAreaAD crtlA = new ctrlAreaAD(viewA,areaC);
            
        }
        //Lanzar ventana para agregar encargado
        if (e.getSource() == this.ventana.btnMasEcgd) {
            //instanciar vista
            viewEncarAD viewA = new viewEncarAD();
            //Instanciar modelo
            EncargadoCrud areaC = new EncargadoCrud();
            //Instanciar el controlador
            ctrlecgd crtlA = new ctrlecgd(viewA,areaC);
        }
        //Lanzar ventana de Categoria
        if (e.getSource() == this.ventana.btnMasCateg) {
           //instanciar vista
            viewCateAD viewT = new viewCateAD();
            //Instanciar modelo
            TipoCrud TipoC = new TipoCrud();
            //Instanciar el controlador
            ctrlTipoAD crtlA = new ctrlTipoAD(viewT,TipoC); 
        }
        //Guardar un registro 
        if (e.getSource() == ventana.btnguardar) {
            if (
                    this.ventana.txtdescripcion.getText().equals("") ||
                    this.ventana.txtmarca.getText().equals("") ||
                    this.ventana.txtmodelo.getText().equals("") ||
                    this.ventana.txtdetalles.getText().equals("")
                ) {
                this.ventana.txtdescripcion.setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "; )\nDebes ingresar todos los datos!!","Mensaje",JOptionPane.WARNING_MESSAGE);
            }else{
               Inventario mt = new Inventario();
               mt.setId(ventana.txtcodigo.getText());
               mt.setId_tipo(3);
               mt.setDescripcion(ventana.txtdescripcion.getText());
               mt.setMarca(ventana.txtmarca.getText());
               mt.setModelo(ventana.txtmodelo.getText());
               //obtener la  condicion e identificarlo con numero
               byte condicion = 1;
                if (this.ventana.JCondicion.getSelectedIndex() != 0) {
                    if (this.ventana.JCondicion.getSelectedIndex() != 1) {
                        condicion = -1;
                    }else{
                        condicion = 0;
                    }
                }
               mt.setE_fisico(condicion);
               mt.setId_area(1);
               mt.setId_encargado(1);
               mt.setDetalles(ventana.txtdetalles.getText());
               if (consul.registrar(mt)) {
                   this.Limpiar();
                   this.tabla(this.ventana.JTDatos);
                   JOptionPane.showMessageDialog(null, "Registro Guardado");
               }else{
                   //this.Limpiar();
                   this.tabla(this.ventana.JTDatos);
                   JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro");
               }
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        filtro(this.ventana.txttextoE.getText().toUpperCase(), this.ventana.JTDatos);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    //Metodo que activa un evento despues de presionar un boton determinado
   // public void actionPerformed(ActionEvent e){
        //listar todos los datos en una tabla
        /*if (e.getSource() == ventana.btnlist) {
            tabla(ventana.jtdatos);
        }
        //Modificar un registro de la db
       /* if (e.getSource() == ventana.btnedit) {
            /*if (ventana.txttipo.getText() == null || "".equals(ventana.txtarticulo.getText()) 
                    || "".equals(ventana.txtmodelo.getText()) || ventana.txtcantidad.getText() == null ||
                    ventana.txtcondicion.getText() == null) {
                JOptionPane.showMessageDialog(null, "Debes ingresar todos los datos!!");
            }else{*/
             /* mt = new Inventario();
               mt.setId_tipo(Integer.parseInt(ventana.txttipo.getText()));
               mt.setArticulo(ventana.txtarticulo.getText());
               mt.setModelo(ventana.txtmodelo.getText());
               mt.setCantidad(Byte.parseByte(ventana.txtcantidad.getText()));
               mt.setCondicion(Byte.parseByte(ventana.txtcondicion.getText()));

               if (consul.registrar(mt)) {
                   this.Limpiar();
                   this.tabla(ventana.jtdatos);
                   JOptionPane.showMessageDialog(null, "Registro Guardado");
               }else{
                   this.Limpiar();
                   this.tabla(ventana.jtdatos);
                   JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro");
               }   */
            //}
        //}
        
    //x }
    //Limpiar los datos de la caje de texto
    public void Limpiar(){
        this.ventana.txtcodigo.setText(null);
        this.ventana.txtdescripcion.setText(null);
        this.ventana.txtdetalles.setText(null);
        this.ventana.txtmarca.setText(null);
        this.ventana.txtmodelo.setText(null);
    }
}
