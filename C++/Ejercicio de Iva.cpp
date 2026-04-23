#include <iostream>
#include <string>

using namespace std;

int codeC,codeA,cant,priceU,subTotal;
string nombre,descrip;
float total,aux;
const float iva = 0.19;

int main (){
	cout<<"-----------------------------"<<endl;
	cout<<"Digite el codigo del cliente"<<endl;
		cin>>codeC;
			cin.ignore();
				cout<<"Digite el nombre completo del usuario"<<endl;
					getline(cin,nombre);
						cout<<"Digite el codigo del articulo"<<endl;
							cin>>codeA;
								cin.ignore();
									cout<<"Describa el articulo"<<endl;
										getline(cin,descrip);
											cout<<"Digite la cantidad que desea comprar"<<endl;
												cin>>cant;
													cin.ignore();
														cout<<"Digite el precio del producto"<<endl;
															cin>>priceU;
																subTotal = (cant * priceU);
																	aux = (subTotal * iva);
																	total = (aux + subTotal);
																		cout<<"El valor del iva es "<<iva<<endl;
																			cout<<"El subtotal equivale a:"<<subTotal<<endl;
																				cout<<"-----------------------------"<<endl;
																					cout<<"-----RECIBO-----"<<endl;
																						cout<<"Total a pagar: "<<total<<endl;
																							cout<<"Gracias por su compra"<<endl;
																								cout<<nombre<<endl;
																									cout<<"Codigo de usuario: "<<codeC;
																									
																	
															
																
											
									
}
