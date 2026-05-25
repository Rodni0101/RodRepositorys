#include <iostream>
#include <string>


using namespace std;

int main (){

string palabra;
cout << "Texto: ";
getline(cin, palabra);

int repeticiones;
cout << "Veces: ";
cin >> repeticiones;

for(int i = 0; i < repeticiones; i++){
    cout << palabra << endl;
	}
}
