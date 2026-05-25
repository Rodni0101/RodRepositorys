
package poo.Ejercicio1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa nota de primer parcial: ");
        double nota1 = leer.nextDouble();
        System.out.print("Ingresa nota de segundo parcial: ");
        double nota2 = leer.nextDouble();
        System.out.print("Ingresa nota de tercer parcial: ");
        double nota3 = leer.nextDouble();
        
        Estudiante A1 = new Estudiante(nota1,nota2,nota3);
        System.out.print("Nota final: ");
        A1.Promedio(); 
        
        System.out.println();
        
        System.out.println("¿Desea ingresar notas nuevas?");
        System.out.println("Si (1) o No (2)");
        int op = leer.nextInt();
        switch(op){
            case 1 -> {
        Estudiante B1 = new Estudiante ();
        System.out.print("Ingresa nota de primer parcial: ");
        B1.setNota1(leer.nextDouble());
        System.out.print("Ingresa nota de segundo parcial: ");
        B1.setNota2(leer.nextDouble());
        System.out.print("Ingresa nota de tercer parcial: ");
        B1.setNota3(leer.nextDouble());
        System.out.print("Nota final: ");
        B1.Promedio();
        break;
            }
            case 2 -> {
                System.out.println("FIN");
                break;
            }
    }
   }
} 
