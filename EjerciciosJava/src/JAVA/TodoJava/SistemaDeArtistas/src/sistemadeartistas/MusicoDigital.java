package sistemadeartistas;

public class MusicoDigital extends Artista{
private String generoMusical;

    public MusicoDigital(String generoMusical, String Nombre, int Edad, String Estilo, int numObras) {
        super(Nombre, Edad, Estilo, numObras);
        this.generoMusical = generoMusical;
    }

    public MusicoDigital() {
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        if (generoMusical == null || generoMusical.trim().isEmpty()) {
        System.out.println("Error: genero no valido");
        } else {
        this.generoMusical = generoMusical;
        }
    }
@Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Genero musical = " + generoMusical);
    }
}
