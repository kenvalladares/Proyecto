package recursos.clases;

import java.util.Date;

public class Animales {
    private String Raza;
    private String Nombre;
    private String Tamaño;
    private Date FechaNacimiento;
    private String Tipo;
    public Animales(){
    }
    public Animales(String Raza, String Nombre, String Tamaño, Date FechaNacimiento, String Tipo){
        this.Raza = Raza;
        this.Nombre = Nombre;
        this.Tamaño = Tamaño;
        this.FechaNacimiento = FechaNacimiento;
        this.Tipo = Tipo;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        this.Raza =raza;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getTamaño(){
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        this.Tamaño = tamaño;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }
}
