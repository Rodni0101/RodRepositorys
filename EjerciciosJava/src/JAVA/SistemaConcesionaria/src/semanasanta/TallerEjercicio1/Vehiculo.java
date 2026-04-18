
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
        if(PrecioBase > 0){
        this.PrecioBase = PrecioBase;
        }else{
            // con los \ Imprimes comillas dentro del texto
            System.out.println("!!!\"Error: el precio base debe ser mayor a 0\"!!");
        }
    }
    
    public double calcularPrecioFinal(){
        return PrecioBase;
    }
}
