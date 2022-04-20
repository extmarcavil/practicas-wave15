public class Hotel extends Producto implements Reserva{

    public Hotel(double precio, int cantidad){
        super(precio, cantidad);
    }

    public double reservar(double precioReserva){
        precioReserva += this.getPrecio();
        return precioReserva;
    }
}
