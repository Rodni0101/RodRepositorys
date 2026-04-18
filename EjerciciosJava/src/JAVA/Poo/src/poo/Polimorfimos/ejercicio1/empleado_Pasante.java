
package poo.Polimorfimos.ejercicio1;

public class empleado_Pasante extends Empleado {
    @Override
    public void calcularSalario(){
        double total = SalarioBase * 0.08;
        System.out.println("Salario del pasante: " + total);
    }

    public empleado_Pasante(String nombre, double SalarioBase) {
        super(nombre, SalarioBase);
    }
    
    public empleado_Pasante(){
    }
}
