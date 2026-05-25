package sistemagestiontramites;

public class Tramite {
    private String Ciudadano;
    private double costoBase;

    public Tramite(String Ciudadano, double costoBase) {
        this.Ciudadano = Ciudadano;
        this.costoBase = costoBase;
    }

    public Tramite() {
    }

    public String getCiudadano() {
        return Ciudadano;
    }

    public void setCiudadano(String Ciudadano) {
        this.Ciudadano = Ciudadano;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        if(costoBase > 0){
        this.costoBase = costoBase;
        }else{
            System.out.println("El valor no puede ser negativo");
        }
    }
    public double calcularCostoFinal(){
        return costoBase;
    }
}
