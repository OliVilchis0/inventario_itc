package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ctrlInicio implements ActionListener{
    private viewInicio vi;

    public ctrlInicio(viewInicio vi) {
        //Ventana General
        this.vi = vi;
        this.vi.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vi.bntInicio.setBackground(Color.red);
        //Cargar panel de principal
        viewPrincipal vp = new viewPrincipal();
        //Cargar controladores
        AreaCrud ac = new AreaCrud();
        EncargadoCrud ec = new EncargadoCrud();
        InventarioCrud ic = new InventarioCrud();
        TipoCrud tc = new TipoCrud();
        //controlador principal
        ctrlPrincipal pcp = new ctrlPrincipal(ac,ec,ic,tc,vp);
        //Cargar vista principal a ventana general
        this.vi.JPPrincipal.setLayout(new BorderLayout());
        this.vi.JPPrincipal.add(vp,BorderLayout.CENTER);
        this.vi.JPPrincipal.updateUI();
        //evento ActionListener
        this.vi.bntInicio.addActionListener(this);
        this.vi.btnInventario.addActionListener(this);
        this.vi.btnareas.addActionListener(this);
        this.vi.btnEcds.addActionListener(this);
        this.vi.btncat.addActionListener(this);
        this.vi.btnPdf.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //Vista principal
         if (e.getSource() == vi.bntInicio) {
            //establecer el color del icono
            vi.btnEcds.setIcon(new ImageIcon(getClass().getResource("/imagenes/usuarios-multiples-en-silueta.png")));
            vi.btnInventario.setIcon(new ImageIcon(getClass().getResource("/imagenes/archivo-de-caja-negra.png")));
            vi.bntInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/home_blanco.png")));
            vi.btnareas.setIcon(new ImageIcon(getClass().getResource("/imagenes/areas.png")));
            vi.btncat.setIcon(new ImageIcon(getClass().getResource("/imagenes/categoria.png")));
             //Establecer color
            vi.bntInicio.setBackground(Color.red);
            vi.btnareas.setBackground(new Color(52,58,64));
            vi.btncat.setBackground(new Color(52,58,64));
            vi.btnInventario.setBackground(new Color(52,58,64));
             //Cargar panel de principal
            viewPrincipal vp = new viewPrincipal();
            //Cargar controladores
            AreaCrud ac = new AreaCrud();
            EncargadoCrud ec = new EncargadoCrud();
            InventarioCrud ic = new InventarioCrud();
            TipoCrud tc = new TipoCrud();
            //controlador principal
            ctrlPrincipal pcp = new ctrlPrincipal(ac,ec,ic,tc,vp);
            //Cargar vista principal a ventana general
            this.vi.JPPrincipal.removeAll();
            this.vi.JPPrincipal.setLayout(new BorderLayout());
            this.vi.JPPrincipal.add(vp,BorderLayout.CENTER);
            this.vi.JPPrincipal.updateUI();
         }
        //Vista Inventario
        if (e.getSource() == vi.btnInventario) {
            //establecer el color del icono
            vi.btnEcds.setIcon(new ImageIcon(getClass().getResource("/imagenes/usuarios-multiples-en-silueta.png")));
            vi.btnInventario.setIcon(new ImageIcon(getClass().getResource("/imagenes/inventario_blanco.png")));
            vi.bntInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/home.png")));
            vi.btnareas.setIcon(new ImageIcon(getClass().getResource("/imagenes/areas.png")));
            vi.btncat.setIcon(new ImageIcon(getClass().getResource("/imagenes/categoria.png")));
            //establecer color
            vi.bntInicio.setBackground(new Color(52,58,64));
            vi.btnareas.setBackground(new Color(52,58,64));
            vi.btncat.setBackground(new Color(52,58,64));
            vi.btnEcds.setBackground(new Color(52,58,64));
            vi.btnInventario.setBackground(Color.red);
            //instanciar la vista
            viewInventario panel = new viewInventario();
            //Instanciar el modelo
            InventarioCrud incrud= new InventarioCrud();
            //Instanciar el controlador
            ctrlInventario inventario = new ctrlInventario(panel,incrud);
            
            vi.JPPrincipal.removeAll();
            vi.JPPrincipal.setLayout(new BorderLayout());
            vi.JPPrincipal.add(panel,BorderLayout.CENTER);
            vi.JPPrincipal.updateUI();
        }
        //Vista de areas
         if (e.getSource() == vi.btnareas) {
            //establecer el color del icono
            vi.btnEcds.setIcon(new ImageIcon(getClass().getResource("/imagenes/usuarios-multiples-en-silueta.png")));
            vi.btnInventario.setIcon(new ImageIcon(getClass().getResource("/imagenes/archivo-de-caja-negra.png")));
            vi.bntInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/home.png")));
            vi.btnareas.setIcon(new ImageIcon(getClass().getResource("/imagenes/areas_blanco.png")));
            vi.btncat.setIcon(new ImageIcon(getClass().getResource("/imagenes/categoria.png")));
             //Establecer color 
             vi.bntInicio.setBackground(new Color(52,58,64));
             vi.btnInventario.setBackground(new Color(52,58,64));
             vi.btncat.setBackground(new Color(52,58,64));
             vi.btnEcds.setBackground(new Color(52,58,64));
             vi.btnareas.setBackground(Color.red);
            //instanciar la vista
            viewAreas panel = new viewAreas();
            //Instanciar el modelo
            AreaCrud area = new AreaCrud();
            //Instanciar el controlador
            ctrlArea pcp = new ctrlArea(panel,area);
            
            vi.JPPrincipal.removeAll();
            vi.JPPrincipal.setLayout(new BorderLayout());
            vi.JPPrincipal.add(panel,BorderLayout.CENTER);
            vi.JPPrincipal.updateUI();
        }
        //Vista Encargados
        if (e.getSource() == vi.btnEcds) {
            //establecer el color del icono
            vi.btnEcds.setIcon(new ImageIcon(getClass().getResource("/imagenes/encargados_blanco.png")));
            vi.btnInventario.setIcon(new ImageIcon(getClass().getResource("/imagenes/archivo-de-caja-negra.png")));
            vi.bntInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/home.png")));
            vi.btnareas.setIcon(new ImageIcon(getClass().getResource("/imagenes/areas.png")));
            vi.btncat.setIcon(new ImageIcon(getClass().getResource("/imagenes/categoria.png")));
            //Establecer color 
            vi.bntInicio.setBackground(new Color(52,58,64));
            vi.btnInventario.setBackground(new Color(52,58,64));
            vi.btnareas.setBackground(new Color(52,58,64));
            vi.btncat.setBackground(new Color(52,58,64));
            vi.btnEcds.setBackground(Color.red);
             //instanciar la vista
            viewEncargado panel = new viewEncargado();
            //Instanciar el modelo
            EncargadoCrud tipo = new EncargadoCrud();
            //Instanciar el controlador
            ctrlEncargado pcp = new ctrlEncargado(panel, tipo);
             
            vi.JPPrincipal.removeAll();
            vi.JPPrincipal.setLayout(new BorderLayout());
            vi.JPPrincipal.add(panel,BorderLayout.CENTER);
            vi.JPPrincipal.updateUI();
         }
         //Vista Categorias
         if (e.getSource() == vi.btncat) {
            //establecer el color del icono
            vi.btnEcds.setIcon(new ImageIcon(getClass().getResource("/imagenes/usuarios-multiples-en-silueta.png")));
            vi.btnInventario.setIcon(new ImageIcon(getClass().getResource("/imagenes/archivo-de-caja-negra.png")));
            vi.bntInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/home.png")));
            vi.btnareas.setIcon(new ImageIcon(getClass().getResource("/imagenes/areas.png")));
            vi.btncat.setIcon(new ImageIcon(getClass().getResource("/imagenes/categoria_blanco.png")));
            //Establecer color 
             vi.bntInicio.setBackground(new Color(52,58,64));
             vi.btnInventario.setBackground(new Color(52,58,64));
             vi.btnareas.setBackground(new Color(52,58,64));
             vi.btnEcds.setBackground(new Color(52,58,64));
             vi.btncat.setBackground(Color.red);
             //instanciar la vista
            viewTipo panel = new viewTipo();
            //Instanciar el modelo
            TipoCrud tipo = new TipoCrud();
            //Instanciar el controlador
            ctrlTipo pcp = new ctrlTipo(tipo,panel);
            
            vi.JPPrincipal.removeAll();
            vi.JPPrincipal.setLayout(new BorderLayout());
            vi.JPPrincipal.add(panel,BorderLayout.CENTER);
            vi.JPPrincipal.updateUI();
        }
    }
}
