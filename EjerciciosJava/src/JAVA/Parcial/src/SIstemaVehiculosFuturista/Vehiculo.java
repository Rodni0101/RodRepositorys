
package SIstemaVehiculosFuturista;

public class Vehiculo {
    private String Marca;
    private String Modelo;
    private double VelocidadMax;
    private String TipEnergia;

    public Vehiculo(String Marca, String Modelo, double VelocidadMax, String TipEnergia) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.VelocidadMax = VelocidadMax;
        this.TipEnergia = TipEnergia;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public double getVelocidadMax() {
        return VelocidadMax;
    }

    public void setVelocidadMax(double VelocidadMax) {
        this.VelocidadMax = VelocidadMax;
    }

    public String getTipEnergia() {
        return TipEnergia;
    }

    public void setTipEnergia(String TipEnergia) {
        this.TipEnergia = TipEnergia;
    }
    
    public void mostrarInfo(){
        System.out.println("Marca = " + Marca);
        System.out.println("Modelo = " + Modelo);
        System.out.println("Velocidad Maxima = " + VelocidadMax);
        System.out.println("Tipo de energia = " + TipEnergia);
    }
    
}
