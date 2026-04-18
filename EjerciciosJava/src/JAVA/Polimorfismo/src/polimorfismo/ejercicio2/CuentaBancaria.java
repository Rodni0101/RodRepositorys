package polimorfismo.ejercicio2;

public class CuentaBancaria {
private String titular;
private double saldo;

public CuentaBancaria(String titular, double saldo){
    this.titular = titular;
    this.saldo = saldo;
}

public CuentaBancaria(){
}

public void setTitular(String titular){
    this.titular = titular;
}

public void setSaldo(double saldo){
    this.saldo = saldo;
}

public String getTitular(){
    return titular;
}

public double getSaldo(){
    return saldo;
}


public String llamarTitular(){
    return titular;
}
public double AplicarOperacion(){
    return saldo;
    
    }
}
