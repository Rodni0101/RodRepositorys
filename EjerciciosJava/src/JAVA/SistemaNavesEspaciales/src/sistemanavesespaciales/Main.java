
package sistemanavesespaciales;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String Nombre;
        String tipoCombustible;
        double Velocidad;
        int Opcion, cantPasajeros, nivelArmamento,escudo,Carga;
       
        System.out.println("SISTEMA DE NAVES");
        do{
        System.out.println("INGRESA DATOS BASICOS");
        do{
            System.out.println("Ingrese su nombre: ");
            Nombre = leer.nextLine();        
            if(Nombre.isEmpty()){
            System.out.println("Error: Vuelva a ingresar un nombre valido");
               }
            }while(Nombre.isEmpty());
        
        do{
        System.out.println("Ingresa la velocidad maxima de la nave: ");
        Velocidad = leer.nextDouble();
        leer.nextLine();
        
        if(Velocidad <= 0){
            System.out.println("Error: Velocidad ingresadad invalida, vuelva a ingresar");
        }
        }while(Velocidad <= 0);
        
        do{
        System.out.println("Ingresa el tipo de combustible: ");
        tipoCombustible = leer.nextLine();
        if(tipoCombustible.isEmpty()){
            System.out.println("Error: tipo de combustible invalido, vuelva a ingresar");    
            }
            System.out.println();
        }while(tipoCombustible.isEmpty());
            System.out.println("Seleccione el tipo de nave que solicita");
            System.out.println("1. Nave Tripulada");
            System.out.println("2. Nave de carga");
            System.out.println("3. Nave de combate");
            System.out.println("4. Salir");
            Opcion = leer.nextInt();
            System.out.println();
            
            switch(Opcion){
case 1 -> {
    do {
        System.out.print("Ingresa la cantidad de pasajeros: ");
        cantPasajeros = leer.nextInt();
        
        if (cantPasajeros <= 0) {
            System.out.println("ERROR, CANTIDAD DE PASAJEROS NO VALIDA");
        }
    } while (cantPasajeros <= 0);

    var n1 = new NaveTripulada(cantPasajeros, Velocidad, tipoCombustible, Nombre);

    System.out.println("DATOS DE LA NAVE");
    System.out.println("-----------------");
    n1.mostrarInfo();
    System.out.println("-----------------");
}
                
case 2 -> {
    do {
        System.out.println("Ingresa la carga a transportar");
        Carga = leer.nextInt();

        if (Carga <= 0) {
            System.out.println("ERROR, CARGA INVALIDA");
        }
    } while (Carga <= 0);

    var n1 = new NaveDeCarga(Carga, Velocidad, tipoCombustible, Nombre);

    System.out.println("DATOS DE LA NAVE");
    System.out.println("-----------------");
    n1.mostrarInfo();
    System.out.println("-----------------");
}
                
case 3 -> {
    do {
        System.out.print("Digite el nivel del armamento (1-10): ");
        nivelArmamento = leer.nextInt();

        if (nivelArmamento < 1 || nivelArmamento > 10) {
            System.out.println("Nivel de armamento invalido");
        }
    } while (nivelArmamento < 1 || nivelArmamento > 10);

    do {
        System.out.print("Digite el nivel de los escudos: ");
        escudo = leer.nextInt();

        if (escudo <= 0) {
            System.out.println("Nivel de escudo invalido");
        }
    } while (escudo <= 0);

    //nota (Sacar el objeto de los ciclos para evitar la creacion de objetos con datos invalidos
    var n1 = new NaveCombate(nivelArmamento, escudo, Velocidad, tipoCombustible, Nombre);

    System.out.println("DATOS DE LA NAVE");
    System.out.println("-----------------");
    n1.mostrarInfo();
    System.out.println("-----------------");
                }    
            }
        }while(Opcion != 4);
    }
}