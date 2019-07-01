package modelo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class codigoQrCrud extends Conexion{
    
    
    //Ingresa un registro 
    public boolean registrar(CodigoQR codigo){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO codigoqr (id,imagen,status) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo.getId());
            ps.setBinaryStream(2, codigo.getImagen());
            ps.setByte(3, codigo.getStatus());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    //Modifica un registro 
    public boolean modificar(CodigoQR codigo){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE codigoqr SET imagen=?,status=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo.getId());
            ps.setBinaryStream(2, codigo.getImagen());
            ps.setByte(3, codigo.getStatus());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
     //Eliminar un registro
    public boolean Eliminar(CodigoQR codigo){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM codigoqr WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    //consultar todos los registros
    public ArrayList<CodigoQR> consulta(){
        ArrayList consulta = new ArrayList();
        CodigoQR codigo;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * from codigoqr";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                codigo = new CodigoQR();
                codigo.setId(rs.getString(1));
                codigo.setImagen((FileInputStream) rs.getBinaryStream(2));
                codigo.setStatus(rs.getByte(3));
                consulta.add(codigo);
            }
        } catch (Exception e) {
        }
        return consulta;
    }
}
