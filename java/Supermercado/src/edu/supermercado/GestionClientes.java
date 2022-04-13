package edu.supermercado;

import java.util.List;

public class GestionClientes {

    private List<Cliente> clientes;

    public GestionClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean eliminarCliente(Cliente cliente) {


        return clientes.remove(cliente);
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) return c;
        }
        return null;
    }

    public void mostrarClientes() {
        clientes.forEach(System.out::println);
    }
}
