package ejercicioAgencia.repositorio;

import ejercicioAgencia.Cliente;

import java.util.ArrayList;

public class RepositorioCliente {

    private ArrayList<Cliente> lstClientes;

    public RepositorioCliente() {
        this.lstClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        lstClientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return lstClientes;
    }

    public void setClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }
}
