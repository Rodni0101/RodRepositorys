package Ejercicio1;

public class PedidoDomicilio extends Pedido{
    private String Direccion;
    
public PedidoDomicilio(String Direccion, int ID_Pedido, double Total){
    this.Direccion = Direccion;
    }

public void setDireccion(String Direccion){
    this.Direccion = Direccion;
    }
public String getDireccion(){
    return Direccion;
    }


@Override
public void CalcularPedido(){
    System.out.println("Direccion del pedido = " + Direccion);
    }
}
