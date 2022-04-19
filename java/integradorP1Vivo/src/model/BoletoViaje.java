package model;

import java.time.LocalDate;
import java.util.Date;

public class BoletoViaje extends Reserva{
    private String tipoAsiento;

    private Descuento descuento;

    public BoletoViaje(Double precio, LocalDate fechaReserva, String tipoAsiento) {
        super(precio, fechaReserva);
        this.tipoAsiento = tipoAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "tipoAsiento='" + tipoAsiento + '\'' +
                "descuento='" + descuento + '\'' +
                super.toString()+
                '}';
    }
}
