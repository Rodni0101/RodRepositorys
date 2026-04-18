//EL CODIGO FUNCIONA POR QUE SI EN EL CASE 2 NO SE DECLARA EL DESCUENTO NO SE CALCULA OSEA QUE EL DESCUENTO ES NULO
package polimorfismo.Ejercicio;
import java.util.*;
public class Prueba {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);  
        var producto1 = new ConDescuento();
        System.out.println("Ingresa el nombre del producto");
        producto1.setNombre(leer.nextLine());
        System.out.println("Ingresa el precio del producto");
        producto1.setPrecio(leer.nextDouble());
        System.out.println("Ingresa la cantidad a llevar");
        producto1.setCantidad(leer.nextInt());
        
        System.out.println("Tiene descuentos disponibles?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int Opcion = leer.nextInt();
        switch(Opcion){
            
            case 1 -> {
                System.out.print("Ingrese el valor del descuento = ");
                producto1.setDescuento(leer.nextDouble());
                
                System.out.println("Nombre = " + producto1.getNombre());
                System.out.println("Precio = " + producto1.getPrecio());
                System.out.println("Cantidad = " + producto1.getCantidad());
                System.out.println("------------------------------");
                System.out.println("Total a pagar con descuento= " + producto1.calcularProducto());
                break; 
            }
            
            case 2 -> {
                System.out.println("Nombre = " + producto1.getNombre());
                System.out.println("Precio = " + producto1.getPrecio());
                System.out.println("Cantidad = " + producto1.getCantidad());
                System.out.println("-------------------------------------");
                System.out.println("Total a pagar = " + producto1.calcularProducto());
            }
        }
    }
}
