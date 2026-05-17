package Recorderis.Poo;

public class Padre {

    String nombre;
    String Apellido;

    public Padre(String nombre, String Apellido) {
        this.nombre = nombre;
        this.Apellido = Apellido;
    }

    public Padre() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String Apellido){
        this.Apellido = Apellido;
    }

    public void Saludar(){
        System.out.println("Hola soy el padre");
        System.out.println("Me llamo: " + getNombre() + " " + "Mi apeliido es " + getApellido());
    }
}
