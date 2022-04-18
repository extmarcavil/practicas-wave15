package Supermercado.repository;

import Supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CrudRepository<Cliente>{

    ArrayList<Cliente> listadoClientes= new ArrayList<>();
    @Override
    public void save(Cliente objeto) {
        listadoClientes.add(objeto);
    }

    @Override
    public void mostrarDatos() {
        listadoClientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        boolean bandera=false;
        for (Cliente clientes: listadoClientes) {
            if(clientes.getDni().equals(id)){
                System.out.println("Cliente encontrado");
                bandera=true;
                return Optional.of(clientes);
            }
        }
        System.out.println("Cliente no encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Cliente> cli = buscar(id);
        if (cli.isEmpty()) {
            System.out.println("El cliente ingresado no se encuentra.");
        }else{
            listadoClientes.remove(cli.get());
            mostrarDatos();
        }
    }

    @Override
    public ArrayList<Cliente> mostrarTodosObjetos() {
        return listadoClientes;
    }
}
