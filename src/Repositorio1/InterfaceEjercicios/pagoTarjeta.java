package Repositorio1.InterfaceEjercicios;

class pagoTarjeta implements Pago{
    @Override
    public void Pagar(){
        System.out.println("Estoy pagando con tarjeta de credito");
    }
}
