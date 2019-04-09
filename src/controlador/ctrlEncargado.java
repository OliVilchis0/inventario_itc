package controlador;

import java.awt.CardLayout;
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
import modelo.Encargado;
import modelo.EncargadoCrud;
import vista.viewEncargado;

public class ctrlEncargado implements ActionListener,KeyListener{
    private viewEncargado ve;
    private EncargadoCrud ec;
    private DefaultTableModel modelo;
    
    public ctrlEncargado(viewEncargado ve,EncargadoCrud ec) {
        this.ve = ve;
        this.ve.setSize(829,431);
        this.ve.setLocation(1,1);
        this.ec = ec;
        //Lanzar Tabla
        this.tabla(this.ve.JTabla);
        //Activar Boton para lanzar evento Keylistener
        this.ve.txtBuscar.addKeyListener(this);
        //Activar Boton para lanzar evento ActionListener
        this.ve.btnGuardar.addActionListener(this);
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
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        //columnas de las tablas
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Primer Apellido");
        modelo.addColumn("Segundo Apellido");
        modelo.addColumn("Cargo");
        Object[] columna = new Object[5];
        //Obtener al tamano de la lista 
        int numRegistros = ec.consulta().size();
        //Recorrer la lista
        for (int i = 0; i < numRegistros ; i++) {
            columna[0] = ec.consulta().get(i).getId();
            columna[1] = ec.consulta().get(i).getNombre().toUpperCase();
            columna[2] = ec.consulta().get(i).getAp1().toUpperCase();
            columna[3] = ec.consulta().get(i).getAp2().toUpperCase();
            columna[4] = ec.consulta().get(i).getCargo().toUpperCase();
            modelo.addRow(columna);
        }
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
                    this.tabla(this.ve.JTabla);
                    JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla(this.ve.JTabla);
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
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
        
    }
    //Limpiar los cuadros de texto
    public void limpiar(){
        this.ve.txtNombre.setText(null);
        this.ve.txtAp1.setText(null);
        this.ve.txtAp2.setText(null);
        this.ve.txtCargo.setText(null);
    }
}
