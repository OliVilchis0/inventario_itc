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
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import modelo.Area;
import modelo.AreaCrud;
import vista.viewAreas;

public class ctrlArea implements ActionListener,KeyListener {
    private viewAreas va;
    private AreaCrud ac;
    private DefaultTableModel modelo;
    
    public ctrlArea(viewAreas va, AreaCrud ac){
        this.va = va;
        this.va.setSize(829,431);
        this.va.setLocation(1,1);
        this.ac = ac;
        //Lanzar  tabla
        this.tabla(this.va.jtarea);
        //Activar boton para lanzar evento de KeyListener
        this.va.txtbuscar.addKeyListener(this);
        this.va.jtarea.addKeyListener(this);
        //Actiavr boton para lanzar evento de ActionListener
        this.va.btnguardar.addActionListener(this);
        this.va.jcFilas.addActionListener(this);
        this.va.jpEliminar.addActionListener(this);
        //Bloquear el boton pdf
        this.va.btnPdf.setEnabled(false);
    }
    //Lista todos los registros en una tabla
    public void tabla(JTable tabla){
        //propiedades del header de la tabla
        JTableHeader THeader = tabla.getTableHeader();
        THeader.setBackground(new Color(52,58,64));
        THeader.setForeground(Color.white);
        THeader.setFont(new Font("DejaVu Sans",Font.ITALIC,14));
        THeader.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.va.jtarea.setRowHeight(25);
        //tabla
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        //Asosiar el arrayList del modelo
        ArrayList<Area> area = this.ac.consulta();
        //Recorrer la lista
        for (Area a : area) {
            Object columna[] = new Object[2];
            columna[0] = a.getId();
            columna[1] = a.getDescripcion();
            modelo.addRow(columna);
        }
        this.va.lbTotalRow.setText("Mostrando un total de "+ac.numFilas()+" Registros");
    }
    //filtrar un registro de la tabla
    public void filtro(String consulta,JTable jtableBuscar){
        modelo = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    //Metodo para lanzar un evento dependiendo el boton que se oprima
    @Override
    public void actionPerformed(ActionEvent e){
        //Guaradr un registro
        if (e.getSource() == this.va.btnguardar) {
            if (this.va.txtNuevaArea.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "; )\nDebes Ingresar el nombre del área","Mensaje",JOptionPane.WARNING_MESSAGE);
            } else {
                Area area = new Area();
                area.setDescripcion(this.va.txtNuevaArea.getText());
                if (this.ac.registrar(area)) {
                    this.limpiar();
                    this.tabla(this.va.jtarea);
                    //Posicionar el foco en la caja de texto nueva area 
                    this.va.txtNuevaArea.requestFocus();
                    //JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla(this.va.jtarea);
                    JOptionPane.showMessageDialog(null, "; )\nError al intentar guardar el registro","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Al seleccionar la cantidad de filas que se desea ver a traves del jcombobox
        if (e.getSource() == this.va.jcFilas) {
            //Actualizar la tabla
            this.tabla(this.va.jtarea);
            try {
                //Obtener la cantidad de filas que se deseean ver
                int numRow = Integer.parseInt(this.va.jcFilas.getSelectedItem().toString());
                //Obtener el total de filas de la tabla
                int numTotal = this.modelo.getRowCount();
                //Restar las filas total con las que se desea ver
                int totalRows = numTotal - numRow;
                for (int i = 0; i < totalRows; i++) {
                    this.modelo.removeRow(this.modelo.getRowCount() -1);
                }
                this.va.lbTotalRow.setText("Mostrando "+numRow+" registros filtrado de un total de "+this.ac.numFilas());
            } catch (Exception ea) {
            }
        }
        //Eliminar un regitro
        if (e.getSource() == this.va.jpEliminar) {
            //Obtener el numero de filas seleccionadas
            int[] fila = this.va.jtarea.getSelectedRows();
            //establecer un array de cadenas para los codigos
            int[] codigo; 
            //Instanciar el modelo Area
            Area area = new Area();
            //Validad si se selecciono una o mas filas
            if (fila.length >= 0) {
                //Si se desea borrar un registro si no, se borrara mas de uno
                if (fila.length == 1) {
                    //crear el array con dimencion = 1;
                    codigo = new int[1];
                    //Obtener el codigo de la fila seleccionada
                    Object id = this.va.jtarea.getValueAt(fila[0],0);
                    codigo[0] = Integer.parseInt(id.toString());
                    //establecer el codigo de la fila en el modelo inventario
                    area.setId(codigo[0]);
                    //Eliminar el registro
                    if (this.ac.Eliminar(area)) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.va.lbTotalRow.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Refrescar la tabla
                        this.tabla(this.va.jtarea);
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
                        Object id = this.va.jtarea.getValueAt(fila[i], 0);
                        codigo[i] = Integer.parseInt(id.toString());
                        area.setId(codigo[i]);
                        if (this.ac.Eliminar(area)) {
                            guardado = true;
                        }else{
                            guardado = false;
                        }
                    }
                    //Lanzar mensaje si todos los registros de guardaron
                    if (guardado) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.va.lbTotalRow.setText("Mostrando un total de "+modelo.getRowCount()+" Registros");
                        //Refrescar la tabla
                        this.tabla(this.va.jtarea);
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
        this.filtro(this.va.txtbuscar.getText().toUpperCase(), this.va.jtarea);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Saber si el usuario presiono la tecla enter en una selda de la tabla
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.va.jtarea.getSelectedRow();
            try {
                //obtener los datos la tabla
                int id = (int) (Object) this.va.jtarea.getValueAt(fila, 0);
                String nombre = (String) this.va.jtarea.getValueAt(fila, 1);
                //Instanciar el modelo area
                Area area = new Area();
                area.setId(id);
                area.setDescripcion(nombre);
                if (this.ac.modificar(area)) {
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
        }
    }
    //Lipiar cajas de texto
    public void limpiar(){
        this.va.txtNuevaArea.setText(null);
    }
}
