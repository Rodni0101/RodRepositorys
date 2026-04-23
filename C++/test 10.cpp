#include <iostream>

using namespace std;

int main(){
	int precio;
	int tipCliente;
	float descuento,Descuento_apli;
	int totalApagar;
			
	while(true){
	cout<<"Ingrese su tipo de membresia"<<endl;
	cout<<"1. VIP"<<endl;
	cout<<"2. Normal"<<endl;
	cin>>tipCliente;
	
	cout<<"Digite el precio de su producto: "<<endl;
	cin>>precio;
	if(precio <= 0){
		cout<<"Precio invalido, Vuelva a ingresar un precio";
	}
		if(tipCliente == 1){
			if(precio > 200){
				descuento = 0.25;
			}else{
				descuento = 0.15;
			}
		}
		else if(tipCliente == 2){
				if(precio > 200){
				descuento = 0.10;
			}else{
				descuento = 0.05;
			}
		}
		
		Descuento_apli = (precio * descuento);
		totalApagar = precio - Descuento_apli;
		
		cout<<"Precio original: ";
		cout<<precio<<endl;
		
		cout<<"Descuento aplicado: ";
		cout<<Descuento_apli<<endl;
		
		cout<<"Total a pagar: ";
		cout<<totalApagar<<endl;
		break;
	}
		return 0;
}	