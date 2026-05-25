package sistemanavesespaciales;

public class NaveTripulada extends Nave{
    private int cantPasajeros;

    public NaveTripulada(int cantPasajeros, double Velocidad, String tipoCombustible, String Nombre) {
        super(Velocidad, tipoCombustible, Nombre);
        this.cantPasajeros = cantPasajeros;
    }



    public NaveTripulada() {
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        if(cantPasajeros > 0 && cantPasajeros <= 100){
        this.cantPasajeros = cantPasajeros;
        }else{
            System.out.println("La cantidad de pasajeros debe de ser entre 1 a 100");
        }
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Cantidad de pasajeros: " + cantPasajeros);
    }
}
