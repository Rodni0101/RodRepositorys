#include <iostream>
using namespace std;

// Función con parámetros
void saludar(string nombre) {
    cout << "Hola, " << nombre << endl;
}

int main() {
	string nombre;
	cout<<"Ingresa tu nombre"<<endl;
	cin>>nombre;
    saludar(nombre); // Llamada con argumento
    return 0;
}
