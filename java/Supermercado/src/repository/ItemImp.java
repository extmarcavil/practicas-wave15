package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository <Item> {

    private List<Item> items;

    public ItemImp() {
        this.items = new ArrayList<>();
    }

    @Override
    public void guardar(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrarPorPantalla() {
        for(Item item: items)
            System.out.println(item.toString());
    }

    @Override
    public Optional<Item> buscar(String id) {
        boolean encontrado = false;

        for(Item item: items) {
            if(item.getCodigo().equals(id)) {
                encontrado = true;
                System.out.println("Item encontrado: ");
                System.out.println(item.toString());
                return Optional.of(item);
            }
        }
        if(!encontrado)
            System.out.println("No se encontro el item con codigo: " + id);

        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Item> item = buscar(id);

        if(item.isEmpty()) {
            System.out.println("No se pudo encontrar el item");
        } else {
            items.remove(item.get());
            System.out.println("El item ha sido borrado con exito");
        }
    }

    @Override
    public List<Item> obtenerTodos() {
        return items;
    }
}
