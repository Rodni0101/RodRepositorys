
package poo.Polimorfimos.ejercicio2;
public class Main {
    public static void main(String[] args) {
        
    Vehiculo [] Arreglo = new Vehiculo[3];
    Arreglo [0] = new Carro();
    Arreglo [1] = new Bicicleta();
    Arreglo [2] = new Avion();
    
    for(Vehiculo TUNG : Arreglo){
        TUNG.Moverse();
    }
    }
}