
package sistemadeserviciodesalud;

public class PacienteUrgencia extends Paciente{
    private int nivelUrgencia;
    
    public PacienteUrgencia(int nivelUrgencia,String Nombre, int Edad, String Documento){
        super(Nombre, Edad, Documento);
        setNivelUrgencia(nivelUrgencia);
    }
    
    public PacienteUrgencia(){
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        if(nivelUrgencia > 1 || nivelUrgencia < 5){
        this.nivelUrgencia = nivelUrgencia;
    }else{
            System.out.println("Error: nivel de urgencia invalido");
        }
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Nivel de urgencia presentado = " + nivelUrgencia);
    }
}
