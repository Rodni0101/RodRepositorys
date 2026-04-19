public class Operadores {
    public static void main(String[] args) {
        // Aritmetica 
        var a = 5;
        var b = 3;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        /*
        Operadores de asignación
        */

        // Asignación

        a = b;
        System.out.println(a);

        a = b * 2;
        System.out.println(a);

        a += 1; // a = a + 1
        System.out.println(a);

        a -= 1;
        System.out.println(a);
        a *= 2;
        System.out.println(a);
        a /= 2;
        System.out.println(a);
        a %= 2;
        System.out.println(a);

        /*
        Operadores de comparación
        */

        // Comparación (Relacionales)

        System.out.println(a == b);
        System.out.println(a == 0);

        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a < b);
        System.out.println(a <= b);

        /*
        Operadores lógicos
        */

        // Lógicos

        // Y (AND)
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println(3 > 2 && 5 == 2);

        // O (OR)
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println(3 > 2 || 5 == 2);

        // NO (NOT)
        System.out.println(!true);
        System.out.println(!false);

        System.out.println(!(3 > 2) || 5 == 2);
        int num = 5;

        System.out.println("Valor inicial: " + num);
        System.out.println("valor positivo " +num);
        System.out.println("Valor negativo " + -num);
        System.out.println("Imprime, despues incrementa " + num++);
        System.out.println("Confirmamos si incremento " + num);
        System.out.println("Volvemos a imprimir y decrementamos " + num--);
        System.out.println("Confirmamos si decremento " + num);  
        System.out.println("Incrementos " + ++num);
        System.out.println("Confirmamos " + num);
        System.out.println("Decrementamos el valor " + --num);
//Si se pone adelante se incrementa o decrementa antes de imprimirse
//Si se pone atras se imprime y luego se incrementa o decrementa
    }
}
