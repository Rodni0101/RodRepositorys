package polimorfismo.ejercicio2;
public class CuentaEmpresarial extends CuentaBancaria{
    private double comisionMensual;

    public CuentaEmpresarial(double comisionMensual, String titular, double saldo) {
        super(titular, saldo);
        this.comisionMensual = comisionMensual;
    }

    public CuentaEmpresarial() {
    }

    public double getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(double comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
    
    @Override
    public double AplicarOperacion(){
        double saldo = super.AplicarOperacion();
        return saldo - comisionMensual;
    }
}
