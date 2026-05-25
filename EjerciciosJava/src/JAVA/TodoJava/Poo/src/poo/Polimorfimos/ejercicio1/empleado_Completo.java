
package poo.Polimorfimos.ejercicio1;

public class empleado_Completo extends Empleado {
    double bono;


    public empleado_Completo(double bono, String nombre, double SalarioBase) {
        super(nombre, SalarioBase);
        this.bono = bono;
    }
    
    public empleado_Completo(){
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }
    

    @Override
        public void calcularSalario(){
        double total = SalarioBase + bono;
        System.out.println("Salario = " + total);
    }
    
}
