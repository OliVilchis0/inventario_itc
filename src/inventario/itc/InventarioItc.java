package inventario.itc;
import controlador.ctrlInicio;
import static java.awt.Frame.MAXIMIZED_BOTH;
import vista.viewInicio;

public class InventarioItc {

    public static void main(String[] args) {
        //Instanciar la vista
        viewInicio win = new viewInicio();
        //Instanciar controlador de inicio
        ctrlInicio ctrl = new ctrlInicio(win);
        //Atributos de la vista general
        win.setExtendedState(viewInicio.MAXIMIZED_BOTH);
        win.setVisible(true);
        win.setLocationRelativeTo(null);
    }
    
}
