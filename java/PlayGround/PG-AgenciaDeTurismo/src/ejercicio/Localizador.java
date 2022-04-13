package ejercicio;

public class Localizador {

    Cliente cliente;
    Double total;
    Paquete listaDeReservas;

    public Localizador(Cliente cliente, Double total, Paquete listaDeReservas) {
        this.cliente = cliente;
        this.total = total;
        this.listaDeReservas = listaDeReservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", listaDeReservas=" + listaDeReservas +
                '}';
    }
}
