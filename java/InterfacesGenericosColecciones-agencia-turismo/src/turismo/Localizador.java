package turismo;

import java.util.List;

public class Localizador {
    Cliente cliente;
    Paquete paquete;
    double total;

    public Localizador(Cliente cliente, Paquete paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.total = paquete.calcularTotal();
    }
}
