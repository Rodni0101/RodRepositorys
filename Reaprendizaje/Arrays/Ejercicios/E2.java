public class E2 {
    public static void main(String[] args) {
        int suma = 0;
        int pares = 0;
        int impares = 0;
        int [] numeros = {1,2,3,4,5,6,7,8,9,10};
        //si vamos a referirnos a mayor o menor siempre definir despues del arreglo
        int mayor = numeros[0];
        int menor = numeros[0];

        for(int v = 0; v < numeros.length; v++){
            System.out.println("Posicion = " + v + " Valor = " + numeros[v]);

            if(numeros[v] % 2 == 0){
                pares ++;
            }else{
                impares++;
            }

            suma += numeros[v];

            if(numeros[v] > mayor){
                mayor = numeros[v];
            }

            if (numeros[v] < menor){
                menor = numeros[v];
            }
        }

        double promedio = (double) suma / numeros.length;
        System.out.println("Promedio del arreglo = " + promedio);
        System.out.println("Suma total del arreglo = " + suma);
        System.out.println("Pares = " + pares);
        System.out.println("Impares = " + impares);
        System.out.println("Numero mayor = " + mayor);
        System.out.println("Numero menor: " + menor);

    }
}
