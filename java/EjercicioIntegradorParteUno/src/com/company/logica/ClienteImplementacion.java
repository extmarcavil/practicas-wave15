package com.company.logica;

import com.company.clases.Cliente;
import com.company.repositorios.RepositorioCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImplementacion implements RepositorioCRUD<Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes) {
            System.out.println("DNI: " + c.getDni());
            System.out.println("Nombre cliente: " + c.getNombre());
            System.out.println("Apellido cliente: " + c.getApellido());
            System.out.println();
        }
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        boolean clienteEncontrado = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(id)) {
                System.out.println("------ Datos del usuario ------");
                System.out.println("DNI: " + c.getDni());
                System.out.println("Nombre cliente: " + c.getNombre());
                System.out.println("Apellido cliente: " + c.getApellido());
                return Optional.of(c);
            }
        }
        if (clienteEncontrado == false) {
            System.out.println("El cliente no fue encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Cliente> cliente = this.buscar(id);
        if (cliente.isEmpty()) {
            System.out.println("El cliente no pudo ser borrado");
        } else {
            listaClientes.remove(cliente.get());
            System.out.println("Cliente borrado correctamete");
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}
