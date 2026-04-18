package semanasanta.ejercicio2;

public class Cliente extends Producto {

    public Cliente(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    public void vender(int cantComprar){
        if(cantComprar <= getStock()){
            setStock(getStock() - cantComprar);
            System.out.println("Venta realizada");
        } else {
            System.out.println("Stock insuficiente");
        }
    }
    @Override
    public void MostrarInfo(){
        System.out.println("nombre = " + getNombre());
        System.out.println("precio = " + getPrecio());
        System.out.println("stock = " + getStock());
    }
}

