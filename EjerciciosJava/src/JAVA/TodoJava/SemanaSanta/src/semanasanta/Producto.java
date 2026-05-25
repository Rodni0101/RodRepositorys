package semanasanta;

public class Producto {
    private String Nombre;
    private double Precio;
    private int Pin;
    
    public Producto(String Nombre, double Precio, int Pin){
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Pin = Pin;
    }
    
    public Producto(){
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void setPrecio(double Precio){
        this.Precio = Precio;
    }
    
    public double getPrecio(){
        return Precio;
    }
    
    public void setPin(int Pin){
        this.Pin = Pin;
    }
    
    public int getPin(){
        return Pin;
    }
    
    public double Calcular(){
        return Precio;
    }
}
