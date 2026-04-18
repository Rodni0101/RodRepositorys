package poo.Ejercicio3;
import java.util.*;
public class Result {
    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        Producto Po1 = new Producto();
        System.out.println("Digite el nombre del producto: ");
        Po1.setNombre(Leer.nextLine());
        System.out.println("Digite la Resistencia del producto: ");
        Po1.setnota1(Leer.nextDouble());
        System.out.println("Digite el Acabado del producto: ");
        Po1.setnota2(Leer.nextDouble());
        System.out.println("Digite el funcionamiento del producto: ");
        Po1.setnota3(Leer.nextDouble());
        
        System.out.println("Nombre del producto: " + Po1.getNombre());
        System.out.println("Notas ingresadas: " + Po1.getnota1() + " , " + Po1.getnota2() + " , " + Po1.getnota3() + " .");
        Po1.Pruebas();
    }
}
