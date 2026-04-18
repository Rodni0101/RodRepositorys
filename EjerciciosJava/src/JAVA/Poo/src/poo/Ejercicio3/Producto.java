package poo.Ejercicio3;

public class Producto {
   private String nombre;
   private double nota1;
   private double nota2;
   private double nota3;
   
   public Producto(String nombre,double nota1,double nota2,double nota3){
       this.nombre = nombre;
       this.nota1 = nota1;
       this.nota2 = nota2;
       this.nota3 = nota3;
   }
   public Producto(){
   }
 
   public String getNombre(){
       return nombre;
   }
   public double getnota1(){
       return nota1;
   }
   public double getnota2(){
       return nota2;
   }
   public double getnota3(){
       return nota3;
   }
   
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   public void setnota1(double nota1){
       this.nota1 = nota1;
   }
   public void setnota2(double nota2){
       this.nota2 = nota2;
   }
   public void setnota3(double nota3){
       this.nota3 = nota3;
   }
   
   public void Pruebas(){
       double promedio = (nota1 + nota2 + nota3) / 3;
       if(promedio >= 3.0){
           System.out.println("Ha pasado el control");
       }else{
           System.out.println("No ha pasado el control");
       }
   }
}