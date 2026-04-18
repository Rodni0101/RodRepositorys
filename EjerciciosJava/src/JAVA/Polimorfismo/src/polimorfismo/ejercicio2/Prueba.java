
package polimorfismo.ejercicio2;
import java.util.Scanner;
public class Prueba {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("-----BANCO-----");
        System.out.println("Ingrese el tipo de cuenta a validar");
        System.out.println("1. Cuenta Ahorro");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Cuenta Empresarial");
        int opcion = leer.nextInt();
        
        switch(opcion){
        case 1: 
            
        CuentaAhorro c1 = new CuentaAhorro();
        System.out.println("-----Cuenta de Ahorro-----");
        System.out.println("Ingresa el nombre del titular de la cuenta: ");
        c1.setTitular(leer.nextLine());
        System.out.println("Digite su saldo actual: ");
        c1.setSaldo(leer.nextDouble());
        if(c1.getSaldo() >= 0){
        System.out.println("Digite la tasa de interes: ");
        c1.setTasaInteres(leer.nextDouble() / 100);
        System.out.println("-----Resultados-----");
        System.out.println("--------------------");
        System.out.println("Te llamas: " + c1.llamarTitular());
        System.out.println("Tu saldo es de: " + c1.AplicarOperacion());
        }else{
        System.out.println("El saldo es negativo");
        }
        break;
        case 2:
        leer.nextLine();
            
        CuentaCorriente c2 = new CuentaCorriente();
        System.out.println("-----Cuenta Corriente-----");
        System.out.println("Ingresa el nombre del titular de la cuenta: ");
        c2.setTitular(leer.nextLine());
        System.out.println("Digite su saldo actual: ");
        c2.setSaldo(leer.nextDouble());
        System.out.println("Digite tasa de interes del sobregiro");
        c2.setTasaInteresSobregiro(leer.nextDouble() / 100);
        System.out.println("Cuanto desea retirar: ");
        c2.setRetiro(leer.nextDouble());
        System.out.println("-----Resultados-----");
        System.out.println("--------------------");
        System.out.println("Te llamas: " + c2.llamarTitular());
        System.out.println("Tu saldo es de: " + c2.AplicarOperacion());
        break;
        
        case 3:
        leer.nextLine();
        
        CuentaEmpresarial c3 = new CuentaEmpresarial();
        System.out.println("-----Cuenta Empresarial-----");
        System.out.println("Ingresa el nombre del titular de la cuenta: ");
        c3.setTitular(leer.nextLine());
        System.out.println("Digite su saldo actual: ");
        c3.setSaldo(leer.nextDouble());
        System.out.println("Digite valor de la comision");
        c3.setComisionMensual(leer.nextInt());
        System.out.println("-----Resultados-----");
        System.out.println("--------------------");
        System.out.println("Te llamas: " + c3.llamarTitular());
        System.out.println("Tu saldo es de: " + c3.AplicarOperacion());
        break;
        }
        
        
        
        
     }
}
