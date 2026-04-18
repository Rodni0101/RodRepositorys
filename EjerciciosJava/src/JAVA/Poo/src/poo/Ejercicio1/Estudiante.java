package poo.Ejercicio1;

public class Estudiante {
    private double nota1,nota2,nota3;

    
    public Estudiante(double nota1,double nota2,double nota3){
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public Estudiante(){
        
    }
    
    public double getNota1(){
        return nota1;
    }
    public double getNota2(){
        return nota2;
    }
    public double getNota3(){
        return nota3;
    }
    public void setNota1(double nota1){
        this.nota1 = nota1;
    }
    public void setNota2(double nota2){
        this.nota2 = nota2;
    }
    public void setNota3(double nota3){
        this.nota3 = nota3;
    }
    
    public void Promedio(){
       double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Nota final = " + promedio);
        if(promedio >= 3.0){
            System.out.println("Aprobado");
        }else{
            System.out.println("Desaprobado");
        }
    }
}
