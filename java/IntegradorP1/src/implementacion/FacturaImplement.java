package implementacion;

import modelo.Cliente;
import modelo.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImplement implements CRUD<Factura>{

    List<Factura> facturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Factura f : facturas) {
            System.out.println(f.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        boolean bandera = false;

        for (Factura f : facturas) {
            if(f.getCodigo().equals(id)){
                System.out.println("Factura encontrada: ");
                System.out.println(f.toString());
                bandera = true;
                break;
            }
        }

        if(!bandera){
            System.out.println("La factura no pudo ser encontrado...");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        boolean bandera = false;

        for (Factura f : facturas) {
            if(f.getCodigo().equals(id)){
                facturas.remove(f);
                bandera = true;
                break;
            }
        }

        if(bandera) {
            System.out.println("Factura eliminada de la lista:");
            mostrar();
        } else {
            System.out.println("No se pudo encontrar la factura a eliminar");
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}
