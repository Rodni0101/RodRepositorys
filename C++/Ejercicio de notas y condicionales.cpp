#include <iostream>
#include <string>

using namespace std;

float nota1,nota2,nota3,definitiva;
string student,Profe;
int main (){
	cout<<"Bienvenido al software de notas academicas"<<endl;
	cout<<"Pofavor ingrese sus notas"<<endl;
	cout<<"-";
	cin>>nota1;
	cout<<"-";
	cin>>nota2;
	cout<<"-";
	cin>>nota3;
	definitiva = (nota1 + nota2 + nota3) / 3;
	if(definitiva >= 3.0){
	
	cout<<"Aprobado";
	} else {
		
		cout<<"Desaprobado";
	}
		cout<<"Su nota final es de,"<<definitiva;
}
