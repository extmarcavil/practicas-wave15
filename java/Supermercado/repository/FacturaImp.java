package Supermercado.repository;

import Supermercado.Cliente;
import Supermercado.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CrudRepository<Factura>{
    ArrayList<Factura> listadoFacturas = new ArrayList<>();
    @Override
    public void save(Factura objeto) {
        listadoFacturas.add(objeto);
    }

    @Override
    public void mostrarDatos() {
        listadoFacturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        boolean bandera=false;
        for (Factura factura: listadoFacturas) {
            if(factura.getCodigoF().equals(id)){
                System.out.println("Cliente encontrado");
                bandera=true;
                return Optional.of(factura);
            }
        }
        System.out.println("Cliente no encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Factura> fact = buscar(id);
        if(fact.isEmpty()){
            System.out.println("La factura ingresada no existe.");
        }else{
            listadoFacturas.remove(fact.get());
            mostrarDatos();
        }

    }

    @Override
    public ArrayList<Factura> mostrarTodosObjetos() {
        return listadoFacturas;
    }

    public boolean verificarExisteCliente(ArrayList<Cliente> listadoClientes,Factura fact){
        return listadoClientes.stream()
                .anyMatch(cliente -> cliente.getDni().equals(fact.getCliente().getDni()));
    }
    public void saveWithValidate(ClienteImp cliente,Factura fact){
        if(verificarExisteCliente(cliente.mostrarTodosObjetos(),fact)){
            this.save(fact);
        }else {
            cliente.save(fact.getCliente());
            this.save(fact);
        }
    }
}
