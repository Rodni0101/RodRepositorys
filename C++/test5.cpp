#include <iostream>
#include <conio.h>
using namespace std;

int main(void){
	
	int opcion;
	cout<<"Que ciclo quiere usar?"<<endl;
	cout<<"1. for"<<endl;
	cout<<"2. Do While"<<endl;
	cin>>opcion;
	switch(opcion){
		
case 1:
	int num;
	cout<<"Digite un numero: "<<endl;
	cin>>num;
	for(int a = 1; a <= 10; a++){
	
	cout<<num << " x " << a << " = " << num * a <<endl;
		}
	break;
	
case 2:
	int a = 1;
	
	cout<<"Digite un numero: "<<endl;
	cin>>num;
	do{
	
	cout<<num << " x "<< a << " = "<< num * a<<endl;
	a++;
	}while(a <= 10);

	break;
	}
	cout<<"Presione una tecla para finalizar...";
	getch();
}

