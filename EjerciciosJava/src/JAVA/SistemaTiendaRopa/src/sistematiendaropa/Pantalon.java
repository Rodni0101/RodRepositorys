package sistematiendaropa;

public class Pantalon extends Producto{
private double Impuesto;

    public Pantalon(double Impuesto, String Nombre, double PrecioBase) {
        super(Nombre, PrecioBase);
        this.Impuesto = Impuesto;
    }

    public Pantalon() {
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double Impuesto) {
        if(Impuesto >= 0){
        this.Impuesto = Impuesto;
        }else{
            System.out.println("Impuesto no valido");
        }
    }
@Override
    public double CalcularPrecioFinal(){
        double Total = getPrecioBase() + (getPrecioBase() * Impuesto);
        return Total;
    }
}
