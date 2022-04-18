package ejercicioAgencia;

public class Localizador {
    private Cliente cliente;
    private Paquete paquete;
    private double total;

    public Localizador(Cliente cliente, Paquete paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", paquete=" + paquete +
                ", total=" + total +
                '}';
    }

    public double calcularPrecioTotalReservas() {
        double totalReservas = paquete.getLstReservas().stream().mapToDouble(reserva -> reserva.calcularPrecioReserva()).sum();
        System.out.println("El total de las reservas sin descuentos es de $" + totalReservas + "\n");
        return total = totalReservas;
    }
}
