
package poo.Herencia.Ejercicio;

public class Conductor extends Personal{
    int Numero_Licencia;
    String Ruta_Asignada;
    
    
    public Conductor(){
    }

    public Conductor(int Numero_Licencia, String Ruta_Asignada, int ID, int DNI, String Nombre, String Apellido, String Direccion, long Telefono) {
        super(ID, DNI, Nombre, Apellido, Direccion, Telefono);
        this.Numero_Licencia = Numero_Licencia;
        this.Ruta_Asignada = Ruta_Asignada;
    }
    
    public int getNumero_Licencia() {
        return Numero_Licencia;
    }

    public void setNumero_Licencia(int Numero_Licencia) {
        this.Numero_Licencia = Numero_Licencia;
    }

    public String getRuta_Asignada() {
        return Ruta_Asignada;
    }

    public void setRuta_Asignada(String Ruta_Asignada) {
        this.Ruta_Asignada = Ruta_Asignada;
    }
        public void imprimirDatosConductor(){
        System.out.println("-----DATOS DE CONDUCTOR-----");
        System.out.println("Numero de licencia " + getNumero_Licencia());
        System.out.println("Ruta asignada " + getRuta_Asignada());
    }
}
