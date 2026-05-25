
package poo.Herencia;

public class Consultor extends Persona {
    String nombre_Consultor;
    int num_Consultor;
    
    public Consultor(){   
    }

    public Consultor(String nombre_Consultor, int num_Consultor, int id, String Dni, String nombre, String apellido, String domicilio, int telefono) {
        super(id, Dni, nombre, apellido, domicilio, telefono);
        this.nombre_Consultor = nombre_Consultor;
        this.num_Consultor = num_Consultor;
    }
    
    
    public String getNombre_Consultor() {
        return nombre_Consultor;
    }

    public void setNombre_Consultor(String nombre_Consultor) {
        this.nombre_Consultor = nombre_Consultor;
    }

    public int getNum_Consultor() {
        return num_Consultor;
    }

    public void setNum_Consultor(int num_Consultor) {
        this.num_Consultor = num_Consultor;
    }
    
}
