package sistemanavesespaciales;

public class NaveCombate extends Nave{
   private int nivelArmamento;
   private int escudo;

    public NaveCombate(int nivelArmamento, int escudo, double Velocidad, String tipoCombustible, String Nombre) {
        super(Velocidad, tipoCombustible, Nombre);
        this.nivelArmamento = nivelArmamento;
        this.escudo = escudo;
    }



public NaveCombate(int nivelArmamento, int escudo) {
            if(nivelArmamento >= 1 && nivelArmamento <= 10){
            this.nivelArmamento = nivelArmamento;
            }else{
                System.out.println("Nivel de armamento invalido");
            }
            if(escudo > 0){
            this.escudo = escudo;
            }else{
                System.out.println("Nivel de escudo invalido");
            }
    }
public NaveCombate() {
    }
    
   @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nivel de armamento: " + nivelArmamento);
        System.out.println("Escudo: " + escudo);
    }
}
