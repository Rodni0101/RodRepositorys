#include <iostream>
#include <string>

using namespace std;
int num1,num2,num3,aux;
int main(){
	cout<<"Digite el primer numero: "<<endl;
	cin>>num1;
	cout<<"Digite el segundo numero: "<<endl;
	cin>>num2;
	cout<<"Digite el tercer numero: "<<endl;
	cin>>num3;
	
		if(num1 > num2){
			aux = num1;
			num1 = num3;
			num2 = aux;
	}else if (num1 > num3){
		
			aux = num1;
			num1 = num3;
			num3 = aux;
	}else if (num2 > num3){
		
			aux = num2;
			num2 = num3;
			num3 = aux;
	}
				cout<<"Estos son sus numeros ordenados de forma ascendete: "<<endl;
					cout<<num1;
					cout<<num2;
					cout<<num3;
		
}

