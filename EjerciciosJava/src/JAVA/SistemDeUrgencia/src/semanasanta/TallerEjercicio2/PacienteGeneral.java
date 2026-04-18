package semanasanta.TallerEjercicio2;

public class PacienteGeneral extends Paciente{
    private double copago;

    public PacienteGeneral(double copago, String Nombre, double CostoConsulta) {
        super(Nombre, CostoConsulta);
        this.copago = copago;
    }

    public PacienteGeneral() {
    }

    public double getCopago() {
        return copago;
    }

    public void setCopago(double copago) {
        this.copago = copago;
    }
    
    @Override
    public double calcularCostoFinal(){
        double Total = getCostoConsulta() + copago;
        return Total;
    }
}
