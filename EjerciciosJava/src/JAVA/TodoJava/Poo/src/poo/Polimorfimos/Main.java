
package poo.Polimorfimos;

public class Main {
    public static void main(String[] args) {
        var p1 = new Persona();
        var p2 = new Perro();
        var v1 = new Vaca();
        var p3 = new Padre();
        
        p1.comer();
        p2.comer();
        p3.comer();
        v1.comer();
    }
}


