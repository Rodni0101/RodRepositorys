package polimorfismo.Ejercicio;

public class Producto {
    protected String nombre;
    protected int Cantidad;
    protected double Precio;

    public Producto(String nombre, int Cantidad, double Precio) {
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }
    
    public Producto(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    //Las funciones que se van a heredar solo retornan no imprimen
    public String NombreProducto(){
        return nombre;
    }
    public double calcularProducto(){
        return Precio * Cantidad;
    }

}
