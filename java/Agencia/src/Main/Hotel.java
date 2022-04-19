package Main;

import java.util.Date;

public class Hotel extends Reserva {
    private int dias;
    private String nombre;

    public Hotel(double price, int dias, String nombre) {
        super(price);
        this.dias = dias;
        this.nombre = nombre;
    }
}
