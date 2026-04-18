package Ejercicio1;

public class PedidoLocal extends Pedido {
    private int NumMesa;
    
public PedidoLocal(int NumMesa, int ID_Pedido, double Total){
    this.NumMesa = NumMesa;
}

public void setNumMesa(int NumMesa){
    this.NumMesa = NumMesa;
    }

public int getNumMesa(){
    return NumMesa;
    }

@Override
public void CalcularPedido(){
    System.out.println("NumMesa = " + NumMesa);
}
}
