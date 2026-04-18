
package gestionempleos;
import java.text.DecimalFormat;
public class Empleado {
    int id;
    String nombre;
    String cargo;
    double Salario_Base;
    int Horas_Extras = 20;
    double Cant_HorasExtra;

    public Empleado(int id, String nombre, String cargo, double Salario_Base, double Cant_HorasExtra) {
        this.Cant_HorasExtra = 0;
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.Salario_Base = Salario_Base;
        this.Cant_HorasExtra = Cant_HorasExtra;
    }

    public Empleado() {                                                                                                                                                                                                                                                        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario_Base() {
        return Salario_Base;
    }

    public void setSalario_Base(double Salario_Base) {
        this.Salario_Base = Salario_Base;
    }

    public double getHoras_Extras() {
        return Horas_Extras;
    }

    public void setHoras_Extras(int Horas_Extras) {
        this.Horas_Extras = Horas_Extras;
    }
    public void Calculo(){
    double valorHoraExtra = Horas_Extras;
    
    double salarioTotal = Salario_Base + (Cant_HorasExtra * valorHoraExtra);

    DecimalFormat df = new DecimalFormat("#");
    
    System.out.println("Salario total " + df.format(salarioTotal));
    System.out.println("Cantidad de horas extras trabajadas: " + Cant_HorasExtra);
    System.out.println("Valor por hora extra = " + valorHoraExtra);
        
    }
    
    public void Imprenta(){
        System.out.println("Su nombre: " + nombre);
        System.out.println("Su identificacion: " + id);
        System.out.println("Su cargo: " + cargo);
    }
}
