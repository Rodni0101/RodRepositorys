package sistemagestiontramites;

public class RegistroCivil extends Tramite{
    private double tarifaFija;

    public RegistroCivil(double tarifaFija, String Ciudadano, double costoBase) {
        super(Ciudadano, costoBase);
        this.tarifaFija = tarifaFija;
    }

    public RegistroCivil() {
    }

    public double getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(double tarifaFija) {
        if(tarifaFija > 0){
        this.tarifaFija = tarifaFija;
        }else{
            System.out.println("La tarifa no puede ser negativa");
        }
    }
    @Override
        public double calcularCostoFinal(){
        return getCostoBase() + tarifaFija;
    }
}
