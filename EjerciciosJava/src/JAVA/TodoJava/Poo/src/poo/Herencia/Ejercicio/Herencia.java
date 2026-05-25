package poo.Herencia.Ejercicio;
import java.util.*;
public class Herencia {
    public static void main(String[] args) {
        //Con Scanner
        Scanner leer = new Scanner(System.in);
        var C1 = new Conductor();
        System.out.println("Ingresa el numero de licencia: ");
        C1.setNumero_Licencia (leer.nextInt());
        System.out.println("Digite su ID: ");
        C1.setID(leer.nextInt());
        System.out.println("Digite su DNI: ");
        C1.setDNI (leer.nextInt());
            leer.nextLine();
        System.out.println("Ingresa la ruta asignada: ");
        C1.setRuta_Asignada(leer.nextLine());
        System.out.println("Ingrese su nombre: ");
        C1.setNombre (leer.nextLine());
        System.out.println("Ingrese su apellido: ");
        C1.setApellido (leer.nextLine());
        System.out.println("Ingrese su direccion: ");
        C1.setDireccion(leer.nextLine());
        System.out.println("Ingrese su numero telefonico: ");
        C1.setTelefono (leer.nextLong());
        
        System.out.println();
        C1.imprimirDatosConductor();
        C1.imprimirDatosPadre();
        
        System.out.println();
                
        //Sin Scanner
        System.out.println("-----DATOS DE ADMINISTRADOR-----");
        var A1 = new Administrativo("Bolivar",50000.0,2211,39201,"Camilo","España","Vicentenario",3412);
        System.out.println("Departamento = " + A1.getDepartamento());
        System.out.println("Salario = " + A1.getSalario());
        System.out.println("ID = " + A1.getID());
        System.out.println("DNI = " + A1.getDNI());
        System.out.println("Nombre = " + A1.getNombre());
        System.out.println("Apellido = " + A1.getApellido());
        System.out.println("Direccion = " + A1.getDireccion());
        System.out.println("Telefono = " + A1.getTelefono());
    }
}
