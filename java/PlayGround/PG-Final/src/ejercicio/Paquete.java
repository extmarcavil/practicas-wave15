package ejercicio;

import java.util.ArrayList;

public class Paquete {

    ArrayList<Reserva> reservasDelCliente;

    public Paquete() {
        this.reservasDelCliente = new ArrayList<>();
    }

    public Paquete(ArrayList<Reserva> reservasDelCliente) {
        this.reservasDelCliente = reservasDelCliente;
    }

    public void agregarAlPaquete(Reserva unaReserva){
        this.reservasDelCliente.add(unaReserva);
    }

    public void crearPaqueteCompleto(ReservaHotel unaReservaDeHotel,ReservaDeComida unaReservaDeComida,ReservaDeTransporte unaReservaDeTransporte, ReservaDeBoletoDeViaje unaReservaDeViaje){
        this.reservasDelCliente = new ArrayList<>();
        this.reservasDelCliente.add(unaReservaDeHotel);
        this.reservasDelCliente.add(unaReservaDeComida);
        this.reservasDelCliente.add(unaReservaDeTransporte);
        this.reservasDelCliente.add(unaReservaDeViaje);

    }

    public double obtenerTotalDeReservas(boolean aplicarDescuentoPorCantidadDeHoteles) {
        if(aplicarDescuentoPorCantidadDeHoteles == false)
            return this.reservasDelCliente.stream().map(Reserva::getMonto).reduce(0.0,(x,y) -> x+y);
        else{
           double totalSinHoteles = this.reservasDelCliente.stream().filter(x->!(x instanceof ReservaHotel)).map(Reserva::getMonto).reduce(0.0,(x,y) -> x+y);
           double totalHoteles = this.reservasDelCliente.stream().filter(x->x instanceof ReservaHotel).map(Reserva::getMonto).reduce(0.0,(x,y) -> x+(y*0.95));
           return totalHoteles + totalSinHoteles;
        }
    }

    public boolean contieneMasDeUnHotel() {
        return (this.reservasDelCliente.stream().filter(x->x instanceof ReservaHotel).count() > 1 );
    }

    public boolean contieneMasDeUnBoleto() {
        return (this.reservasDelCliente.stream().filter(x->x instanceof ReservaDeBoletoDeViaje).count() > 1 );
    }

    public boolean esUnPaqueteCompleto() {
        return(
                this.reservasDelCliente.stream().anyMatch(x->( x instanceof ReservaDeBoletoDeViaje) ) &&
                this.reservasDelCliente.stream().anyMatch(x->( x instanceof ReservaDeTransporte) )    &&
                this.reservasDelCliente.stream().anyMatch(x->( x instanceof ReservaDeComida) )        &&
                this.reservasDelCliente.stream().anyMatch(x->( x instanceof ReservaHotel) )              );
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "reservasDelCliente=" + reservasDelCliente +
                '}';
    }
}
