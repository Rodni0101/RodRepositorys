package Repositorio1;
import java.util.*;
public class Repositorio1{
	public static void main(String[] args) {
        System.out.println("Holamundo");
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa un numero: ");
        int a = leer.nextInt();

        System.out.println("Ingresa otro numero: ");
        int b = leer.nextInt();

        int suma = a + b;
        System.out.println(suma);
    }
}
