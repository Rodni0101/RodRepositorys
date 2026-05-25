package semanasanta.TallerEjercicio1;

public class Automovil extends Vehiculo{
    private double Impuesto;

    public Automovil(double Impuesto, String Marca, double PrecioBase) {
        super(Marca, PrecioBase);
        this.Impuesto = Impuesto;
    }

    public Automovil() {
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double Impuesto) {
        this.Impuesto = Impuesto;
    }
    
    @Override
    public void calcularPrecioFinal(){
        System.out.println("Marca = " + getMarca());
        System.out.println("Precio Base = " + getPrecioBase());
        double precioFinal = getPrecioBase() + (Impuesto * getPrecioBase());
        System.out.println("Total a pagar = " + precioFinal);
    }
}
