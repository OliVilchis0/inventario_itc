package modelo;

import com.mysql.jdbc.Blob;
import java.io.FileInputStream;

public class CodigoQR {
    private String id;
    private FileInputStream imagen;
    private byte status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
