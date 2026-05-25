
package polimorfismo;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        var p1 = new Producto();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el nombre del producto");
        p1.setNombre(leer.nextLine());
        System.out.println("Ingresa el precio del producto");
        p1.setPrecio(leer.nextDouble());
        System.out.println("Ingresa la cantidad a comprar");
        p1.setCantidad(leer.nextInt());
        
        System.out.println();
        
        var p2 = new Producto();
        leer.nextLine();
        System.out.println("Ingresa el nombre del producto");
        p2.setNombre(leer.nextLine());
        System.out.println("Ingresa el precio del producto");
        p2.setPrecio(leer.nextDouble());
        System.out.println("Ingresa la cantidad a comprar");
        p2.setCantidad(leer.nextInt());
        
        var p3 = new Producto();
        leer.nextLine();
        System.out.println("Ingresa el nombre del producto");
        p3.setNombre(leer.nextLine());
        System.out.println("Ingresa el precio del producto");
        p3.setPrecio(leer.nextDouble());
        System.out.println("Ingresa la cantidad a comprar");
        p3.setCantidad(leer.nextInt());
        
        //Forma uno usando constructor
        var F1 = new Factura(1,p1,p2,p3);
        System.out.println("Total factura: " + F1.calcularTotalFactura());
        
        //Forma dos usando setters
        var D1 = new Descuento();
        D1.setIdFactura(2);
        D1.p1 = p1;
        D1.p2 = p2;
        D1.p3 = p3;
        System.out.println("Total con descuento: " + D1.calcularTotalDescuento());
        
        var F2 = new Factura();
        F2.setIdFactura(3);
        F2.p1 = p1;
        F2.p2 = p2;
        F2.p3 = p3;
        System.out.println("Factura: " + F2.calcularTotalFactura());
        
        var D2 = new Descuento();
        D2.setIdFactura(4);
        D2.p1 = p1;
        D2.p2 = p2;
        D2.p3 = p3;
        System.out.println("Total con descuento: " + D1.calcularTotalDescuento());
    }
}
