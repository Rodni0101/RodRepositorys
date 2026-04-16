package EjercicioCombinado;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Sistema de pago");
        System.out.print("Ingrese el valor a pagar: ");
        double Pago = leer.nextDouble();

        System.out.println("1. Pago por tarjeta");
        System.out.println("2. Pago en efectivo");
        System.out.println("3. Pago por trasnferencia");
        int opcion = leer.nextInt();
        leer.close();
        System.out.println();

        switch(opcion){
        case 1 -> {
            Pago p1 = new pagoTarjeta();
            p1.Pagar();
            System.out.println("Valor a pagar: " + Pago);
            }

        case 2 -> {
            Pago p2 = new pagoEfectivo();
            p2.Pagar();
            System.out.println("Valor a pagar: " + Pago);
            }

        case 3 -> {
            Pago p3 = new pagoTransferencia();
            p3.Pagar();
            System.out.println("Valor a pagar: " + Pago);
            }
        }
    }
}