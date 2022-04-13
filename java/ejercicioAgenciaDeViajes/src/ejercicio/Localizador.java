package ejercicio;

import java.util.ArrayList;

public class Localizador {
    // Las reservas son almacenadas en localizadores,
    // los cuales contienen los datos del cliente,
    // el total y la reserva o varias reservas dependiendo
    // del producto adquirido. Por tanto los descuentos
    // se aplicarán cuando:

    Cliente cliente;
    Double total;
    Paquete listaDeReservas;

    public Localizador(Cliente cliente, Double total, Paquete listaDeReservas) {
        this.cliente = cliente;
        this.total = total;
        this.listaDeReservas = listaDeReservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Paquete getListaDeReservas() {
        return listaDeReservas;
    }

    public void setListaDeReservas(Paquete listaDeReservas) {
        this.listaDeReservas = listaDeReservas;
    }
}
