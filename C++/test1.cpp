#include <iostream>
#include <conio.h>

using namespace std;

int main(){
	//que entra: numeros que el usuario ingresa
	//que sale: la sumatoria de esos numeros
	
	double numeros = 0;
	double sumaTotal = 0;
	int contador = 0;
	cout<<"Ingresa un numero: "<<endl;
	cin>>numeros;
	while(numeros != 0){
		cin.ignore();
		sumaTotal += numeros;
		contador++;
		cout<<"Ingresa otro numero: "<<endl;
		cin>>numeros;
	}
	cout<<"Cantidad de numeros ingresados: "<<contador<<endl;
	cout<<"Sumatoria total: "<<sumaTotal<<endl;
}

//Este codigo le pide al usuario ingresar un numero y hasta que ingrese el numero 0 no acaba el sistema
//Cuenta con la imprenta de el numero de numeros ingresados y la sumatoria total por cada numero ingresado