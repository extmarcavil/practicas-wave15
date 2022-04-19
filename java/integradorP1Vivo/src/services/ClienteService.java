package services;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();

    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.create(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(Integer dni){
        return clienteRepository.findById(dni);
    }

}
