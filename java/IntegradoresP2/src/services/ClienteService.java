package services;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private static final ClienteRepository clienteRepository = new ClienteRepository();

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente eliminarCliente(Integer dni){
         Cliente cliente = clienteRepository.delete(dni);
        if (cliente == null)
            System.out.println("No se encontro Cliente con DNI "+dni );
        else System.out.println("ELiminado exitosamente");
        return cliente;
    }

    public Cliente buscarClientePorDni(Integer dni){
        Cliente cliente = clienteRepository.find(dni);
        if (cliente == null)
            System.out.println("No se encontro Cliente con DNI "+dni );
        else System.out.println("Encontrado exitosamente");
        return cliente;
    }

    public Cliente modificarCliente(Integer dni,Cliente cliente){
        return clienteRepository.update(dni,cliente);
    }

    public void crearCliente(Cliente cliente){
        clienteRepository.insert(cliente);
    }

}
