#include <iostream>
#include <string>

using namespace std;

int main(){
	//Que entra?
	//codigo de encomienda, peso en KG
	//Que sale?
	//peso total de las encomiendas
	//la cantidad de encomiendas totales
	int TotalEncomiendas = 0,cantidadEncomiendas = 0,peso = 0;
	double pesoTotal;
	int code;
	do{
		cout<<"Digite el codigo de 4 letras para validar su encomienda: "<<endl;
		cin>>code;
		
		cout<<"Digite el peso de su encomienda: "<<endl;
		cin>>peso;
		
		cantidadEncomiendas++;
		pesoTotal += peso;
		
	}while(peso <= 50);
		cout<<"Peso total de encomienda: "<<pesoTotal<<endl;
		cout<<"Encomiendas realizadas: "<<cantidadEncomiendas;

}