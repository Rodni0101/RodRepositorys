import java.util.*;
public class Ejercicios {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        /* 
        int numeros[] ={1,2,3,4,5};

        for(int v = 0; v < numeros.length; v++){
            System.out.println("Posicion = " + v + " " + "Valor = " + numeros[v]);
        }
*/

        /* 
        System.out.print("Ingresa 5 numeros: ");
        System.out.print("-");int n1 = leer.nextInt();
        System.out.print("-");int n2 = leer.nextInt();
        System.out.print("-");int n3 = leer.nextInt();
        System.out.print("-");int n4 = leer.nextInt();
        System.out.print("-");int n5 = leer.nextInt();

        int array[] ={n1,n2,n3,n4,n5};
        
        for (int v = 0; v < array.length; v++){
            System.out.println("Posicion = " + v + " Valor = " + array[v]);
        }
        leer.close();
        */

        /* 
        int suma = 0;
        System.out.println("Ingresa 5 numeros");
        System.out.print("-");int n1 = leer.nextInt();
        System.out.print("-");int n2 = leer.nextInt();
        System.out.print("-");int n3 = leer.nextInt();
        System.out.print("-");int n4 = leer.nextInt();
        System.out.print("-");int n5 = leer.nextInt();

        int arreglo[] ={n1,n2,n3,n4,n5};

        for(int v = 0; v < arreglo.length; v++){
            suma = n1 + n2 + n3 + n4 + n5;
    }
        System.out.print("Valor total de los numeros ingresados: " + suma);
        */

        /* 
        float promedio = 0;
        System.out.println("Ingresa 5 numeros");
        System.out.print("-");int n1 = leer.nextInt();
        System.out.print("-");int n2 = leer.nextInt();
        System.out.print("-");int n3 = leer.nextInt();
        System.out.print("-");int n4 = leer.nextInt();
        System.out.print("-");int n5 = leer.nextInt();

        int arreglo[] ={n1,n2,n3,n4,n5};

        for(int v = 0; v < arreglo.length; v++){
            promedio = (n1 + n2 + n3 + n4 + n5) / 5;
    }
        System.out.println("Promedio de los numeros ingresados = " + promedio);
        */


        /*  
        System.out.print("Digite el numero que desea encontrar: ");
        int encontrar = leer.nextInt();
        boolean encontrado = false;
        int arreglo[] = {1,2,3,4,5};

        for(int v = 0; v < arreglo.length; v++){
            if(arreglo[v] == encontrar){
            System.out.println("El numero esta en la posicion = " + v);
            encontrado = true;
        }
    }
        if(!encontrado){
            System.out.println("El numero no se encuentra en el arreglo");
        }
    }
    */
    int contador = 0;
    int arreglo[] = {5,12,3,20,9};
    for(int v = 0; v < arreglo.length; v++){
        if(arreglo[v] > 10){
            contador++;
        }
    }
        System.out.println("Cantidad de calores mayores a 10: " + contador);
    }
}