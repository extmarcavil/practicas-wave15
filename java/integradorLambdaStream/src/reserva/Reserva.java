package reserva;

public abstract class Reserva {
    private int cantidad;
    private double precio;

    public double calcularMonto() {
        return precio * cantidad;
    }

    public Reserva(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
