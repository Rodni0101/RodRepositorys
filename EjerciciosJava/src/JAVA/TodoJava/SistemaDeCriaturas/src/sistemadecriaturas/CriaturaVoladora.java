
package sistemadecriaturas;

public class CriaturaVoladora extends Criatura{
    private double tamañoAlas;

    public CriaturaVoladora(double tamañoAlas, String Nombre, int nivelEnergia, String tipoADN) {
        super(Nombre, nivelEnergia, tipoADN);
        this.tamañoAlas = tamañoAlas;
    }

    public CriaturaVoladora() {
    }

    public double getTamañoAlas() {
        return tamañoAlas;
    }

    public void setTamañoAlas(double tamañoAlas) {
        if(tamañoAlas >= 0){
        this.tamañoAlas = tamañoAlas;
        }else{
            System.out.println("Valor invalido");
        }
    }
    @Override
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Tamaño de las alas = " + tamañoAlas);
    }
}
