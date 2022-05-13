package ejercicioIntegradorSupermercado.repository;

import ejercicioIntegradorSupermercado.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImpRepository implements ICRUDRepository<Cliente> {

    private List<Cliente> lstClientes = new ArrayList<Cliente>();

    @Override
    public void guardar(Cliente cliente) {
        lstClientes.add(cliente);
    }

    @Override
    public void mostrarEnPantalla() {
        for (Cliente cliente : lstClientes) { System.out.println(cliente.toString()); }
    }

    @Override
    public Optional<Cliente> buscar(Long dni) {

        for (Cliente cliente : lstClientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println(cliente.toString());
                return Optional.of(cliente);
            }
        }

        System.out.println("Cliente no encontrado");

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dni) {
        Optional<Cliente> cliente = this.buscar(dni);

        if(cliente.isEmpty()) {
            System.out.println("No se encontro el cliente que se desea eliminar.");
        }
        else {
            System.out.println("Cliente eliminado correctamente.");
            lstClientes.remove(cliente.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return lstClientes;
    }
}
