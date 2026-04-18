
package poo.Polimorfimos.ejercicio1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Empleado p1;
        System.out.println("Ingrese que tipo de empleado es");
        System.out.println("1.empleado ordinario");
        System.out.println("2.Empleado a tiempo completo");
        System.out.println("3.Pasante");
        System.out.println("---------------------------");
        int opcion = leer.nextInt();
        
        leer.nextLine();
        
        switch(opcion){
            case 1 -> {
                p1 = new Empleado();
                System.out.print("Ingresa tu nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingresa tu salario: ");
                p1.setSalarioBase(leer.nextDouble());
                p1.llamarNombre();
                p1.calcularSalario();
            }
                
            case 2 -> {
                p1 = new empleado_Completo();
                System.out.print("Ingresa tu nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingresa tu salario: ");
                p1.setSalarioBase(leer.nextDouble());
                System.out.print("Ingresa tu bono: ");
                ((empleado_Completo)p1).setBono(leer.nextDouble());
                p1.llamarNombre();
                p1.calcularSalario();
            }
            
            case 3 -> {
                p1 = new empleado_Pasante();
                System.out.print("Ingresa tu nombre: ");
                p1.setNombre(leer.nextLine());
                System.out.print("Ingresa tu salario: ");
                p1.setSalarioBase(leer.nextDouble());
                   
                p1.llamarNombre();
                p1.calcularSalario();
            }
           }
        }
    }

