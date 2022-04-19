package Main;

import java.time.LocalDate;
import java.util.Date;

public class Viaje extends Reserva{
    private String compania;
    private String tipo;
    private LocalDate fecha;

    public Viaje(double price, String compania, String tipo, LocalDate fecha) {
        super(price);
        this.compania = compania;
        this.tipo = tipo;
        this.fecha = fecha;
    }
}
