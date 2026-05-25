package gestionempleos;
import java.util.Scanner;
public class GestionEmpleos {

    public static void main(String[] args) {
        Scanner learn = new Scanner(System.in);
        Empleado n1 = new Empleado();
        System.out.println("Ingrese su nombre: ");
        n1.nombre = learn.nextLine();
        System.out.println("Ingrese su cargo en la empresa: ");
        n1.cargo = learn.nextLine();
        System.out.println("Digite su identificacion: ");
        n1.id = learn.nextInt();
        System.out.println("Digite tu salario basico: ");
        n1.Salario_Base = learn.nextDouble();
        System.out.println("Digite la cantidad de horas extras trabajadas: ");
        n1.Cant_HorasExtra = learn.nextDouble();
        n1.Imprenta();
        n1.Calculo();
    }            
}
