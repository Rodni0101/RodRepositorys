package Ejercicio1;

public class Producto extends Pedido {
   private String nombre;
   private double precio;
   
public Producto (String nombre, double precio, int ID_Pedido, double Total){
    super(ID_Pedido,Total);
    this.nombre = nombre;
    this.precio = precio;
    }

public Producto(){
    }

public void setNombre(String nombre){
    this.nombre = nombre;
    }

public void setPrecio(double precio){
    this.precio = precio;
    }

@Override
public void CalcularPedido(){
    System.out.println("Nombre del pedido = " + nombre);
    System.out.println("Precio del pedido = " + precio);
    }
}
