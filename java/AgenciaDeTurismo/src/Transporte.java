public class Transporte extends Producto implements Reserva{

    public Transporte(double precio, int cantidad){
        super(precio, cantidad);
    }

    public double reservar(double precioReserva){
        precioReserva += this.getPrecio();
        return precioReserva;
    }

}
