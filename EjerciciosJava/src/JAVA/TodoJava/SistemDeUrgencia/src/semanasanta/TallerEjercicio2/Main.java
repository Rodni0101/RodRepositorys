package semanasanta.TallerEjercicio2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    int Opcion;
        do{
        System.out.println();
        System.out.println("-------HOSPITAL-------");
        System.out.println("1. Paciente general");
        System.out.println("2. Paciente Asegurado");
        System.out.println("3. Paciente en urgencia ");
        System.out.println("4. Salir");
        System.out.println("----------------------");
        Opcion = leer.nextInt();
        
        switch(Opcion){
            case 1 ->{
                var p1 = new PacienteGeneral();
                leer.nextLine();
                System.out.print("Ingrese su nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingrese el costo de la consulta: ");
                p1.setCostoConsulta(leer.nextDouble());
                System.out.print("Digite el valor de copago: ");
                p1.setCopago(leer.nextDouble());
               
                System.out.println();
                
                System.out.println("Referencia " + p1.getNombre());
                System.out.println("Total a pagar " + p1.calcularCostoFinal());
                System.out.println();
                break;
            }
            
            case 2 ->{
                var p1 = new PacienteAsegurado();
                leer.nextLine();
                System.out.print("Ingrese su nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingrese el costo de la consulta: ");
                p1.setCostoConsulta(leer.nextDouble());
                System.out.print("Digite el valor de cobertura del paciente: ");
                p1.setPorcentajeCobertura(leer.nextDouble() / 100);
               
                System.out.println();
                
                System.out.println("Referencia " + p1.getNombre());
                System.out.println("Total a pagar " + p1.calcularCostoFinal());
                System.out.println();
                break;
            }
            
            case 3 ->{
                var p1 = new PacienteUrgencias();
                leer.nextLine();
                System.out.print("Ingrese su nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingrese el costo de la consulta: ");
                p1.setCostoConsulta(leer.nextDouble());
                System.out.print("Digite el valor de recargo del paciente: ");
                p1.setRecargoUrgencia(leer.nextDouble());
                
                System.out.println();
                
                System.out.println("Referencia " + p1.getNombre());
                System.out.println("Total a pagar " + p1.calcularCostoFinal());
                System.out.println();
                break;
            }
        }
        }while(Opcion != 4);
    }
}