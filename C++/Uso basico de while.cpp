#include <iostream>
#include <string>

using namespace std;

int main(){
	int num;

cout << "Ingresa un numero (0 para salir): ";
cin >> num;

while(num != 0){
    cout << "Ingresaste: " << num << endl;

    cout << "Ingresa otro numero (0 para salir): ";
    cin >> num; // actualizar para evitar bucle infinito
}

cout << "Fin del programa.";

}
