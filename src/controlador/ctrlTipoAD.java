package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.TipoCrud;
import vista.viewCateAD;
//import vista.viewCateAD;

public class ctrlTipoAD implements ActionListener{
    private viewCateAD viewT;
    private TipoCrud TipoC;
    public ctrlTipoAD(viewCateAD viewT, TipoCrud TipoC){
        //Propiedades de la ventana
        this.viewT = viewT;
        viewT.setSize(400,160);
        viewT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewT.setLocationRelativeTo(null);
        viewT.setVisible(true);
        //Vinvular atributos 
        this.TipoC = TipoC;
        //Activar Evento de botones
        this.viewT.btncancelar.addActionListener(this);
        this.viewT.btncerrar.addActionListener(this);
        this.viewT.btnguardar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //cerrar ventana cone l bototn cancelar
        if (e.getSource() == viewT.btncancelar) {
            this.viewT.dispose();
        }
        //Cerrar ventana con el boton superior
        if (e.getSource() == viewT.btncerrar) {
            this.viewT.dispose();
        }
        //Guardar datos
        if (e.getSource() == viewT.btnguardar) {
            
        }
    }
}
