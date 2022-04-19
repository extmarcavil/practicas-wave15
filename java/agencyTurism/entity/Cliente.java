package agencyTurism.entity;

import java.util.List;

public class Cliente {
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String nombre, List<Reserva> reservas) {
        this.nombre = nombre;
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
