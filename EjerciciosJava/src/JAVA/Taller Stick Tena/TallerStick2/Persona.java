package TallerStick2;

public class Persona {
    int edad = 22;
    int anioActual = 2026;

public void Calcular_anioNacimiento(){
    int aproX = anioActual - edad;
    System.out.println(aproX);
}

public static void main(String[] args) {
        Persona A1 = new Persona();
        A1.Calcular_anioNacimiento();
    }
}
