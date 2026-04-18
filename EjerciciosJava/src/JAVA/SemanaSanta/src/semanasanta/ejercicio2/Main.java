package semanasanta.ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Precio: ");
        double precio = leer.nextDouble();

        System.out.print("Stock: ");
        int stock = leer.nextInt();

        Cliente c = new Cliente(nombre, precio, stock);

        System.out.print("Cantidad a comprar: ");
        int cant = leer.nextInt();

        c.vender(cant); 
        
        c.MostrarInfo();
    }
}