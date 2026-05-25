
package polimorfismo;

public class Descuento extends Factura{
    double descuento;

    public Descuento(double descuento, int idFactura, Producto p1, Producto p2, Producto p3) {
        super(idFactura, p1, p2, p3);
        this.descuento = descuento;
    }

    public Descuento() {
    }
    
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double calcularTotalDescuento(){
    double porcentajeDescuento = 0.08;
    double total = calcularTotalFactura();
    
    descuento = total * porcentajeDescuento;
    
    return total - descuento;
    }
}


