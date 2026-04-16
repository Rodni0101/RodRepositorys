package EjercicioImplements;

public class Efectivo extends Pago implements MetodoPago{
    
    public Efectivo(String titular){
        super(titular);
    }

    @Override
    public void pagar(double monto) {
        System.out.println(" Titular: " + getTitular());
        System.out.println("Monto a pagar en efectivo = $"+ monto);
    }
}
