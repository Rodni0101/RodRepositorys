#include <iostream>
#include <conio.h>
#include <string>
using namespace std;

int main(void){

int edad = 0;
int peso = 0;
double estatura = 0;
int cumplen = 0;
int nocumplen = 0;
int numPersonas = 0;
double mayorAltura = 0;                      
string nombre,nombreMasAlto;             
double sumaestatura = 0;
double PromedioEstatura = 0;
int pesoFi,edadFi;

cout<<"Sistema de ColDeportes Bolivar"<<endl;
cout<<"Ingresa las siguientes caracteristicas (Edad, Estatura, Peso)"<<endl;

do{
	
cout<<"Ingrese su nombre: "<<endl;
	cin>>nombre;
cout<<"Digite su edad: "<<endl;
	cin>>edad;
		if(edad == 0)break;
	
cout<<"Digite su estatura: "<<endl;
	cin>>estatura;
		if(estatura == 0)break;
cout<<"Digite su peso: "<<endl;
	cin>>peso;
		if(peso == 0)break;
		
	if(edad <= 18 && estatura >= 180 && peso <= 80){
		cumplen++;
}
	else{
		nocumplen++;
	}
	
	if(estatura > mayorAltura){
		
	mayorAltura = estatura;
	nombreMasAlto = nombre;
	pesoFi = peso;
	edadFi = edad;
}
	sumaestatura += estatura;
	numPersonas++;
	
	}while(true);
	
	PromedioEstatura =sumaestatura / numPersonas;
	cout<<"Numero de personas que cumplen con las condiciones: "<<cumplen<<endl;
	cout<<"Numero de personas que no cumplen con las condiciones: "<<nocumplen<<endl;
	cout<<"Numero de personas registradas: "<<numPersonas<<endl;
	cout<<"El promedio de estatura por persona es: "<<PromedioEstatura<<endl;
	if(numPersonas > 0){
    cout << "La persona mas alta es:" << endl;
    cout << "Nombre: " << nombreMasAlto << endl;
    cout << "Estatura: " << mayorAltura << endl;
    cout << "Peso: " << pesoFi << endl;
    cout << "Edad: " << edadFi << endl;
}

}