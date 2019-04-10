package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class InventarioCrud extends Conexion{
    //Ingresa un registro 
    public boolean registrar(Inventario mt){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO inventario (id,id_tipo,descripcion,marca,modelo,e_fisico,id_area,id_nombre,detalle) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mt.getId());
            ps.setInt(2, mt.getId_tipo());
            ps.setString(3, mt.getDescripcion());
            ps.setString(4, mt.getMarca());
            ps.setString(5, mt.getModelo());
            ps.setByte(6, mt.getE_fisico());
            ps.setInt(7, mt.getId_area());
            ps.setInt(8, mt.getId_encargado());
            ps.setString(9, mt.getDetalles());
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
    public boolean modificar(Inventario mt){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE invetario SET id_tipo=?,descripcion=?,marca=?,modelo=?,e_fisico=?,id_area=?,id_nombre=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mt.getId_tipo());
            ps.setString(2, mt.getDescripcion());
            ps.setString(3, mt.getMarca());
            ps.setString(4, mt.getModelo());
            ps.setByte(6, mt.getE_fisico());
            ps.setInt(7, mt.getId_area());
            ps.setInt(8, mt.getId_encargado());
            ps.setString(9, mt.getId());
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
    public boolean Eliminar(Inventario mt){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM inventario WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mt.getId());
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
    public boolean buscar(Inventario mt){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM inventario WHERE descripcion LIKE ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+mt.getDescripcion()+"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                mt.setId(rs.getString("id"));
                mt.setId_tipo(Integer.parseInt(rs.getString("id_tipo")));
                mt.setDescripcion(rs.getString("descripcion"));
                mt.setMarca(rs.getString("marca"));
                mt.setModelo(rs.getString("modelo"));
                mt.setId_area(Integer.parseInt(rs.getString("id_area")));
                mt.setId_area(Integer.parseInt(rs.getString("id_nombre")));
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
    public ArrayList<Inventario> consulta_m()
    {
        ArrayList consulta_m = new ArrayList();
        Inventario material;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * from inventario";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                material = new Inventario();
                material.setId(rs.getString(1));
                material.setId_tipo(rs.getInt(2));
                material.setDescripcion(rs.getString(3));
                material.setMarca(rs.getString(4));
                material.setModelo(rs.getString(5));
                material.setE_fisico(rs.getByte(6));
                material.setId_area(rs.getInt(7));
                material.setId_encargado(rs.getInt(8));
                material.setDetalles(rs.getString(9));
                consulta_m.add(material);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consulta_m;
    }
    //consultar todos los registros de la vista inventario
    public ArrayList<inventarioVista> consultaVista()
    {
        ArrayList consulta = new ArrayList();
        inventarioVista iVista;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = "SELECT * FROM inventariovista";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                iVista = new inventarioVista();
                iVista.setCodigo(rs.getString(1));
                iVista.setCategory(rs.getString(2));
                iVista.setDescripcion(rs.getString(3));
                iVista.setMarca(rs.getString(4));
                iVista.setModelo(rs.getString(5));
                iVista.setEstadoFisico(rs.getByte(6));
                iVista.setArea(rs.getString(7));
                iVista.setEncargado(rs.getString(8));
                iVista.setDetalle(rs.getString(9));
                consulta.add(iVista);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consulta;
    }
    //Obtener el numero de regitros de la tabla inventario
    public int numFilas(){
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(*) FROM inventario";
        
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
    //Obtener numero de estados
    public int[] Condicion(){
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Connection con = getConexion();
        int datos[] = new int[3];
        
        String sql1 = "SELECT count(*) FROM inventario WHERE e_fisico=-1";
        String sql2 = "SELECT count(*) FROM inventario WHERE e_fisico=0";
        String sql3 = "SELECT count(*) FROM inventario WHERE e_fisico=1";
        
        try {
           Statement stmt = con.createStatement();
           rs1 = stmt.executeQuery(sql1);
           while (rs1.next()){
               datos[0] = rs1.getInt(1);
           }
           rs2 = stmt.executeQuery(sql2);
           while (rs2.next()){
               datos[1] = rs2.getInt(1);
           }
           
           rs3 = stmt.executeQuery(sql3);
           while (rs3.next()){
               datos[2] = rs3.getInt(1);
           }
           
        } catch (SQLException e) {
            System.err.println(e);
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }
    //Obtener nombres de areas
    public Map<String, Integer> areas(){
        Map<String, Integer> areas = new HashMap<String, Integer>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
        
            String sql = " SELECT a.descripcion AS Area,count(*) AS Total FROM inventario, area AS a "
                    + "WHERE id_area=a.id GROUP BY id_area";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //rs.next();
            while(rs.next()){
                areas.put(rs.getString(1),rs.getInt(2));
            }
        } catch (Exception e) {
        }
        return areas;
    }
}
