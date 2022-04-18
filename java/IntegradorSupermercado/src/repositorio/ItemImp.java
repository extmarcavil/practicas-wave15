package repositorio;
import model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDrepository <Item>{

    List <Item> listaItems = new ArrayList<>();

    @Override
    public void save(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item it : listaItems) {
            System.out.println(it.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {

        boolean bandera = false;
        for (Item i : listaItems) {
            if (i.getCodigo().equals(codigoBuscado)) {
                System.out.println("----Item encontrado, sus datos son: ----");
                System.out.println(i.toString());
                return Optional.of(i);
            }
        }

        if (bandera == false) {
            System.out.println("Item no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Item> it = this.buscar(codigoBorrado);

        if (it.isEmpty()) {
            System.out.println("No se encontró el item a borrar");
        }
        else {
            System.out.println("item borrado correctamente");
            listaItems.remove(it.get());
        }
    }

    @Override
    public List<Item> traerTodos() {
        return listaItems;
    }
}
