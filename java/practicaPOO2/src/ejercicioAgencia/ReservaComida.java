package ejercicioAgencia;

public class ReservaComida extends Reserva {

    public ReservaComida(double precio, int cantReservas) {
        super(precio, cantReservas);
    }

    @Override
    public double calcularPrecioReserva() {
        return this.getPrecio() * this.getCantReservas();
    }
}
