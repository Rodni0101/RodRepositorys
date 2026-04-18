
package poo.Herencia;

public class Empleado extends Persona {
    int codigo_empleado;
    String cargo;
    double sueldo;

    public Empleado() {
    }

    public Empleado(int codigo_empleado, String cargo, double sueldo, int id, String Dni, String nombre, String apellido, String domicilio, int telefono) {
        super(id, Dni, nombre, apellido, domicilio, telefono);
        this.codigo_empleado = codigo_empleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
