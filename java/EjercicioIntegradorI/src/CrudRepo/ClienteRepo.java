package CrudRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import Supermercado.Cliente;

public class ClienteRepo implements CrudRepo<Cliente>{
    private HashMap<String, Cliente> clientes = new HashMap<>();

    @Override
    public void save(Cliente objeto) {
        clientes.put(objeto.getDni(), objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente client : clientes.values()){
            System.out.println(client);
        }
    }

    @Override
    public Optional<Cliente> buscar(String clave) {
        if (clientes.containsKey(clave)){
            return Optional.of(clientes.get(clave));
        } else {
            System.out.println("Supermercado.Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String clave) {
        Optional<Cliente> cl = this.buscar(clave);
        if (cl.isEmpty()){
            System.out.println("Cliente no encontrado");
        } else {
            clientes.remove(clave);
        }
    }

    @Override
    public List<Cliente> mostrarTodos() {
        return null;
    }
}
