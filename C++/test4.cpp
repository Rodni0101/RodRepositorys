#include <iostream>
#include <conio.h>
using namespace std;

int main(){
	//Que entra? codigo, precio y cantidad de producto
	//Que sale? total de productos vendidos, prodcuto con mayor valor de venta
	int codigo,cantidad,auxiliar1 = 0,auxiliar2 = 0;
	double precio;
	double ventaActual;
	double mayorVenta = 0;
	cout<<"Valide el codigo de producto:"<<endl;
		cin>>codigo;	
		
		while(codigo != 0){
				
				
	cout<<"Digite el precio del producto"<<endl;
		cin>>precio;
	cout<<"Que cantidad esta llevando?"<<endl;
		cin>>cantidad;
		
		ventaActual= precio * cantidad;
		
		auxiliar1 += cantidad;
		auxiliar2 += ventaActual;
	
		if(ventaActual > mayorVenta){
			mayorVenta = ventaActual;
			}  
		
		cout<<"\nIngrese el codigo del producto (0 para salir): "<<endl;
        cin>>codigo;
			                    		
		}
	
		cout<<"--------FACTURA--------"<<endl;
		cout<<"Ventas realizadas: "<<auxiliar2<<endl;
		cout<<"Producto con mayor valor de venta: "<<mayorVenta<<endl;
		cout<<"Productos vendidos: "<<auxiliar1<<endl;
	}   
