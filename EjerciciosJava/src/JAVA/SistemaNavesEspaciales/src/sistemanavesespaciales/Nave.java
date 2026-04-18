
package sistemanavesespaciales;
public class Nave {
    private double Velocidad;
    private String tipoCombustible;
    private String Nombre;

    public Nave(double Velocidad, String tipoCombustible,String Nombre) {
        this.Velocidad = Velocidad;
        this.tipoCombustible = tipoCombustible;
        this.Nombre = Nombre;
    }

    public Nave() {
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double Velocidad) {
        if(Velocidad >= 0 ){
        this.Velocidad = Velocidad;
        }
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    public void mostrarInfo(){
        System.out.println("Nombre de la nave: " + Nombre);
        System.out.println("Velocidad de la nave: " + Velocidad);
        System.out.println("Tipo de combustible: " + tipoCombustible);
    }
}
