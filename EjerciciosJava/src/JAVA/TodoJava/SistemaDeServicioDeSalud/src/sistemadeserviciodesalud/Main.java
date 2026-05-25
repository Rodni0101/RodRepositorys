package sistemadeserviciodesalud;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int Opcion;
       String motivoConsulta;
       String fechaCita;
       String horaCita;
       String especialidad;
       int nivelUrgencia;
       
        Scanner leer = new Scanner(System.in);
        do{
        System.out.println("---SISTEMA DE SALUD---");
        System.out.println("INGRESA DATOS BASICOS");
        String Nombre;
        do{
        System.out.print("Ingresa el nombre: ");
        Nombre = leer.nextLine();
        if(Nombre.isEmpty()){
        System.out.println("Error, ingresa un nombre válido");
    }

        } while(Nombre.isEmpty());
        
        int Edad;
        
        do {
        System.out.print("Ingresa la edad: ");
        Edad = leer.nextInt();
        if(Edad <= 0){
        System.out.println("Error, ingresa un valor válido");
    }
        
        } while (Edad <= 0);
        leer.nextLine();
        
        String Documento;

        do {
        System.out.print("Ingresa el documento: ");
        Documento = leer.nextLine();

        if(Documento.isEmpty()){
        System.out.println("Error, ingresa un valor válido");
    }

        } while(Documento.isEmpty());
       
        System.out.println();
        System.out.println("----ELECCION DE PACIENTE----");
        System.out.println("1. General");
        System.out.println("2. Con Cita");
        System.out.println("3. Urgencias");
        System.out.println("4. Salir");
        Opcion = leer.nextInt();
        

    switch(Opcion){
    case 1 -> {
        leer.nextLine();
        do{
        System.out.print("Motivo de consulta:");
        motivoConsulta = leer.nextLine();
        if(motivoConsulta.isEmpty()){
            System.out.println("ERROR");
    }
        }while(motivoConsulta.isEmpty());
        
        var p = new PacienteGeneral(motivoConsulta, Nombre,Edad,Documento);
        System.out.println();
        System.out.println("---DATOS---");
        p.mostrarInfo();
        System.out.println("------------------------");
        System.out.println();
        break;
        }
    case 2 -> {
        leer.nextLine();
        do{
        System.out.print("Ingresa la fecha:");
        fechaCita = leer.nextLine();
        if(fechaCita.isEmpty()){
            System.out.println("ERROR");
        }
        }while(fechaCita.isEmpty());
        
        do{
        System.out.print("Ingresa la hora:");
        horaCita = leer.nextLine();
        if(horaCita.isEmpty()){
            System.out.println("ERROR");
        }
        }while(horaCita.isEmpty());
        
        do{
        System.out.print("Ingresa la especialidad:");
        especialidad = leer.nextLine();
        if(especialidad.isEmpty()){
            System.out.println("ERROR");
        }
        }while(especialidad.isEmpty());
        
        var p = new PacienteConCita(fechaCita, horaCita, Nombre, Edad, Documento);
        System.out.println();
        System.out.println("---DATOS---");
        p.mostrarInfo();
        System.out.println("------------------------");
        System.out.println();
        break;
    }
    case 3 -> {
        leer.nextLine();
        do{
        System.out.print("Nivel de urgencia (1-5):");
        nivelUrgencia = leer.nextInt();
        if(nivelUrgencia < 1 || nivelUrgencia > 5){
            System.out.println("ERROR");
        }
        }while(nivelUrgencia < 1 || nivelUrgencia > 5);
        leer.nextLine();
        
        var p = new PacienteUrgencia(nivelUrgencia, Nombre, Edad, Documento);
        System.out.println();
        System.out.println("---DATOS---");
        p.mostrarInfo();
        System.out.println("------------------------");
        System.out.println();
        break;        
            }
        }
    }while(Opcion != 4);
    }
}