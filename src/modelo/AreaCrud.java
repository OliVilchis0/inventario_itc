package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AreaCrud extends Conexion{
    //Ingresa un registro 
    public boolean registrar(Area a){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO area (id,descripcion) VALUES(null,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getDescripcion());
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
    public boolean modificar(Area a){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE area SET descripcion=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getDescripcion());
            ps.setInt(2, a.getId());
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
    public boolean Eliminar(Area a){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM area WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getId());
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
    public boolean buscar(Area a){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM area WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setDescripcion(rs.getString("descripcion"));
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
    public ArrayList<Area> consulta(){
        ArrayList consulta = new ArrayList();
        Area a;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * from area";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                a = new Area();
                a.setId(rs.getInt(1));
                a.setDescripcion(rs.getString(2));
                consulta.add(a);
            }
        } catch (Exception e) {
        }
        return consulta;
    }
    //Consultar el numero de filas
        public int numFilas(){
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(*) FROM area";
        
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
