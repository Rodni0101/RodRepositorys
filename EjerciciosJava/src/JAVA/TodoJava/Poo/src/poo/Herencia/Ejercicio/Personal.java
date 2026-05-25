package poo.Herencia.Ejercicio;
public class Personal {
    int ID;
    int DNI;
    String Nombre;
    String Apellido;
    String Direccion;
    long Telefono;
    
    public Personal(int ID, int DNI, String Nombre, String Apellido, String Direccion, long Telefono){
        this.ID = ID;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }
    public Personal(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }
       public void imprimirDatosPadre(){
        System.out.println("Nombre del conductor " + getNombre());
        System.out.println("Apellido " + getApellido());
        System.out.println("ID " + getID());
        System.out.println("Identificacion " + getDNI());
        System.out.println("Numero de telefono " + getTelefono());
        System.out.println("Direccion " + getDireccion());
    }
}
