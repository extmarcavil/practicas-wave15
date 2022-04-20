package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository <Cliente> {

    private List<Cliente> clientes;

    public ClienteImp() {
        clientes = new ArrayList<>();
    }

    @Override
    public void guardar(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPorPantalla() {
        for(Cliente cliente: clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Dni: " + cliente.getDni());
        }
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        boolean dniEncontrado = false;

        for(Cliente cliente: clientes) {
            if(cliente.getDni().equals(id)) {
                dniEncontrado = true;
                System.out.println("Cliente encontrado: ");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dni: " + cliente.getDni());
                return Optional.of(cliente);
            }
        }
        if(!dniEncontrado)
            System.out.println("No se encontro un cliente con el dni: " + id);

        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Cliente> cliente = buscar(id);

        if(cliente.isEmpty()) {
            System.out.println("No se pudo encontrar al cliente");
        } else {
            clientes.remove(cliente.get());
            System.out.println("El cliente ha sido borrado con exito");
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}
