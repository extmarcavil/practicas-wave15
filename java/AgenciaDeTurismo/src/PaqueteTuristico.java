import java.util.ArrayList;

public class PaqueteTuristico{

    private double precio;
    private ArrayList<Producto> productos;


    public PaqueteTuristico(int precio){
        this.precio = precio;
        this.productos = new ArrayList<>();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void comprarPaqueteCompleto(int costo, int cantidad){
        reservarHotel(costo, cantidad);
        reservarComida(costo, cantidad);
        reservarTickets(costo, cantidad);
        reservarTransporte(costo, cantidad);
    }

    public void reservarHotel(int costo, int cantidad){
        Hotel hotel = new Hotel(1500, 1);
        productos.add(hotel);
        this.precio += hotel.reservar(this.precio);
    }

    public void reservarComida(int costo, int cantidad){
        Comida comida = new Comida(300, 2);
        productos.add(comida);
        this.precio += comida.reservar(this.precio);
    }

    public void reservarTransporte(int costo, int cantidad){
        Transporte transporte = new Transporte(3000,1);
        productos.add(transporte);
        this.precio += transporte.reservar(this.precio);
    }

    public void reservarTickets(int costo, int cantidad){
        Tickets tickets = new Tickets(3500, 1);
        productos.add(tickets);
        this.precio += tickets.reservar(this.precio);
    }


}
