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
        if(Descuento >= 0 && Descuento <= 100){
        this.Descuento = Descuento;
        }else{
            System.out.println("!!!\"Error el porcentaje debe esta entre 0 y 100\"!!!");
        }
    }
    
    @Override
    public double calcularPrecioFinal(){
        double DescuentoAplicado = getPrecioBase()- (getPrecioBase() * Descuento);
        return DescuentoAplicado;
    }
}
