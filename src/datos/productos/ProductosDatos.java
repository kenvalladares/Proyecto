package datos.productos;

import datos.conexion.Conexion;
import recursos.clases.Doctores;
import recursos.clases.Productos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosDatos {
    public static List<Productos> LeerProductos(){
        List<Productos> listaProductos = new ArrayList<Productos>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Precio, Codigo FROM Productos";
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
               Productos productos = new Productos();
               productos.setNombre(rs.getString(1));
                productos.setPrecio(rs.getInt(2));
               productos.setCodigo(rs.getInt(3));


               listaProductos.add(productos);
            }
            cn.close();
        }catch (Exception e){

        }
        return listaProductos;
    }
    public static String InsertarProductos(Productos productos){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "INSERT INTO Productos VALUES(?,?,?)";
            PreparedStatement ps  = cn.prepareStatement(sql);
            ps.setString(1,productos.getNombre());
            ps.setInt(2,productos.getPrecio());
            ps.setInt(3,productos.getCodigo());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+e.getMessage();
        }
        return null;
    }
    public static String ActualizarProductos(Productos productos){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "UPDATE Productos SET Precio =?, Codigo =?,  WHERE Nombre=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,productos.getPrecio());
            ps.setInt(2,productos.getCodigo());
            ps.setString(3,productos.getNombre());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static String EliminarProductos(Productos productos){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "DELETE FROM Productos WHERE Nombre=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,productos.getNombre());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static List<Productos> BuscarProductos(Productos productos)throws SQLException {
        List<Productos> listaProductos= new ArrayList<Productos>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql= "SELECT Nombre, Precio, Codigo FROM Productos WHERE Nombre= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+productos.getNombre().toLowerCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                do {
                    Productos productoObjeto=new Productos();
                    productoObjeto.setNombre(rs.getString(1));
                    productoObjeto.setPrecio(rs.getInt(2));
                    productoObjeto.setPrecio(rs.getInt(3));
                    listaProductos.add(productoObjeto);
                }while (rs.next());
            }
            else{
                throw new SQLException("Error no se encontro coicidencia");
            }
            cn.close();
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaProductos;

    }
}
