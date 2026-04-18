package semanasanta.TallerEjercicio1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Opcion;
        Scanner leer = new Scanner(System.in);
        do{
        System.out.println("-----CONCESIONARIO-----");
        System.out.println("Que vehiculo va a comprar?");
        System.out.println("1. Automovil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camion");
        System.out.println("4. Salir");
        System.out.println("------------------------");
        Opcion = leer.nextInt();
        
        switch(Opcion){
            case 1 ->{
            System.out.println();
        var p1 = new Automovil();
        leer.nextLine();
        System.out.print("Ingresa la marca del vehiculo: ");
        p1.setMarca(leer.nextLine());
        System.out.print("Ingresa el precio base del vehiculo: ");
        p1.setPrecioBase(leer.nextDouble());
        System.out.print("Digita el valor del impuesto: ");
        p1.setImpuesto(leer.nextDouble() / 100);
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p1.getMarca());
        System.out.println("Precio Base = " + p1.getPrecioBase());
        System.out.println("Total a pagar = " + p1.calcularPrecioFinal());
        
        break;
        }
            
        case 2 ->{
            System.out.println();
        var p2 = new Motocicleta();
        leer.nextLine();
        System.out.print("Ingresa la marca del vehiculo: ");
        p2.setMarca(leer.nextLine());
        System.out.print("Ingresa el precio base del vehiculo: ");
        p2.setPrecioBase(leer.nextDouble());
        System.out.print("Digita el valor del descuento: ");
        p2.setDescuento(leer.nextDouble() / 100);
        
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p2.getMarca());
        System.out.println("Precio Base = " + p2.getPrecioBase());
        System.out.println("Total a pagar = " + p2.calcularPrecioFinal());
        System.out.println();
        break;
        }
        
        case 3 ->{
            System.out.println();
            var p3 = new Camion();
        leer.nextLine();
        System.out.print("Ingresa la marca del vehiculo: ");
        p3.setMarca(leer.nextLine());
        System.out.print("Ingresa el precio base del vehiculo: ");
        p3.setPrecioBase(leer.nextDouble());
        System.out.print("Digita el valor del costo de carga : ");
        p3.setCostoCarga(leer.nextDouble());
        
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p3.getMarca());
        System.out.println("Precio Base = " + p3.getPrecioBase());
        System.out.println("Total a pagar = " + p3.calcularPrecioFinal());
        System.out.println();
        break;
        }
        
        case 4 ->{
            System.out.println("Gracias por Usarnos");
        }
    }
   }while(Opcion != 4);
}
}
