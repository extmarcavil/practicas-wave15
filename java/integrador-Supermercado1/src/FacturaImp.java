import java.util.ArrayList;
import java.util.List;

public class FacturaImp implements CRUD<Factura> {

    List<Factura> facturas;

    public FacturaImp() {
        facturas = new ArrayList<>();
    }

    @Override
    public void guardar(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public Factura buscar(String codigo) {
        for(Factura f : facturas){
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        System.out.println("La factura no existe");
        return null;
    }

    @Override
    public void eliminar(String codigo) {

        Factura f = this.buscar(codigo);
        if(f != null){
            facturas.remove(f);
        }
    }

    @Override
    public void mostrar() {
        for(Factura f : facturas){
            System.out.println(f.toString());
        }
    }

    @Override
    public List<Factura> devolver() {
        return facturas;
    }
}
