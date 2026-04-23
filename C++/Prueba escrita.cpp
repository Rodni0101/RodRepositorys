#include <iostream>
#include <string>

using namespace std;

int main (){
	
	string Nombre;
	int edad;
	
	cout<<"Ingresa tu nombre completo: "<<endl;
		getline(cin,Nombre);
				cout<<"Ingresa tu edad: "<<endl;
					cin>>edad;
						
						if(edad >= 18) {
						
							cout<<"Eres mayor de edad";		
						}
						
						else{
							
							cout<<"Eres menor de edad"<<endl;
							}
								cout<<"Te llamas, "<<Nombre<<endl;
									cout<<"Tu edad es:  "<<edad<<endl;
										cout<<"Gracias";
}
