import models.Cliente;
import models.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado() {
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public boolean existsClienteByDni(String dni) {
        return this.findClienteByDni(dni).isPresent();
    }

    public Optional<Cliente> findClienteByDni(String dni) {
        return this.clientes
                .stream()
                .filter(c -> c.getDni().equals(dni))
                .findAny();
    }

    public void removeClientePorDni(String dni) {
        this.clientes = clientes
                .stream()
                .filter(c -> !c.getDni().equals(dni))
                .collect(Collectors.toList());
    }

    public void imprimirClientePorDni(String dni) {
        System.out.println("-------------- Buscando cliente con dni " + dni);
        Optional<Cliente> oc = this.findClienteByDni(dni);
        if (oc.isPresent()) {
            oc.get().imprimir();
        } else {
            System.out.println("No existe ese cliente");
        }
        System.out.println("");
    }

    public void imprimirClientes() {
        System.out.println("-------------- Lista de clientes");
        this.clientes.forEach(Cliente::imprimir);
        System.out.println("");
    }

    public void addFactura(Factura factura) {
        if (!this.existsClienteByDni(factura.getCliente().getDni())) {
            this.addCliente(factura.getCliente());
        }
        this.facturas.add(factura);
    }

    public void imprimirFacturas() {
        System.out.println("-------------- Lista de facturas");
        this.facturas.forEach(System.out::println);
        System.out.println("");
    }
}
