#include <iostream>
#include <string>

using namespace std;

int main () {
	
	float num1,num2;
	int oP;
	
	cout<<"Bienvenido ala calculadora virtual"<<endl;
		cout<<"Ingresa los numeros: "<<endl;
			cout<<"--------------------"<<endl;
				cout<<"-";
					cin>>num1;
						cout<<"-";
							cin>>num2;
									cout<<"Elige la opcion "<<endl;
									cout<<"1.Suma"<<endl;
									cout<<"2.Resta"<<endl;
									cout<<"3.Multiplicacion"<<endl;
									cout<<"4.Division"<<endl;
									cin>>oP;
									switch (oP){
										case 1: cout<<"Resultado: "<<num1 + num2;break;
										
										case 2: cout<<"Resultado: "<<num1 - num2;break;
										
										case 3: cout<<"Resultado: "<<num1 * num2;break;
										
										case 4: cout <<"Resultado: "<<num1 / num2;break;
								}
 }
								 
								 
										
										
										
										
										
										
										
										
										

