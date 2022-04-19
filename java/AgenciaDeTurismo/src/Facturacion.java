import java.util.HashMap;

public class Facturacion {

    private Cliente cliente;
    private boolean descuentoFuturasCompras;

    public Facturacion(Cliente cliente) {
        this.cliente = cliente;
        this.descuentoFuturasCompras = false;
    }

    public double facturarCompraPaquete(Paquete paquete) {
        double totalPaquete = paquete.obtenerPrecioTotal();
        if(descuentoFuturasCompras) {
            totalPaquete -= totalPaquete * 0.05;
        } else if(cliente.getLocalizadores().size() >= 2) {
            descuentoFuturasCompras = true;
        }

        if(paquete.esPaqueteCompleto()) {
            totalPaquete -= (totalPaquete * 0.1);
        }

        return totalPaquete;
    }
}
