package ejercicioIntegradorSupermercado.repository;

import ejercicioIntegradorSupermercado.model.Cliente;
import ejercicioIntegradorSupermercado.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImpRepository implements ICRUDRepository<Factura> {

    private List<Factura> lstFacturas = new ArrayList<Factura>();

    @Override
    public void guardar(Factura factura) {
        lstFacturas.add(factura);
    }

    @Override
    public void mostrarEnPantalla() {
        for (Factura factura : lstFacturas) { System.out.println(factura.toString()); }
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        for (Factura factura : lstFacturas) {
            if (factura.getId().equals(id)) {
                System.out.println(factura.toString());
                return Optional.of(factura);
            }
        }

        System.out.println("Factura no encontrada");

        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Factura> factura = this.buscar(id);

        if(factura.isEmpty()) {
            System.out.println("No se encontro la factura que se desea eliminar.");
        }
        else {
            System.out.println("Factura eliminada correctamente.");
            lstFacturas.remove(factura.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return lstFacturas;
    }
}
