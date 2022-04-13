package ar.com.alehenestroza;

import java.time.LocalDate;

public class ReservaHotel extends Producto {
    private String nombreHotel;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public ReservaHotel(double costo, String nombreHotel, LocalDate fechaIngreso, LocalDate fechaSalida) {
        super("ReservaHotel", costo);
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
