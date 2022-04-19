package db;

import model.Cliente;
import model.Localizador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgenciaTurismoDB {
    private static Map<Integer, Cliente> clientes;
    static {
        clientes=new HashMap<>();
        clientes.put(1,new Cliente(1,"Luc","Doe"));
        clientes.put(12,new Cliente(12,"Ema","Joe"));
        clientes.put(123,new Cliente(123,"Due","Ema"));
        clientes.put(1234,new Cliente(1234,"Mike","Lamp"));
        clientes.put(2,new Cliente(2,"Juan","Bela"));

    }


    private static Map<Cliente, List<Localizador>> localizadoresPorCliente;
    static {
        localizadoresPorCliente=new HashMap<>();
    }

    public static Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public static Map<Cliente, List<Localizador>> getLocalizadoresPorCliente() {
        return localizadoresPorCliente;
    }
}
