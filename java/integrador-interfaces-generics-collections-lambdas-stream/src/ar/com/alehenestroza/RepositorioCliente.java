package ar.com.alehenestroza;

import java.util.ArrayList;

public class RepositorioCliente implements Repositorio<Cliente> {
    private ArrayList<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    private boolean existeCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(cliente.getDocumento())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregar(Cliente item) {
        if (!existeCliente(item)) {
            clientes.add(item);
        }
    }

}

