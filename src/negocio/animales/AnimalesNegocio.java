package negocio.animales;

import datos.animales.AnimalesDatos;
import recursos.clases.Animales;

import java.util.ArrayList;
import java.util.List;

public class AnimalesNegocio {
    public List<Animales> Leer(){
        List<Animales> listaAnimales = new ArrayList<>();
        try {
            listaAnimales = AnimalesDatos.LeerAnimales();
        }catch (Exception e){

        }
        return listaAnimales;
    }
    public String Insertar(Animales animales){
        String respuesta = "Error";
        try {
            if (animales.getRaza().isEmpty()){
                throw new Exception("Error:La Raza del Animal no debe estar Vacia");
            }
            if (animales.getNombre().isEmpty()){
                throw new Exception("Error:El Nombre del Animal no debe estar Vacio");
            }
            if (animales.getTamaño().isEmpty()){
                throw new Exception("Error:El Tamaño del Animal no debe estar Vacio");
            }
            if (animales.getFechaNacimiento().toString().isEmpty()){
                throw new Exception("Error:Fecha incorrecta");
            }
            respuesta= AnimalesDatos.InsertarAnimales(animales);
            if (respuesta==null){
                respuesta="Guardado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }
    }
    public void Actualizar(Animales animales){
        try {
            AnimalesDatos.ActualizarAnimales(animales);
            //Faltan Validaciones
        }catch (Exception e){
        }
    }
    public void Eliminar(Animales animales){
        try {
            AnimalesDatos.EliminarAnimales(animales);
        }catch (Exception e){
        }
    }
    public List<Animales> Buscar(Animales animales) throws Exception{
        List<Animales> listaAnimales = new ArrayList<>();
        try {
            listaAnimales = AnimalesDatos.BuscarAnimales(animales);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaAnimales;
    }
}
