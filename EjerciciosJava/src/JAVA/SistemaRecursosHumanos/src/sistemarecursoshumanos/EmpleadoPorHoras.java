package sistemarecursoshumanos;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double pagoPorHoras;

    public EmpleadoPorHoras(int horasTrabajadas, double pagoPorHoras, String nombre, int edad, double salarioBase, String cargo, String departamento) {
        super(nombre, edad, salarioBase, cargo, departamento);
        setHorasTrabajadas(horasTrabajadas);
        setPagoPorHoras(pagoPorHoras);
    }

    public EmpleadoPorHoras() {
    }
    

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas < 0) {
            System.out.println("Error: Las horas trabajadas no pueden ser negativas.");
            this.horasTrabajadas = 0;
        } else {
            this.horasTrabajadas = horasTrabajadas;
        }
    }

    public double getPagoPorHoras() {
        return pagoPorHoras;
    }

    public void setPagoPorHoras(double pagoPorHoras) {
        if(pagoPorHoras < 0){
            System.out.println("Error: El pago por hora no puede ser negativo.");
        } else {
            this.pagoPorHoras = pagoPorHoras;
        }
    }

    public double calcularTotal(){
        return (horasTrabajadas * pagoPorHoras) + getSalarioBase();
    }  

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Horas trabajadas = " + horasTrabajadas);
        System.out.println("Pago por hora = " + pagoPorHoras);
        System.out.println("Total a pagar = " + calcularTotal());
    }
}