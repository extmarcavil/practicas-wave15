package ejercicioAgencia;

public class ReservaTransporte extends Reserva {

    public ReservaTransporte(double precio, int cantReservas) {
        super(precio, cantReservas);
    }

    @Override
    public double calcularPrecioReserva() {
        return this.getPrecio() * this.getCantReservas();
    }
}
