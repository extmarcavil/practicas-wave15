package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RepoClient {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> addClient(Cliente cliente){
        this.clientes.add(cliente);
        return this.clientes;
    }

    public List<Cliente> removeClient(Cliente cliente){
        clientes.remove(cliente);

        return clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void mostrarClientes(){
        clientes.stream().forEach(System.out::println);
    }

    public Cliente findByDNI(int dni){
        Cliente toRet = clientes.stream().filter(c -> c.getDni() == dni).findFirst().orElse(null);

        return toRet;
    }
}
