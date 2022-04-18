package implementacion;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImplement implements CRUD<Cliente> {

    List<Cliente> clientes = new ArrayList<Cliente>();
    @Override
    public void save(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente c:clientes) {
            System.out.println("DNI: " + c.getDni() + " - Nombre: " + c.getNombre() + " - Apellido: " + c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        boolean bandera = false;
        Optional<Cliente>  cli = Optional.of(new Cliente());

        for (Cliente c:clientes) {
            if(c.getDni().equals(id)){
                System.out.println("Cliente encontrado: ");
                System.out.println("DNI: " + c.getDni() + " - Nombre: " + c.getNombre() + " - Apellido: " + c.getApellido());
                bandera = true;
                cli = Optional.of(c);
                return cli;
            }
        }

        if(!bandera){
            System.out.println("El cliente no pudo ser encontrado...");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        boolean bandera = false;

        for (Cliente c:clientes) {
            if(c.getDni().equals(id)){
                clientes.remove(c);
                bandera = true;
                break;
            }
        }

        if(bandera) {
            System.out.println("👍 Cliente eliminado de la lista:");
            mostrar();
        } else {
            System.out.println("No se pudo encontrar el cliente a eliminar");
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
