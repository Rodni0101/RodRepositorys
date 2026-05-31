import java.util.*;

public class p {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = leer.nextLine();

        if (nombre.equalsIgnoreCase("Rodney") && nombre.equalsIgnoreCase("rodney")) {
            for (int v = 0; v <= 5; v++) {
                System.out.println("Eres la cabra " + nombre);
            }
        } else if (nombre.equalsIgnoreCase("Xavier") && nombre.equalsIgnoreCase("xavier")) {
            for (int v = 0; v <= 5; v++) {
                System.out.println("Eres la bestia " + nombre);
            }
        }
    }
}
