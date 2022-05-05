import reserva.Reserva;

import java.util.List;

public class Localizador {
    Cliente cliente;
    List<Reserva> reservas;
    double monto;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;

        cliente.agregarLocalizador(this);
        RepositorioLocalizadores.getRepositorioLocalizadores().agregarLocalizador(this);
    }

    public double getMonto() {
        return monto;
    }
}
