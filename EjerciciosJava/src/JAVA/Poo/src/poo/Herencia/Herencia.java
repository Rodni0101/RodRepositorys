
package poo.Herencia;
public class Herencia {
    public static void main(String[] args) {
        System.out.println("-----DATOS DE EMPLEADO-----");
        System.out.println();
        Empleado A1 = new Empleado(123,"Gerente", 2500.0, 1 ,"12345678", "Lucho", "Frias", "Calle 28a",300782213);
  
        System.out.println("Dni = " + A1.getDni());
        System.out.println("Cargo = " + A1.getCargo());
        System.out.println("Sueldo = " + A1.getSueldo());
        System.out.println("Codigo de empleado = " + A1.getCodigo_empleado());
        System.out.println("ID = " + A1.getId());
        System.out.println("Dni = " + A1.getDni());
        System.out.println("Nombre = " + A1.getNombre());
        System.out.println("Apellido = " + A1.getApellido());
        System.out.println("Domicilio = " + A1.getDomicilio());
        System.out.println("Telefono = " + A1.getTelefono());
        System.out.println();
        
        System.out.println("-----DATOS DE CONSULTOR-----");
        
        Consultor B1 = new Consultor("Rodni",676767,1048442903,"39342449","","Puertas","Turbaco",300782213);
        System.out.println();
        System.out.println("Numero de consultor = " + B1.getNum_Consultor());
        System.out.println("ID de consultor = " + B1.getId());
        System.out.println("DNI de consultor = " + B1.getDni());
        System.out.println("Nombre de consultor = " + B1.getNombre_Consultor());
        System.out.println("Apellido = " + B1.getApellido());
        System.out.println("Domicilio = " + B1.getDomicilio());
        System.out.println("Telefono = " + B1.getTelefono());
    }
}
