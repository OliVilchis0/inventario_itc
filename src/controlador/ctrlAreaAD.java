package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCrud;
import vista.viewAreaAD;
import vista.viewInventario;

public class ctrlAreaAD implements ActionListener{
    private viewAreaAD viewA;
    private AreaCrud areaC;
    private Area area;
    public ctrlAreaAD(viewAreaAD viewA, AreaCrud areaC){
        //Propiedades de la ventana
        this.viewA = viewA;
        viewA.setSize(400,160);
        viewA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewA.setLocationRelativeTo(null);
        viewA.setVisible(true);
        //Vinvular atributos 
        this.areaC = areaC;
        //Activar Evento de botones
        this.viewA.btncancelar.addActionListener(this);
        this.viewA.btncerrar.addActionListener(this);
        this.viewA.btnguardar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //cerrar ventana cone l bototn cancelar
        if (e.getSource() == viewA.btncancelar) {
            this.viewA.dispose();
        }
        //Cerrar ventana con el boton superior
        if (e.getSource() == viewA.btncerrar) {
            this.viewA.dispose();
        }
        //Guardar datos
        if (e.getSource() == viewA.btnguardar) {
            if (this.viewA.txtnombre.equals("")) {
                this.viewA.txtnombre.setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "; )\nDebes ingresar todos los datos!!","Mensaje",JOptionPane.WARNING_MESSAGE);
            } else {
               this.area = new Area();
               this.area.setDescripcion(this.viewA.txtnombre.getText());
                if (this.areaC.registrar(area)) {
                    viewInventario inv = new viewInventario();
                    inv.updateUI();
                    JOptionPane.showMessageDialog(null, "Registro Guardado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar el registro","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
