package AgenciaTurismo;

import java.util.ArrayList;

public class ClienteRepositorio implements Repositorio<Cliente> {
    ArrayList<Cliente> listadoClientes = new ArrayList<>();
    @Override
    public void agregar(Cliente objeto) {
        if(!existeCliente(objeto))
            listadoClientes.add(objeto);
    }
    public boolean existeCliente(Cliente clienteBuscar){
        return listadoClientes.stream().anyMatch(c -> c.equals(clienteBuscar));
    }

    public ArrayList<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(ArrayList<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    @Override
    public String toString() {
        return "ClienteRepositorio{" +
                "listadoClientes=" + listadoClientes +
                '}';
    }
}
