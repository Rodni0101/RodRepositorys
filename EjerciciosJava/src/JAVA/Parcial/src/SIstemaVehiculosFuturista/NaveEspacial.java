
package SIstemaVehiculosFuturista;

public class NaveEspacial extends Vehiculo{
    private int tripulacion;
    private String tipoPropulsion;

    public NaveEspacial(int tripulacion, String tipoPropulsion, String Marca, String Modelo, double VelocidadMax, String TipEnergia) {
        super(Marca, Modelo, VelocidadMax, TipEnergia);
        this.tripulacion = tripulacion;
        this.tipoPropulsion = tipoPropulsion;
    }
    
    public NaveEspacial(){
    }
    
    public void setTripulacion(int tripulacion){
        this.tripulacion = tripulacion;
    }
    
    public int getTripulacion(){
        return tripulacion;
    }
    
    public void setTipoPropulsion(String tipoPropulsion){
        this.tipoPropulsion = tipoPropulsion;
    }
    
    public String getTipoPropulsion(){
        return tipoPropulsion;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tripulacion = " + tripulacion);
        System.out.println("Tipo de propulsion = " + tipoPropulsion);
    }
    
}
