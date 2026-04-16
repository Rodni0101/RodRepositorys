package Ejercicio;

public class Pago {
    private String titular;

    public Pago(String titular){
        this.titular =  titular;
    }

    public Pago(){
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public String getTitular(){
        return titular;
    }
}
