package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.AreaCrud;
import modelo.EncargadoCrud;
import modelo.InventarioCrud;
import modelo.TipoCrud;
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
import vista.viewPrincipal;

public class ctrlPrincipal {
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
       // this.grafica_Barras();
        this.grafica_Pastel();
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
        TextTitle titulo = new TextTitle("Condicion de inventario", new Font ("Verdana", Font.PLAIN , 17));
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
        ChartPanel CP = new ChartPanel(chart);
        vp.JPGpastel.add(CP);
    }
    //Grafica de barras
    /*public void grafica_Barras(){
        //Se almacenan los datos que seran usados en el gráfico
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        //Configurar datos de areas
        /*for (int i = 0; i < ic.areas().size(); i++) {
          datos.setValue(,"java",ic.areas().get(i));  
        }*/
        /*for (Map.Entry<String,Integer> entry: ic.areas().entrySet()) {
            //System.out.println(entry.getKey() + " tiene " + entry.getValue());
            datos.setValue(entry.getValue(),"java",entry.getKey());
        }
          //Se crea el gráfico y se asignan algunas caracteristicas
        JFreeChart barras = ChartFactory.createBarChart
        (
            "",
            "Areas",
            "Articulos",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );  
        //Establecer titulo
        TextTitle titulo = new TextTitle("Articulos por area", new Font ("Verdana", Font.PLAIN , 17));
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
        vp.JPGbarras.add(CP);
    }
   */
}
