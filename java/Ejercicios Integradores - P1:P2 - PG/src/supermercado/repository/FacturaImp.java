package supermercado.repository;

import supermercado.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FacturaImp implements CrudRepository<Factura> {

    List<Factura> facturas = new ArrayList<>();

    @Override
    public void guardar(Factura factura) {
        facturas.add(factura);
        System.out.println("\nLa factura se agrego correctamente.");
    }

    @Override
    public void mostrarPantalla() {
        System.out.println("\n==================\n");
        System.out.println("Lista de facturas: \n");
        facturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(String id) {
        return Optional.ofNullable(facturas.stream()
                .filter(f -> Objects.equals(f.getId(), id))
                .findFirst().orElse(null));
    }


    @Override
    public void eliminar(String id) {
        Optional<Factura> factura = buscar(id);
        if (factura.isPresent()) {
            facturas.remove(factura.get());
            System.out.println("La factura: " + factura.get().getId() +
                    " del cliente: ." + factura.get().getCliente().getNombre() + " fue eliminada.");
        } else {
            System.out.println("La factura ingresada no fue encontrada!");
        }
    }
}
