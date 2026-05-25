#include <iostream>
#include <string>
#include <iomanip>

using namespace std;
long double SalarioN,SalarioF;
const double Cant = 1500000;
int main(){
	//aprende mas includes
	//Digita un salario
	//Si el salario es menor a 1.500.000 aplicar un aumento del 10%(0.10)
	//si es mayor o igual a 1.500.00 aplicar un aumento del 5%(0.5)
	//Imprimir el salario final
		cout<<"Digite su salario este mes: "<<endl;
			cin>>SalarioN;
				if(SalarioN < Cant){
				SalarioF = SalarioN + (SalarioN * 0.10);
						cout<<SalarioF;
				}
				else{
					
					SalarioF = SalarioN + (SalarioN * 0.05);
					//aprender la linea 23
					cout<< fixed << setprecision(0);
							cout<<SalarioF;
				}
								
}	
