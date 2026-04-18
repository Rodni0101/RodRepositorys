
package interfaces.Ejercicio1;

public class main {
    public static void main(String[] args) {
    Animal a1 = new Perro();
    a1.Comer();
    a1.Dormir();
    a1.HacerSonido();
        System.out.println();
    Animal a2 = new Gato();
    a2.Comer();
    a2.Dormir();
    a2.HacerSonido();
    }
}