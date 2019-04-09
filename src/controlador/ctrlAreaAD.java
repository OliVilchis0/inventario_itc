package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.AreaCrud;
import vista.viewAreaAD;

public class ctrlAreaAD implements ActionListener{
    private viewAreaAD viewA;
    private AreaCrud areaC;
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
            
        }
    }
}
