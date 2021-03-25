package datos.doctores;

import datos.conexion.Conexion;
import recursos.clases.Animales;
import recursos.clases.Doctores;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctoresDatos {
    public static List<Doctores> LeerDoctores(){
        List<Doctores> listaDoctores = new ArrayList<Doctores>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT DNI, Nombre, FechaNacimiento, Especialidad FROM Doctores";
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                Doctores doctores = new Doctores();
                doctores.setDNI(rs.getLong(1));
                doctores.setNombre(rs.getString(2));
                doctores.setFechaNacimiento(rs.getDate(3));
                doctores.setEspecialidad(rs.getString(4));
                listaDoctores.add(doctores);
            }
            cn.close();
        }catch (Exception e){

        }
        return listaDoctores;
    }
    public static String InsertarDoctores(Doctores doctores){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "INSERT INTO Doctores VALUES(?,?,?,?)";
            PreparedStatement ps  = cn.prepareStatement(sql);
            ps.setLong(1,doctores.getDNI());
            ps.setString(2,doctores.getNombre());
            ps.setDate(3,new java.sql.Date(doctores.getFechaNacimiento().getTime()));
            ps.setString(4,doctores.getEspecialidad());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+e.getMessage();
        }
        return null;
    }
    public static String ActualizarDoctores(Doctores doctores){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "UPDATE Doctores SET Nombre =?, FechaNacimiento =?, Especialidad =? WHERE DNI=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,doctores.getNombre());
            ps.setDate(2,new java.sql.Date(doctores.getFechaNacimiento().getTime()));
            ps.setString(3,doctores.getEspecialidad());
            ps.setLong(4,doctores.getDNI());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static String EliminarDoctores(Doctores doctores){
        try {
            Connection cn = Conexion.obetenerConexion();
            String sql = "DELETE FROM Doctores WHERE DNI=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,doctores.getDNI());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error:"+ e.getMessage();
        }
        return null;
    }
    public static List<Doctores> BuscarDoctores(Doctores doctores)throws SQLException {
        List<Doctores> listaDoctores= new ArrayList<Doctores>();
        try {
            Connection cn = Conexion.obetenerConexion();
            Statement st = cn.createStatement();
            String sql= "SELECT DNI, Nombre, FechaNacimiento, Especialidad FROM Doctores WHERE DNI= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+doctores.getNombre().toLowerCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                do {
                    Doctores doctorObjeto=new Doctores();
                    doctorObjeto.setDNI(rs.getLong(1));
                    doctorObjeto.setNombre(rs.getString(2));
                    doctorObjeto.setFechaNacimiento(rs.getDate(3));
                    doctorObjeto.setEspecialidad(rs.getString(4));
                    listaDoctores.add(doctorObjeto);
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
        return listaDoctores;

    }

}
