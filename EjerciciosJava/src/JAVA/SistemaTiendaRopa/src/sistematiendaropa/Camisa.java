package sistematiendaropa;

public class Camisa extends Producto{
private double Descuento;

    public Camisa(double Descuento, String Nombre, double PrecioBase) {
        super(Nombre, PrecioBase);
        this.Descuento = Descuento;
    }

    public Camisa(){
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        if(Descuento >= 0 && Descuento <= 100){
        this.Descuento = Descuento;
        }else{
            System.out.println("El descuento debe estar entre 0 y 100");
        }
    }
    @Override
    public double CalcularPrecioFinal(){
        double Total = getPrecioBase() - (getPrecioBase() * Descuento);
        return Total;
    }
    
}
