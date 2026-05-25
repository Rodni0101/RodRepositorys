package sistemarecursoshumanos;

public class EmpleadoTiempoCompleto extends Empleado{
    private double bonoAnual;
    private int horasSemanales;
    private String tipoContrato;
    private int añosEnEmpresa;

    public EmpleadoTiempoCompleto(double bonoAnual, int horasSemanales, String tipoContrato, int añosEnEmpresa, String Nombre, int Edad, double salarioBase, String Cargo, String Departamento) {
        super(Nombre, Edad, salarioBase, Cargo, Departamento);
        setBonoAnual(bonoAnual);
        setHorasSemanales(horasSemanales);
        setTipoContrato(tipoContrato);
        setAñosEnEmpresa(añosEnEmpresa);
    }

    public EmpleadoTiempoCompleto() {
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        if(bonoAnual <= 0){
        System.out.println("Error: Bono anual no valido");
        }else{
        this.bonoAnual = bonoAnual;
    }
}
    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        if(horasSemanales <= 0){
            System.out.println("Error: Horas semanales invalidas");
        }else{
        this.horasSemanales = horasSemanales;
        }
    }
    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        if(tipoContrato == null || tipoContrato.trim().isEmpty()){
            System.out.println("Error: Tipo de contrato invalido");
        }else{
        this.tipoContrato = tipoContrato;
        }
    }
    public int getAñosEnEmpresa() {
        return añosEnEmpresa;
    }

    public void setAñosEnEmpresa(int añosEnEmpresa) {
        if(añosEnEmpresa < 0){
            System.out.println("Error: años en empresa invalido");
        }else{
        this.añosEnEmpresa = añosEnEmpresa;
        }
    }
    
    @Override
        public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Bono anual = " + getBonoAnual());
        System.out.println("Horas Semanales = " + getHorasSemanales());
        System.out.println("Tipo de contrato = " + getTipoContrato());
        System.out.println("Años en empresa = " + getAñosEnEmpresa());
 }
}
