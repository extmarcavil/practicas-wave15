package ejercicio;

public class Paquete {

    Cliente nuevoCliente;
    ReservaHotel reservaDeHotel;
    Comida comida;
    BoletoDeViaje boletosDeViaje;
    Transporte transporte;
    Localizador unLocalizador;

    public Paquete(Cliente nuevoCliente, ReservaHotel reservaDeHotel, Comida comida, BoletoDeViaje boletosDeViaje, Transporte transporte) {
        this.nuevoCliente = nuevoCliente;
        this.reservaDeHotel = reservaDeHotel;
        this.comida = comida;
        this.boletosDeViaje = boletosDeViaje;
        this.transporte = transporte;

        //nuevoCliente.guardarPaquete(this);

        double total = 0;
        total += reservaDeHotel.getMonto();
        total += comida.getMonto();
        total += boletosDeViaje.getMonto();
        total += transporte.getMonto();
        unLocalizador = new Localizador(nuevoCliente,total,this);

    }

    public Localizador getLocalizador() {
            return unLocalizador;
    }

    public void imprimirLocalizador(){
        System.out.println("Cliente : "+ unLocalizador.getCliente().nombre);
        System.out.println("Total : "+ unLocalizador.getTotal());
    }


}
