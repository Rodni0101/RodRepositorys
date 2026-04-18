package polimorfismo.Ejercicio;

public class ConDescuento extends Producto{
    protected double Descuento;

    public ConDescuento(String nombre, int Cantidad, double Precio) {
        super(nombre, Cantidad, Precio);
    }
    
    public ConDescuento(){
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }
    @Override
    public String NombreProducto(){
        System.out.println("Nombre del producto: ");
        return nombre;
    }
    @Override
    public double calcularProducto(){
        return super.calcularProducto() * (1 - Descuento);
    }
}
