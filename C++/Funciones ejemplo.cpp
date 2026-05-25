#include <iostream>
using namespace std;

void cambiar(int &x){
    x = 50;
}

int main(){
    int numero = 10;
    
    cambiar(numero);
    cout << numero;
}