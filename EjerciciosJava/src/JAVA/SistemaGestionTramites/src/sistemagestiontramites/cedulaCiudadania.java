package sistemagestiontramites;

public class cedulaCiudadania extends Tramite{
    private double recargoUrgente;

    public cedulaCiudadania(double recargoUrgente, String Ciudadano, double costoBase) {
        super(Ciudadano, costoBase);
        this.recargoUrgente = recargoUrgente;
    }

    public cedulaCiudadania() {
    }

    public double getRecargoUrgente() {
        return recargoUrgente;
    }

    public void setRecargoUrgente(double recargoUrgente) {
        if(recargoUrgente >= 0){
        this.recargoUrgente = recargoUrgente;
        }
    }
    @Override
        public double calcularCostoFinal(){
        return getCostoBase() + recargoUrgente;
    }
}
