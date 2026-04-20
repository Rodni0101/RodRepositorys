public class E2 {
    public static void main(String[] args) {
        int [] numeros = {1,2,3,4,5};

        int suma = 0;
        int mayor = numeros[0];
        int menor = numeros[0];
        int pares = 0;
        int impares = 0;

        for(int v = 0; v < numeros.length; v++){
            System.out.println("Posicion = " + v + " Valor = " + numeros[v]);
            
            suma += numeros[v];
            
            if(numeros[v] > mayor){
                mayor = numeros[v];
            }

            if(numeros[v] < menor){
                menor = numeros[v];
            }

            if(numeros[v] % 2 == 0){
                pares++;
            }else{
                impares++;
            }
        }

        double promedio = (double) suma / numeros.length;
        System.out.println("Promedio del arreglo = " + promedio);
        System.out.println("Suma total de los valores = " + suma);
        System.out.println("Mayor = " + mayor);
        System.out.println("Menor = " + menor);
        System.out.println("Pares = " + pares);
        System.out.println("Impares = " + impares);
    }
}
