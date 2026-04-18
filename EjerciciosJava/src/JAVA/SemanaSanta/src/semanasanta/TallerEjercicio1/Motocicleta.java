package semanasanta.TallerEjercicio1;

public class Motocicleta extends Vehiculo{
    private double Descuento;

    public Motocicleta(double Descuento, String Marca, double PrecioBase) {
        super(Marca, PrecioBase);
        this.Descuento = Descuento;
    }

    public Motocicleta() {
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }
    
    @Override
    public void calcularPrecioFinal(){
        System.out.println("Marca = " + getMarca());
        System.out.println("Precio Base = " + getPrecioBase());
        double DescuentoAplicado = getPrecioBase()- (getPrecioBase() * Descuento);
        System.out.println("Total a pagar = " + DescuentoAplicado);
    }
}
