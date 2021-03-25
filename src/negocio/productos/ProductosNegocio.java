package negocio.productos;

import datos.doctores.DoctoresDatos;
import datos.productos.ProductosDatos;
import recursos.clases.Doctores;
import recursos.clases.Productos;

import java.util.ArrayList;
import java.util.List;

public class ProductosNegocio {
    public List<Productos> Leer(){
        List<Productos> listaProductos = new ArrayList<>();
        try {
            listaProductos = ProductosDatos.LeerProductos();


        }catch (Exception e){

        }
        return listaProductos;
    }
    public String Insertar(Productos productos){
        String respuesta = "Error";
        try {

            if (productos.getNombre().isEmpty()){
                throw new Exception("Error:El Nombre no debe estar Vacio");
            }
            if (productos.getPrecio()<=0){
                throw new Exception("Error: El Precio no debe ser mayor a 0");
            }
            if (productos.getCodigo()<=0){
                throw new Exception("Error: El Codigo no debe ser menor a 0");
            }
            respuesta= ProductosDatos.InsertarProductos(productos);
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
    public void Actualizar(Productos productos){
        try {
            ProductosDatos.ActualizarProductos(productos);
            //Faltan Validaciones
        }catch (Exception e){
        }
    }
    public void Eliminar(Productos productos){
        try {
            ProductosDatos.EliminarProductos(productos);
        }catch (Exception e){
        }
    }
    public List<Productos> Buscar(Productos productos) throws Exception{
        List<Productos> listaProductos = new ArrayList<>();
        try {
            listaProductos = ProductosDatos.BuscarProductos(productos);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaProductos;
    }
}
