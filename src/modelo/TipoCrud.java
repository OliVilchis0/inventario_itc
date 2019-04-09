package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoCrud extends Conexion{
    
     //Ingresa un registro 
    public boolean registrar(TipoPro tp){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO tipo (id,nombre,descripcion) VALUES(null,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,tp.getNombre());
            ps.setString(2, tp.getDescripcion());
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
    public boolean modificar(TipoPro tp){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE tipo SET nombre = ? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getNombre());
            ps.setInt(6, tp.getId());
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
    public boolean Eliminar(TipoPro tp){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM tipo WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tp.getId());
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
    public boolean buscar(TipoPro tp){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM tipo WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tp.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tp.setId(Integer.parseInt(rs.getString("id")));
                //mt.setId_tipo(Integer.parseInt(rs.getString("id_tipo")));
                tp.setNombre(rs.getString("nombre"));
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
    public ArrayList<TipoPro> consulta(){
        ArrayList consulta = new ArrayList();
        TipoPro tp;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * FROM tipo";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tp = new TipoPro();
                tp.setId(rs.getInt(1));
                tp.setNombre(rs.getString(2));
                tp.setDescripcion(rs.getString(3));
                consulta.add(tp);
            }
        } catch (Exception e) {
        }
        return consulta;
    }
     //Consultar el numero de filas
        public int numFilas(){
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(*) FROM tipo";
        
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
