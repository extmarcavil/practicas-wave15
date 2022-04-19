package repository;

import db.AgenciaTurismoDB;
import model.Cliente;

import java.util.List;

public class ClienteRepository implements Repository<Cliente,Integer>{

    @Override
    public Cliente findById(Integer dni) {
        return AgenciaTurismoDB.getClientes().get(dni);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return AgenciaTurismoDB.getClientes().put(cliente.getDni(), cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return List.copyOf(AgenciaTurismoDB.getClientes().values());
    }
}
