package repositorio;
import model.Cliente;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDrepository <Cliente>{

    List<Cliente> listaCliente = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        listaCliente.add(objeto);
    }

    @Override
    public void mostrarPantalla() {

        for(Cliente cli : listaCliente){
            System.out.println("DNI: " + cli.getDni() + ". Nombre y apellido: " + cli.getNombre() + " " + cli.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long clienteBuscado) {

        Boolean bandera = false;
        for(Cliente cliente : listaCliente){
            if(cliente.getDni().equals(clienteBuscado)){
                System.out.println("El cliente buscado tiene la siguiente información: ");
                System.out.println("DNI: " + cliente.getDni() + ". Nombre y apellido: " + cliente.getNombre() + " " + cliente.getApellido());
                return Optional.of(cliente);
            }
        }
        if(!bandera){
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {

        Optional<Cliente> cliente = this.buscar(dniBorrado);

        if(cliente.isEmpty()){
            System.out.println("No se encontró ningún cliente asociado al DNI");
        }
        else{
            System.out.println("Cliente asociado al DNI borrado correctamente");
            listaCliente.remove(cliente.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}
