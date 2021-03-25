package datos.animales;

import datos.conexion.Conexion;
import recursos.clases.Animales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalesDatos {
    public static List<Animales> LeerAnimales(){
        List<Animales> listaAnimales = new ArrayList<Animales>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Raza, Nombre, Tamaño, FechaNacimiento, Tipo FROM Animales";
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                Animales animales = new Animales();
                animales.setRaza(rs.getString(1));
                animales.setNombre(rs.getString(2));
                animales.setTamaño(rs.getString(3));
                animales.setFechaNacimiento(rs.getDate(4));
                animales.setTipo(rs.getString(5));
                listaAnimales.add(animales);
            }
            cn.close();
        }catch (Exception e){

        }
        return listaAnimales;
    }
    public static String InsertarAnimales(Animales animales){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "INSERT INTO Animales VALUES(?,?,?,?,?)";
            PreparedStatement ps  = cn.prepareStatement(sql);
            ps.setString(1,animales.getRaza());
            ps.setString(2,animales.getNombre());
            ps.setString(3,animales.getTamaño());
            ps.setDate(4,new java.sql.Date(animales.getFechaNacimiento().getTime()));
            ps.setString(5,animales.getTipo());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+e.getMessage();
        }
        return null;
    }
    public static String ActualizarAnimales(Animales animales){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "UPDATE Animales SET Nombre =?, Tamaño=?, FechaNacimiento =?,Tipo =? WHERE Raza=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,animales.getNombre());
            ps.setString(2,animales.getTamaño());
            ps.setDate(3,new java.sql.Date(animales.getFechaNacimiento().getTime()));
            ps.setString(4,animales.getTipo());
            ps.setString(5,animales.getRaza());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static String EliminarAnimales(Animales animales){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "DELETE FROM Animales WHERE Raza=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,animales.getRaza());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static List<Animales> BuscarAnimales(Animales animales)throws SQLException {
        List<Animales> listaAnimales= new ArrayList<Animales>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql= "SELECT Raza, Nombre, Tamaño, FechaNacimiento, Tipo FROM Animales WHERE UPPER(Raza) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+animales.getNombre().toLowerCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                do {
                    Animales animalObjeto=new Animales();
                    animalObjeto.setRaza(rs.getString(1));
                    animalObjeto.setNombre(rs.getString(2));
                    animalObjeto.setTamaño(rs.getString(3));
                    animalObjeto.setFechaNacimiento(rs.getDate(4));
                    animalObjeto.setTipo(rs.getString(5));
                    listaAnimales.add(animalObjeto);
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
        return listaAnimales;

    }
}
