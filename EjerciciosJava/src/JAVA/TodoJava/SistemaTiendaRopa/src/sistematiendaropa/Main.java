package sistematiendaropa;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int Opcion;
        do{
        System.out.println();
        System.out.println("-----TIENDA ONLINE-----");
        System.out.println("Productos Disponibles");
        System.out.println("1. Camisa");
        System.out.println("2. Pantalon");
        System.out.println("3. Chaqueta");
        System.out.println("4. Salir");
        Opcion = leer.nextInt();
        
        switch(Opcion){
            case 1 ->{
                var p1 = new Camisa();
                leer.nextLine();
                System.out.print("Ingresa la referencia del producto: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Digite el precio del producto: ");
                p1.setPrecioBase(leer.nextDouble());
                System.out.print("Ingrese el valor del descuento a aplicar: ");
                p1.setDescuento(leer.nextDouble() / 100);
                
                System.out.println();
                System.out.println("Referencia: " + p1.getNombre());
                System.out.println("Total a pagar = " + p1.CalcularPrecioFinal());
 
                
                break;
            }
            
            case 2 ->{
                leer.nextLine();
                var p2 = new Pantalon();
                System.out.print("Ingresa la referencia del producto: ");
                p2.setNombre(leer.nextLine());
                System.out.print("Digite el precio del producto: ");
                p2.setPrecioBase(leer.nextDouble());
                System.out.print("Ingrese el valor del Impuesto a aplicar: ");
                p2.setImpuesto(leer.nextDouble() / 100);
                
                System.out.println();
                System.out.println("Referencia: " + p2.getNombre());
                System.out.println("Total a pagar = " + p2.CalcularPrecioFinal());
                break;
            }
            
            case 3 ->{
                leer.nextLine();
                var p3 = new Chaqueta();
                System.out.print("Ingresa la referencia del producto: ");
                p3.setNombre(leer.nextLine());
                System.out.print("Digite el precio del producto: ");
                p3.setPrecioBase(leer.nextDouble());
                System.out.print("Ingrese el valor del envio a aplicar: ");
                p3.setCostoEnvio(leer.nextInt());
                
                System.out.println();
                System.out.println("Referencia: " + p3.getNombre());
                System.out.println("Total a pagar = " + p3.CalcularPrecioFinal());
            }
            
        }
        
     }while(Opcion != 4);
   }
}
