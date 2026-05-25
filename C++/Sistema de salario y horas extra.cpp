#include <iostream>
#include <string>
using namespace std;

int main() {
    string nombreEmpleado;
    float salarioBasicoHora, horasTrabajadas, horasExtras;
    float valorHorasOrdinarias, valorHoraExtra, valorHorasExtras;
    float salarioBruto, retencion, salarioNeto;

    // Entradas
    cout << "Ingrese el nombre del empleado: ";
    getline(cin, nombreEmpleado);

    cout << "Ingrese el salario basico por hora: ";
    cin >> salarioBasicoHora;

    cout << "Ingrese las horas ordinarias trabajadas: ";
    cin >> horasTrabajadas;

    cout << "Ingrese las horas extras trabajadas: ";
    cin >> horasExtras;

    valorHorasOrdinarias = salarioBasicoHora * horasTrabajadas;

    valorHoraExtra = salarioBasicoHora * 1.40;   
    valorHorasExtras = valorHoraExtra * horasExtras;

    salarioBruto = valorHorasOrdinarias + valorHorasExtras;

    if (valorHorasExtras > 10000) {
        retencion = valorHorasExtras * 0.10;  
    } else {
        retencion = 0;
    }

    salarioNeto = salarioBruto - retencion;

    cout << "--- RESULTADOS ---"<<endl;
    cout << "Nombre del empleado: " << nombreEmpleado << endl;
    cout << "Salario neto a pagar: $" << salarioNeto << endl;
    cout << "Valor de la retencion en la fuente: $" << retencion << endl;
return 0;
}
