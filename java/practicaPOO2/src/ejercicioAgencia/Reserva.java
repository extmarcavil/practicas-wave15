package ejercicioAgencia;

public abstract class Reserva {
    private double precio;
    private int cantReservas;

    public Reserva(double precio, int cantReservas) {
        this.precio = precio;
        this.cantReservas = cantReservas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", cantReservas=" + cantReservas +
                '}';
    }

    public abstract double calcularPrecioReserva();
}
