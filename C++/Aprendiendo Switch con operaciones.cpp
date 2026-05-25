#include <iostream>
#include <string>

using namespace std;
int num1,num2,edad,opciones;
string nombre;

int main(){
	cout<<"Ingre su nombre: "<<endl;
		getline(cin,nombre);
	cout<<"Digite el primer numero: "<<endl;
		cin>>num1;
	cout<<"Digite el segundo numero: "<<endl;
		cin>>num2;
	cout<<"Selecione la operacion a realizar"<<endl;
	cout<<"1. Suma"<<endl;
	cout<<"2. Resta"<<endl;
	cout<<"3. Multiplicacion"<<endl;
	cout<<"4. Division"<<endl;
	cout<<"5. Residuo(%)"<<endl;
		cout<<"-----------------"<<endl;
	cin>>opciones;
	//Recuerda escribir bien (switch no swicht)
	switch(opciones)
	{
		case 1: cout<<"Elegiste la opcion 1"<<endl;
				cout<<"Resultado: "<< num1 + num2<<endl;break;
		
		case 2: cout<<"Elegiste la opcion 2"<<endl;
				cout<<"Resultado: "<< num1 - num2<<endl;break;
				
				
		case 3: cout<<"Elegiste la opcion 3"<<endl;
				cout<<"Resultado: "<< num1 * num2<<endl;break;
				
				
		case 4: cout<<"Elegiste la opcion 4"<<endl;
				cout<<"Resultado: "<< num1 / num2<<endl;break;
				
				
		case 5: cout<<"Elegiste la opcion 5"<<endl;
				cout<<"Resultado: "<< num1 % num2<<endl;break;
	}
	
}

