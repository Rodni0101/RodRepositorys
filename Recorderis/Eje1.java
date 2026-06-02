package Recorderis;
    
import java.util.*;

public class Eje1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido a Calculadora virtual");
        System.out.println("");

        // Usamos while(true) para no depender de evaluar una variable afuera
        while (true) {
            System.out.println("Ingrese dos numeros");
            System.out.println("----------------------");

            System.out.print("Primer numero: ");
            int n1 = Integer.parseInt(leer.nextLine());

            System.out.print("Segundo numero: ");
            int n2 = Integer.parseInt(leer.nextLine());

            System.out.println("----------------------");

            System.out.println("Seleccione la operacion a realizar");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Salir");

            // Usamos Integer.parseInt para mantener el buffer limpio
            int opcion = Integer.parseInt(leer.nextLine());

            // Validamos la salida inmediatamente de forma interna
            if (opcion == 5) {
                System.out.println("¡Gracias por usar la calculadora!");
                break; // Rompe el bucle while por completo
            }

            System.out.println("----------------------");

            switch (opcion) {
                case 1 -> {
                    int suma = n1 + n2;
                    System.out.println("Resultado de la suma = " + suma);
                }
                case 2 -> {
                    int resta = n1 - n2;
                    System.out.println("Resultado de la resta = " + resta);
                }
                case 3 -> {
                    int multi = n1 * n2;
                    System.out.println("Resultado de la multiplicacion = " + multi);
                }
                case 4 -> {
                    if (n2 == 0) {
                        System.out.println("Error: No se puede dividir entre cero.");
                    } else {
                        int div = n1 / n2;
                        System.out.println("Resultado de la division = " + div);
                    }
                }
                default -> System.out.println("Opcion no valida.");
            }
            
            System.out.println("Operacion Terminada");
            System.out.println("----------------------");
            System.out.println("");
        }
    }
}