package sistemadecriaturas;

public class Criatura {
    private String Nombre;
    private int nivelEnergia;
    private String tipoADN;

    public Criatura(String Nombre, int nivelEnergia, String tipoADN) {
        this.Nombre = Nombre;
        this.nivelEnergia = nivelEnergia;
        this.tipoADN = tipoADN;
    }


    public Criatura() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {//Validacion en setters
    if (Nombre == null || Nombre.trim().isEmpty()) {
        System.out.println("Error: el nombre no puede estar vacío");
        } else {
        this.Nombre = Nombre;
        }
    }
    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        if(nivelEnergia >= 0){
        this.nivelEnergia = nivelEnergia;
        }else{
            System.out.println("Valor invalido");
        }
    }
    public String getTipoADN() {
        return tipoADN;
    }

    public void setTipoADN(String tipoADN) {
        this.tipoADN = tipoADN;
    }
    
    public void imprimirInfo(){
        System.out.println("Nombre = " + Nombre);
        System.out.println("Energia = " + nivelEnergia);
        System.out.println("ADN = " + tipoADN);
    }
}
