package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
        //Actiavr boton para lanzar evento de ActionListener
        this.va.btnguardar.addActionListener(this);
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
        modelo.addColumn("DESCRIPCION");
        Object[] columna = new Object[2];
        //Obtener al tamano de la lista 
        int numRegistros = ac.consulta().size();
        //Recorrer la lista
        for (int i = 0; i < numRegistros ; i++) {
            columna[0] = ac.consulta().get(i).getId();
            columna[1] = ac.consulta().get(i).getDescripcion().toUpperCase();
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
                    JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla(this.va.jtarea);
                    JOptionPane.showMessageDialog(null, "; )\nError al intentar guardar el registro","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
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
        
    }
    //Lipiar cajas de texto
    public void limpiar(){
        this.va.txtNuevaArea.setText(null);
    }
}
