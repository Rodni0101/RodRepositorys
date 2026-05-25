
package SistemasEmpleados;

public class EmpleadoTiempoCompelto extends Empleado{
    private double bono;

    public EmpleadoTiempoCompelto(double bono, String Nombre, double salarioBase) {
        super(Nombre, salarioBase);
        setBono(bono);
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        if(bono >=  0){
        this.bono = bono;
    }else{
            System.out.println("Error: Bono invalido");
        }
    }
    
    public EmpleadoTiempoCompelto() {
    }
    
    @Override
    public double calcularSalarioFinal(){
        super.getNombre();
        return getSalarioBase() + bono;
    }
}
