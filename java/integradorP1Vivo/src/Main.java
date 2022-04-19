import model.*;
import services.ClienteService;
import services.LocalizadorService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService=new ClienteService();
        LocalizadorService localizadorService = new LocalizadorService();
        List<Localizador> localizadors;
        System.out.println("======================================");
        System.out.println("Listado de Clientes:");
        System.out.println(clienteService.listarClientes());
        System.out.println("======================================");
        System.out.println("Cliente por DNI:");
        Cliente cliente = clienteService.buscarCliente(2);
        System.out.println(cliente);
        System.out.println("======================================");
        System.out.println(localizadorService.listarLocalizadores());

        Localizador localizador=new Localizador(cliente,
                List.of(new Comida(100., LocalDate.now(), 7),
                        new Hotel(300.,LocalDate.now(),2,"Simple"),
                        new Transporte(500.,LocalDate.now(),"Auto",5),
                        new BoletoViaje(750.,LocalDate.now(),"Preferencial")
                )
        );

        localizadorService.crearLocalizador(localizador);
        localizadors=localizadorService.listarLocalizadores();
        System.out.println(localizadors);
        System.out.println("======================================");

        Localizador localizador1=new Localizador(cliente,
                    List.of(
                            new Hotel(300.,LocalDate.now(),2,"Simple"),
                            new Hotel(300.,LocalDate.now(),2,"Simple"),
                            new BoletoViaje(750.,LocalDate.now(),"Preferencial"),
                            new BoletoViaje(750.,LocalDate.now(),"Preferencial")
                    )
        );
        localizadorService.crearLocalizador(localizador1);
        localizadors=localizadorService.listarLocalizadores();
        System.out.println(localizadors);
        System.out.println("======================================");

        Localizador localizador2= new Localizador(cliente,
                List.of(
                    new Hotel(300.,LocalDate.now(),2,"Simple")
                )
        );

        localizadorService.crearLocalizador(localizador2);
        localizadors=localizadorService.listarLocalizadores();
        System.out.println(localizadors);

        System.out.println("======================================");
        System.out.println("FIN PARTE 1");
        System.out.println("======================================");

        System.out.println("Cantidad de localizadores Vendidos: "+localizadors.size());
        System.out.println("======================================");

        List<Reserva> reservas= new ArrayList<>();
        localizadors.forEach(reserva-> reservas.addAll(reserva.getReservas()));
        System.out.println("Cantidad de Reservas: "+reservas.size());
        System.out.println("======================================");

        Map<String,List<Reserva>> reservasMap=new HashMap<>();
        reservasMap.put("Hotel",new ArrayList<>());
        reservasMap.put("Boleto de Viaje",new ArrayList<>());
        reservasMap.put("Comida",new ArrayList<>());
        reservasMap.put("Transporte",new ArrayList<>());

        reservas.forEach(r->{
            if (r instanceof Hotel) reservasMap.get("Hotel").add(r);
            if (r instanceof BoletoViaje) reservasMap.get("Boleto de Viaje").add(r);
            if (r instanceof Comida) reservasMap.get("Comida").add(r);
            if (r instanceof Transporte) reservasMap.get("Transporte").add(r);
        });


        System.out.println(reservasMap);
        System.out.println("======================================");
        System.out.println("Total de las ventas: "+
                localizadors.stream()
                        .mapToDouble(Localizador::getTotal)
                        .sum()
        );
        System.out.println("======================================");
        System.out.println("Promedio de las ventas: "+
                localizadors.stream()
                        .mapToDouble(Localizador::getTotal)
                        .average().getAsDouble()
        );


    }
}
