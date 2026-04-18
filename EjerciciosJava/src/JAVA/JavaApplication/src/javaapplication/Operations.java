package javaapplication;

public class Operations {
    int numero1;
    int numero2;
    
public void imprimir(){
   System.out.println("Tabla de multiplicar de " + numero1);
   for(int a = 1; a <= 10; a++){
       
    int Result = numero1 * a;
    
    System.out.println(numero1 + " X " + a + " = " + Result);
        }
   
            System.out.println();
    
   System.out.println("Tabla de multiplicar de " + numero2);
   for(int a = 1; a <= 10; a++){
       
    int Result = numero2 * a;
    
    System.out.println(numero2 + " X " + a + " = " + Result);
    
        }
}
       public void aritmetica() {
        int suma = numero1 + numero2;
        System.out.println("Suma = " + suma);
        
        int resta = numero1 - numero2;
           System.out.println("resta = " + resta);
        
        int multiplicacion = numero1 * numero2;
            System.out.println("multiplicacion = " + multiplicacion);
            
        double division = numero1 / numero2;
           System.out.println("division = " + division);
            
        }
}
    