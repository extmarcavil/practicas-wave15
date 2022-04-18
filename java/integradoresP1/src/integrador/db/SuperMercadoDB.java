package integrador.db;

import integrador.model.Cliente;
import integrador.model.Factura;

import java.util.HashMap;
import java.util.Map;

public class SuperMercadoDB {

    private static Map<Integer,Cliente> clientes;
    static {
        clientes = new HashMap<>();
        clientes.put(1234,new Cliente(1234,"Lucas","Jimenez"));
        clientes.put(12345,new Cliente(12345,"Brian","Jimenez"));
        clientes.put(123,new Cliente(123,"Emmanuel","Jimenez"));
    };

    //Para una mas facil busqueda de las facturas de un cliente
    private static Map<Integer,Factura> clienteFacturaMap = new HashMap<>();

    public static Map<Integer,Cliente> getClientes() {
        return clientes;
    }

    public static Map<Integer, Factura> getClienteFacturaMap() {
        return clienteFacturaMap;
    }
}
