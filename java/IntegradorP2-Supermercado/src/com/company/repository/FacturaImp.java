package repository;
import com.company.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICRUDRepository<Factura>{

    List<Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura object) {
        listaFacturas.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura fact : listaFacturas){
            System.out.println(fact.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoABuscar) {
        boolean flag = false;
        for (Factura fac : listaFacturas){
            if (fac.getCodigoFactura().equals(codigoABuscar)){
                System.out.println("Se encontro la factura con los siguientes datos:" + fac.toString());
                return Optional.empty();
            }
        }
        if (!flag){
            System.out.println("Factura no encontrada.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoAEliminar) {
        Optional<Factura> fact = this.buscar(codigoAEliminar);

        if (fact.isEmpty()){
            System.out.println("No se encontró la factura a eliminar.");
        } else {
            listaFacturas.remove(fact.get());
            System.out.println("Se eliminó la factura.");
        }
    }

    @Override
    public List<Factura> traerElementos() {

        return listaFacturas;
    }
}
