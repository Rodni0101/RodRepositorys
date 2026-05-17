package Recorderis.Poo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        var p1 = new Padre();
        System.out.println("Ingresa el nombre del padre");
        p1.setNombre(leer.nextLine());

        System.out.println("Ingresa el Apellido del padre");
        p1.setApellido(leer.nextLine());

        p1.Saludar();

        var p2 = new Hijo();
        System.out.println("Ingresa el nombre del hijo");
        p2.setNombre(leer.nextLine());

        System.out.println("Ingresa el Apellido del hijo");
        p2.setApellido(leer.nextLine());

        p2.Saludar();

    }
}
