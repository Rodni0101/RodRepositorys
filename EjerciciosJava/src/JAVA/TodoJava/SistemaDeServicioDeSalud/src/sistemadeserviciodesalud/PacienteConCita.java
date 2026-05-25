
package sistemadeserviciodesalud;

public class PacienteConCita extends Paciente{
    private String fechacita;
    private String horaCita;
    
    public PacienteConCita(String fechacita, String horaCita, String Nombre, int Edad, String Documento){
        super(Nombre, Edad, Documento);
        setFechacita(fechacita);
        setHoraCita(horaCita);
    }
    
    public PacienteConCita(){
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Fecha de la cita = " + fechacita);
        System.out.println("Horacita de la cita = " + horaCita);
    }
}
