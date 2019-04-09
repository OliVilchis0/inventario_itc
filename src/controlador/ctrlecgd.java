package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.EncargadoCrud;
import vista.viewEncarAD;

public class ctrlecgd implements ActionListener{
    private viewEncarAD viewE;
    private EncargadoCrud EncarC;
    public ctrlecgd(viewEncarAD viewE, EncargadoCrud encarC){
        //Propiedades de la ventana
        this.viewE = viewE;
        this.viewE.setSize(400,200);
        this.viewE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.viewE.setLocationRelativeTo(null);
        this.viewE.setVisible(true);
        //Vinvular atributos 
        this.EncarC = EncarC;
        //Activar Evento de botones
        this.viewE.btncancelar.addActionListener(this);
        this.viewE.btncerrar.addActionListener(this);
        this.viewE.btnguardar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //cerrar ventana cone l bototn cancelar
        if (e.getSource() == viewE.btncancelar) {
            this.viewE.dispose();
        }
        //Cerrar ventana con el boton superior
        if (e.getSource() == viewE.btncerrar) {
            this.viewE.dispose();
        }
        //Guardar datos
        if (e.getSource() == viewE.btnguardar) {
            
        }
    }
}
