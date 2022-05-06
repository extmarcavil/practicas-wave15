package com.company.repository;

import com.company.model.Cliente;

import java.util.*;

public class ClienteImpl implements CRUDRepository<Cliente> {

    /**
     * Atributos
     */
    private List<Cliente> listaDeClientes = new ArrayList<>();


    /**
     * Metodos
     */
    @Override
    public void save(Cliente obj) {
        listaDeClientes.add(obj);
    }

    @Override
    public void mostrarPorPantalla() {
        listaDeClientes.stream().forEach(cliente -> System.out.println(cliente));
    }

    @Override
    public Optional<Cliente> buscarPorId(int dni) {
        Optional<Cliente> clienteABuscar = Optional.empty();
        try {
            //Buscando el cliente
            clienteABuscar = Optional.of(listaDeClientes.stream()
                    .filter(c -> c.getDni() == dni).findFirst().orElseThrow());
            System.out.println("Informacion del cliente: ");
        } catch (NoSuchElementException e) {
            System.out.println("Cliente no esta almacenado en la base de datos " + "\n");
        }
        return clienteABuscar;
    }

    @Override
    public void delete(int dni) {

        //Formas de recorrerla lista clinete, obtener el cliente, mostarr cliente, eliminar cliente.
        /*Cliente clienteAbuscar = listaDeClientes.stream()
             .filter(c -> c.getDni() == dni).findFirst().orElseThrow();
        listaDeClientes.stream().filter(dni -> dni.getDni() == dniAbuscar).forEach(cliente -> System.out.println(cliente));
        listaDeClientes.removeIf(cliente -> cliente.getDni() == dni);*/

        try {
            //Buscando el cliente.
            Optional<Cliente> clienteBuscado = buscarPorId(dni);
            //Eliminando el cliente.
            listaDeClientes.remove(clienteBuscado.get());
            System.out.println("Cliente eliminado correctamente: " + clienteBuscado + "\n");
        } catch (NoSuchElementException e) {
            System.out.println("Cliente no es posible eliminar ya que no ha sido almacenado en la Bd " + "\n");
        }
    }

    @Override
    public List<Cliente> mostrarTodos() {
        return listaDeClientes;
    }

    /**
     * Getter & Setter
     */
    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
}
