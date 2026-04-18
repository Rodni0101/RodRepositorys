package Ejercicio1;

public class Pedido {
   private int ID_Pedido;
   private double Total;
   
public Pedido(int ID_Pedido, double Total){
    this.ID_Pedido = ID_Pedido;
    this.Total = Total;
}
public Pedido(){
}

public void setID_Pedido(int ID_Pedido){
    this.ID_Pedido = ID_Pedido;
}

public void setTotal(double Total){
    this.Total = Total;
}

public int getID_Pedido(){
    return ID_Pedido;
}

public double getTotal(){
    return Total;
}
public void CalcularPedido(){
    System.out.println("Total del pedido = " + Total);
    System.out.println("ID de pedido = " + ID_Pedido);
    }
}
