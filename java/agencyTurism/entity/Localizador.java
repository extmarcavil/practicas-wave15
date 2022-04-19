package agencyTurism.entity;

public class Localizador {
    private Cliente cliente;
    private Reserva reserva;

    public Localizador(Cliente cliente, Reserva reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
