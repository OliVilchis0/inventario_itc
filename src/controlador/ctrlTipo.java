package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import modelo.TipoCrud;
import modelo.TipoPro;
import vista.viewTipo;


public class ctrlTipo implements ActionListener,KeyListener{
    private TipoPro tp;
    private TipoCrud tc;
    private viewTipo vt;
    private DefaultTableModel modelo;
    
    public ctrlTipo(TipoCrud tc, viewTipo vt){
        this.tc = tc;
        this.vt = vt;
        this.vt.setSize(829,431);
        this.vt.setLocation(1, 1);
        //Lanzar tabla de datos
        this.tabla(this.vt.JTabla);
        //Activar Botones para lanzar evento ActionListener
        this.vt.bntGuardar.addActionListener(this);
        this.vt.jCFilas.addActionListener(this);
        this.vt.jmEliminar.addActionListener(this);
        //Activar Botones para lanzar evento KeyListener
        this.vt.txtBuscar.addKeyListener(this);
        this.vt.JTabla.addKeyListener(this);
        //Bloquear el boton pdf
        this.vt.btnPdf.setEnabled(false);
    }
    //Lista todos los registros en una tabla
    public void tabla(JTable tabla){
        //propiedades del header de la tabla
        JTableHeader THeader = tabla.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.vt.JTabla.setRowHeight(25);
        //tabla
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("DESCRIPCION");
        //Asosiar tabla con el modelo
        ArrayList<TipoPro> tipo = this.tc.consulta();
        //Recorrer la lista
        for (TipoPro tp : tipo) {
            Object[] columna = new Object[3];
            columna[0] = tp.getId();
            columna[1] = tp.getNombre();
            columna[2] = tp.getDescripcion();
            modelo.addRow(columna);
        }
        this.vt.lbFilas.setText("Mostrando un total de "+tc.numFilas()+" Registros");
    }
    //filtrar un registro de la tabla
    public void filtro(String consulta,JTable jtableBuscar){
        modelo = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Gusrdar un registro
        if (ae.getSource() == this.vt.bntGuardar) {
            if (this.vt.txtNombre.getText().equals("") || this.vt.txtDescripcion.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "; )\nDebes Ingresar el nombre y descripcion de la categoria","Mensaje",JOptionPane.WARNING_MESSAGE);
            }else{
                TipoPro tipo = new TipoPro();
                tipo.setNombre(this.vt.txtNombre.getText());
                tipo.setDescripcion(this.vt.txtDescripcion.getText());
                if (this.tc.registrar(tipo)) {
                    this.limpiar();
                    //tratar de actualizar la tabla
                    try {
                        this.tabla(this.vt.JTabla);
                    } catch (Exception e) {
                        Object[] datos = {tipo.getId(),tipo.getNombre(),tipo.getDescripcion()};
                        modelo.addRow(datos);
                    }
                    //Establecer el foco en la caja de texto nombre
                    this.vt.txtNombre.requestFocus();
                    //JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla(this.vt.JTabla);
                    JOptionPane.showMessageDialog(null, "; )\nError al intentar guardar el registro","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Al seleccionar la cantidad de filas que se desea ver a traves del jcombobox
        if (ae.getSource() == this.vt.jCFilas) {
            //Actualizar la tabla
            this.tabla(this.vt.JTabla);
            try {
                //Obtener la cantidad de filas que se deseean ver
                int numRow = Integer.parseInt(this.vt.jCFilas.getSelectedItem().toString());
                //Obtener el total de filas de la tabla
                int numTotal = this.modelo.getRowCount();
                //Restar las filas total con las que se desea ver
                int totalRows = numTotal - numRow;
                for (int i = 0; i < totalRows; i++) {
                    this.modelo.removeRow(this.modelo.getRowCount() -1);
                }
                this.vt.lbFilas.setText("Mostrando "+numRow+" registros filtrado de un total de "+this.tc.numFilas());
            } catch (Exception ea) {
            }
        }
        //Eliminar un regitro
        if (ae.getSource() == this.vt.jmEliminar) {
            //Obtener el numero de filas seleccionadas
            int[] fila = this.vt.JTabla.getSelectedRows();
            //establecer un array de cadenas para los codigos
            int[] codigo; 
            //Instanciar el modelo Encargado
            TipoPro tipo = new TipoPro();
            //Validad si se selecciono una o mas filas
            if (fila.length >= 0) {
                //Si se desea borrar un registro si no, se borrara mas de uno
                if (fila.length == 1) {
                    //crear el array con dimencion = 1;
                    codigo = new int[1];
                    //Obtener el codigo de la fila seleccionada
                    Object id = this.vt.JTabla.getValueAt(fila[0],0);
                    codigo[0] = Integer.parseInt(id.toString());
                    //establecer el codigo de la fila en el modelo inventario
                    tipo.setId(codigo[0]);
                    //Eliminar el registro
                    if (this.tc.Eliminar(tipo)) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.vt.lbFilas.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Tratar de refrescar la tabla
                        try {
                            this.tabla(this.vt.JTabla);
                        } catch (Exception e) {
                            this.modelo.removeRow(fila[0]);
                        }
                        //JOptionPane.showMessageDialog(null, "Registro borrado");
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
                    codigo = new int[fila.length];
                    //Recorrer el array con FOR para establecer los codigos en modelo inventario
                    for (int i = 0; i < codigo.length; i++) {
                        Object id = this.vt.JTabla.getValueAt(fila[i], 0);
                        codigo[i] = Integer.parseInt(id.toString());
                        tipo.setId(codigo[i]);
                        System.out.println(tipo.getId());
                        if (this.tc.Eliminar(tipo)) {
                            guardado = true;
                        }else{
                            guardado = false;
                        }
                    }
                    //Lanzar mensaje si todos los registros de guardaron
                    if (guardado) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.vt.lbFilas.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Refrescar la tabla
                        this.tabla(this.vt.JTabla);
                        //JOptionPane.showMessageDialog(null, "Registros borrados");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debes Seleccionar una fila","Aviso",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        this.filtro(this.vt.txtBuscar.getText().toUpperCase(), this.vt.JTabla);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Saber si el usuario presiono la tecla enter en una selda de la tabla
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.vt.JTabla.getSelectedRow();
            try {
                //obtener los datos la tabla
                int id = (int) (Object) this.vt.JTabla.getValueAt(fila, 0);
                String nombre = (String) this.vt.JTabla.getValueAt(fila, 1);
                String descripcion = (String) this.vt.JTabla.getValueAt(fila, 2);
                //Instanciar el modelo area
                TipoPro tipo = new TipoPro();
                tipo.setId(id);
                tipo.setNombre(nombre);
                tipo.setDescripcion(descripcion);
                if (!this.tc.modificar(tipo)) {
                    JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","AVISO",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
        }
    }
    //limpiar cajas de texto
    public void limpiar(){
        this.vt.txtNombre.setText(null);
        this.vt.txtDescripcion.setText(null);
    }
}
