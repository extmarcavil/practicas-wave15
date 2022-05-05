import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private static final RepositorioClientes repositorioClientes = new RepositorioClientes();
    private List<Cliente> clientes;

    private RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    public static RepositorioClientes getRepositorioClientes() {
        return repositorioClientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}
