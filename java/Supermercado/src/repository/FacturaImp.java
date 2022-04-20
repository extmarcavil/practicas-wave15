package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository <Factura> {

    private List<Factura> facturas;

    public FacturaImp() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public void guardar(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrarPorPantalla() {
        for (Factura factura: facturas) {
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        boolean encontrado = false;

        for(Factura factura: facturas) {
            if(factura.getCodigo().equals(id)) {
                encontrado = true;
                System.out.println("Factura encontrada: ");
                System.out.println(factura.toString());
                return Optional.of(factura);
            }
        }
        if(!encontrado)
            System.out.println("No se encontro una factura con codigo: " + id);

        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Factura> factura = buscar(id);

        if(factura.isEmpty()) {
            System.out.println("No se pudo encontrar la factura");
        } else {
            facturas.remove(factura.get());
            System.out.println("La factura ha sido borrada con exito");
        }
    }

    @Override
    public List<Factura> obtenerTodos() {
        return facturas;
    }
}
