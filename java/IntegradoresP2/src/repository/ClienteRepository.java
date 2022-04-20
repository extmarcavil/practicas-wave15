package repository;

import model.Cliente;
import db.SuperMercadoDB;

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
    public void insert(Cliente cliente) {
        SuperMercadoDB.getClientes().put(cliente.getDni(),cliente);
    }

    @Override
    public Cliente update(Integer dni, Cliente cliente) {
        return SuperMercadoDB.getClientes().put(dni, cliente);
    }
}
