
package interfaces.Ejercicio1;

class Perro implements Animal{
    @Override
    public void Comer(){
        System.out.println("El perro esta comiendo");
    }
    
    @Override
    public void Dormir(){
        System.out.println("El perro esta durmiendo");
    }
    
    @Override
    public void HacerSonido(){
        System.out.println("El perro ladra");
    }
}
