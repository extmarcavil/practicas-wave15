import java.util.ArrayList;
import java.util.List;

public class ClienteImp implements CRUD<Cliente>{

    List<Cliente> clientes;

    public ClienteImp() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String dni) {

        for(Cliente c : clientes){
            if (c.getDni().equals(dni)) {
               return c;
            }
        }
        System.out.println("El cliente no existe");
        return null;
    }

    @Override
    public void eliminar(String dni) {
        Cliente c = this.buscar(dni);
        if(c != null){
            clientes.remove(c);
        }
    }

    @Override
    public void mostrar() {
        for(Cliente c : clientes){
            System.out.println(c.toString());
        }
    }

    @Override
    public List<Cliente> devolver() {
        return clientes;
    }
}
