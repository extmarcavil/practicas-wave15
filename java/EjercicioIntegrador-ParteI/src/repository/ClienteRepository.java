package repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Repository<Cliente>{
    List<Cliente> clientes;
    public ClienteRepository(){
        clientes = new ArrayList<>();
    }

    @Override
    public Cliente save(Cliente object) {
        clientes.add(object);
        return object;
    }

    @Override
    public Cliente delete(Cliente object) {
        try {
            return clientes.remove(clientes.indexOf(object));
        } catch (Exception e){
            System.out.println("No existe el cliente: " + object);
        }
        return null;
    }

    @Override
    public Cliente deleteByIndex(Integer index) {
        try{
            Cliente c = clientes.get(index);
            clientes.remove(index);
            return c;
        } catch (NullPointerException e){
            System.out.println("No existe cliente en esta posicion");
        };
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public Cliente findByIndex(Integer index) {
        try{
            return clientes.get(index);
        } catch (NullPointerException e){
            System.out.println("No existe cliente en esta posicion");
        };
        return null;
    }

    @Override
    public Cliente findEquals(Cliente object) {
        try {
            return clientes.get(clientes.indexOf(object));
        } catch (Exception e) {
            System.out.println("No existe la cliente: " + object);
        }
        return null;
    }

    @Override
    public Cliente updateByIndex(Integer index, Cliente cliente) {
        clientes.set(index, cliente);
        return cliente;
    }
}
