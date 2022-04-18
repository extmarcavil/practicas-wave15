package Supermercado.repository;

import Supermercado.Factura;
import Supermercado.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CrudRepository<Item>{
    ArrayList<Item> listadoItems = new ArrayList<>();
    @Override
    public void save(Item objeto) {
        listadoItems.add(objeto);
    }

    @Override
    public void mostrarDatos() {
        listadoItems.forEach(System.out::println);
    }

    @Override
    public Optional<Item> buscar(Long id) {
        boolean bandera=false;
        for (Item items: listadoItems) {
            if(items.getCodigo().equals(id)){
                System.out.println("Cliente encontrado");
                bandera=true;
                return Optional.of(items);
            }
        }
        System.out.println("Cliente no encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Item> item = buscar(id);
        if(item.isEmpty()){
            System.out.println("El item no existe");
        }else{
            listadoItems.remove(item.get());
            mostrarDatos();
        }
    }

    @Override
    public ArrayList<Item> mostrarTodosObjetos() {
        return listadoItems;
    }

    public double calcularTotal(){
        int cantidad= listadoItems.stream().mapToInt(Item::getCant).sum();
        double precio= listadoItems.stream().mapToDouble(Item::getConstoUnitario).sum();
        return cantidad*precio;
    }
}
