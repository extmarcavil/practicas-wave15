package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura>{

    ArrayList<Factura> listaFacturas = new ArrayList<>();

    @Override
    public void guardar(Factura object) {
        listaFacturas.add(object);
    }

    @Override
    public void consultar() {
        listaFacturas.forEach(System.out::println);
    }

    @Override
    public Factura buscar(int id) {
        return null;
    }

    @Override
    public void eliminar() {

    }
}
