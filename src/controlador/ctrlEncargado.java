package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Encargado;
import modelo.EncargadoCrud;
import vista.viewEncargado;

public class ctrlEncargado implements ActionListener,KeyListener{
    private viewEncargado ve;
    private EncargadoCrud ec;
    
    public ctrlEncargado(viewEncargado ve,EncargadoCrud ec) {
        this.ve = ve;
        this.ve.setSize(829,431);
        this.ve.setLocation(1,1);
        this.ec = ec;
        //Lanzar Tabla
        this.tabla();
        //Activar Boton para lanzar evento Keylistener
        this.ve.txtBuscar.addKeyListener(this);
        this.ve.JTabla.addKeyListener(this);
        //Activar Boton para lanzar evento ActionListener
        this.ve.btnGuardar.addActionListener(this);
        this.ve.jmEliminar.addActionListener(this);
        this.ve.jCFilas.addActionListener(this);
        //Bloquear el boton pdf
        this.ve.btnPdf.setEnabled(false);
    }
    //Lista todos los registros en una tabla
    public void tabla(){
        while(this.ve.modelo.getRowCount() > 0){
            this.ve.modelo.removeRow(0);
        }
        //Asosiar tabla con el modelo
        ArrayList<Encargado> encargado = this.ec.consulta();
        //Recorrer la lista
        for (Encargado ecgd : encargado) {
            Object columna[] = new Object[5];
            columna[0] = ecgd.getId();
            columna[1] = ecgd.getNombre().toUpperCase();
            columna[2] = ecgd.getAp1().toUpperCase();
            columna[3] = ecgd.getAp2().toUpperCase();
            columna[4] = ecgd.getCargo().toUpperCase();
            this.ve.modelo.addRow(columna);
        }
        this.ve.lbFilas.setText("Mostrando un total de "+ec.numFilas()+" Registros");
    }
    //filtrar un registro de la tabla
    public void filtro(String consulta,JTable jtableBuscar){
        this.ve.modelo = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(this.ve.modelo);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Guardar un registro
        if (ae.getSource() == this.ve.btnGuardar) {
            if (
                this.ve.txtNombre.getText().equals("") ||
                this.ve.txtCargo.getText().equals("")
                ) {
                JOptionPane.showMessageDialog(null,"; )\nEl nombre y cargo son obligatorios","Mensaje",JOptionPane.WARNING_MESSAGE);
            } else {
                Encargado ecgd = new Encargado();
                ecgd.setNombre(this.ve.txtNombre.getText());
                ecgd.setAp1(this.ve.txtAp1.getText());
                ecgd.setAp2(this.ve.txtAp2.getText());
                ecgd.setCargo(this.ve.txtCargo.getText());
                if (this.ec.registrar(ecgd)) {
                    this.limpiar();
                    //tratar de refrescar la tabla
                    try {
                        this.tabla();
                    } catch (Exception e) {
                        //Agregar los datos a la tabla
                        Object[] datos = {ecgd.getNombre(),ecgd.getAp1(),ecgd.getAp2(),ecgd.getCargo()};
                        this.ve.modelo.addRow(datos);
                    }
                    //Establecer el foco en la caja de texto nombre
                    this.ve.txtNombre.requestFocus();
                    //JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla();
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Al seleccionar la cantidad de filas que se desea ver a traves del jcombobox
        if (ae.getSource() == this.ve.jCFilas) {
            //Actualizar la tabla
            this.tabla();
            try {
                //Obtener la cantidad de filas que se deseean ver
                int numRow = Integer.parseInt(this.ve.jCFilas.getSelectedItem().toString());
                //Obtener el total de filas de la tabla
                int numTotal = this.ve.modelo.getRowCount();
                //Restar las filas total con las que se desea ver
                int totalRows = numTotal - numRow;
                for (int i = 0; i < totalRows; i++) {
                    this.ve.modelo.removeRow(this.ve.modelo.getRowCount() -1);
                }
                this.ve.lbFilas.setText("Mostrando "+numRow+" registros filtrado de un total de "+this.ec.numFilas());
            } catch (Exception ea) {
            }
        }
        //Eliminar un regitro
        if (ae.getSource() == this.ve.jmEliminar) {
            //Obtener el numero de filas seleccionadas
            int[] fila = this.ve.JTabla.getSelectedRows();
            //establecer un array de cadenas para los codigos
            int[] codigo; 
            //Instanciar el modelo Encargado
            Encargado encargado = new Encargado();
            //Validad si se selecciono una o mas filas
            if (fila.length >= 0) {
                //Si se desea borrar un registro si no, se borrara mas de uno
                if (fila.length == 1) {
                    //crear el array con dimencion = 1;
                    codigo = new int[1];
                    //Obtener el codigo de la fila seleccionada
                    Object id = this.ve.JTabla.getValueAt(fila[0],0);
                    codigo[0] = Integer.parseInt(id.toString());
                    //establecer el codigo de la fila en el modelo inventario
                    encargado.setId(codigo[0]);
                    //Eliminar el registro
                    if (this.ec.Eliminar(encargado)) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.ve.lbFilas.setText("Mostrando un total de "+this.ve.modelo.getRowCount()+" Registros");
                        //Refrescar la tabla
                        this.tabla();
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
                        Object id = this.ve.JTabla.getValueAt(fila[i], 0);
                        codigo[i] = Integer.parseInt(id.toString());
                        encargado.setId(codigo[i]);
                        if (this.ec.Eliminar(encargado)) {
                            guardado = true;
                        }else{
                            guardado = false;
                        }
                    }
                    //Lanzar mensaje si todos los registros de guardaron
                    if (guardado) {
                        //Actualizar la etiqueta donde muestra el total de registros
                        this.ve.lbFilas.setText("Mostrando un total de "+this.ve.modelo.getRowCount()+" Registros");
                        //Refrescar la tabla
                        this.tabla();
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
       this.filtro(this.ve.txtBuscar.getText().toUpperCase(), this.ve.JTabla);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Saber si el usuario presiono la tecla enter en una selda de la tabla
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.ve.JTabla.getSelectedRow();
            try {
                //obtener los datos la tabla
                int id = (int) (Object) this.ve.JTabla.getValueAt(fila, 0);
                String nombre = (String) this.ve.JTabla.getValueAt(fila, 1);
                String ap1 = (String) this.ve.JTabla.getValueAt(fila, 2);
                String ap2 = (String) this.ve.JTabla.getValueAt(fila, 3);
                String cargo = (String) this.ve.JTabla.getValueAt(fila, 4);
                //Instanciar el modelo area
                Encargado encargado = new Encargado();
                encargado.setId(id);
                encargado.setNombre(nombre);
                encargado.setAp1(ap1);
                encargado.setAp2(ap2);
                encargado.setCargo(cargo);
                if (!this.ec.modificar(encargado)) {
                    JOptionPane.showMessageDialog(null,"; (\nDebio ocurrir un error","AVISO",JOptionPane.ERROR_MESSAGE);
                }
                this.tabla();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
        }
    }
    //Limpiar los cuadros de texto
    public void limpiar(){
        this.ve.txtNombre.setText(null);
        this.ve.txtAp1.setText(null);
        this.ve.txtAp2.setText(null);
        this.ve.txtCargo.setText(null);
    }
}
