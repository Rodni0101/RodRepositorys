
package poo.Polimorfimos.Practica;

public class Main {
    public static void main(String[] args) {
    Animal[] Arreglo = new Animal[3];
    Arreglo[0] = new Perro();
    Arreglo[1] = new Vaca();
    Arreglo[2] = new Animal();
    
    for(Animal animal : Arreglo){
        animal.Hacer_sonido();
    }
    }
}
