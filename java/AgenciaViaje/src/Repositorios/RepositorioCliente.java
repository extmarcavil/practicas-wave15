package Repositorios;
import Modelo.Cliente;

import java.util.ArrayList;

public class RepositorioCliente implements Repositorio<Cliente>{

    private ArrayList<Cliente> listado_clientes;

    public RepositorioCliente() {
        this.listado_clientes = new ArrayList<>();
    }


    private boolean existeCliente(Cliente cliente){
        for(Cliente cli : listado_clientes){
            return cliente.getDni().equals(cli.getDni());
        }
        return false;
    }


    @Override
    public void agregar(Cliente item) {
        if(!existeCliente(item))
            listado_clientes.add(item);
    }
}
