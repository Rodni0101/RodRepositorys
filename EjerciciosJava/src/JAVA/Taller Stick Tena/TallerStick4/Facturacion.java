
package TallerStick4;

public class Facturacion {
    int cantidad = 3;
    double precioUni = 75;
    double impuesto = 19;

    
public void factura(){
    double Subtotal = precioUni * cantidad;
    System.out.println("Subtotal a pagar: " + Subtotal);
    //impuesto
    double ValorImpuesto = Subtotal * (impuesto / 100);
    System.out.println("Valor de impuesto a aplicar: " + ValorImpuesto);
    //total a pagar
    double Total = Subtotal + ValorImpuesto;
    System.out.println("Total a pagar: " + Total);
       }
       public static void main(String[] args) {
        Facturacion N1 = new Facturacion();
        N1.factura();
    }
}
