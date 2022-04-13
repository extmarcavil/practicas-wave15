import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class FacturaServicio implements ICrudGeneral<Factura> {
    private List<Factura> listFacturas;

    public FacturaServicio() {
        listFacturas = new ArrayList<>();
    }

    @Override
    public boolean Nuevo(Factura entity) {
        if(listFacturas.size() == 0)
            entity.setCodigoFactura(1);
        else{
            var t = listFacturas.get(listFacturas.size() - 1);
            entity.setCodigoFactura(t.getCodigoFactura() + 1);
        }
        entity.setTotalCompra(entity.getListProductos().stream()
                .mapToDouble(i -> i.getCostoUnitario() * i.getCantidad())
                .sum());
        listFacturas.add(entity);
        return true;
    }

    @Override
    public boolean Eliminar(long Codigo) {
        listFacturas.remove(this.Buscar(Codigo));
        return  true;
    }

    @Override
    public Factura Buscar(long Codigo) {
        var where =  listFacturas.stream().filter(f -> f.getCodigoFactura() == Codigo).collect(Collectors.toList());
        if(where.stream().count() > 0){
            return where.stream().findFirst().get();
        }
        else
            return  null;
    }

    @Override
    public boolean Actualizar(Factura entity) {
        try{
            var idx = listFacturas.indexOf(entity);
            listFacturas.add(idx,entity);
            return true;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Factura> BuscarTodo() {
        return listFacturas;
    }

    public  List<Factura> getFacturasCliente(long DniCliente){
        var result = new ArrayList<Factura>();
        listFacturas.forEach(item -> {
            if(item.getCliente().getDni().equals(DniCliente))
                result.add(item);
        });
        return  result;
    }
}
