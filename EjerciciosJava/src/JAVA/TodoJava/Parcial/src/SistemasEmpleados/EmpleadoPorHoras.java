package SistemasEmpleados;

public class EmpleadoPorHoras extends Empleado{
 private int horasTrabajadas;
 private double pagoPorHora;

    public EmpleadoPorHoras(int horasTrabajadas, double pagoPorHora, String Nombre, double salarioBase) {
        super(Nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    public EmpleadoPorHoras() {
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if(horasTrabajadas >= 0){
        this.horasTrabajadas = horasTrabajadas;
    }else{
        System.out.println("Error: Las horas no puede ser negativas");
    }
}
    public double getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(double pagoPorHora) {
        if(pagoPorHora >= 0){
        this.pagoPorHora = pagoPorHora;
    }else{
            System.out.println("Error: El pago por las horas trabajadas no puede ser negativo");
        }
    }
 @Override
    public double calcularSalarioFinal(){
        super.getNombre();
        return pagoPorHora * horasTrabajadas + getSalarioBase();
    }
}