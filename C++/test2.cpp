#include <iostream>
#include <conio.h>
using namespace std;

int main(){
	//que entra: un numero del uno al 5 en un menu
	//que se necesita hacer: que se repita si la opcion ingresada no entra en el rango ademas de mostrar el numero ingresado
	int opcion;
	
	do{
	cout<<"Bienvenido al menu de usuario, Seleccione una opcion (1-5)"<<endl;
	cout<<"1. Hola mundo"<<endl;
	cout<<"2. Hola chavales"<<endl;
	cout<<"3. HOLAAA"<<endl;
	cout<<"4. Hello Wordl"<<endl;
	cout<<"5. HOLIS UWU"<<endl;
	cout<<"6. Salir"<<endl;
	cin>>opcion;
	system("cls");
	
	cout<<"--------------------------------"<<endl;
		switch(opcion){
		
		case 1:
		cout<<"Hola mundo"<<endl;
			break;
		case 2:
		cout<<"Hola chavales"<<endl;
			break;
		case 3:
		cout<<"HOLAAA"<<endl;
			break;
		case 4:
		cout<<"Hello World"<<endl;
			break;
		case 5:
		cout<<"HOLIS UWU"<<endl;
			break;
		case 6:
		cout<<"Oprime una tecla para salir...";
		getch();
			
	}
	
	}while(opcion != 6);
}