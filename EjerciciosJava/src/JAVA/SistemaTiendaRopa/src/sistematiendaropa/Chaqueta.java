package sistematiendaropa;

public class Chaqueta extends Producto{
private int costoEnvio;

    public Chaqueta(int costoEnvio, String Nombre, double PrecioBase) {
        super(Nombre, PrecioBase);
        this.costoEnvio = costoEnvio;
    }

    public Chaqueta() {
    }

    public int getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(int costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

@Override
    public double CalcularPrecioFinal(){
        double Total = getPrecioBase() + costoEnvio;
        return Total;
    }
}
