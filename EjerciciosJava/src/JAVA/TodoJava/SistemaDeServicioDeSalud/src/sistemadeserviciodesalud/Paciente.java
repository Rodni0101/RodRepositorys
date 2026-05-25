package sistemadeserviciodesalud;

public class Paciente {
private String Nombre;
private int Edad;
private String Documento;

public Paciente(String Nombre, int Edad, String Documento){
    setDocumento(Documento);
    setNombre(Nombre);
    setEdad(Edad);
}

public Paciente(){
}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if(Nombre == null || Nombre.trim().isEmpty()){
            System.out.println("Error: nombre invalido");
        }
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        if(Edad <= 0){
            System.out.println("Error: edad invalida");
        }else{
            this.Edad = Edad;
        }
    }
    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        if(Documento == null || Documento.trim().isEmpty()){
            System.out.println("Eror: Documento invalido");
        }
        this.Documento = Documento;
    }

public void mostrarInfo() {
    System.out.println("Nombre = " + Nombre);
    System.out.println("Edad = " + Edad);
    System.out.println("Documento = " + Documento);
}
}
