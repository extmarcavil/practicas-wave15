public class Localizador {

    private double total;
    private Paquete paquete;

    public Localizador(Paquete paquete) {
        this.paquete = paquete;
        this.total = paquete.obtenerPrecioTotal();
    }

    public double getTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "total=" + total +
                ", paquete=" + paquete +
                '}';
    }
}
