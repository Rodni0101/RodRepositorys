
package TallerStick5;

public class Notas_Estudiantes {
    double nota1 = 1.0;
    double nota2 = 5.0;
    double nota3 = 3.0;
    
    public void Calculo(){
        double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Promedio del estudiante: " + promedio);
        
        if(promedio >= 3.0){
            System.out.println("El estudiante aprueba");
        }else{
            System.out.println("El estudiante reprueba");
        }
    }
    public static void main(String[] args) {
    Notas_Estudiantes n1 = new Notas_Estudiantes();
    n1.Calculo();
    }
}
    


