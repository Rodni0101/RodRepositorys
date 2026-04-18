package aplicacion;

public class Aplicacion{
    public static void main(String []args){
   
    Persona p1 = new Persona();
    p1.nombre = "Rodni";
    p1.apellido = "Puertas";
    p1.id = 1048442903;
    
    p1.mostrar();
    
    System.out.println("\n-----Segunda persona-----");
    
    Persona p2 = new Persona();
    p2.nombre = "Camilo";
    p2.apellido = "España";
    p2.id = 1985813;
   
    p2.mostrar();
    }
}