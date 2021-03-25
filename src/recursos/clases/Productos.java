package recursos.clases;

public class Productos {
    private String Nombre;
    private int Precio;
    private int Codigo;
    public Productos(){
    }
    public Productos(String Nombre, int Precio, int Codigo){
        this.Nombre =Nombre;
        this.Precio =Precio;
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        this.Precio = precio;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }
}
