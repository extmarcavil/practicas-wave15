package Main;

public class Comida extends Reserva{
    private String resto;
    private String menu;

    public Comida(double price, String resto, String menu) {
        super(price);
        this.resto = resto;
        this.menu = menu;
    }
}
