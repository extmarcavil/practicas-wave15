public class ReservaHotel extends Reserva {

    public ReservaHotel(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "monto=" + monto +
                '}';
    }
}
