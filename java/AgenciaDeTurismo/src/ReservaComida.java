public class ReservaComida extends Reserva {

    public ReservaComida(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ReservaComida{" +
                "monto=" + monto +
                '}';
    }
}
