package EjercicioImplements;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Como desea pagar?");
        System.out.println("1. Tarjeta");
        System.out.println("2. Efectivo");
        int opcion = leer.nextInt();

        switch(opcion){
            case 1 ->{
                leer.nextLine();
        System.out.print("Ingresa el nombre del titular: ");
            String titular = leer.nextLine();

        System.out.print("Ingresa el monto a pagar: ");
        double monto = leer.nextDouble();

        leer.nextLine();

        MetodoPago pago = new Tarjeta(titular);
        pago.pagar(monto);

            }
            case 2 ->{
                leer.nextLine();
        System.out.print("Ingresa el nombre del titular: ");
            String titular = leer.nextLine();

        System.out.print("Ingresa el monto a pagar: ");
        double monto = leer.nextDouble();

        leer.close();
        MetodoPago pago = new Efectivo(titular);
        pago.pagar(monto);
            }
        }
        
    }
}

