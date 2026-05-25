package polimorfismo.ejercicio2;

public class CuentaCorriente extends CuentaBancaria{
    private double tasaInteresSobregiro;
    private double tasaInteres;
    private double retiro;
    public CuentaCorriente(double tasaInteresSobregiro, String titular, double saldo, double retiro) {
        super(titular, saldo);
        this.tasaInteresSobregiro = tasaInteresSobregiro;
        this.retiro = retiro;
    }

    public CuentaCorriente() {
    }

    public double getTasaInteresSobregiro() {
        return tasaInteresSobregiro;
    }

    public void setTasaInteresSobregiro(double tasaInteresSobregiro) {
        this.tasaInteresSobregiro = tasaInteresSobregiro;
    }
    
    
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getRetiro() {
        return retiro;
    }

    public void setRetiro(double retiro) {
        this.retiro = retiro;
    }
    
    
        @Override
    public String llamarTitular(){
    return super.llamarTitular();
}
    
    @Override
    public double AplicarOperacion(){
        double saldo = super.AplicarOperacion();
        return saldo - retiro;
    }
    
} 

