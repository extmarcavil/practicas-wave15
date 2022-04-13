package agenciaViajes.model;

public class Hotel {
    private String nombre;
    private int cantidadReservas;
    private int costo;

    public Hotel(String nombre, int cantidadReservas, int costo) {
        this.nombre = nombre;
        this.cantidadReservas = cantidadReservas;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
