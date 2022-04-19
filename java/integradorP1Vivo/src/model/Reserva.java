package model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Reserva {

    private static Integer contador=0;

    private Integer idReserva;
    private Double precio;
    private LocalDate fechaReserva;

    public Reserva(Double precio, LocalDate fechaReserva) {
        this.precio = precio;
        this.fechaReserva = fechaReserva;
        this.idReserva=getId();
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    private Integer getId(){
        return ++contador;
    }



    @Override
    public String
    toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", precio=" + precio +
                ", fechaReserva=" + fechaReserva +
                '}';
    }

}
