package poo.Herencia.Ejercicio;

public class Administrativo extends Personal {
    String Departamento;
    double Salario;
    
    public Administrativo(){
    }
    
    public Administrativo(String Departamento, double Salario, int ID, int DNI, String Nombre, String Apellido, String Direccion, long Telefono) {
        super(ID, DNI, Nombre, Apellido, Direccion, Telefono);
        this.Departamento = Departamento;
        this.Salario = Salario;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
}
