package ejercicioAgencia;

public class Reserva {
    private double precio;

    public Reserva(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                '}';
    }
}
