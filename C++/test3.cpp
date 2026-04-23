#include <iostream>
#include <conio.h>
using namespace std;

int main(){
	int opcion;
	int num,aux,suma,resta;
	float division;
	int a;
	do{
	cout<<"Bienvenido ala calculadora de Rodney"<<endl;
	cout<<"1. Calcular Multiplos"<<endl;
	cout<<"2. Calcular Suma"<<endl;
	cout<<"3. Calcular Resta"<<endl;
	cout<<"4. Caclular Division"<<endl;
	cout<<"5. Salir"<<endl;
	cout<<"Seleccione el calculo a realizar: "<<endl;
	cin>>opcion;
	system("cls");
	switch (opcion){
	case 1:
		cout<<"Digite un numero"<<endl;
		cin>>num;
		for(a = 1; a <=10; a++){
		cout<<num <<"x" << a << "=" << num * a <<"\n";
	}
		break;
		
	case 2:
		
		cout<<"Digite un numero"<<endl;
		cin>>num;
		cout<<"Digite otro numero"<<endl;
		cin>>aux;
			suma = num + aux;
		cout<<"Resultado = "<<suma<<endl;
		
			break;

	case 3:
		
		cout<<"Digite un numero"<<endl;
		cin>>num;
		cout<<"Digite otro numero"<<endl;
		cin>>aux;
			resta = num - aux;
		cout<<"Resultado = "<<resta<<endl;
		
			break;

	case 4:
		
		cout<<"Digite un numero"<<endl;
		cin>>num;
		cout<<"Digite otro numero"<<endl;
		cin>>aux;
			if(aux == 0 or num == 0){
            cout<<"No se puede dividir entre cero"<<endl;
                }else{
                division = (float) num / aux;
            cout<<"Resultado = "<<division<<endl;
                }
			break;

	case 5:
		cout<<"Presione una tecla para finalizar..."<<endl;
		getch();
		system("cls");
		cout<<"Recuerda, Si puedes imaginarlo puedes programarlo...";
		}
	}while(opcion != 5);
}

		
