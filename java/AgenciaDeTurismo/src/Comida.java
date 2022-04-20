public class Comida extends Producto implements Reserva{

    public Comida(double precio, int cantidad){
        super(precio, cantidad);
    }

    public double reservar(double precioReserva){
        precioReserva += this.getPrecio();
        return precioReserva;
    }
}
