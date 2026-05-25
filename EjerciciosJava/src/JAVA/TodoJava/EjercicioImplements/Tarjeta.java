package EjercicioImplements;

public class Tarjeta extends Pago implements MetodoPago{
    
    public Tarjeta(String titular){
        super(titular);
    }

    @Override
    public void pagar(double monto){
        System.out.println(" Titular: " + getTitular());
        System.out.println("Monto a pagar con tarjeta = $"+ monto);
    }
}
