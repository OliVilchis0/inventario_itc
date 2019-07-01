package controlador;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public class codigoQR {
    
    private String datos;
    private int tAncho = 400;
    private int tAlto = 400;
    private BitMatrix bm;
    private Writer writer;
    private BufferedImage imagen;
    
    public codigoQR(String datos){
        this.datos = datos;
        this.writer = new QRCodeWriter();
        this.codigo();
    }
    
    //metodo para generar codigo qr
    public void codigo(){
        try {
            //generar matriz con formato qr
            bm = writer.encode(datos, BarcodeFormat.QR_CODE, tAncho, tAlto);
            //instanciar buffer para poder escribirn en el dico duro
            imagen = new BufferedImage(tAncho,tAlto,BufferedImage.TYPE_INT_RGB);
            //crear codigo qr
            for (int y = 0; y < tAncho; y++) {
                for (int x = 0; x < tAlto; x++) {
                    int grayvalue = (bm.get(x, y) ? 1 : 0) & 0xff;
                    imagen.setRGB(x, y, (grayvalue ==  0 ? 0 : 0xffffff));
                }
            }
            //Invertir los colores que se crearon con la instruccion anterior
            imagen = this.invertir(imagen);
            //establecer ruta
            FileOutputStream qrCode = new FileOutputStream(this.ruta()+"/"+this.datos+".gif");
            ImageIO.write(imagen,"gif", qrCode);
            qrCode.close();
            
            /*Desktop d = Desktop.getDesktop();
            d.open(new File(System.getProperty("user.home")+"/qr.gif"));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //Invertir colores
    public BufferedImage invertir(BufferedImage imagen){
        for (int x = 0; x < tAncho; x++) {
            for (int y = 0; y < tAlto; y++) {
                int rgb = imagen.getRGB(x, y);
                if (rgb == -16777216) {
                    imagen.setRGB(x, y, -1);
                }else{
                    imagen.setRGB(x, y, -16777216); 
                }
            }
        }
        return imagen; 
    }
    
    //obtener la imagen del codigo qr para insertarlo en la DB
    public FileInputStream getQR(){
        FileInputStream imagen = null;
        try {
            //abrir imagen
            File ruta = new File(this.ruta()+"/"+this.datos+".gif");
            imagen = new FileInputStream(ruta);
        } catch (Exception e) {
            System.out.println("error");
        }
        return imagen;
    }
    
    
    //Ruta donde se crearan los archivos
    public String ruta(){
        String dir = "";
        File ruta = new File("./codigosQR");
        try {
            dir = ruta.getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }
    
    
    public void borrarArchivos(){
        File direccion = new File(this.ruta());
        String[] archivos;
        if (direccion.isDirectory()) {
            archivos = direccion.list();
            for(String a : archivos){
                File f = new File(this.ruta()+"/"+a);
                f.delete();
            }
        }else{
            System.out.println("no existe el directorio");
        }
    }
}
