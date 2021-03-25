package recursos.clases;

import java.util.Date;

public class Doctores {
    private long DNI;
    private String Nombre;
    private Date FechaNacimiento;
    private String Especialidad;
    public Doctores(){
    }
    public Doctores(long DNI, String Nombre, Date FechaNacimiento, String Especialidad){
        this.DNI =DNI;
        this.Nombre =Nombre;
        this.FechaNacimiento =FechaNacimiento;
        this.Especialidad=Especialidad;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.Especialidad = especialidad;
    }
}
