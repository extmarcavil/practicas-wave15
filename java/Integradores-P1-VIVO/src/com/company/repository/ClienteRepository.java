package com.company.repository;

import com.company.Cliente;


import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    /**
     * Atributos
     */
    List<Cliente> listaDeClientes;


    /**
     * Constructor
     */
    public ClienteRepository() {
        this.listaDeClientes = new ArrayList<>();
    }


    /**
     * Metodos
     */
    public void agregarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
        System.out.println("Cliente almacenado con la informacion: " + cliente +"\n");

    }


    /**
     * Getter & Setter
     */
    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

}
