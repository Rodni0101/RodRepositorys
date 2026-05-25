
package semanasanta.TallerEjercicio1;

public class Vehiculo {
    private String Marca;
    private double PrecioBase;
    
    public Vehiculo(String Marca, double PrecioBase){
        this.Marca = Marca;
        this.PrecioBase = PrecioBase;
    }
    
    public Vehiculo(){
    }
    
    public String getMarca(){
        return Marca;
    }
    
    public void setMarca(String Marca){
        this.Marca = Marca;
    }
    
    public double getPrecioBase(){
        return PrecioBase;
    }
    
    public void setPrecioBase(double PrecioBase){
        this.PrecioBase = PrecioBase;
    }
    
    public void calcularPrecioFinal(){
        System.out.println("Marca = " + Marca);
        System.out.println("Precio Base = " + PrecioBase);
    }
}
