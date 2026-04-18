package semanasanta;

public class productoNormal extends Producto{
private int Cantidad;

public productoNormal(String Nombre, double Precio, int Pin, int Cantidad){
    super(Nombre, Precio, Pin);
    }
    
    public productoNormal(){
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
@Override
    public double Calcular(){
        //Validacion
        if(Cantidad == 0){
            return super.Calcular();
        }
        return super.Calcular() * Cantidad;
    }
}
