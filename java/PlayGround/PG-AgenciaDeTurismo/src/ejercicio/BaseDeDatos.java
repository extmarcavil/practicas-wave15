package ejercicio;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDeDatos {

    HashMap<Cliente, ArrayList<Localizador>> listaDeDatos;

    public BaseDeDatos() {
        this.listaDeDatos = new HashMap<>();
    }

    public int registrarCompraDePaquete(Cliente unCliente, Paquete unPaquete) {
        boolean aplicarDescuentoPorCantidadDeLocalizadores = contieneMasDeUnLocalizadorRegistrado(unCliente);
        boolean aplicarDescuentoPorCantidadDeHoteles = ( unPaquete.contieneMasDeUnHotel() || unPaquete.contieneMasDeUnBoleto());
        boolean aplicarDescuentoPorPaqueteCompleto = unPaquete.esUnPaqueteCompleto();

        double totalSinDescuentos = unPaquete.obtenerTotalDeReservas(false);
        double totalDescuentoDeHoteles = unPaquete.obtenerTotalDeReservas(aplicarDescuentoPorCantidadDeHoteles);
        double totalNeto = totalDescuentoDeHoteles * ((aplicarDescuentoPorPaqueteCompleto)? 0.9 : 1 ) * ((aplicarDescuentoPorCantidadDeLocalizadores)? 0.95 : 1 );

        System.out.println("-----------------------------------");
        System.out.println("Se registro un nuevo localizador");
        System.out.println("El total sin descuentos es: "+ totalSinDescuentos);
        System.out.println( (aplicarDescuentoPorCantidadDeLocalizadores?"Se detecto":"No se detecto") + " un descuento por cantidad de localizares");
        System.out.println( (aplicarDescuentoPorCantidadDeHoteles?"Se detecto":"No se detecto") + " un descuento por cantidad de hoteles/boletos");
        System.out.println( (aplicarDescuentoPorPaqueteCompleto?"Se detecto":"No se detecto") + " un descuento por paquete completo");
        System.out.println("El total con descuentos es: "+ totalNeto);
        System.out.println("-----------------------------------\n");


        Localizador localizadorParaElCliente = new Localizador(unCliente,totalNeto,unPaquete);
        if(listaDeDatos.containsKey(unCliente))
            this.listaDeDatos.get(unCliente).add(localizadorParaElCliente);
        else {
            ArrayList<Localizador> listaDeLocalizadores = new ArrayList();
            listaDeLocalizadores.add(localizadorParaElCliente);
            this.listaDeDatos.put(unCliente, listaDeLocalizadores);
        }
        return localizadorParaElCliente.hashCode();
    }

    private boolean contieneMasDeUnLocalizadorRegistrado(Cliente unCliente) {
        boolean aplicarDescuentoPorCantidadDeLocalizadores = false;
        if( listaDeDatos.containsKey(unCliente)){
            aplicarDescuentoPorCantidadDeLocalizadores = (listaDeDatos.get(unCliente).stream().count() >= 2);
        }
        return aplicarDescuentoPorCantidadDeLocalizadores;
    }

    public void imprimirComprobante(int numeroDeOperacion, Cliente clienteQueHizoOperacion) {
      if( listaDeDatos.containsKey(clienteQueHizoOperacion) == false)
          System.out.println("No se encontro cliente");
      else{
          System.out.println("Cliente encontrado");
          ArrayList<Localizador> listaDeLocalizadoresDelCliente = listaDeDatos.get(clienteQueHizoOperacion);
          Localizador localiadorEncontrado = listaDeLocalizadoresDelCliente.stream().filter(x->x.hashCode() == numeroDeOperacion).findFirst().get();
          System.out.println(localiadorEncontrado.toString());
      }
    }
}
