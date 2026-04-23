package TallerStick3;

public class Tienda {
    double precioProducto = 35;
    int cantidad = 4;

public void Total_aPagar(){
    double Total = precioProducto * cantidad;
    double descuento = 0.10;
    System.out.println("Total a pagar sin descuento: " + Total);
 
    if(Total > 100){
      double aux = Total - (Total * descuento);
    System.out.println("Total a pagar con descuento aplicado del 10%: " + aux);
   }
}
    public static void main(String[] args) {
        Tienda R1 = new Tienda();
        
        R1.Total_aPagar();
    }
}
