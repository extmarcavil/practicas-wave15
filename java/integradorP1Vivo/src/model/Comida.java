package model;

import java.time.LocalDate;
import java.util.Date;

public class Comida extends Reserva {

    private Integer cantidadComidasPorDia;

    public Comida(Double precio, LocalDate fechaReserva, Integer cantidadComidasPorDia) {
        super(precio, fechaReserva);
        this.cantidadComidasPorDia = cantidadComidasPorDia;
    }

    public Integer getCantidadComidasPorDia() {
        return cantidadComidasPorDia;
    }

    public void setCantidadComidasPorDia(Integer cantidadComidasPorDia) {
        this.cantidadComidasPorDia = cantidadComidasPorDia;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "cantidadComidasPorDia=" + cantidadComidasPorDia +
                super.toString()+
                '}';
    }
}
