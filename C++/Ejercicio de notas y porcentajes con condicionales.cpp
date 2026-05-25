#include <iostream>
#include <string>

using namespace std;
double n1,n2,n3,n4,NotaF;
int main(){
	//El enunciado pide 4 notas que tienen distinto peso:
	// n1(40%) n2(30%) n3(20%) n4(10%)
		cout<<"Digite la nota1: "<<endl;
			cin>>n1;
				cout<<"Digite la nota2: "<<endl;
					cin>>n2;
						cout<<"Digite la nota3: "<<endl;
							cin>>n3;
								cout<<"Digite la nota4: "<<endl;
									cin>>n4;
										NotaF = n1*0.40 + n2*0.30 + n3*0.20 + n4*0.10;
												if(NotaF >= 3.0){
													cout<<"Aprobado"<<endl;
												}else{
													cout<<"Desaprobado"<<endl;
												}
												cout<<"Nota final: "<<NotaF;
}
