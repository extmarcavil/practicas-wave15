package com.company.logica;

import com.company.clases.Cliente;
import com.company.clases.Factura;
import com.company.repositorios.RepositorioCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImplementacion implements RepositorioCRUD<Factura> {

    List<Factura> listaFactura = new ArrayList<>();

    @Override
    public void save(Factura objeto) {
        listaFactura.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Factura f : listaFactura){
            System.out.println(f.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        boolean facturaEncontrada = false;
        for (Factura f : listaFactura) {
            if (f.getCodigo().equals(id)) {
                System.out.println("------ Datos de FACTURA ------");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }
        if (facturaEncontrada == false) {
            System.out.println("La factura no fue encontrada");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Factura> factura = this.buscar(id);
        if (factura.isEmpty()) {
            System.out.println("La factura no pudo ser borrada");
        } else {
            listaFactura.remove(factura.get());
            System.out.println("La factura fue borrada correctamete");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFactura;
    }
}
