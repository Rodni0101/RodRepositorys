#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main(void){
string placa;
int vehiculosControlados = 0;
double promedio = 0;
int velocidad,sumaVelocidad = 0;

do{
	cout<<"Ingrese la placa de su vehiculo: "<<endl;
		cin>>placa;
	cout<<"Ingrese y registre su velocidad(KM/H"<<endl;
		cin>>velocidad;
	if(velocidad >= 1 && velocidad <= 120){
		
		vehiculosControlados++;
		sumaVelocidad += velocidad;
	}
	
	if(vehiculosControlados > 0){
		
	promedio = (double)sumaVelocidad / vehiculosControlados;
		
	}else{
		cout<<"No se registraron vehiculos";
	}
		
	}while(velocidad >= 1 && velocidad <= 120);
	
			cout<<fixed<<setprecision (2);
	cout<<"El promedio de velocidad es de: "<< promedio<<endl;
	cout<<"El numero de vehiculos controlados es: "<< vehiculosControlados<<endl;
}