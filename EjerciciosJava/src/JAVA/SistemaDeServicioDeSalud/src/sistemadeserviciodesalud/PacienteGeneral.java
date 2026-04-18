package sistemadeserviciodesalud;
public class PacienteGeneral extends Paciente{
private String motivoConsulta;

public  PacienteGeneral(String motivoConsulta,String Nombre,int Edad,String Documento){
    super(Nombre, Edad, Documento);
    setMotivoConsulta(motivoConsulta);
    }

public PacienteGeneral(){
}

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        if(motivoConsulta == null || motivoConsulta.trim().isEmpty()){
            System.out.println("Error: Motivo de consulta invalido");
        }
        this.motivoConsulta = motivoConsulta;
    }

@Override
public void mostrarInfo() {
    super.mostrarInfo();
    System.out.println("Motivo de consulta: " + motivoConsulta);
    }
}
