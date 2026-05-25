#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;
const float PI = 3.1416;
float Radio;

int main(){
	
	cout << "Ingresa el valor del radio: "<<endl;
		cin>>Radio;
	cout << "Longitud es: "<< fixed << setprecision(2) << 2* PI * Radio<<endl;
	
	cout << "Area de circulo: "<< PI*pow(Radio,2)<<endl;
	
	cout << "Volumen de la esfera: " << (4.0/3)*PI*pow(Radio,3)<<endl;
}
