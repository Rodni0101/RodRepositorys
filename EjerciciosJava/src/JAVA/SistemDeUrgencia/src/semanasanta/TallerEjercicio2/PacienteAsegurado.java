package semanasanta.TallerEjercicio2;

public class PacienteAsegurado extends Paciente{
    private double porcentajeCobertura;

    public PacienteAsegurado(double porcentajeCobertura, String Nombre, double CostoConsulta) {
        super(Nombre, CostoConsulta);
        this.porcentajeCobertura = porcentajeCobertura;
    }

    public PacienteAsegurado() {
    }

    public double getPorcentajeCobertura() {
        return porcentajeCobertura;
    }

    public void setPorcentajeCobertura(double porcentajeCobertura) {
        this.porcentajeCobertura = porcentajeCobertura;
    }
    
    @Override
    public double calcularCostoFinal(){
        double Total = getCostoConsulta() - (getCostoConsulta() * porcentajeCobertura);
        return Total;
    }
}
