package sistemarecursoshumanos;

public class EmpleadoPasante extends Empleado{
    private String Universidad;
    private String Carrera;

    public EmpleadoPasante(String Universidad, String Carrera, String Nombre, int Edad, double salarioBase, String Cargo, String Departamento) {
        super(Nombre, Edad, salarioBase, Cargo, Departamento);
        setUniversidad(Universidad);
        setCarrera(Carrera);
    }

    public EmpleadoPasante() {
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String Universidad) {
        if(Universidad == null || Universidad.trim().isEmpty()){
            System.out.println("Error: Universidad ingresada no valida");
        }else{
        this.Universidad = Universidad;
        }
    }
    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        if(Carrera == null || Carrera.trim().isEmpty()){
            System.out.println("Error: Carrera ingresada no valida");
        }else{
        this.Carrera = Carrera;
        }
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Universidad = " + getUniversidad());
        System.out.println("Carrera = " + getCarrera());
    }
}
