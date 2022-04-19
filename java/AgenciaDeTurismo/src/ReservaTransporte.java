public class ReservaTransporte extends Reserva {

    public ReservaTransporte(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ReservaTransporte{" +
                "monto=" + monto +
                '}';
    }
}
