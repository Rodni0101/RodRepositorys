
package poo.Ejercicio2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingresa tu nombre: ");
        String nombre = leer.nextLine();
        
        System.out.println("Ingrese su salario base: ");
        int salarioBase = leer.nextInt();
        
        System.out.println("Ingrese al cantidad de horas extras trabajadas: ");
        int horasExtras = leer.nextInt();
        Empleado A1 = new Empleado(nombre,salarioBase,horasExtras);
        A1.getNombre();
        A1.Calculo();
}
}
