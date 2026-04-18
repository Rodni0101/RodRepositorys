package semanasanta.TallerEjercicio2;

public class PacienteUrgencias extends Paciente{
private double recargoUrgencia;

    public PacienteUrgencias(double recargoUrgencia, String Nombre, double CostoConsulta) {
        super(Nombre, CostoConsulta);
        this.recargoUrgencia = recargoUrgencia;
    }

    public PacienteUrgencias() {
    }

    public double getRecargoUrgencia() {
        return recargoUrgencia;
    }

    public void setRecargoUrgencia(double recargoUrgencia) {
        this.recargoUrgencia = recargoUrgencia;
    }

@Override
    public double calcularCostoFinal(){
        double Total = getCostoConsulta() + recargoUrgencia;
        return Total;
    }

}
