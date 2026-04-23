#include <iostream>
#include <string>

using namespace std;

int main (){
  int  temp1,temp2,temp3;
  float  promedio;
  
  cout<<"Ingresa la primera temperatura"<<endl;
  cin>>temp1;
  cout<<"Ingresa la segunda temperatura"<<endl;
  cin>>temp2;
  cout<<"Ingresa la tercera temperatura"<<endl;
  cin>>temp3;
  
  	promedio = (temp1 + temp2 + temp3) / 3;
  	cout<<"El promedio de estas temperaturas es: "<<promedio;
}
