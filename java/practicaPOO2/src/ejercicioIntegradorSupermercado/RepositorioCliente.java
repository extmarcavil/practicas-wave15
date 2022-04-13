package ejercicioIntegradorSupermercado;

import java.util.ArrayList;

public class RepositorioCliente {

    private ArrayList<Cliente> lstClientes;

    public RepositorioCliente(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public ArrayList<Cliente> getClientes() {
        return lstClientes;
    }

    public void setClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    @Override
    public String toString() {
        return "RepositorioCliente{" +
                "lstClientes=" + lstClientes +
                '}';
    }
}
