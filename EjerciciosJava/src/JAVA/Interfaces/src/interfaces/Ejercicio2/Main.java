
package interfaces.Ejercicio2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int a = leer.nextInt();
        System.out.print("Ingresa otro numero: ");
        int b = leer.nextInt();
        
        System.out.println("Suma");
        Operacion o1 = new Suma();
        System.out.println(o1.calcular(a, b));
        
        System.out.println();
        
        System.out.println("Resta");
        Operacion o2 = new Resta();
        System.out.println(o2.calcular(a, b));
                
        System.out.println();
        
        System.out.println("Multiplicacion");
        Operacion o3 = new Multiplicacion();
        System.out.println(o3.calcular(a, b));
    }
}
