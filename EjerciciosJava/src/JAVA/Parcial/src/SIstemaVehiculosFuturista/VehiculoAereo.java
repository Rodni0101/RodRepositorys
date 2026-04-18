
package SIstemaVehiculosFuturista;

public class VehiculoAereo extends Vehiculo{
    private int altitudMax;
    private String tipAlas;

    public VehiculoAereo(int altitudMax, String tipAlas, String Marca, String Modelo, double VelocidadMax, String TipEnergia) {
        super(Marca, Modelo, VelocidadMax, TipEnergia);
        this.altitudMax = altitudMax;
        this.tipAlas = tipAlas;
    }

    public VehiculoAereo(int altitudMax, String tipAlas) {
        this.altitudMax = altitudMax;
        this.tipAlas = tipAlas;
    }

    public VehiculoAereo() {
    }

    public int getAltitudMax() {
        return altitudMax;
    }

    public void setAltitudMax(int altitudMax) {
        this.altitudMax = altitudMax;
    }

    public String getTipAlas() {
        return tipAlas;
    }

    public void setTipAlas(String tipAlas) {
        this.tipAlas = tipAlas;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Altitud maxima = " + altitudMax);
        System.out.println("Tipo de alas = " + tipAlas);
    }
}
