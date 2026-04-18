
package interfaces.Ejercicio1;

public interface Animal{
    void Comer();
    void Dormir();
    
    default void HacerSonido(){
        System.out.println("El animal esta haciendo un sonido");
    }
}

