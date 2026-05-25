#include <iostream>
#include <string>

using namespace std;

int main(){
	//Que entra?
	//horas trabajadas y nombre del trabajador}
	//Que sale Total de horas, empleados registrados
	string nombre;
	int TotalHoras = 0;
	int empleadosRegistrados = 0, horasTrabajadas = 0;
	cout<<"Ingrese su nombre: "<<endl;
		getline(cin,nombre);
	cout<<"Digite las horas laboradas: "<<endl;
	cin>>horasTrabajadas;
	
	do{
		cin.ignore();
		empleadosRegistrados++;
		TotalHoras += horasTrabajadas;
	cout<<"Ingrese su nombre: "<<endl;
		getline(cin,nombre);
	cout<<"Digite las horas laboradas: "<<endl;
		cin>>horasTrabajadas;
	}while(horasTrabajadas <= 60);
		cout<<"Total de horas trabajadas: "<<TotalHoras<<"\n";
		cout<<"Total de empleados registrados: "<<empleadosRegistrados<<endl;
}