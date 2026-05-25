#include <iostream>
#include <string>
#include <iomanip>

using namespace std;
string nombre;
int edad;
float salario;

int main(){
	cout<<"Ingrese su nombre: "<<endl;
		getline(cin,nombre);
		cin.ignore();
	cout<<"Digite su edad: "<<endl;
		cin>>edad;
	 cout<<"Digite su salario: "<<endl;
	 	cin>>salario;
	 	//usaste la linea 19 para poner valores mas grandes
	cout << fixed << setprecision (0);	
	cout<<"Hola, "<<nombre<<", Tienes: "<<edad<<" Años de edad y ganas, "<<salario<<" $ Pesos al mes";	
}
