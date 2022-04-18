package ar.com.alehenestroza;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente implements Repositorio<String, Cliente> {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    private boolean existe(Cliente cliente) {
        long count = this.clientes.entrySet().stream()
                .filter(p -> p.getValue().equals(cliente))
                .count();

        return count != 0;
    }

    public String agregar(Cliente cliente) {
        String documento = null;
        if (!existe(cliente)) {
            documento = cliente.getDocumento();
            clientes.put(documento, cliente);
        }
        return cliente.getDocumento();
    }

    public void mostrarClientes() {
        this.clientes.forEach((p, q) -> {
            System.out.println("Cliente " + p + ":");
            System.out.println(q.toString());
        });
    }

    public Cliente buscarPorDocumento(String documento) {
        return clientes.get(documento);
    }
}
