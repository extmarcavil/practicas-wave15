package agenciaViajes.model;

public class Localizador {
// los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo del producto adquirido
    private String id;
    private double total;
    private int cantidadReservas;
    private Cliente cliente;
    private PaqueteTuristico paqueteTuristico;

    public Localizador() {
    }

    public Localizador(String id, int cantidadReservas, Cliente cliente, PaqueteTuristico paqueteTuristico) {
        this.id = id;
        this.cantidadReservas = cantidadReservas;
        this.cliente = cliente;
        this.paqueteTuristico = paqueteTuristico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public PaqueteTuristico getPaqueteTuristico() {
        return paqueteTuristico;
    }

    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        this.paqueteTuristico = paqueteTuristico;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", cantidadReservas=" + cantidadReservas +
                ", cliente=" + cliente.toString() +
                ", paqueteTuristico=" + paqueteTuristico.toString() +
                '}';
    }
}
