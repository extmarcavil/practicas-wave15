package com.company.repository;

import com.company.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ItemImpl implements CRUDRepository<Item> {

    /**
     * Atributos
     */
    List<Item> listaDeItems = new ArrayList<>();

    /**
     * Methods
     */
    @Override
    public void save(Item obj) {
        listaDeItems.add(obj);
    }

    @Override
    public void mostrarPorPantalla() {
        listaDeItems.stream().forEach(item -> System.out.println(item));
    }

    @Override
    public Optional<Item> buscarPorId(int codigo) {
        Optional<Item> itemBuscar = null;

        try {
            itemBuscar = Optional.of(listaDeItems.stream()
                    .filter(item -> item.getCodigo().equals(codigo)).findFirst().orElseThrow());
            System.out.println("Informacion del item: ");
        } catch (NoSuchElementException e) {
            System.out.println("Item no esta almacenado en la base de datos " + "\n");
        }

        return itemBuscar;
    }

    @Override
    public void delete(int codigo) {

        try {
            Optional<Item> itemEliminar = buscarPorId(codigo);
            // Eliminando Item de la lista
            listaDeItems.remove(itemEliminar);
            System.out.println("Item eliminado correctamente: " + itemEliminar + "\n");
        } catch (NoSuchElementException e) {
            System.out.println("Item no es posible eliminar ya que no ha sido almacenado en la BD" + "\n");
        }
    }

    @Override
    public List<Item> mostrarTodos() {
        return listaDeItems;
    }

    /**
     * Getter & Setter
     */
    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }
}
