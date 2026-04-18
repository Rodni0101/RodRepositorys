package sistemagestiontramites;

public class TarjetaIdentidad extends Tramite{
    private double Descuento;

    public TarjetaIdentidad(double Descuento, String Ciudadano, double costoBase) {
        super(Ciudadano, costoBase);
        this.Descuento = Descuento;
    }

    public TarjetaIdentidad() {
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        if(Descuento >= 0 && Descuento <= 100){
        this.Descuento = Descuento;
        }
    }
    @Override
        public double calcularCostoFinal(){
        return getCostoBase() - (getCostoBase() * Descuento);
    }
}
