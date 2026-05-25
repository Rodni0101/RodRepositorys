package semanasanta.TallerEjercicio1;

public class Camion extends Vehiculo{
    private double CostoCarga;

    public Camion(double CostoCarga, String Marca, double PrecioBase) {
        super(Marca, PrecioBase);
        this.CostoCarga = CostoCarga;
    }

    public Camion() {
    }

    public double getCostoCarga() {
        return CostoCarga;
    }

    public void setCostoCarga(double CostoCarga) {
        if(CostoCarga >= 0){
        this.CostoCarga = CostoCarga;
        }else{
            System.out.println("!!!\"El costo de carga no puede ser menor que 0\"!!!");
        }
    }
    
    @Override
    public double calcularPrecioFinal(){
        double CostoCargaAplicado = getPrecioBase() + CostoCarga;
        return CostoCargaAplicado;
    }
}
