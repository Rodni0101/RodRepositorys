
package poo.Herencia;

public class Persona {
    int id;
    String Dni;
    String nombre;
    String apellido;
    String domicilio;
    int telefono;
    
    public Persona(int id, String Dni, String nombre, String apellido, String domicilio, int telefono){
    this.id = id;
    this.Dni = Dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.domicilio = domicilio;
    this.telefono = telefono;
}
    public Persona(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
