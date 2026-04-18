package SistemasEmpleados;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    String Nombre;
    double salarioBase, bono, pagoPorHora, tarifaProyecto;
    int opcion, horasTrabajadas, numProyectos;
    do{
    System.out.println("---------------------");
    System.out.println("SISTEMA DE EMPLEADOS");
    System.out.println("1. Empleado a tiempo completo");
    System.out.println("2. Empleado por horas");
    System.out.println("3. Empleado Freelance");
    System.out.println("4. Salir");
    System.out.println("---------------------");
    opcion = leer.nextInt();
    
    switch(opcion){
        case 1 ->{
                leer.nextLine();
            do{    
            System.out.print("Ingresa tu nombre: ");
            Nombre = leer.nextLine();
            
                if(Nombre == null || Nombre.trim().isEmpty()){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(Nombre == null || Nombre.trim().isEmpty());
            
            do{
            System.out.print("Ingresa tu salario Basico = ");
            salarioBase = leer.nextDouble();
            
                if(salarioBase <= 0){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(salarioBase <= 0);
            
                leer.nextLine();
                
            do{
            System.out.print("Digite el valor del bono a sumar a su salario = ");
            bono = leer.nextDouble();
            if(bono <= 0){
                System.out.println("Error: Ingresa bono valido");
            }
            }while(bono <= 0);
            
            var E1 = new EmpleadoTiempoCompelto(bono,Nombre,salarioBase);
            System.out.println();
            System.out.println("Empleado : " + E1.getNombre());
            System.out.print("Salario final = " + E1.calcularSalarioFinal());
            System.out.println();
            break;
        }

        case 2 ->{
            System.out.println();
                leer.nextLine();
            do{    
            System.out.print("Ingresa tu nombre: ");
            Nombre = leer.nextLine();
            
                if(Nombre == null || Nombre.trim().isEmpty()){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(Nombre == null || Nombre.trim().isEmpty());
            
            do{
            System.out.print("Ingresa tu salario Basico = ");
            salarioBase = leer.nextDouble();
            
                if(salarioBase <= 0){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(salarioBase <= 0);
            
            do{
            System.out.print("Ingresa la cantidad de horas trabajadas: ");
            horasTrabajadas = leer.nextInt();
                if(horasTrabajadas <= 0){
                    System.out.println("Error: Ingresa horas validas");
                }
            }while(horasTrabajadas <= 0);
            
                    leer.nextLine();
            
            do{
            System.out.print("Ingresa el valor por hora trabajada: ");
            pagoPorHora = leer.nextDouble();
            if(pagoPorHora <= 0){
                System.out.println("Error: Ingresa un valor valido");
                }
            }while(pagoPorHora <= 0);
            
            var E1 = new EmpleadoPorHoras(horasTrabajadas,pagoPorHora,Nombre,salarioBase);
            System.out.println();
            System.out.println("Empleado : " + E1.getNombre());
            System.out.print("Salario final = " + E1.calcularSalarioFinal());
            System.out.println();
            break;
        }
        
        case 3 ->{
               leer.nextLine();
            do{    
            System.out.print("Ingresa tu nombre: ");
            Nombre = leer.nextLine();
            
                if(Nombre == null || Nombre.trim().isEmpty()){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(Nombre == null || Nombre.trim().isEmpty());
            
            do{
            System.out.print("Ingresa tu salario Basico = ");
            salarioBase = leer.nextDouble();
            
                if(salarioBase <= 0){
                    System.out.println("Error: Intentalo de nuevo");
                }
            }while(salarioBase <= 0);
            
                leer.nextLine();
            do{
            System.out.print("Digite el valor de la tarifa del proyecto: ");
            tarifaProyecto = leer.nextDouble();
            if(tarifaProyecto < 0){
                System.out.println("Error: Ingresa una tarifa valida");
            }
            }while(tarifaProyecto <= 0);
            
                    leer.nextLine();
            do{        
            System.out.print("Digite el numero de proyectos realizados: ");
            numProyectos = leer.nextInt();
            }while(numProyectos <= 0);
            
            var E1 = new EmpleadoFreelance(tarifaProyecto,numProyectos,Nombre,salarioBase);
            System.out.println();
            System.out.println("Empleado : " + E1.getNombre());
            System.out.print("Salario final = " + E1.calcularSalarioFinal());
            System.out.println();
            break;
                }
            }
        }while(opcion != 4);
    }
}