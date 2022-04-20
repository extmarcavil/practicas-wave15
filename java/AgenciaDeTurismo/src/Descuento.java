import java.util.ArrayList;

public class Descuento {

    private double descuento;

    public Descuento(){
        this.descuento = 1;
    }

    public void descuentoDosLocalizadores(){
        this.descuento = 5/100;
    }

    public void descuentoPaqueteCompleto(PaqueteTuristico paquete){
        double precioPaquete = paquete.getPrecio();
        precioPaquete = precioPaquete * 10/100;
        paquete.setPrecio(precioPaquete);
    }

    public void descuentoDosReservas(Producto productoUno, Producto productoDos){
        double precioReserva = productoUno.getPrecio();
        precioReserva = precioReserva * 5/100;
        productoUno.setPrecio(precioReserva);
        double precioReservaDos = productoDos.getPrecio();
        precioReservaDos = precioReservaDos * 5/100;
        productoDos.setPrecio(precioReservaDos);
    }

    public void aplicar(Localizador localizador){
        ArrayList<PaqueteTuristico> paquetes = localizador.getPaquetes();
        for(int i = 0; i< paquetes.size(); i++){
            PaqueteTuristico paquete = paquetes.get(i);
            for(int j = 0; j < paquete.getProductos().size();j++){
                
            }
        }

    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
