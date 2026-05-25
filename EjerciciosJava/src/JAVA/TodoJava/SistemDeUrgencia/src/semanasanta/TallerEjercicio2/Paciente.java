package semanasanta.TallerEjercicio2;

public class Paciente {
    private String Nombre;
    private double CostoConsulta;
    
    public Paciente(String Nombre, double CostoConsulta){
        this.Nombre = Nombre;
        this.CostoConsulta = CostoConsulta;
    }
    
    public Paciente(){
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getCostoConsulta() {
        return CostoConsulta;
    }

    public void setCostoConsulta(double CostoConsulta) {
        this.CostoConsulta = CostoConsulta;
    }
    
    public double calcularCostoFinal(){
        return CostoConsulta;
    }
}
