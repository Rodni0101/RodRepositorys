

package gestionempleos;

import java.util.Scanner;
public class NewClass {
    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        System.out.println("Ingresa la palabra a imprimir");
        String Texto = Leer.nextLine();
        System.out.print("Cuantas veces se va a imprimir: ");
        var Cant = Leer.nextInt();
        for(var a = 1; a <= Cant; a++){
            System.out.println(Texto);
        }
    }
}
