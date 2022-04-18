import java.util.ArrayList;

public class PaqueteTuristico{

    private int precio;
    private ArrayList<Producto> productos;


    public PaqueteTuristico(int precio, ArrayList<Producto> productos){
        this.precio = precio;
        this.productos = productos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void comprarPaqueteCompleto(){
        reservarHotel(int costo, int cantidad);
        reservarComida();
        reservarTickets();
        reservarTransporte();
    }

    public void reservarHotel(int costo, int cantidad){
        Hotel hotel = new Hotel(1500, 1);
        productos.add(hotel);
    }

    public void reservarComida(){
        Comida comida = new Comida(300, 2);
        productos.add(comida);
    }

    public void reservarTransporte(){
        Transporte transporte = new Transporte(3000,1);
        productos.add(transporte);
    }

    public void reservarTickets(){
        Tickets tickets = new Tickets(3500, 1);
        productos.add(tickets);
    }



}
