package polimorfismo.ejercicio2;
public class CuentaAhorro extends CuentaBancaria{

    private double tasaInteres;

    public CuentaAhorro(double tasaInteres, String titular, double saldo) {
        super(titular, saldo);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(){
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    @Override
    public String llamarTitular(){
    return super.llamarTitular();
}
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    @Override
    public double AplicarOperacion(){
        return super.AplicarOperacion() * (1 + tasaInteres);
    }
}
