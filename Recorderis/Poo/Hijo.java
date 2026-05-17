package Recorderis.Poo;

public class Hijo extends Padre {

    String Nombre;

    public Hijo(String nombre, String Apellido) {
        this.nombre = Nombre;
    }

    public Hijo() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    @Override
    public void Saludar() {
        System.out.println("Hola soy el Hijo");

        System.out.println("Me llamo: " + getNombre() + " " + "Mi apeliido es " + getApellido());
    }
}
