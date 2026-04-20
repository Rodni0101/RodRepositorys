import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        int[] numeros = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Sistema de busqueda de numeros");
        System.out.println("1. Buscar numero");
        System.out.println("2. Salir");
        opcion = leer.nextInt();

        switch (opcion) {
            case 1 -> {
                int numeroBuscado;

                do {
                    System.out.print("Ingresa un número (0 para salir): ");
                    numeroBuscado = leer.nextInt();

                    if (numeroBuscado == 0) {
                        System.out.println("Saliendo de la búsqueda...");
                        break;
                    }

                    boolean encontrado = false;

                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] == numeroBuscado) {
                            System.out.println("El número está en la posición " + i);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El número no está en el arreglo");
                    }

                } while (true);
            }

            case 2 -> {
                System.out.println("Gracias por usar");
            }

            default -> {
                System.out.println("Opción inválida");
            }
        }

        leer.close();
    }
}