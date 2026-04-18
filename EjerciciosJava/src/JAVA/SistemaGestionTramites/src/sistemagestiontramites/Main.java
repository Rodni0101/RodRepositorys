package sistemagestiontramites;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Opcion;
        Scanner leer = new Scanner(System.in);
        do{
        System.out.println("-----REGISTRADURIA-----");
        System.out.println("Que documento desea tramitar?");
        System.out.println("1. RegistroCivil");
        System.out.println("2. Targeta Identidad");
        System.out.println("3. Cedula Ciudadania");
        System.out.println("4. Salir");
        System.out.println("------------------------");
        Opcion = leer.nextInt();
        
        switch(Opcion){
            case 1 ->{
            System.out.println();
        var p1 = new RegistroCivil();
        leer.nextLine();
        System.out.print("Ingresa su nombre completo: ");
        p1.setCiudadano(leer.nextLine());
        System.out.print("Digite el costo del tramite: ");
        p1.setCostoBase(leer.nextDouble());
        System.out.print("Ingrese el numero de tarifa: ");
        p1.setTarifaFija(leer.nextDouble());
                System.out.println();
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p1.getCiudadano());
        System.out.println("Precio Base = " + p1.getCostoBase());
        System.out.println("Total a pagar = " + p1.calcularCostoFinal());
            System.out.println();
        break;
        }
            
            case 2 ->{
            System.out.println();
        var p1 = new TarjetaIdentidad();
        leer.nextLine();
        System.out.print("Ingresa su nombre completo: ");
        p1.setCiudadano(leer.nextLine());
        System.out.print("Digite el costo del tramite: ");
        p1.setCostoBase(leer.nextDouble());
        System.out.print("Ingrese el valor del descuento: ");
        p1.setDescuento(leer.nextDouble() / 100);
            System.out.println();
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p1.getCiudadano());
        System.out.println("Precio Base = " + p1.getCostoBase());
        System.out.println("Total a pagar = " + p1.calcularCostoFinal());
            System.out.println();
        break;
        }
        
            case 3 ->{
            System.out.println();
        var p1 = new cedulaCiudadania();
        leer.nextLine();
        System.out.print("Ingresa su nombre completo: ");
        p1.setCiudadano(leer.nextLine());
        System.out.print("Digite el costo del tramite: ");
        p1.setCostoBase(leer.nextDouble());
        System.out.print("Ingrese el valor del recargo: ");
        p1.setRecargoUrgente(leer.nextDouble());
            System.out.println();
        System.out.println("-----Factura-----");
        System.out.println("Marca = " + p1.getCiudadano());
        System.out.println("Precio Base = " + p1.getCostoBase());
        System.out.println("Total a pagar = " + p1.calcularCostoFinal());
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
