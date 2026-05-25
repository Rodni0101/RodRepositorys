package poo;
import java.util.*;
public class Persona {
    private String nombre;
    private int id;
    
    public Persona(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }

    public Persona() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = Leer.nextLine();
        System.out.println("Ingresa tu identificaion: ");
        int id = Leer.nextInt();
        
        Persona A1 = new Persona(nombre,id);
        System.out.println("El nombre es: " + A1.getNombre());
        System.out.println("La identificacion es: " + A1.getId());
        
        System.out.println();
        
        Persona P1 = new Persona(nombre,id);
        P1.setNombre("pepe");
        P1.setId(67676767);
        System.out.println("Datos de la segunda persona");
        System.out.println("El nombre es: " + P1.getNombre());
        System.out.println("La identificacion es: " + P1.getId());
    }
}