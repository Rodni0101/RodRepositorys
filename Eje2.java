
import java.util.Scanner;

public class Eje2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
            double suma = 0;

            System.out.println("Sistema de estudiantes");
            System.out.println("---------------------");

            System.out.println("Ingrese su nombre: ");
            String nombre = leer.nextLine();

            double notas[] = new double[3];

            for (int v = 0; v < notas.length; v++) {
                System.out.println("Ingresa la nota #" + (v + 1));
                notas[v] = leer.nextDouble();
                suma = suma + notas[v];
            }

            System.out.println("");

            double promedio = suma / notas.length;

            if (promedio >= 3.0) {
                System.out.println("Aprueba");
            } else {
                System.out.println("Reprueba");
            }
            System.out.println("Estudiante: " + nombre);
            System.out.println("Promedio de notas = " + promedio);
            leer.close();
    }
}
