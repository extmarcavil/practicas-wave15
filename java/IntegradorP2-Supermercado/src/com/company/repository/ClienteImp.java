package repository;
import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements ICRUDRepository <Cliente>{ //Imp -> Implementacion

    List <Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente object) {
        listaClientes.add(object);
    }

    @Override
    public void mostrarPantalla() {
        //Recorriendo la lista de clientes
        System.out.println("------------------");
        System.out.println("Lista de clientes:");
        System.out.println("------------------");
        for (Cliente c : listaClientes){
            System.out.println("Nombre " + c.getNombre() + ", apellido " + c.getApellido() + ", DNI " + c.getDni());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long DNIABuscar) {
        boolean flag = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(DNIABuscar)){
                System.out.println("La persona con DNI " + c.getDni() + ", se llama " + c.getNombre() + " " + c.getApellido());
                return Optional.of(c);
            }
        }

        if (!flag){
            System.out.println("No se encontró al cliente solicitado.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long DNIElimninado) {
        Optional<Cliente> client = this.buscar(DNIElimninado);

        if (client.isEmpty()){
            System.out.println("No se eliminó a ningun cliente.");
        } else {
            listaClientes.remove(client.get());
            System.out.println("Se eliminó el cliente correctamente.");
        }
    }

    @Override
    public List<Cliente> traerElementos() {
        return null;
    }

}
