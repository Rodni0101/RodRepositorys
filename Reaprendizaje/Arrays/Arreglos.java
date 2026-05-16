import java.util.Scanner;

public class Arreglos {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = leer.nextLine();

        if (nombre.equals("Rodney")) {
            for (int v = 0; v <= 10; v++) {
                System.out.println("Estas mondao");
            }
        } else {
            System.out.println("Hola " + nombre);
        }
        leer.close();
    }
}
