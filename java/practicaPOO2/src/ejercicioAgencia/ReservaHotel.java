package ejercicioAgencia;

public class ReservaHotel extends Reserva {

    public ReservaHotel(double precio, int cantReservas) {
        super(precio, cantReservas);
    }

    @Override
    public double calcularPrecioReserva() {
        return this.getPrecio() * this.getCantReservas();
    }
}
