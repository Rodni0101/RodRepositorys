
package SistemasEmpleados;

public class EmpleadoFreelance extends Empleado{
    private double tarifaProyecto;
    private int numProyectos;

    public EmpleadoFreelance(double tarifaProyecto, int numProyectos, String Nombre, double salarioBase) {
        super(Nombre, salarioBase);
        setTarifaProyecto(tarifaProyecto);
        setNumProyectos(numProyectos);
    }

    public EmpleadoFreelance() {
    }

    public double getTarifaProyecto() {
        return tarifaProyecto;
    }

    public void setTarifaProyecto(double tarifaProyecto) {
        if(tarifaProyecto >= 0){
        this.tarifaProyecto = tarifaProyecto;
    }else{
            System.out.println("Error: La tarifa no puede ser negativa");
        }
    }
    
    public int getNumProyectos(){
        return numProyectos;
    }

    public void setNumProyectos(int numProyectos) {
        if(numProyectos >= 0){
        this.numProyectos = numProyectos;
    }else{
            System.out.println("Error: El numero de proyectos no puede ser negativo");
        }
    }
    
    @Override
    public double calcularSalarioFinal(){
        super.getNombre();
        return (tarifaProyecto * numProyectos) + getSalarioBase();
    }
}
