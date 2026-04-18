 package sistemarecursoshumanos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n-----SISTEMA DE RECURSOS HUMANOS-----");
            System.out.println("Tipos de empleados:");
            System.out.println("1. Empleado por horas");
            System.out.println("2. Empleado pasante");
            System.out.println("3. Empleado tiempo completo");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine(); 

            switch (opcion) {
                case 1 -> { 
                    var empHoras = new EmpleadoPorHoras();

                    do {
                        System.out.print("Nombre: ");
                        empHoras.setNombre(leer.nextLine());
                    } while (empHoras.getNombre() == null || empHoras.getNombre().trim().isEmpty());

                    int edad;
                    
                    do {       
                        System.out.print("Edad: ");
                        edad = leer.nextInt();
                        if (edad <= 0) System.out.println("Error: Edad debe ser mayor a 0");
                    } while (edad <= 0);
                    empHoras.setEdad(edad);

                    double salario;
                    
                    do {
                        System.out.print("Salario base: ");
                        salario = leer.nextDouble();
                        if (salario <= 0) System.out.println("Error: Salario debe ser mayor a 0");
                    } while (salario <= 0);
                    empHoras.setSalarioBase(salario);

                    leer.nextLine();

                    do {
                        System.out.print("Cargo: ");
                        empHoras.setCargo(leer.nextLine());
                    } while (empHoras.getCargo() == null || empHoras.getCargo().trim().isEmpty());

                    do {
                        System.out.print("Departamento: ");
                        empHoras.setDepartamento(leer.nextLine());
                    } while (empHoras.getDepartamento() == null || empHoras.getDepartamento().trim().isEmpty());

                    int horas;
                    do {
                        System.out.print("Horas trabajadas: ");
                        horas = leer.nextInt();
                        if (horas < 0) System.out.println("Error: Horas no pueden ser negativas");
                    } while (horas < 0);
                    empHoras.setHorasTrabajadas(horas);

                    double pagoHora;
                    do {
                        System.out.print("Pago por hora: ");
                        pagoHora = leer.nextDouble();
                        if (pagoHora < 0) System.out.println("Error: Pago por hora no puede ser negativo");
                    } while (pagoHora < 0);
                    empHoras.setPagoPorHoras(pagoHora);

                    System.out.println("\n=== Informacion del empleado ===");
                    empHoras.mostrarInfo();
                }

                case 2 -> { 
                    var empPasante = new EmpleadoPasante();
                    
                    do {
                        System.out.print("Nombre: ");
                        empPasante.setNombre(leer.nextLine());
                    } while (empPasante.getNombre() == null || empPasante.getNombre().trim().isEmpty());

                    int edad;
                    do {
                        System.out.print("Edad: ");
                        edad = leer.nextInt();
                        if (edad <= 0) System.out.println("Error: Edad debe ser mayor a 0");
                    } while (edad <= 0);
                    empPasante.setEdad(edad);

                    double salario;
                    do {
                        System.out.print("Salario base: ");
                        salario = leer.nextDouble();
                        if (salario <= 0) System.out.println("Error: Salario debe ser mayor a 0");
                    } while (salario <= 0);
                    empPasante.setSalarioBase(salario);

                    leer.nextLine();

                    do {
                        System.out.print("Cargo: ");
                        empPasante.setCargo(leer.nextLine());
                    } while (empPasante.getCargo() == null || empPasante.getCargo().trim().isEmpty());

                    do {
                        System.out.print("Departamento: ");
                        empPasante.setDepartamento(leer.nextLine());
                    } while (empPasante.getDepartamento() == null || empPasante.getDepartamento().trim().isEmpty());

                    do {
                        System.out.print("Universidad: ");
                        empPasante.setUniversidad(leer.nextLine());
                    } while (empPasante.getUniversidad() == null || empPasante.getUniversidad().trim().isEmpty());

                    do {
                        System.out.print("Carrera: ");
                        empPasante.setCarrera(leer.nextLine());
                    } while (empPasante.getCarrera() == null || empPasante.getCarrera().trim().isEmpty());

                    System.out.println("\n=== Informacion del empleado ===");
                    empPasante.mostrarInfo();
                }

                case 3 -> {
                    var empCompleto = new EmpleadoTiempoCompleto();

                    do {
                        System.out.print("Nombre: ");
                        empCompleto.setNombre(leer.nextLine());
                    } while (empCompleto.getNombre() == null || empCompleto.getNombre().trim().isEmpty());

                    int edad;
                    do {
                        System.out.print("Edad: ");
                        edad = leer.nextInt();
                        if (edad <= 0) System.out.println("Error: Edad debe ser mayor a 0");
                    } while (edad <= 0);
                    empCompleto.setEdad(edad);

                    double salario;
                    do {
                        System.out.print("Salario base: ");
                        salario = leer.nextDouble();
                        if (salario <= 0) System.out.println("Error: Salario debe ser mayor a 0");
                    } while (salario <= 0);
                    empCompleto.setSalarioBase(salario);

                    leer.nextLine();

                    do {
                        System.out.print("Cargo: ");
                        empCompleto.setCargo(leer.nextLine());
                    } while (empCompleto.getCargo() == null || empCompleto.getCargo().trim().isEmpty());

                    do {
                        System.out.print("Departamento: ");
                        empCompleto.setDepartamento(leer.nextLine());
                    } while (empCompleto.getDepartamento() == null || empCompleto.getDepartamento().trim().isEmpty());

                    double bono;
                    do {
                        System.out.print("Bono anual: ");
                        bono = leer.nextDouble();
                        if (bono < 0) System.out.println("Error: Bono no puede ser negativo");
                    } while (bono < 0);
                    empCompleto.setBonoAnual(bono);

                    int horas;
                    do {
                        System.out.print("Horas semanales: ");
                        horas = leer.nextInt();
                        if (horas <= 0) System.out.println("Error: Horas semanales deben ser mayores a 0");
                    } while (horas <= 0);
                    empCompleto.setHorasSemanales(horas);

                    leer.nextLine(); 

                    do {
                        System.out.print("Tipo de contrato: ");
                        empCompleto.setTipoContrato(leer.nextLine());
                    } while (empCompleto.getTipoContrato() == null || empCompleto.getTipoContrato().trim().isEmpty());

                    int años;
                    do {
                        System.out.print("Años en empresa: ");
                        años = leer.nextInt();
                        if (años < 0) System.out.println("Error: Años en empresa no puede ser negativo");
                    } while (años < 0);
                    empCompleto.setAñosEnEmpresa(años);

                    System.out.println("\n=== Informacion del empleado ===");
                    empCompleto.mostrarInfo();
                }

                case 4 -> System.out.println("Saliendo del sistema...");
            }

        } while (opcion != 4);
    }
}