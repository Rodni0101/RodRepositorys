package poo.Polimorfimos.ejercicio1;

public class Empleado {
    String nombre;
    double SalarioBase;
    
    
    public void calcularSalario(){
        System.out.println("Salario Base = " + SalarioBase);
    }
    public void llamarNombre(){
        System.out.println("Bienvenido " + nombre);
    }
    public Empleado(String nombre,double SalarioBase){
        this.nombre = nombre;
        this.SalarioBase = SalarioBase;
    }
    public Empleado(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(double SalarioBase) {
        this.SalarioBase = SalarioBase;
    }

    
}
