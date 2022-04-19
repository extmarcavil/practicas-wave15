package ejercicioAgenciaTurismo;

public class Localizador {
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private double total = 0;

    public Localizador(Cliente cliente, PaqueteTuristico paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public void calcularTotal(double descuento) {
        this.total = this.paquete.calcularTotal(descuento);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getReservas() {
        return paquete.getReservas();
    }

    @Override
    public String toString() {
        return "Localizador{\n" +
                "\t" + cliente.toString() +", \n" +
                "\t" + paquete.toString() +
                ", \n\ttotal=" + total +
                "\n}";
    }
}
