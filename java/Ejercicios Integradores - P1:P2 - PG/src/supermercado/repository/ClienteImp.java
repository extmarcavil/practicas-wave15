package supermercado.repository;

import supermercado.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteImp implements CrudRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void guardar(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("\nEl cliente se agrego correctamente.");
    }

    @Override
    public void mostrarPantalla() {
        System.out.println("\n==================\n");
        System.out.println("Lista de clientes: \n");
        clientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(String dni) {
        return Optional.ofNullable(clientes.stream()
                .filter(c -> Objects.equals(c.getDni(), dni))
                .findFirst().orElse(null));
    }

    @Override
    public void eliminar(String dni) {
        Optional<Cliente> cliente = buscar(dni);
        if (cliente.isPresent()) {
            clientes.remove(cliente.get());
            System.out.println("El cliente " + cliente.get().getNombre() + " fue eliminado con exito.");
        } else {
            System.out.println("El cliente ingresado no fue encontrado!");
        }
    }
}
