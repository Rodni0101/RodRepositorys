#include <iostream>
#include <string>


using namespace std;

int main (){

string palabra;
cout << "Texto: ";
getline(cin, palabra);

int veces;
cout << "Veces: ";
cin >> veces;

for(int i = 0; i < veces; i++){
    cout << palabra << endl;
	}
}
