package Main;

public abstract class Reserva {
    private double price;
    //private Cliente cliente;

    public Reserva(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
