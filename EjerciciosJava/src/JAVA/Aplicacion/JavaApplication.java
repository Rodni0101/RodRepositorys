package javaapplication;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
      Tablas T1 = new Tablas();
        System.out.println("Digite un numero: ");
        T1.numero1 = lee.nextInt();
        System.out.println("Digite otro numero: ");
        T1.numero2 = lee.nextInt();
        
        T1.imprimir();

        System.out.println();
       
        Operaciones Op1 = new Operaciones();
        System.out.println("Aritmetica basica");
        T1.aritmetica();
        
    }
    
}
