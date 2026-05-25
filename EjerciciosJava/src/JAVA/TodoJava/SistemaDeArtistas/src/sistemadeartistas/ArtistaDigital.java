package sistemadeartistas;

public class ArtistaDigital extends Artista{
    private String Herramientas;//(Photoshop,Ilustrador, etc

    public ArtistaDigital(String Herramientas, String Nombre, int Edad, String Estilo, int numObras) {
        super(Nombre, Edad, Estilo, numObras);
        this.Herramientas = Herramientas;
    }

    public ArtistaDigital() {
    }

    public String getHerramientas() {
        return Herramientas;
    }

    public void setHerramientas(String Herramientas) {
        if (Herramientas == null || Herramientas.trim().isEmpty()) {
        System.out.println("Error: la herramienta no puede estar vacía");
        } else {
        this.Herramientas = Herramientas;
        }
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Herramientas = " + Herramientas);
    }
}
