package repository;
import com.company.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItempImp implements ICRUDRepository<Item>{

    List <Item> listaItems = new ArrayList<>();

    @Override
    public void save(Item object) {
        listaItems.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Item i : listaItems){
            System.out.println(i.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {
        boolean flag = false;
        for (Item items : listaItems){
            if (items.getCodigo().equals(codigoBuscado)){
                System.out.println("Se encontró el siguiente item:" + items.toString());
                return Optional.of(items);
            }
        }
        if (!flag){
            System.out.println("No se encontró el item.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoEliminado) {
        Optional<Item> i = this.buscar(codigoEliminado);
        if (i.isEmpty()){
            System.out.println("No se encontró el item a eliminar.");
        } else {
            listaItems.remove(i.get());
            System.out.println("Item eliminado corrrectamente.");
        }
    }

    @Override
    public List<Item> traerElementos() {
        return listaItems;
    }
}
