package polimorfismo;
public class Factura {
    int idFactura;
    Producto p1;
    Producto p2;
    Producto p3;
    
    public Factura(int idFactura,Producto p1, Producto p2, Producto p3) {
        this.idFactura = idFactura;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Factura(){
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public double calcularTotalFactura(){  
        double suma = p1.calcularTotal() + p2.calcularTotal() + p3.calcularTotal();
        return suma;
    }
}
