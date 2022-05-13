package ejercicioIntegradorSupermercado.repository;

import ejercicioIntegradorSupermercado.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoImpRepository implements ICRUDRepository<Producto> {

    private List<Producto> lstProductos = new ArrayList<Producto>();

    @Override
    public void guardar(Producto producto) {
        lstProductos.add(producto);
    }

    @Override
    public void mostrarEnPantalla() {
        for (Producto producto : lstProductos) { System.out.println(producto.toString()); }
    }

    @Override
    public Optional<Producto> buscar(Long codigo) {
        for (Producto producto : lstProductos) {
            if (producto.getCodigo().equals(codigo)) {
                System.out.println(producto.toString());
                return Optional.of(producto);
            }
        }

        System.out.println("Producto no encontrado");

        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigo) {
        Optional<Producto> producto = this.buscar(codigo);

        if(producto.isEmpty()) {
            System.out.println("No se encontro el producto que se desea eliminar.");
        }
        else {
            System.out.println("Producto eliminada correctamente.");
            lstProductos.remove(producto.get());
        }
    }

    @Override
    public List<Producto> traerTodos() {
        return lstProductos;
    }
}
