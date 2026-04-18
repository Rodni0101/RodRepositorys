package sistemadeartistas;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String Nombre, Estilo,Herramientas,generoMusical,Plataforma;
        int Edad, numObras,Opcion;
        double numSeguidores;
        
        System.out.println("SISTEMA DE ARTISTAS/MUSICOS/CREADORES DE CONTENIDO");
        System.out.println();
        do{
        System.out.println("Que tipo de artista eres?");
        System.out.println("1. Artista Digital");
        System.out.println("2. Musico Digital");
        System.out.println("3. Creador de contenido");
        System.out.println("4. Salir");
        Opcion = leer.nextInt();
        leer.nextLine();
        
        switch(Opcion){
            case 1 ->{
                
                do{
                System.out.println("Ingrese su nombre: ");
                Nombre = leer.nextLine();        
                if(Nombre.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un nombre valido");
                    }
                }while(Nombre.isEmpty());
                
                do{
                System.out.println("Digite su edad: ");
                Edad = leer.nextInt();
                if(Edad <= 0){
                    System.out.println("Eror: Vuelva a ingresar una edad valida");
                }
                leer.nextLine();
                }while(Edad <= 0);
                
                do{
                System.out.println("Ingrese su estilo de dibujo: ");
                Estilo = leer.nextLine();
                if(Estilo.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un estilo valido");
                }
                }while(Estilo.isEmpty());
                
                do{
                System.out.println("Digite su numero de obras: ");
                numObras = leer.nextInt();
                leer.nextLine();
                if(numObras <= 0){
                    System.out.println("Error: Vuelva a ingresar un numero valido");
                    }
                }while(numObras <= 0);
                
                do{
                System.out.println("Ingresa tu herramienta de trabajo(Photoshop,Catcup,inshot, etc)");
                Herramientas = leer.nextLine();
                if(Herramientas.isEmpty()){
                    System.out.println("Error: Herramienta no valida vuelva a ingresar");
                }
                }while(Herramientas.isEmpty());
                
                System.out.println();
                
                var a1 = new ArtistaDigital(Herramientas,Nombre, Edad, Estilo, numObras);
                System.out.println("---DATOS---");
                a1.mostrarInfo();
                System.out.println("----------");
                System.out.println();
                }
            
            case 2 ->{
                do{
                System.out.println("Ingrese su nombre: ");
                Nombre = leer.nextLine();        
                if(Nombre.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un nombre valido");
                    }
                }while(Nombre.isEmpty());
                
                do{
                System.out.println("Digite su edad: ");
                Edad = leer.nextInt();
                if(Edad <= 0){
                    System.out.println("Eror: Vuelva a ingresar una edad valida");
                }
                leer.nextLine();
                }while(Edad <= 0);
                
                do{
                System.out.println("Ingrese su estilo de dibujo: ");
                Estilo = leer.nextLine();
                if(Estilo.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un estilo valido");
                }
                }while(Estilo.isEmpty());
                
                do{
                System.out.println("Digite su nomero de obras: ");
                numObras = leer.nextInt();
                leer.nextLine();
                if(numObras <= 0){
                    System.out.println("Error: Vuelva a ingresar un numero valido");
                    }
                }while(numObras <= 0);
                
                do{
                System.out.println("Ingresa tu genero musical(Pop,Rock,Champeta,etc)");
                generoMusical = leer.nextLine();
                if(generoMusical.isEmpty()){
                    System.out.println("Error: Herramienta no valida vuelva a ingresar");
                }
                }while(generoMusical.isEmpty());
                
                System.out.println();
                
                var a1 = new MusicoDigital(generoMusical,Nombre, Edad, Estilo, numObras);
                System.out.println("---DATOS---");
                a1.mostrarInfo();
                System.out.println("----------");
                System.out.println();
                }
            
            case 3 ->{
                do{
                System.out.println("Ingrese su nombre: ");
                Nombre = leer.nextLine();        
                if(Nombre.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un nombre valido");
                    }
                }while(Nombre.isEmpty());
                
                do{
                System.out.println("Digite su edad: ");
                Edad = leer.nextInt();
                if(Edad <= 0){
                    System.out.println("Eror: Vuelva a ingresar una edad valida");
                }
                leer.nextLine();
                }while(Edad <= 0);
                
                do{
                System.out.println("Ingrese su estilo de dibujo: ");
                Estilo = leer.nextLine();
                if(Estilo.isEmpty()){
                    System.out.println("Error: Vuelva a ingresar un estilo valido");
                    }
                }while(Estilo.isEmpty());
                
                do{
                System.out.println("Digite su numero de obras: ");
                numObras = leer.nextInt();
                leer.nextLine();
                if(numObras <= 0){
                    System.out.println("Error: Vuelva a ingresar un numero valido");
                }
                }while(numObras <= 0);
                
                do{
                System.out.println("Ingresa la plataforma en la que creas contenido (Youtube,Tiktok,Kick,etc)");
                Plataforma = leer.nextLine();
                if(Plataforma.isEmpty()){
                    System.out.println("Error: Herramienta no valida vuelva a ingresar");
                }
                }while(Plataforma.isEmpty());
                
                do{
                System.out.println("Digite su numero de seguidores: ");
                numSeguidores = leer.nextInt();
                if(numSeguidores <= 0){
                    System.out.println("Error: Vuelva a ingresar un numero valido");
                }
                }while(numSeguidores <= 0);
                
                System.out.println();
                
                var a1 = new CreadorDeContenido(Plataforma,numSeguidores,Nombre, Edad, Estilo, numObras);
                System.out.println("---DATOS---");
                a1.mostrarInfo();
                System.out.println("----------");
                System.out.println();
                }
            }
           }while(Opcion != 4);
        }
    }

   
