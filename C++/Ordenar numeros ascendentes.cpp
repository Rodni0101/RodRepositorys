#include <iostream>
#include <iomanip>
using namespace std;
int main(void)
{                               
    int num1, num2, num3;

    //se introducen los números por teclado
    cout << "\nPrimer numero: ";
    cin >> num1;
    cout << "\nSegundo numero: ";
    cin >> num2;
    cout << "\nTercer numero: ";
    cin >> num3;
                                          
    if(num1 > num2)
       if( num3 > num3)
           cout << num3 << " " << num2 << " " << num1 << endl;
       else if(num1 > num3)
               cout << num2 << " " << num3 << " " << num1 << endl;
            else
               cout << num2 << " " << num1 << " " << num3 << endl;
    else if(num2 > num3)
            if(num1 > num3)
               cout << num3 << " " << num1 << " " << num2 << endl;
            else
               cout << num1 << " " << num3 << " " << num2 << endl;
         else
            cout << num1 << " " << num2 << " " << num3 << endl;
    return 0;
}

