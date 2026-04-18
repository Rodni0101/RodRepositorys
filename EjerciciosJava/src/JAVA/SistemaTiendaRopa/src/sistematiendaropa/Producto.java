package sistematiendaropa;

public class Producto {
    private String Nombre;
    private double PrecioBase;
    
    public Producto(String Nombre, double PrecioBase){
        this.Nombre = Nombre;
        this.PrecioBase = PrecioBase;
    }
    
    public Producto(){
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void setPrecioBase(double PrecioBase){
        if(PrecioBase >= 0)  {
        this.PrecioBase = PrecioBase;
        }else{
            System.out.println("El precio no puede ser negativo");
        }
    }
    
    public double getPrecioBase(){
        return PrecioBase;
    }
    
    public double CalcularPrecioFinal(){
        System.out.print("Referencia: ");
        System.out.println(getNombre());
        return PrecioBase;
    }
    
}
