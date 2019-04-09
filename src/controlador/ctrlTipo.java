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
import modelo.Inventario;
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
        //Activar Botones para lanzar evento KeyListener
        this.vt.txtBuscar.addKeyListener(this);
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
        modelo.addColumn("DESCRIPCION");
        Object[] columna = new Object[3];
        //Obtener al tamano de la lista 
        int numRegistros = tc.consulta().size();
        //Recorrer la lista
        for (int i = 0; i < numRegistros ; i++) {
            columna[0] = tc.consulta().get(i).getId();
            columna[1] = tc.consulta().get(i).getNombre().toUpperCase();
            columna[2] = tc.consulta().get(i).getDescripcion().toUpperCase();
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
                    this.tabla(this.vt.JTabla);
                    JOptionPane.showMessageDialog(null, "Ragistro guardado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.tabla(this.vt.JTabla);
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
        this.filtro(this.vt.txtBuscar.getText().toUpperCase(), this.vt.JTabla);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    //limpiar cajas de texto
    public void limpiar(){
        this.vt.txtNombre.setText(null);
        this.vt.txtDescripcion.setText(null);
    }
}
