
package SIstemaVehiculosFuturista;

public class VehiculoTerrestre extends Vehiculo{
    private int numRuedas;
    private String tipTerreno;

    public VehiculoTerrestre(int numRuedas, String tipTerreno, String Marca, String Modelo, double VelocidadMax, String TipEnergia) {
        super(Marca, Modelo, VelocidadMax, TipEnergia);
        this.numRuedas = numRuedas;
        this.tipTerreno = tipTerreno;
    }

    public VehiculoTerrestre(int numRuedas, String tipTerreno) {
        this.numRuedas = numRuedas;
        this.tipTerreno = tipTerreno;
    }

    public VehiculoTerrestre() {
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public String getTipTerreno() {
        return tipTerreno;
    }

    public void setTipTerreno(String tipTerreno) {
        this.tipTerreno = tipTerreno;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de Ruedas = " + numRuedas);
        System.out.println("Tipo de Terreno = " + tipTerreno);
    }
}
