package sistemadecriaturas;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       int Opcion;
       double tamañoAlas;
       double profundidadMaxima;
       int Fuerza;
       
        Scanner leer = new Scanner(System.in);
        do{
        System.out.println("---SISTEMA DE CRIATURAS---");
        System.out.println("INGRESA DATOS BASICOS");
        String Nombre;
        do{
        System.out.print("Ingresa el nombre: ");
        Nombre = leer.nextLine();
        if(Nombre.isEmpty()){
        System.out.println("Error, ingresa un nombre válido");
    }

        } while(Nombre.isEmpty());
        
        int NivelEnergia;
        
        do {
        System.out.print("Ingresa el nivel de energia: ");
        NivelEnergia = leer.nextInt();
        if(NivelEnergia <= 0){
        System.out.println("Error, ingresa un valor válido");
    }
        
        } while (NivelEnergia < 0);
        leer.nextLine();
        
        String tipoADN;

        do {
        System.out.print("Ingresa el tipo de ADN: ");
        tipoADN = leer.nextLine();

        if(tipoADN.isEmpty()){
        System.out.println("Error, ingresa un valor válido");
    }

        } while(tipoADN.isEmpty());
       
        System.out.println();
        System.out.println("----ELECCION DE CRIATURA----");
        System.out.println("1. Voladora");
        System.out.println("2. Acuatica");
        System.out.println("3. Terrestre");
        System.out.println("4. Salir");
        Opcion = leer.nextInt();
        

    switch(Opcion){
    case 1 -> {
        //Ingresa validaciones para pulir
        leer.nextLine();
        do{
        System.out.print("Tamaño de las alas:");
        tamañoAlas = leer.nextDouble();
        if(tamañoAlas < 0){
            System.out.println("ERROR");
    }
        }while(tamañoAlas < 0);
        leer.nextLine();
        var c = new CriaturaVoladora(tamañoAlas,Nombre,NivelEnergia,tipoADN);
        System.out.println();
        System.out.println("---DATOS---");
        c.imprimirInfo();
        System.out.println("------------------------");
        System.out.println();
        break;
        }
    case 2 -> {
        leer.nextLine();
        do{
        System.out.print("Ingresa la profundidad maxima:");
        profundidadMaxima = leer.nextDouble();
        if(profundidadMaxima < 0){
            System.out.println("ERROR");
        }
        }while(profundidadMaxima < 0);
        leer.nextLine();
        
        var c = new CriaturaAcuatica(profundidadMaxima,Nombre,NivelEnergia,tipoADN);
        System.out.println();
        System.out.println("---DATOS---");
        c.imprimirInfo();
        System.out.println("------------------------");
        System.out.println();
        break;
    }
    case 3 -> {
        leer.nextLine();
        do{
        System.out.print("Ingresa la fuerza maxima:");
        Fuerza = leer.nextInt();
        if(Fuerza < 0){
            System.out.println("ERROR");
        }
        }while(Fuerza < 0);
        leer.nextLine();
        
        var c = new CriaturaTerrestre(Fuerza, Nombre, NivelEnergia, tipoADN);
        System.out.println();
        System.out.println("---DATOS---");
        c.imprimirInfo();
        System.out.println("------------------------");
        System.out.println();
        break;        
            }
        }
    }while(Opcion != 4);
}
}
