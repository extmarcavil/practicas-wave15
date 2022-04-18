package ejercicioAgencia;

public class ReservaBoleto extends Reserva {

    public ReservaBoleto(double precio, int cantReservas) {
        super(precio, cantReservas);
    }

    @Override
    public double calcularPrecioReserva() {
        return this.getPrecio() * this.getCantReservas();
    }
}
