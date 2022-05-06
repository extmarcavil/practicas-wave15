package com.company.repository;

import com.company.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FacturaImpl implements CRUDRepository<Factura> {

    /**
     * Atributos
     */
    private List<Factura> listaDeFacturas = new ArrayList<>();
    private ClienteImpl implClient;

    /**
     * Constructor
     */
    public FacturaImpl(ClienteImpl implClient) {
        this.implClient = implClient;
    }

    /**
     * Metodos
     */
    @Override
    public void save(Factura obj) {
        listaDeFacturas.add(obj);
        //Validando que el cliente este asociado a la BD de clienteIMPL
        implClient.getListaDeClientes().stream().forEach(c -> {
            if (c.equals(obj.getCliente())) {
                System.out.println("El cliente " + obj.getCliente().getNombre() + " ya esta registrado en la Bd " + "\n");
            } else {
                System.out.println("El cliente " + obj.getCliente().getNombre() + " ha sido registrado en la base de datos " + "\n");
            }
        });

       /* listaDeFacturas.stream().filter(factura -> {
            if (implClient.getListaDeClientes().contains(factura.getCliente())) {
                System.out.println("El cliente " + factura.getCliente().getNombre() + " ya esta registrado en la Bd " + "\n");
            } else {
                System.out.println("El cliente " + factura.getCliente().getNombre() + " ha sido registrado en la base de datos " + "\n");
            }
        });*/ //El uso es parecido pero itera dos veces un mismo cliente.

    }

    @Override
    public void mostrarPorPantalla() {
        listaDeFacturas.stream().forEach(factura -> System.out.println(factura));
    }

    @Override
    public Optional<Factura> buscarPorId(int dni) {
        Optional<Factura> factura = Optional.empty();
        //buscando la factura.
        try {
            factura = Optional.of(listaDeFacturas.stream()
                    .filter(f -> f.getCliente().getDni() == dni).findFirst().orElseThrow());
            System.out.println("Datos de la Factura: ");
        } catch (NoSuchElementException e) {
            System.out.println("Factura no esta almacenada en la base de datos" + "\n");
        }
        return factura;
    }

    @Override
    public void delete(int dni) {
        try {
            //Buscando la factura
            Optional<Factura> facturaEliminar = buscarPorId(dni);
            //Eliminando el cliente
            listaDeFacturas.remove(facturaEliminar);
            System.out.println("Factura eliminado correctamente " + facturaEliminar + "\n");
        } catch (NoSuchElementException e) {
            System.out.println("Factura no es posible eliminar ya que no ha sido almacenada en la Bd " + "\n");
        }
    }

    @Override
    public List<Factura> mostrarTodos() {
        return listaDeFacturas;
    }

    /**
     * Getter Y Setter
     */
    public List<Factura> getListaDeFacturas() {
        return listaDeFacturas;
    }

    public void setListaDeFacturas(List<Factura> listaDeFacturas) {
        this.listaDeFacturas = listaDeFacturas;
    }

    public ClienteImpl getImplClient() {
        return implClient;
    }

    public void setImplClient(ClienteImpl implClient) {
        this.implClient = implClient;
    }
}
