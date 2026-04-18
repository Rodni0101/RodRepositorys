
    import java.util.Scanner;
public class NewClass {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int num;
        do{
        System.out.println("Ingresa un numero:  ");
        num = leer.nextInt();
        for(int v = 1; v <= 10; v++){
            int result = v * num;
            System.out.println(num + " X " + v + " = " + result);
            }
        }while(num != 0);
    }
}

