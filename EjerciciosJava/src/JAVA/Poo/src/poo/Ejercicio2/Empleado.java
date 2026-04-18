
package poo.Ejercicio2;

public class Empleado {
    private String nombre;
    private double salarioBase;
    private int horasExtras;

    public Empleado(String nombre, double salarioBase, int horasExtras) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
     
    public void Calculo(){
        int valorPagarXhora = horasExtras * 20000;
        int salarioTotal = (int) (salarioBase + valorPagarXhora);
        
        System.out.println("Nombre del Empleado: " + nombre);
        System.out.println("Horas extras trabajadas: " + horasExtras);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Valor a pagar por horas extras trabajadas = " + valorPagarXhora);
        System.out.println("Salario total a pagar: " + salarioTotal);
        
        if(salarioTotal > 2000000){
            System.out.println("Tiene bono");
        }else{
            System.out.println("No tiene bono");
        }   
    }
}
