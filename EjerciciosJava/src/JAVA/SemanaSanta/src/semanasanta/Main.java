package semanasanta;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        productoNormal p1;
        
        p1 = new productoNormal();
        System.out.print("Ingresa el nombre del producto: ");
        p1.setNombre(leer.nextLine());
        System.out.print("Ingresa el pin del producto (ej 1234): ");
        p1.setPin(leer.nextInt());
        System.out.print("Ingresa el precio del producto: ");
        p1.setPrecio(leer.nextDouble());
        System.out.println("Desea llevar mas de un producto? ");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = leer.nextInt();
        
        switch(opcion){
            case 1 -> {
                System.out.println("Ingrese la cantidad a llevar: ");
                p1.setCantidad(leer.nextInt());
                
                System.out.println("-----Factura-----");
                System.out.println("-----------------");
                System.out.println("Nombre = " + p1.getNombre());
                System.out.println("Pin = " + p1.getPin());
                System.out.println("Total = " + p1.Calcular());
                
                break;
            }
            
            case 2 -> {
                System.out.println("-----Factura-----");
                System.out.println("-----------------");
                System.out.println("Nombre = " + p1.getNombre());
                System.out.println("Pin = " + p1.getPin());
                System.out.println("Total = " + p1.Calcular());
                
                break;
            }
        }        
    }
}