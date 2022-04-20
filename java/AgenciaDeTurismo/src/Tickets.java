public class Tickets extends Producto implements Reserva{

    public Tickets(int precio, int cantidad){
        super(precio, cantidad);
    }

    public double reservar(double precioReserva){
        precioReserva += this.getPrecio();
        return precioReserva;
    }

}
