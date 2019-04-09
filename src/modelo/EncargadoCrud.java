package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EncargadoCrud extends Conexion{
    //Ingresa un registro 
    public boolean registrar(Encargado encargado){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO encargado (nombre,apellido_p,apellido_m,puesto) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, encargado.getNombre());
            ps.setString(2, encargado.getAp1());
            ps.setString(3, encargado.getAp2());
            ps.setString(4, encargado.getCargo());
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
    public boolean modificar(Encargado encargado){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE encargado SET nombre=?,apellido_p=?,apellido_m=?,puesto=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, encargado.getNombre());
            ps.setString(2, encargado.getAp1());
            ps.setString(3, encargado.getAp2());
            ps.setString(4, encargado.getCargo());
            ps.setInt(5, encargado.getId());
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
    public boolean Eliminar(Encargado encargado){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM encargado WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, encargado.getId());
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
     //Consultar un registro
    public boolean buscar(Encargado encargado){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM encargado WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, encargado.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                encargado.setId(Integer.parseInt(rs.getString("id")));
                encargado.setNombre(rs.getString("nombre"));
                encargado.setAp1(rs.getString("apellido_p"));
                encargado.setAp2(rs.getString("apellido_m"));
                encargado.setCargo(rs.getString("puesto"));
                return true;
            }
            return false;
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
    public ArrayList<Encargado> consulta(){
        ArrayList consulta = new ArrayList();
        Encargado encargado;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * from encargado";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                encargado = new Encargado();
                encargado.setId(rs.getInt(1));
                encargado.setNombre(rs.getString(2));
                encargado.setAp1(rs.getString(3));
                encargado.setAp2(rs.getString(4));
                encargado.setCargo(rs.getString(5));
                consulta.add(encargado);
            }
        } catch (Exception e) {
        }
        return consulta;
    }
     //Consultar el numero de filas
        public int numFilas(){
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(*) FROM encargado";
        
        try {
           Statement stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           while (rs.next()){
               return rs.getInt(1);
           }
           
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return 0;
    }
}
