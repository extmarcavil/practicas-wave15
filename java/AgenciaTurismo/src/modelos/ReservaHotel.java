package modelos;

import modelos.Producto;

import java.util.Date;

public class ReservaHotel extends Producto {
    private String nombreHotel;
    private Date fechaIngreso;
    private Date fechaSalida;

    public ReservaHotel(String nombre, double costo, String nombreHotel, Date fechaIngreso, Date fechaSalida) {
        super(nombre, costo);
        this.nombreHotel = nombreHotel;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
