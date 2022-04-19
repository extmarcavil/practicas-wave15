import java.util.ArrayList;
import java.util.List;

public class Paquete {

    private List<Reserva> reservas;

    public Paquete() {
        this.reservas = new ArrayList<>();
    }

    public Paquete(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public double obtenerPrecioTotal() {
        double totalReservaHotel = this.reservas.stream().filter(reserva -> reserva instanceof ReservaHotel)
                .mapToDouble(reserva -> reserva.getMonto()).sum();

        double totalReservaBoleto = this.reservas.stream().filter(reserva -> reserva instanceof ReservaBoleto)
                .mapToDouble(reserva -> reserva.getMonto()).sum();

        double totalRestoReservas = this.reservas.stream().filter(
                reserva -> !(reserva instanceof ReservaBoleto) && !(reserva instanceof ReservaHotel))
                .mapToDouble(reserva -> reserva.getMonto()).sum();

        if(contieneMasDeUnHotel()) {
            totalReservaHotel -= (totalReservaHotel * 0.05);
        }
        if(contieneMasDeUnBoleto()) {
            totalReservaBoleto -= (totalReservaBoleto * 0.05);
        }

        return totalReservaHotel + totalReservaBoleto + totalRestoReservas;
    }

    private boolean contieneMasDeUnHotel() {
        return (this.reservas.stream().filter(reserva -> reserva instanceof ReservaHotel).count() > 1 );
    }

    private boolean contieneMasDeUnBoleto() {
        return (this.reservas.stream().filter(reserva -> reserva instanceof ReservaBoleto).count() > 1 );
    }

    public boolean esPaqueteCompleto() {
        return(
                        this.reservas.stream().anyMatch(reserva -> reserva instanceof ReservaBoleto) &&
                        this.reservas.stream().anyMatch(reserva -> reserva instanceof ReservaComida) &&
                        this.reservas.stream().anyMatch(reserva -> reserva instanceof ReservaHotel) &&
                        this.reservas.stream().anyMatch(reserva -> reserva instanceof ReservaTransporte)
        );
    }



    @Override
    public String toString() {
        return "Paquete{" +
                "reservas=" + reservas +
                '}';
    }
}
