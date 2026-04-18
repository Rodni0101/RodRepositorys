package sistemarecursoshumanos;

public class Empleado {
    private String Nombre;
    private int Edad;
    private double salarioBase;
    private String Cargo;
    private String Departamento;

    public Empleado(String Nombre, int Edad, double salarioBase, String Cargo, String Departamento) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.salarioBase = salarioBase;
        this.Cargo = Cargo;
        this.Departamento = Departamento;
    }

    public Empleado() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if(Nombre == null || Nombre.trim().isEmpty()){
            System.out.println("Error: nombre invalido");
        }else{
        this.Nombre = Nombre;
        }
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase < 0){
            System.out.println("Error: Valor invalido");
        }else{
        this.salarioBase = salarioBase;
        }
    }
    
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        if(Cargo == null || Cargo.trim().isEmpty()){
            System.out.println("Error: cargo invalido");
        }else{
        this.Cargo = Cargo;
        }
    }
    
    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        if(Departamento == null || Departamento.trim().isEmpty()){
            System.out.println("Error: Departamento invalido");
        }
        this.Departamento = Departamento;
    }
    
    public void mostrarInfo(){
        System.out.println("Nombre = " + Nombre);
        System.out.println("Edad = " + Edad);
        System.out.println("Salario Base = " + salarioBase);
        System.out.println("Cargo = " + Cargo);
        System.out.println("Departamento = " + Departamento);
    }
}
