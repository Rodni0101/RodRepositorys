package TallerStick6;

public class Numero {
    int valor = 0;
   public void metodos(){
       if(valor > 0){
           System.out.println("Numero positivo");
       }
       else if(valor < 0){
           System.out.println("Numero negativo");
       }
       
       if(valor % 2 == 0){
           System.out.println("Numero par");
       }else{
           System.out.println("Numero impar");
       }
    
       if(valor == 0){
           System.out.println("Es cero");
       }
   }
    public static void main(String[] args) {
        Numero N1 = new Numero();
        N1.metodos();
    }
}  