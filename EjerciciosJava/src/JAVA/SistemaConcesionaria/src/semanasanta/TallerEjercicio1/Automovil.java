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
        if(Impuesto >= 0){
        this.Impuesto = Impuesto;
        }else{
            System.out.println("!!!\"Error impuesto no valido\"!!!  ");
        }
    }
    
    @Override
    public double calcularPrecioFinal(){
        double precioFinal = getPrecioBase() + (Impuesto * getPrecioBase());
        return precioFinal;
    }
}
