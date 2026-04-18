
package interfaces.Ejercicio1;

class Gato implements Animal{
    @Override
    public void Comer(){
        System.out.println("El gato esta comiendo");
    }
    
    @Override
    public void Dormir(){
        System.out.println("El gato duerme");
    }
    
    @Override
    public void HacerSonido(){
        System.out.println("El gato maulla");
    }
}
