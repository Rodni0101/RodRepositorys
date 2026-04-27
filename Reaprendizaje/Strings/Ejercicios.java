package Strings;
import java.util.*;
public class Ejercicios{
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
         // 1. Concatena dos cadenas de texto.
        String nombre = "Rodney";
        String segundoNombre = "Alexander";

        System.out.println("Hola me llamo " + nombre + " " + segundoNombre);
        // 2. Muestra la longitud de una cadena de texto.
            System.out.println(nombre.length());
        // 3. Muestra el primer y último carácter de un string.
            System.out.println(nombre.charAt(0));
            System.out.println(nombre.charAt(nombre.length() - 1));
        // 4. Convierte a mayúsculas y minúsculas un string.
            System.out.println(nombre.toUpperCase());
            System.out.println(nombre.toLowerCase());
            System.out.println(nombre);
        // 5. Comprueba si una cadena de texto contiene una palabra concreta.
            System.out.println("Hola mundo".contains("Hola"));
            System.out.println("Rodney".contains("z"));
        // 6. Formatea un string con un entero.
            int peso = 83;
            System.out.println(String.format("Hola, %s. Pesas = %d", nombre, peso));
        // 7. Elimina los espacios en blanco al principio y final de un string.
            System.out.println(" Hola a todos ");
            System.out.println(" Hola a todos ".trim());
        // 8. Sustituye todos los espacios en blanco de un string por un guión (-).
            System.out.println("Hola a todos".replace("todos", "los chicos de ADSO"));
        // 9. Comprueba si dos strings son iguales.
            String nombre1 = "Camilo";
            String nombre2 = "camilo";
            String nombre3 = new String ("Camilo");

            System.out.println(nombre1 == nombre2);
            System.out.println(nombre1 == nombre3);
            //equals para comprar objetos y variables
            System.out.println(nombre1.equals(nombre3));
            //equalsIgnoreCase para ignorar mayuculas o minusculas
            System.out.println(nombre1.equalsIgnoreCase(nombre3));

        // 10. Comprueba si dos strings tienen la misma longitud.
            boolean Mlongitud = true;
            boolean Dlongitud = false;
            System.out.println("Ingresa una palabra");
            String p1 = leer.nextLine();
            System.out.println("Ingresa otra palabra");
            String p2 = leer.nextLine();

            if(p1.length() == p2.length()){
                System.out.println(Mlongitud);
            }else{
                System.out.println(Dlongitud);
            }
    }
}