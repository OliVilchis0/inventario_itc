package controlador;

//rojo #dc3545
//verde #28a745
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.ImageIcon;
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
import vista.viewDatos;
import vista.viewEncarAD;
import vista.viewInventario;

public class ctrlInventario implements ActionListener,KeyListener,FocusListener,MouseListener {
    private InventarioCrud consul;
    private viewInventario ventana;
    private TipoCrud tipoC;
    private AreaCrud areaC;
    private EncargadoCrud encargadoC;
    private DefaultTableModel modelo;

    public ctrlInventario(viewInventario ventana,InventarioCrud consul) {
        this.ventana = ventana;
        this.ventana.setSize(829,431);
        this.ventana.setLocation(1,1);
        //this.ventana.setLayout(new Layout());
        this.consul = consul;
        //Lanzar tabla de datos
        this.tabla(this.ventana.JTDatos);
        //Llamar metodo para asignar propiedades de jcombo
        this.jcombo();
        //Activar botones para lanzar eventos ActionListener
        this.ventana.btnlimpiar.addActionListener(this);
        this.ventana.bntmiltiple.addActionListener(this);
        this.ventana.btnauto.addActionListener(this);
        this.ventana.btnguardar.addActionListener(this);
        this.ventana.btnMasArea.addActionListener(this);
        this.ventana.btnMasEcgd.addActionListener(this);
        this.ventana.btnMasCateg.addActionListener(this);
        this.ventana.jccategoria.addActionListener(this);
        this.ventana.JCrows.addActionListener(this);
        this.ventana.JMEliminar.addActionListener(this);
        this.ventana.JMPropiedades.addActionListener(this);
        this.ventana.JModificar.addActionListener(this);
        //Activar botones para lanzar eventos KeyListener
        this.ventana.txttextoE.addKeyListener(this);
        this.ventana.JCondicion.addKeyListener(this);
        this.ventana.jccategoria.addKeyListener(this);
        this.ventana.jcarea.addKeyListener(this);
        this.ventana.jcencargado.addKeyListener(this);
        this.ventana.txtdescripcion.addKeyListener(this);
        this.ventana.txtdetalles.addKeyListener(this);
        this.ventana.txtmarca.addKeyListener(this);
        this.ventana.txtmodelo.addKeyListener(this);
        //Activar componente para lanzar evento FocusLietener
        this.ventana.txtdescripcion.addFocusListener(this);
        this.ventana.txtdetalles.addFocusListener(this);
        this.ventana.txtmarca.addFocusListener(this);
        this.ventana.txtmodelo.addFocusListener(this);
        this.ventana.JTDatos.addKeyListener(this);
        //Activar evento para MouseListener
        this.ventana.JTDatos.addMouseListener(this);
        //establecer el codigo por defecto en campo de texto dependiendo si es editable o no
        this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
    }
    //Lista todos los registros en una tabla
    public void tabla(JTable tabla)
    {
        //propiedades del header de la tabla
        JTableHeader THeader = tabla.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.ventana.JTDatos.setRowHeight(25);
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
        //Asociar el array del modelo 
        ArrayList<inventarioVista> inventario = consul.consultaVista();
        //Recorrer la lista
        for (inventarioVista iv : inventario) {
            //Obtener al tamano de la lista 
            Object columna[] = new Object[9];
            columna[0] = iv.getCodigo();
            columna[1] = iv.getCategory().toUpperCase();
            columna[2] = iv.getDescripcion().toUpperCase();
            columna[3] = iv.getMarca().toUpperCase();
            columna[4] = iv.getModelo().toUpperCase();
                //Identificar el tipo de condicion
            if (iv.getEstadoFisico() != -1) {
                if (iv.getEstadoFisico() != 0) {
                    columna[5] = "Bueno".toUpperCase();
                }else{
                    columna[5] = "Regular".toUpperCase();
                }
            } else {
                columna[5] = "Malo".toUpperCase();
            }
            columna[6] = iv.getArea().toUpperCase();
            columna[7] = iv.getEncargado().toUpperCase();
            columna[8] = iv.getDetalle().toUpperCase();
            modelo.addRow(columna);
        }
        this.ventana.JLfilas.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
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
            this.ventana.jcencargado.addItem(encargadoC.consulta().get(i).getNombre()+" "+encargadoC.consulta().get(i).getAp1()
            +" "+encargadoC.consulta().get(i).getAp2());
        }
        //establecer valores de JCobobox para filtras datos de la tabla
        this.ventana.JCrows.addItem("Todo");
        this.ventana.JCrows.addItem("10");
        this.ventana.JCrows.addItem("25");
        this.ventana.JCrows.addItem("50");
        this.ventana.JCrows.addItem("100");
    }
    //Metodo para lanzar un evento dependiendo el boton que se oprima
    @Override
    public void actionPerformed(ActionEvent e) {
        //Insertar mas de un registro a la ves
        if (e.getSource() == this.ventana.bntmiltiple) {
            //variables para conocer si el usuario tecleo una letra y si se guardaro exitosamente
            boolean error = false;
            boolean guardado = false;
            String codigos[] = null;
            //Lanzar la ventana repetidas veces si el usuario ingresa una letra en la caja de texto
            while(!error) {  
                String datos = JOptionPane.showInputDialog("Total de registros");
                if (datos == null) {
                    break;
                }
                //manejar si ahi error
                try {
                    int dato = Integer.parseInt(datos);
                
                    //areglo para almacenar los codigos generados
                    codigos = new String[dato];
                    //obtener los datos 
                    //obtener el año
                    Calendar cal = Calendar.getInstance();
                    int año = cal.get(Calendar.YEAR);
                    /*obtener el numero total de objetos dependiendo de la categoria obtenida
                    paso 1. obtener el id de la categoria a traves del metodo getCategory
                    paso 2. obtener el numero total con el metodo getObjetos de la clase modelo*/
                    String categoria = this.ventana.jccategoria.getSelectedItem().toString();
                    int idCategory = this.getCetegory(categoria);
                    int num = this.consul.getObjetos(idCategory);                        
                    byte condicion = 1;
                    if (this.ventana.JCondicion.getSelectedIndex() != 0) {
                        if (this.ventana.JCondicion.getSelectedIndex() != 1) {
                            condicion = -1;
                        }else{
                            condicion = 0;
                        }
                    }
                    int category = this.getCetegory(this.ventana.jccategoria.getSelectedItem().toString());
                    int area = this.getIdArea(this.ventana.jcarea.getSelectedItem().toString());
                    String descripcion = this.ventana.txtdescripcion.getText();
                    int encargado = this.getIdEncar(this.ventana.jcencargado.getSelectedItem().toString());
                    String marca = this.ventana.txtmarca.getText();
                    String modelo = this.ventana.txtmodelo.getText();
                    String deralles = this.ventana.txtdetalles.getText();
                    for (int i = 0; i < dato; i++) {
                        Inventario mt = new Inventario();
                        num ++;
                        //Establecer la cadena de codigo
                        String cadena = "ITC"+año+categoria.toUpperCase().charAt(0)+num;
                        mt.setId(cadena);
                        mt.setE_fisico(condicion);
                        mt.setId_tipo(category);
                        mt.setId_area(area);
                        mt.setDescripcion(descripcion);
                        mt.setId_encargado(encargado);
                        mt.setMarca(marca);
                        mt.setModelo(modelo);
                        mt.setDetalles(ventana.txtdetalles.getText());
                        if (consul.registrar(mt)) {
                            guardado = true;
                            codigos[i] = cadena;
                        }
                    }
                    error = true;
                } catch (Exception ea) {
                    error = false;
                }
            };
            //Limpiar y actualizar la tabla una ves los registros multiples se inserten correctamente
            if (guardado) {
                this.Limpiar();
                this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Los registros se guardaron exitosamente con los codigos\n"+Arrays.toString(codigos));
                this.tabla(this.ventana.JTDatos);
            }else{
                JOptionPane.showMessageDialog(null, "Debio ocurrir un error");
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
                //Pintar el cuadro de texto amarillo indicando que dicho cuadro esta basio
                if (this.ventana.txtdescripcion.getText().equals("")) {
                    this.ventana.txtdescripcion.setBackground(Color.yellow);
                }
                if (this.ventana.txtmarca.getText().equals("")) {
                    this.ventana.txtmarca.setBackground(Color.yellow);
                }
                if (this.ventana.txtmodelo.getText().equals("")) {
                    this.ventana.txtmodelo.setBackground(Color.yellow);
                }
                if (this.ventana.txtdetalles.getText().equals("")) {
                    this.ventana.txtdetalles.setBackground(Color.yellow);
                }
                JOptionPane.showMessageDialog(null, "; )\nDebes ingresar todos los datos!!","Mensaje",JOptionPane.WARNING_MESSAGE);
            }else{
               Inventario mt = new Inventario();
               mt.setId(ventana.txtcodigo.getText());
               //obtener el id de la catedoria a partir delcombobox
               mt.setId_tipo(this.getCetegory(this.ventana.jccategoria.getSelectedItem().toString()));
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
               //obtener el id del area a traves del jcombobx
               mt.setId_area(this.getIdArea(this.ventana.jcarea.getSelectedItem().toString()));
               //obtener el id del encargado a traves de su nombre mediante JCombobox
               mt.setId_encargado(this.getIdEncar(this.ventana.jcencargado.getSelectedItem().toString()));
               mt.setDetalles(ventana.txtdetalles.getText());
               //Si el registro se guardo correctamente limpiar y actualizar la tabla
               if (consul.registrar(mt)) {
                   this.Limpiar();
                   this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
                   JOptionPane.showMessageDialog(null, "Registro Guardado");
                   this.tabla(this.ventana.JTDatos);
               }else{
                   //Lanzar mensaje de error
                   JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro");
               }
            }
        }
        //borrar campo de texto del codigo si el usuario lo deshabilita
        if (e.getSource() == this.ventana.btnauto) {
            if (!this.ventana.btnauto.isSelected()) {
                this.ventana.txtcodigo.setText(null);
            }else{
                this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
            }
        }
        //Al seleccionar el JCOMBOBOX
        if (e.getSource() == this.ventana.jccategoria) {
            String category = this.ventana.jccategoria.getSelectedItem().toString();
            this.codigo(category);
        }
        //Establecer la cantidad de filas de la tabla de acuerdo al item seleccionado del combobox
        if (e.getSource() ==  this.ventana.JCrows) {
            //Actualizar la tabla
            this.tabla(this.ventana.JTDatos);
            try {
                //Obtener la cantidad de filas que se desea ver
                int numRows = Integer.parseInt(this.ventana.JCrows.getSelectedItem().toString());
                //Obtener el total de filas de la tabla
                int numTotal = this.modelo.getRowCount();
                //Restar las filas total con las que se desea ver
                int totalRows = numTotal - numRows;
                for (int i = 0; i <= totalRows; i++) {
                    this.modelo.removeRow(this.modelo.getRowCount() -1);
                }
                this.ventana.JLfilas.setText("Mostrando "+numRows+" registros filtrado de un total de "+this.consul.numFilas());
            } catch (Exception ea) {
                
            }
        }
        //Al presionar el boton eliminar del popupmenu ubicado en la tabla
        if (e.getSource() == this.ventana.JMEliminar) {
            //Obtener el numero de filas seleccionadas
            int[] fila = this.ventana.JTDatos.getSelectedRows();
            //establecer un array de cadenas para los codigos
            String[] codigo; 
            //Instanciar el modelo inventario
            Inventario inv = new Inventario();
            //Validad si se selecciono una o mas filas
            if (fila.length >= 0) {
                //Si se desea borrar un registro si no, se borrara mas de uno
                if (fila.length == 1) {
                    //crear el array con dimencion = 1;
                    codigo = new String[1];
                    //Obtener el codigo de la fila seleccionada
                    codigo[0] = (String) this.ventana.JTDatos.getValueAt(fila[0], 0);
                    //establecer el codigo de la fila en el modelo inventario
                    inv.setId(codigo[0]);
                    //Eliminar el registro
                    if (consul.Eliminar(inv)) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.ventana.JLfilas.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Actualizar el codigo
                        this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
                        //Refrescar la tabla
                        this.tabla(this.ventana.JTDatos);
                        JOptionPane.showMessageDialog(null, "Registro borrado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Imposible borrar este registro");
                    }
                }
                //Si se desea eliminar mas de un registro
                else 
                {
                    //variable para saber si todos los registros se insertan correctamente
                    boolean guardado = false;
                    //crear el array de codigo con la dimencion de las filas seleccionadas
                    codigo = new String[fila.length];
                    //Recorrer el array con FOR para establecer los codigos en modelo inventario
                    for (int i = 0; i < codigo.length; i++) {
                        codigo[i] = (String) this.ventana.JTDatos.getValueAt(fila[i], 0);
                        inv.setId(codigo[i]);
                        if (consul.Eliminar(inv)) {
                            guardado = true;
                        }else{
                            guardado = false;
                        }
                    }
                    //Lanzar mensaje si todos los registros de guardaron
                    if (guardado) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.ventana.JLfilas.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Actualizar el codigo
                        this.codigo(this.ventana.jccategoria.getSelectedItem().toString());
                        //Refrescar la tabla
                        this.tabla(this.ventana.JTDatos);
                        JOptionPane.showMessageDialog(null, "Registros borrados");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debes Seleccionar una fila","Aviso",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Metodos Sobeescritos de KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
       //validar el campo descripcion para que no se escriban numero
        if (e.getSource() == this.ventana.txtdescripcion) {
            char tecla = e.getKeyChar();
            if ((tecla >= '0') && (tecla <= '9')) {
                e.consume();
                this.ventana.lbdescripcion1.setForeground(Color.red);
                this.ventana.lbdescripcion1.setText("No Numeros **");
            }else{
                this.ventana.lbdescripcion1.setText("");
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //Filtrar una serie de resultados de la tabla al obtener la tecla insertada por el usuasio
        filtro(this.ventana.txttextoE.getText().toUpperCase(), this.ventana.JTDatos);
        //Asignar el foco a el sigiente cuadro de texto
        if (e.getComponent() == this.ventana.JCondicion) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.jccategoria.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.jccategoria) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.jcarea.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.jcarea) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.txtdescripcion.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.txtdescripcion) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.jcencargado.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.jcencargado) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.txtmarca.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.txtmarca) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.txtdetalles.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.txtdetalles) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.txtmodelo.requestFocus();
            }
        }
        if (e.getComponent() == this.ventana.txtmodelo) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.ventana.btnguardar.requestFocus();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //Saber si el usuario presiono la tecla enter en una selda de la tabla
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.ventana.JTDatos.getSelectedRow();
            this.actualizar(fila);
        }
    }
    //Metodos sobreescritos de FocusLietener
    @Override
    public void focusGained(FocusEvent fe) {
        //pintar de color blanco le cuadro de texto una ves escrito algo en este
        if (fe.getComponent() == this.ventana.txtdescripcion) {
            this.ventana.txtdescripcion.setBackground(Color.white);
        }
        if (fe.getComponent() == this.ventana.txtdetalles) {
            this.ventana.txtdetalles.setBackground(Color.white);
            this.ventana.LbDetalles.setText("");
        }
        if (fe.getComponent() == this.ventana.txtmarca) {
            this.ventana.txtmarca.setBackground(Color.white);
            this.ventana.LbMarca.setText("");
        }
        if (fe.getComponent() == this.ventana.txtmodelo) {
            this.ventana.txtmodelo.setBackground(Color.white);
            this.ventana.LbModelo.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent fe) {
        //pintar de color amarillo si el cuadro de texto no camputo caracteres
        if (fe.getComponent() == this.ventana.txtdescripcion) {
            if (this.ventana.txtdescripcion.getText().equals("")) {
                this.ventana.txtdescripcion.setBackground(Color.yellow);
                this.ventana.lbdescripcion1.setForeground(Color.red);
                this.ventana.lbdescripcion1.setText("Obligatorio **");
            }
        }
        if (fe.getComponent() == this.ventana.txtdetalles) {
            if (this.ventana.txtdetalles.getText().equals("")) {
                this.ventana.txtdetalles.setBackground(Color.yellow);
                this.ventana.LbDetalles.setForeground(Color.red);
                this.ventana.LbDetalles.setText("Obligatorio **");
            }
        }
        if (fe.getComponent() == this.ventana.txtmarca) {
            if (this.ventana.txtmarca.getText().equals("")) {
                this.ventana.txtmarca.setBackground(Color.yellow);
                this.ventana.LbMarca.setForeground(Color.red);
                this.ventana.LbMarca.setText("Obligatorio **");
            }
        }
        if (fe.getComponent() == this.ventana.txtmodelo) {
            if (this.ventana.txtmodelo.getText().equals("")) {
                this.ventana.txtmodelo.setBackground(Color.yellow);
                this.ventana.LbModelo.setForeground(Color.red);
                this.ventana.LbModelo.setText("Obligatorio **");
            }
        }
        if (fe.getComponent() == this.ventana.JTDatos) {
            
        }
    }
    @Override
    public void mouseClicked(MouseEvent me) {  
        //obtener las coordenadas del raton para que se visualize el JDialog
        Point punto = MouseInfo.getPointerInfo().getLocation();
        int x;
        int y;
        //Variables para los nombres que van a obtenerse
        String nombre;
        int id;
        //Reservar Array para pasarlo como parametro al jDialog
        String[] datos;
        //Preparar el JDialog
        viewDatos ventana;
        //Obtener la posicion de la fila
        int fila = this.ventana.JTDatos.getSelectedRow();
        //Obtener la posicion de la columna
        int columna = this.ventana.JTDatos.getSelectedColumn();
        //Obtener el Nombre de la columna
        String nomColumna = this.ventana.JTDatos.getColumnName(columna).toUpperCase();
        //this.ventana.JTDatos.setValueAt("funciona", fila, columna);
        switch(nomColumna){
            case "TIPO":
                //Establecer las coordenadoas
                x = punto.x;
                y = punto.y;
                //Obtener el nombre de las categorias para ello instanciar el modelo tipocrud
                tipoC = new TipoCrud();
                //establecer el tamaño de arreglo
                datos = new String[tipoC.consulta().size()];
                for (int i = 0; i < tipoC.consulta().size(); i++) {
                    datos[i] = tipoC.consulta().get(i).getNombre();
                }
                //Lanzar el JDialog
                ventana = new viewDatos(null,true,datos);
                ventana.setLocation(x, y);
                ventana.setIconImage(new ImageIcon("src/imagenes/categoria.png").getImage());
                ventana.setVisible(true);
                try {
                    //obtener el nombre de la categoria
                    nombre = ventana.Jlista.getSelectedValue().toString();
                    //Obtener el id del nombre de la categoria
                    id = this.getCetegory(nombre);
                    //Establecer el nombre en la tabla
                    this.ventana.JTDatos.setValueAt(nombre, fila, columna);
                    //Actualizar registro
                    this.actualizar(fila);
                } catch (Exception e) {
                    break;
                }
                break;
            case "CONDICION":
                x = punto.x;
                y = punto.y;
                datos = new String[3];
                datos[0] = "Bueno";
                datos[1] = "Regular";
                datos[2] = "Malo";
                ventana = new viewDatos(null,true,datos);
                ventana.setLocation(x, y);
                ventana.setIconImage(new ImageIcon("src/imagenes/archivo-de-caja-negra.png").getImage());
                ventana.setVisible(true);
                try {
                    //Obtener la condicion 
                    nombre = ventana.Jlista.getSelectedValue().toString();
                    //Obtener el numero de la condicion
                    byte num = this.getCondicion(nombre.toUpperCase());
                    //Establecer el nombre en la tabla
                    this.ventana.JTDatos.setValueAt(nombre, fila, columna);
                    //Actualizar registro
                    this.actualizar(fila);
                } catch (Exception e) {
                    break;
                }
                break;
            case "AREA":
                x = punto.x;
                y = punto.y;
                //Instanciar Area
                areaC = new AreaCrud();
                //Establecer el tamaño de el array
                datos = new String[areaC.consulta().size()];
                //Listar el arreglo
                for (int i = 0; i < areaC.consulta().size(); i++) {
                    datos[i] = areaC.consulta().get(i).getDescripcion();
                }
                //Lanzar el jDialo y pasar como parametro el arreglo
                ventana = new viewDatos(null,true,datos);
                ventana.setLocation(x, y);
                ventana.setIconImage(new ImageIcon("src/imagenes/areas.png").getImage());
                ventana.setVisible(true);
                try {
                    //obtener el nombre del area
                    nombre = ventana.Jlista.getSelectedValue().toString();
                    //Obtener el id del nombre del area
                    id = this.getIdArea(nombre);
                    //Establecer el nombre en la tabla
                    this.ventana.JTDatos.setValueAt(nombre, fila, columna);
                    //Actualizar registro
                    this.actualizar(fila);
                } catch (Exception e) {
                    break;
                }
                break;
            case "ENCARGADO":
                x = punto.x;
                y = punto.y;
                //Instanciar el objeto encargado
                encargadoC = new EncargadoCrud();
                //Establecer el tamaño del arreglo
                datos = new String[encargadoC.consulta().size()];
                //Listar el arreglo
                for (int i = 0; i < encargadoC.consulta().size(); i++) {
                    datos[i] = encargadoC.consulta().get(i).getNombre()+" "
                            +encargadoC.consulta().get(i).getAp1()+" "
                            +encargadoC.consulta().get(i).getAp2();
                }
                ventana = new viewDatos(null,true,datos);
                ventana.setLocation(x, y);
                ventana.setIconImage(new ImageIcon("src/imagenes/usuarios-multiples-en-silueta.png").getImage());
                ventana.setVisible(true);
                try {
                    //obtener el nombre del encargado
                    nombre = ventana.Jlista.getSelectedValue().toString();
                    //obtener el id del nombre del encargado
                    id = this.getIdEncar(nombre);
                    //Establecer el nombre en la tabla
                    this.ventana.JTDatos.setValueAt(nombre, fila, columna);
                    //Actualizar registro
                    this.actualizar(fila);
                } catch (Exception e) {
                    break;
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void mousePressed(MouseEvent me) {   
    }
    @Override
    public void mouseReleased(MouseEvent me) {   
    }
    @Override
    public void mouseEntered(MouseEvent me) {  
    }
    @Override
    public void mouseExited(MouseEvent me) {   
    }
    //Limpiar los datos de la caje de texto
    public void Limpiar(){
        this.ventana.txtcodigo.setText(null);
        this.ventana.txtdescripcion.setText(null);
        this.ventana.txtdetalles.setText(null);
        this.ventana.txtmarca.setText(null);
        this.ventana.txtmodelo.setText(null);
    }
    //obtener el id del empleado de acuerdo a su nombre obtenido del combobox
    public int getIdArea(String nombre){
        Area area = new Area();
        area.setDescripcion(nombre);
        AreaCrud  ac = new AreaCrud();
        if (ac.buscarNom(area)) {
            return area.getId();
        }else{
            return 0;
        }
        
    }
    //obtener el id del encargado mediante el nombre proveniente del JCombobox
    public int getIdEncar(String Nombre){
        //separar en nombre y apellido
        String[] separarNom = Nombre.split(" ");
        //instanciar la clase encargado
        Encargado encargado = new Encargado();
        //verificar si el nombre del encargado tiene sus apellidos ingresados
        if (separarNom.length != 1) {
            if (separarNom.length !=2) {
                encargado.setNombre(separarNom[0]);
                encargado.setAp1(separarNom[1]);
                encargado.setAp2(separarNom[2]);
            } else {
                encargado.setNombre(separarNom[0]);
                encargado.setAp1(separarNom[1]);
                encargado.setAp2("");
            }
        } else {
            encargado.setNombre(separarNom[0]);
            encargado.setAp1(" ");
            encargado.setAp2("");
        }
        //instanciar el crud de encargado
        EncargadoCrud ec = new EncargadoCrud();
        if (ec.buscarNom(encargado)) {
            return encargado.getId();
        }else{
            return 0;
        } 
    }
    //obtener el id de la categoria a apartir de su nombre
    public int getCetegory(String nombre){
        //instanciar la clase TipoPro
        TipoPro tipo = new TipoPro();
        tipo.setNombre(nombre);
        //Instanciar la clase TipoCrud
        TipoCrud tc = new TipoCrud();
        if (tc.buscarNom(tipo)) {
            return tipo.getId();
        }else{
            return 0;
        }
    }
    //obtener elc codigo de inventario
    public void codigo(String category){
        //establecer cadena de codigo
        String cadena;
        //obtener el año
        Calendar cal = Calendar.getInstance();
        int año = cal.get(Calendar.YEAR);
        /*obtener el numero total de objetos dependiendo de la categoria obtenida
        paso 1. obtener el id de la categoria a traves del metodo getCategory
        paso 2. obtener el numero total con el metodo getObjetos de la clase modelo*/
        int idCategory = this.getCetegory(category);
        int numero = this.consul.getObjetos(idCategory);
        //verificar que existe registro
        if (numero != 0) {
            //Establecer la cadena de codigo
            cadena = "ITC"+año+category.toUpperCase().charAt(0)+(numero+1);
        }else{
            //asignar el primer numero al codigo
            numero = 1;
            //Establecer la cadena de codigo
            cadena = "ITC"+año+category.toUpperCase().charAt(0)+numero;
        }
        //asignarlo a la caja de texto de inventario
        this.ventana.txtcodigo.setText(cadena);
    }
    //Obtener la condicion del articulo en formato de numero
    public byte getCondicion(String condicion){
        //Variable para almacenar el estado fisico
        byte resultado = -1;
        switch (condicion){
            case "BUENO":
                resultado = 1;
                break;
            case "REGULAR":
                resultado =  0;
                break;
            default:
                break;
        }   
        return resultado;
    }
    //Actualizar un registro
    public void actualizar(int fila){
        try {
            //Obtener valores del registro a midificar
            String codigo = (String) this.ventana.JTDatos.getValueAt(fila, 0);
            String categoria = (String) this.ventana.JTDatos.getValueAt(fila, 1);
            String descripcion = (String) this.ventana.JTDatos.getValueAt(fila, 2);
            String marca = (String) this.ventana.JTDatos.getValueAt(fila, 3);
            String modelo = (String) this.ventana.JTDatos.getValueAt(fila, 4);
            String condicion = (String) this.ventana.JTDatos.getValueAt(fila, 5);
            String area = (String) this.ventana.JTDatos.getValueAt(fila, 6);
            String encargado = (String) this.ventana.JTDatos.getValueAt(fila, 7);
            String detalles = (String) this.ventana.JTDatos.getValueAt(fila, 8);
            //una ves obtenido los datos de la tabla. Obtendremos el id de Categoria,condicion,area,encargado
            int idCategoria = this.getCetegory(categoria);
            byte numCondicion = this.getCondicion(condicion.toUpperCase());
            int idArea = this.getIdArea(area);
            int idEncargado = this.getIdEncar(encargado);
            //Instanciar el modelo inventario y establecer los valores en el objeto
            Inventario inv = new Inventario();
            inv.setId(codigo);
            inv.setId_tipo(idCategoria);
            inv.setDescripcion(descripcion);
            inv.setMarca(marca);
            inv.setModelo(modelo);
            inv.setE_fisico(numCondicion);
            inv.setId_area(idArea);
            inv.setId_encargado(idEncargado);
            inv.setDetalles(detalles);
            //modificar el registro con el modelo inventariocrud
            if (consul.modificar(inv)) {
                //JOptionPane.showMessageDialog(null, "Modificado");
            }else{
                
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ":(\nError: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }
}
