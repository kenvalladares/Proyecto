package negocio.doctores;

import datos.doctores.DoctoresDatos;
import recursos.clases.Doctores;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DoctoresNegocio {
    public List<Doctores> Leer(){
        List<Doctores> listaDoctores = new ArrayList<>();
        try {
            listaDoctores = DoctoresDatos.LeerDoctores();


        }catch (Exception e){

        }
        return listaDoctores;
    }
    public String Insertar(Doctores doctores){
        String respuesta = "Error";
        try {
            if (doctores.getDNI()<=0){
                throw new Exception("Error: El DNI no debe ser mayor a 0");
            }
            if (doctores.getNombre().isEmpty()){
                throw new Exception("Error:El Nombre no debe estar Vacio");
            }

            if (doctores.getFechaNacimiento().toString().isEmpty()){
                throw new Exception("Error:Fecha incorrecta");
            }
            if (doctores.getEspecialidad().isEmpty()){
                throw new Exception("Error:La especialidad no debe estar Vacio");
            }
            respuesta= DoctoresDatos.InsertarDoctores(doctores);
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
    public void Actualizar(Doctores doctores){
        try {
            DoctoresDatos.ActualizarDoctores(doctores);
            //Faltan Validaciones
        }catch (Exception e){
        }
    }
    public void Eliminar(Doctores doctores){
        try {
            DoctoresDatos.EliminarDoctores(doctores);
        }catch (Exception e){
        }
    }
    public List<Doctores> Buscar(Doctores doctores) throws Exception{
        List<Doctores> listaDoctores = new ArrayList<>();
        try {
            listaDoctores = DoctoresDatos.BuscarDoctores(doctores);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaDoctores;
    }
}
