package model;

import java.time.LocalDate;
import java.util.Date;

public class Hotel extends Reserva {

    private Integer cantidadPersonas;
    private String tipoHabitacion;

    private Descuento descuento;


    public Hotel(Double precio, LocalDate fechaReserva, Integer cantidadPersonas, String tipoHabitacion) {
        super(precio, fechaReserva);
        this.cantidadPersonas = cantidadPersonas;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "cantidadPersonas=" + cantidadPersonas +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                ", descuento='" + descuento + '\'' +
                super.toString()+
                '}';
    }
}
