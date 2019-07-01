package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCrud;
import modelo.Encargado;
import modelo.EncargadoCrud;
import modelo.InventarioCrud;
import modelo.TipoCrud;
import modelo.TipoPro;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import vista.viewDialogArea;
import vista.viewDialogEcgd;
import vista.viewDialogTipo;
import vista.viewPrincipal;

public class ctrlPrincipal implements ActionListener {
    private viewPrincipal vp;
    private InventarioCrud ic;
    private AreaCrud ac;
    private EncargadoCrud ec;
    private TipoCrud tc;
    
    public ctrlPrincipal(AreaCrud ac, EncargadoCrud ec, InventarioCrud ic, TipoCrud tc,viewPrincipal vp){
        this.vp = vp;
        this.vp.setSize(1000,500);
        this.vp.setLocation(1,1);
        this.ac = ac;
        this.ec = ec;
        this.ic = ic;
        this.tc = tc;
        //Metodos de la clase(Graficas)
        this.TotalRow();
        this.grafica_Barras();
        if (ic.numFilas() != 0) {
            this.grafica_Pastel();
        }
        //Activar botones para lanzar un evento
        this.vp.btnAreas.addActionListener(this);
        this.vp.btnCategory.addActionListener(this);
        this.vp.btnEncar.addActionListener(this);
        this.vp.btninvetario.addActionListener(this);
    }
     //Obtener el numero de regitros por cada tabla
    public void TotalRow(){
       vp.lbinventario.setText(Integer.toString(ic.numFilas()));
       vp.lbareas.setText(Integer.toString(ac.numFilas()));
       vp.lbencargados.setText(Integer.toString(ec.numFilas()));
       vp.lbcategorias.setText(Integer.toString(tc.numFilas()));
    }
    //Grafica de pasteles
    //http://www.fanuriotimetracking.com/files/releases/3.2.1/help/html/template-guide-charts.html
    public void grafica_Pastel(){
        // Fuente de Datos
        int condicion[] = new int[3];
        System.arraycopy(ic.Condicion(), 0, condicion, 0, 3);
        double mala = (condicion[0] * 100)/ic.numFilas() ;
        double regular = (condicion[1] * 100) / ic.numFilas();
        double buena = (condicion[2] * 100) / ic.numFilas();
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Buena", buena);
        data.setValue("Mala", mala);
        data.setValue("Regular", regular);
        // Crear Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "", 
         data, 
         true, 
         true, 
         false);
        //Establecer titulo
        TextTitle titulo = new TextTitle("Condición de inventario", new Font ("Verdana", Font.PLAIN , 17));
        titulo.setPosition(RectangleEdge.BOTTOM);
        chart.setTitle(titulo);
        //Remover acotaciones
        chart.removeLegend();
        //Personalizas la grafica
        PiePlot plot = (PiePlot) chart.getPlot();
        //Color de fondo
        plot.setBackgroundPaint(Color.white);
        //Color de las etiquetas
        plot.setLabelBackgroundPaint(null);
        //Eliminar el borede de color
        plot.setOutlineVisible(false);
        //Eliminar la sombra
        plot.setShadowPaint(null);
        //Angulo de posicion
        plot.setStartAngle(45);
        //Contorno de color blanco
        plot.setBaseSectionOutlinePaint(Color.white);
        //Resaltar la seccion
        plot.setExplodePercent("Buena", 0.02);
        plot.setExplodePercent("Mala", 0.02);
        plot.setExplodePercent("Regular", 0.02);
        //Establecer color de secciones
        plot.setSectionPaint("Buena",new Color(3,57,57));
        plot.setSectionPaint("Mala",new Color(6,140,53));
        plot.setSectionPaint("Regular",new Color(157,226,25));
        /*plot.setSectionPaint("Buena",new Color(65,154,217));
        plot.setSectionPaint("Mala",new Color(250,161,37));
        plot.setSectionPaint("Regular",new Color(71,92,102));*/
        //Mostrar los porcentajes en las etiquetas
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));
        //Eliminar sombre de etiqueta
        plot.setLabelShadowPaint(null);
        //Eliminar contorno de etiqueta
        plot.setLabelOutlinePaint(null);
        //Linea de etiquete standar
        plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        //Agregar al panel
        ChartPanel CP = new ChartPanel(chart);
        vp.JPGpastel.add(CP);
    }
    //Grafica de barras
    public void grafica_Barras(){
        //Se almacenan los datos que seran usados en el gráfico
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        //variables para el tamao del Scroll
        int i = 1;
        int dimencionH = 436;
        //Listar datos
        for (Map.Entry<String,Integer> entry: ic.areas().entrySet()) {
            //System.out.println(entry.getKey() + " tiene " + entry.getValue());
            datos.setValue(entry.getValue(),"java",entry.getKey());
            i++;
        } 
        //Se crea el gráfico y se asignan algunas caracteristicas
        JFreeChart barras = ChartFactory.createBarChart
        (
            "Hoa",
            "Áreas",
            "Articulos",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            true
        );  
        //Establecer titulo
        TextTitle titulo = new TextTitle("Articulos por área", new Font ("Verdana", Font.PLAIN , 17));
        titulo.setPosition(RectangleEdge.BOTTOM);
        barras.setTitle(titulo);
        //Remover acotaciones
        barras.removeLegend();
        //Personalizas la grafica
        CategoryPlot plot = (CategoryPlot) barras.getPlot();
        //Color de fondo
        plot.setBackgroundPaint(Color.white);
        //Eliminar el borede de color
        plot.setOutlineVisible(false);
        //Quitar margen
        plot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        //Posicion de la grafica
        plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(new Color(119,119,119));
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        plot.getRenderer().setSeriesPaint(0, new Color(65,154,217));
        NumberAxis range = (NumberAxis)plot.getRangeAxis();
        range.setTickUnit(new NumberTickUnit(20));
        //plot.setRangeGridlineStroke(new BasicStroke(1));
        plot.getDomainAxis().setAxisLinePaint(new Color(187,187,187));
        plot.getDomainAxis().getCategoryMargin();
        plot.getDomainAxis().setLowerMargin(0.15);
        plot.getDomainAxis().setUpperMargin(0.015);
        plot.getDomainAxis().setTickLabelPaint(new Color(119,119,119));
        plot.getDomainAxis().setTickMarksVisible(false);
        
        plot.getRangeAxis().setAxisLineVisible(false);
        plot.getRangeAxis().setTickLabelPaint(new Color(119,119,119));
        plot.getRangeAxis().setTickMarksVisible(false);
        //Agregar al panel
        ChartPanel CP = new ChartPanel(barras);
        //Definir el tamao del Scroll
        if (i > 15) {
            int diferencia = i - 15;
            dimencionH += diferencia * 20;
            this.vp.JPBarras.setPreferredSize(new Dimension(300,dimencionH));
        }
        this.vp.JPBarras.add(CP);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Lanzar ventana para agregar nueva area
        if (ae.getSource() == this.vp.btnAreas) {
            //obtener las coordenadas del raton para que se visualize el JDialog
            Point punto = MouseInfo.getPointerInfo().getLocation();
            int x = punto.x;
            int y = punto.y;
            //Instanciar el modelo tipo
            Area area = new Area();
            //Instanciar el modelo tipoCrud
            AreaCrud areaC = new AreaCrud();
            //Intanciar la ventana de nueva categoria
            viewDialogArea view = new viewDialogArea(null,true);
            view.setTitle("Nueva Area");
            view.setIconImage(new ImageIcon("src/imagenes/areas.png").getImage());
            view.setLocation(x-400, y);
            view.setVisible(true);
            //abrir ventana hasta que el usuasio presione cancelar en el jdialog
            while(view.estado != -1){
                //Obtener los datos de las cajas de texto
                String nombre = view.txtNombre.getText();
                //Ingresar valores al objeto tipo
                area.setDescripcion(nombre);
                //Si el estado es igual a 0 guardara los datos en la DB y se cerrara la ventana
                if (view.estado == 0) {
                    //ingresar los datos a la DB
                    if (!areaC.registrar(area)) {
                        JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    vp.lbareas.setText(Integer.toString(ac.numFilas()));
                    //Romper el ciclo
                    break;
                }
                //ingresar los datos a la DB
                if (!areaC.registrar(area)) {
                    JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                }
                //Resetear las cajas de texto
                view.txtNombre.setText("");
                view.setVisible(true);
                //Actualizar los datos de label areas
                vp.lbareas.setText(Integer.toString(ac.numFilas()));
            }
        }
        
        
        
        //lanzar vantana para agregar una nueva categoria
        if (ae.getSource() == this.vp.btnCategory) {
           //obtener las coordenadas del raton para que se visualize el JDialog
            Point punto = MouseInfo.getPointerInfo().getLocation();
            int x = punto.x;
            int y = punto.y;
            //Instanciar el modelo tipo
            TipoPro tipo = new TipoPro();
            //Instanciar el modelo tipoCrud
            TipoCrud tipoC = new TipoCrud();
            //Intanciar la ventana de nueva categoria
            viewDialogTipo view = new viewDialogTipo(null,true);
            view.setTitle("Nueva Categoria");
            view.setIconImage(new ImageIcon("src/imagenes/categoria.png").getImage());
            view.setLocation(x-400, y);
            view.setVisible(true);
            //abrir ventana hasta que el usuasio presione cancelar en el jdialog
            while(view.estado != -1){
                //Obtener los datos de las cajas de texto
                String nombre = view.txtNombre.getText();
                String descripcion = view.txtDescripcion.getText();
                //Ingresar valores al objeto tipo
                tipo.setNombre(nombre);
                tipo.setDescripcion(descripcion);
                //ingresar los datos a la DB
                if (view.estado == 0) {
                    //ingresar los datos a la DB
                    if (!tipoC.registrar(tipo)) {
                        JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    vp.lbcategorias.setText(Integer.toString(tc.numFilas()));
                    //Romper el ciclo
                    break;
                }
                //ingresar los datos y abrir nuevamente
                if (!tipoC.registrar(tipo)) {
                    JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                }
                //Resetear las cajas de texto
                view.txtNombre.setText("");
                view.txtDescripcion.setText("");
                view.setVisible(true);
                vp.lbcategorias.setText(Integer.toString(tc.numFilas()));
            } 
        }
        
        
        if (ae.getSource() == this.vp.btnEncar) {
           //obtener las coordenadas del raton para que se visualize el JDialog
            Point punto = MouseInfo.getPointerInfo().getLocation();
            int x = punto.x;
            int y = punto.y;
            //Instanciar el modelo Encargado
            Encargado ecgd = new Encargado();
            //Instanciar el modelo tipoCrud
            EncargadoCrud encargadoC = new EncargadoCrud();
            //Intanciar la ventana de nueva categoria
            viewDialogEcgd view = new viewDialogEcgd(null,true);
            view.setTitle("Nuevo Encargado");
            view.setIconImage(new ImageIcon("src/imagenes/usuarios-multiples-en-silueta.png").getImage());
            view.setLocation(x-400, y);
            view.setVisible(true);
            //abrir ventana hasta que el usuasio presione cancelar en el jdialog
            while(view.estado != -1){
                //Obtener los datos de las cajas de texto
                String nombre = view.txtNombre.getText();
                String ap1 = view.txtAp1.getText();
                String ap2 = view.txtAp2.getText();
                String cargo = view.txtCargo.getText();
                //Ingresar valores al objeto tipo
                ecgd.setNombre(nombre);
                ecgd.setAp1(ap1);
                ecgd.setAp2(ap2);
                ecgd.setCargo(cargo);
                //Si solo se quiere ingresar un registro y salir de dialof
                if (view.estado == 0) {
                    //ingresar los datos a la DB
                    if (!encargadoC.registrar(ecgd)) {
                        JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    //Actualizar la etiqueta de encargado
                    vp.lbencargados.setText(Integer.toString(ec.numFilas()));
                    //Romper el ciclo
                    break;
                }
                //ingresar los datos a la DB
                if (!encargadoC.registrar(ecgd)) {
                    JOptionPane.showMessageDialog(null,"; (\nDebio Ocurrir un error","Aviso",JOptionPane.ERROR_MESSAGE);
                }
                //Resetear las cajas de texto
                view.txtNombre.setText("");
                view.txtAp1.setText("");
                view.txtAp2.setText("");
                view.txtCargo.setText("");
                view.setVisible(true);
                //Actualizar la etiqueta de encargado
                vp.lbencargados.setText(Integer.toString(ec.numFilas()));
            }
        }
        if (ae.getSource() == this.vp.btninvetario) {
            
        }
    }
}
