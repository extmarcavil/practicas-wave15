package turismo;

import java.util.List;

public class Paquete {
    List<Reserva> paquete;

    public Paquete(List<Reserva> paquete) {
        this.paquete = paquete;
    }

    public double calcularTotal(){
        return this.paquete.stream().mapToDouble(reserva -> reserva.calcularTotal()).sum();
    }
}
