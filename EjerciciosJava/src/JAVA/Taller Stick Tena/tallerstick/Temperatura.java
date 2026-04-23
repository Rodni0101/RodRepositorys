package tallerstick;

public class Temperatura {
    double GradosF,Celcius;
    double Dato = 25;

public void Farenheit(){
    GradosF = (Dato * 9.0 / 5.0) + 32;
    System.out.println("Fahrenheit = " + GradosF);
    }

public void Celcius(){
    Celcius = (Dato -32) * 5.0 / 9.0;
    System.out.println("Celcius = " + Celcius);
}
public static void main(String[] args) {
        Temperatura GF = new Temperatura();
        System.out.println("Grados Farenheit: ");
        GF.Farenheit();
        
        System.out.println();
        
        Temperatura GC = new Temperatura();
        System.out.println("Grados Celcius");
        GC.Celcius();
    }
}

