package sistemadeartistas;

public class CreadorDeContenido extends Artista{
private String Plataforma;
private double numSeguidores;

    public CreadorDeContenido(String Plataforma, double numSeguidores, String Nombre, int Edad, String Estilo, int numObras) {
        super(Nombre, Edad, Estilo, numObras);
        this.Plataforma = Plataforma;
        this.numSeguidores = numSeguidores;
    }

    public CreadorDeContenido() {
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String Plataforma) {
        if (Plataforma == null || Plataforma.trim().isEmpty()) {
        System.out.println("Error: Plataforma no valida");
        } else {
        this.Plataforma = Plataforma;
    }
    }
    public double getNumSeguidores() {
        return numSeguidores;
    }

    public void setNumSeguidores(double numSeguidores) {
        if(numSeguidores >= 0){
        this.numSeguidores = numSeguidores;
        }else{
            System.out.println("Cantidad de seguidores invalida");
        }
    }
@Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de seguidores = " + numSeguidores);
    }
}
