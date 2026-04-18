
package sistemadecriaturas;

public class CriaturaTerrestre extends Criatura{
    private int Fuerza;

    public CriaturaTerrestre(int Fuerza, String Nombre, int nivelEnergia, String tipoADN) {
        super(Nombre, nivelEnergia, tipoADN);
        this.Fuerza = Fuerza;
    }

    public CriaturaTerrestre() {

    }

    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int Fuerza) {
        if(Fuerza >= 0){
        this.Fuerza = Fuerza;
        }else{
            System.out.println("Valor invalido");
        }
    }
    @Override
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Fuerza = " + Fuerza);
    }
}
