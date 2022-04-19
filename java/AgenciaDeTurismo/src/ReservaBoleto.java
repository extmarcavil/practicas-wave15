public class ReservaBoleto extends Reserva {

    public ReservaBoleto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ReservaBoleto{" +
                "monto=" + monto +
                '}';
    }
}
