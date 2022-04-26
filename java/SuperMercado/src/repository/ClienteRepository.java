package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements ICRUD <Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                return Optional.of(c);
            }
        }
        System.out.println("Cliente no encontrado");


        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorado) {
        Optional<Cliente> cli = this.buscar(dniBorado);

        if (cli.isEmpty()) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
            listaClientes.remove(cli.get());
        }

    }

    @Override
    public List<Cliente> todos() {
        return listaClientes;
    }
}

