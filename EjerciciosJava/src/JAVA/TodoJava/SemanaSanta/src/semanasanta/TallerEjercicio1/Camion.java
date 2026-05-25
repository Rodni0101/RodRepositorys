package semanasanta.TallerEjercicio1;

public class Camion extends Vehiculo{
    private double CostoCargo;

    public Camion(double CostoCargo, String Marca, double PrecioBase) {
        super(Marca, PrecioBase);
        this.CostoCargo = CostoCargo;
    }

    public Camion() {
    }

    public double getCostoCargo() {
        return CostoCargo;
    }

    public void setCostoCargo(double CostoCargo) {
        this.CostoCargo = CostoCargo;
    }
    
    @Override
    public void calcularPrecioFinal(){
        System.out.println("Marca = " + getMarca());
        System.out.println("Precio Base = " + getPrecioBase());
        double CostoCargaAplicado = getPrecioBase() + CostoCargo;
        System.out.println("Total a pagar = " + CostoCargaAplicado);
    }
}
