package sistemadecriaturas;

public class CriaturaAcuatica extends Criatura{
    private double profundidadMaxima;

    public CriaturaAcuatica(double profundidadMaxima, String Nombre, int nivelEnergia, String tipoADN) {
        super(Nombre, nivelEnergia, tipoADN);
        this.profundidadMaxima = profundidadMaxima;
    }

    public CriaturaAcuatica() {
    }

    public double getProfundidadMaxima() {
        return profundidadMaxima;
    }

    public void setProfundidadMaxima(double profundidadMaxima) {
        if(profundidadMaxima >= 0){
        this.profundidadMaxima = profundidadMaxima;
        }else{
            System.out.println("Valor invalido");
        }
    }
    @Override
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Profundidad Maxima = " + profundidadMaxima);
    }
}
