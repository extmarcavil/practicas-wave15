import java.util.ArrayList;
import java.util.List;

public class ProductoImp implements CRUD<Producto>{

    List<Producto> productos;

    public ProductoImp() {
        productos = new ArrayList<>();
    }



    @Override
    public void guardar(Producto objeto) {
        productos.add(objeto);
    }

    @Override
    public Producto buscar(String objeto) {
        for(Producto p : productos){
            if (p.getCodigo().equals(objeto)) {
                return p;
            }
        }
        System.out.println("El producto no existe");
        return null;
    }

    @Override
    public void eliminar(String codigo) {
        Producto p = this.buscar(codigo);
        if(p != null){
            productos.remove(p);
        }
    }

    @Override
    public void mostrar() {
        for(Producto p : productos){
            System.out.println(p.toString());
        }
    }

    @Override
    public List<Producto> devolver() {
        return productos;
    }
}
