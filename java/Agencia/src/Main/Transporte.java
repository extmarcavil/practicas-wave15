package Main;

public class Transporte extends Reserva{
    private String tipo;

    public Transporte(double price, String tipo) {
        super(price);
        this.tipo = tipo;
    }
}
