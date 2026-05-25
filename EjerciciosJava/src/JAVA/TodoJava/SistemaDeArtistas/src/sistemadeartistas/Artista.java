package sistemadeartistas;

public class Artista {
private String Nombre;
private int Edad;
private String Estilo;
private int numObras;

public Artista(String Nombre, int Edad, String Estilo, int numObras){
    setNombre(Nombre);
    setEdad(Edad);
    setEstilo(Estilo);
    setNumObras(numObras);
}

public Artista(){
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if (Nombre == null || Nombre.trim().isEmpty()) {
        System.out.println("Error: el nombre no puede estar vacío");
        } else {
        this.Nombre = Nombre;
        }
    }
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        if(Edad > 0){
        this.Edad = Edad;
        }else{
            System.out.println("Error: La edad debe ser mayor a 0");
        }
    }
    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        if(Estilo == null || Estilo.trim().isEmpty()){
            System.out.println("Error: el estilo no puede estar vacio");
        }else{
        this.Estilo = Estilo;
        }
    }
    public int getNumObras() {
        return numObras;
    }

    public void setNumObras(int numObras) {
        if(numObras >= 0){
        this.numObras = numObras;
    }else{
        System.out.println("Error: el numero de obras no puede ser negativo");
        }
    }
    public void mostrarInfo(){
        System.out.println("Nombre = " + getNombre());
        System.out.println("Edad = " + getEdad());
        System.out.println("Estilo = " + getEstilo());
        System.out.println("Numero de obras = " + getNumObras());
    }
}
