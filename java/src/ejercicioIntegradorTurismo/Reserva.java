package ejercicioIntegradorTurismo;

public class Reserva {

    private Cliente cliente;
    private ReservaType tipoReserva;
    private double costo;

    public Reserva(Cliente cliente, ReservaType tipoReserva, double costo) {
        this.cliente = cliente;
        this.tipoReserva = tipoReserva;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                " TipoReserva =" + tipoReserva +
                ", Costo =" + costo +
                '}';
    }

}
