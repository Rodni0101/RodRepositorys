
package SistemasEmpleados;

public class Empleado {
    private String Nombre;
    private double salarioBase;

    public Empleado(String Nombre, double salarioBase) {
        setNombre(Nombre);
        setSalarioBase(salarioBase);
    }

    public Empleado() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if(Nombre == null || Nombre.trim().isEmpty()){
            System.out.println("Error: Nombre invalido");
        }else{
        this.Nombre = Nombre;
        }
    }
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase >= 0){
        this.salarioBase = salarioBase;
    }else{
            System.out.println("Error: Salario Invalido");
        }
    }
    public double calcularSalarioFinal(){
        return salarioBase;
    }
}
