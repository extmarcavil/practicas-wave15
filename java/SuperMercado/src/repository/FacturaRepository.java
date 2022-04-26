package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements ICRUD <Factura>{

    List<Factura> listaFacturas = new ArrayList<Factura>();

    public void save(Factura objeto, ClienteRepository clientes) {
        if(clientes.buscar(objeto.getCliente().getDni()).isEmpty()) {
            clientes.save(objeto.getCliente());
        }
        save(objeto);
    }

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrar() {

        for (Factura fact : listaFacturas) {
            System.out.println(fact.toString());

        }

    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {
        for (Factura f : listaFacturas) {
            if (f.getCodigoFactura().equals(codigoBuscado)) {
                System.out.println("----Factura encontrada, sus datos son: ----");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }
        System.out.println("Factura no encontrada");
        return Optional.empty();

    }

    @Override
    public void eliminar(Long codigoBorrado) {

        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isEmpty()) {
            System.out.println("No se encontró la factura a borrar");
        }
        else {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(fact.get());
        }

    }

    @Override
    public List<Factura> todos() {
        return listaFacturas;
    }
}

