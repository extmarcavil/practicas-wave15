package integrador.repository;

import integrador.model.Cliente;
import integrador.db.SuperMercadoDB;

import java.util.List;

public class ClienteRepository implements Repository<Cliente,Integer>{


    @Override
    public List<Cliente> findAll() {
        return List.copyOf(SuperMercadoDB.getClientes().values());
    }

    @Override
    public Cliente find(Integer dni) {
        return SuperMercadoDB.getClientes().get(dni);
    }

    @Override
    public Cliente delete(Integer dni) {
        return SuperMercadoDB.getClientes().remove(dni);
    }

    @Override
    public Cliente insert(Cliente cliente) {
        return SuperMercadoDB.getClientes().put(cliente.getDni(),cliente);
    }

    @Override
    public Cliente update(Integer dni, Cliente cliente) {
        return SuperMercadoDB.getClientes().put(dni, cliente);
    }
}
