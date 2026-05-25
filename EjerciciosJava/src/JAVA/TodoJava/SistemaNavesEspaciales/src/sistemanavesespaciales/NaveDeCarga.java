package sistemanavesespaciales;

public class NaveDeCarga extends Nave{
    private int Carga;

    public NaveDeCarga(int Carga, double Velocidad, String tipoCombustible, String Nombre) {
        super(Velocidad, tipoCombustible, Nombre);
        this.Carga = Carga;
    }

    

    public NaveDeCarga() {
    }

    public double getCarga() {
        return Carga;
    }

    public void setCarga(int Carga) {
        if(Carga >= 0 && Carga <= 100){
        this.Carga = Carga;
        }else{
            System.out.println("Carga invalida");
        }
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Carga actual: " + Carga + " KG");
    }
}