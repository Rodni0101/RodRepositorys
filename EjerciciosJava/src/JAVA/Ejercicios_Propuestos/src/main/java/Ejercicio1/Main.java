package Ejercicio1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        var Pedido1 = new Producto();
        leer.close();
        System.out.print("Ingresa el ID del pedido: ");
        Pedido1.setID_Pedido(leer.nextInt());
        System.out.print("Digite el precio del producto: ");
        Pedido1.setPrecio(leer.nextDouble());
        System.out.print("Ingresa Nombre del pedido: ");
        Pedido1.setNombre(leer.nextLine());
        Pedido1.CalcularPedido();
    }
}
