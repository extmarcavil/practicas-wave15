package implementacion;

import modelo.Factura;
import modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImplement implements CRUD<Item>{


    List<Item> items = new ArrayList<Item>();

    @Override
    public void save(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Item i : items) {
            System.out.println(i.toString());
        }

    }

    @Override
    public Optional<Item> buscar(String id) {
        boolean bandera = false;

        for (Item i : items) {
            if(i.getCodigo().equals(id)){
                System.out.println("Item encontrado: ");
                System.out.println(i.toString());
                bandera = true;
                break;
            }
        }

        if(!bandera){
            System.out.println("El item no pudo ser encontrado...");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {

        boolean bandera = false;

        for (Item i : items) {
            if(i.getCodigo().equals(id)){
                items.remove(i);
                bandera = true;
                break;
            }
        }

        if(bandera) {
            System.out.println("Item eliminado de la lista:");
            mostrar();
        } else {
            System.out.println("No se pudo encontrar el item a eliminar");
        }

    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }
}
