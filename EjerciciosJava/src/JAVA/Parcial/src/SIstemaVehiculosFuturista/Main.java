package SIstemaVehiculosFuturista;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
    
        int opcion,tripulacion,numRuedas,altitudMax,NavesTotales = 0;
        String Marca,Modelo,TipEnergia,tipoPropulsion,tipTerreno,tipAlas;
        double VelocidadMax;
        do{
        System.out.println("-------------------------");
        System.out.println("SISTMA DE VEHICULOS");
        System.out.println("1. Nave Espacial");
        System.out.println("2. Vehiculo Terrestre");
        System.out.println("3. Vehiculo Aereo");
        System.out.println("4. Salir");
        System.out.println("-----------------------------");
        opcion = leer.nextInt();
        switch(opcion){
            case 1 ->{
                leer.nextLine();
                System.out.println();
           do{
           System.out.print("Ingresa la marca del vehiculo: ");
            Marca = leer.nextLine();
            
                if(Marca == null || Marca.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Marca == null || Marca.trim().isEmpty());
            
           do{ 
           System.out.print("Ingresa el modelo del vehiculo: ");
             Modelo = leer.nextLine();
            
                if(Modelo == null || Modelo.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Modelo == null || Modelo.trim().isEmpty());
            
           do{ 
           System.out.print("Ingresa la velocidad maxima del vehiculo: ");
             VelocidadMax = leer.nextDouble();
            
                if(VelocidadMax <= 0){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(VelocidadMax <= 0);
            
                leer.nextLine();
                
            do{    
           System.out.print("Ingrese el tipo de energia: ");
             TipEnergia = leer.nextLine();
            
                if(TipEnergia == null || TipEnergia.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(TipEnergia == null || TipEnergia.trim().isEmpty());
            
           do{ 
           System.out.print("Ingresa el tipo de propulsion del vehiculo: ");
            tipoPropulsion = leer.nextLine();
            
                if(tipoPropulsion == null || tipoPropulsion.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(tipoPropulsion == null || tipoPropulsion.trim().isEmpty());
            
           do{ 
            
           System.out.print("Ingresa la cantidad de tripulantes: ");
           tripulacion = leer.nextInt();
            
                if(tripulacion <= 0){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(tripulacion <= 0);
            
                leer.nextLine();
                System.out.println();
           var V1 = new NaveEspacial(tripulacion,tipoPropulsion,Marca,Modelo,VelocidadMax,TipEnergia);
               NavesTotales++;
               System.out.println();
               V1.mostrarInfo();
               System.out.println("Total de vehiculos registradas = " + NavesTotales);
                System.out.println();
                
                break;
              }

            case 2 ->{
                leer.nextLine();
                System.out.println();
           do{     
           System.out.print("Ingresa la marca del vehiculo: ");
            Marca = leer.nextLine();
            
                if(Marca == null || Marca.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Marca == null || Marca.trim().isEmpty());
            
           do{
           System.out.print("Ingresa el modelo del vehiculo: ");
           Modelo = leer.nextLine();
                if(Modelo == null || Modelo.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Modelo == null || Modelo.trim().isEmpty());
            
            do{
           System.out.print("Ingresa la velocidad maxima del vehiculo: ");
            VelocidadMax = leer.nextDouble();
                if(VelocidadMax <= 0){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(VelocidadMax <= 0);
            
                leer.nextLine();
                
            do{    
           System.out.print("Ingrese el tipo de energia: ");
            TipEnergia = leer.nextLine();
            
                if(TipEnergia == null || TipEnergia.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(TipEnergia == null || TipEnergia.trim().isEmpty());
            
            do{
           System.out.print("Ingresa el numero de ruedas del vehiculo: ");
            numRuedas = leer.nextInt();
            
                if(numRuedas <= 0 && numRuedas >= 4){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(numRuedas <= 0 && numRuedas >= 4);
            
                    leer.nextLine();
            
           do{
           System.out.print("Ingresa el tipo de terreno: ");
            tipTerreno = leer.nextLine();
            
                if(tipTerreno == null || tipTerreno.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(tipTerreno == null || tipTerreno.trim().isEmpty());
            System.out.println();
           var V1 = new VehiculoTerrestre(numRuedas,tipTerreno,Marca,Modelo,VelocidadMax,TipEnergia);
               NavesTotales++;
               System.out.println();
               V1.mostrarInfo();
               System.out.println("Total de vehiculos registradas = " + NavesTotales);
               System.out.println();
               
               break;
            }
            case 3->{
                 leer.nextLine();
                System.out.println();
           do{
           System.out.print("Ingresa la marca del vehiculo: ");
            Marca = leer.nextLine();
            
                if(Marca == null || Marca.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Marca == null || Marca.trim().isEmpty());
            
            do{
           System.out.print("Ingresa el modelo del vehiculo: ");
            Modelo = leer.nextLine();
            
                if(Modelo == null || Modelo.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(Modelo == null || Modelo.trim().isEmpty());
            
            do{
           System.out.print("Ingresa la velocidad maxima del vehiculo: ");
            VelocidadMax = leer.nextDouble();
            
                if(VelocidadMax <= 0){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(VelocidadMax <= 0);
            
                leer.nextLine();
               
            do{    
           System.out.print("Ingrese el tipo de energia: ");
            TipEnergia = leer.nextLine();
            
                if(TipEnergia == null || TipEnergia.trim().isEmpty()){
                    System.out.println("Error: Intenta de nuevo");
                }
            }while(TipEnergia == null || TipEnergia.trim().isEmpty());
            
            do{
           System.out.println("Ingresa la altitud maxima (10-300): ");
            altitudMax = leer.nextInt();
    
                if(altitudMax <= 10 && altitudMax >= 300){
                System.out.println("Error: Altitud fuera de rango");
            }
            }while(altitudMax <= 10 && altitudMax >= 300);
            
                 leer.nextLine();
               
           do{
           System.out.print("Ingresa el tipo de alas del vehiculo: ");
            tipAlas = leer.nextLine();
            
                if(tipAlas == null || tipAlas.trim().isEmpty()){
                    System.out.println("Error: Tipo de alas invalido");
                }
            }while(tipAlas == null || tipAlas.trim().isEmpty());
            System.out.println();
            var V1 = new VehiculoAereo(altitudMax,tipAlas,Marca,Modelo,VelocidadMax,TipEnergia);
                NavesTotales++;
                System.out.println();
                V1.mostrarInfo();
                System.out.println("Total de vehiculos registradas = " + NavesTotales);
            System.out.println();
                }
            }
        }while(opcion != 4);
    }
}