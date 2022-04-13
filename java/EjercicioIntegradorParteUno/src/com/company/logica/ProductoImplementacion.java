package com.company.logica;

import com.company.clases.Cliente;
import com.company.clases.Producto;
import com.company.repositorios.RepositorioCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoImplementacion implements RepositorioCRUD<Producto> {

    List<Producto> listaProductos = new ArrayList<Producto>();

    @Override
    public void save(Producto objeto) {
        listaProductos.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Producto p : listaProductos) {
            System.out.println("Codigo del producto: " + p.getCodigo());
            System.out.println("Nombre del producto: " + p.getNombre());
            System.out.println("Costo unitario: " + p.getCostoUnitario());
            System.out.println();
        }
    }

    @Override
    public Optional<Producto> buscar(String id) {
        boolean productoEncontrado = false;
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(id)) {
                System.out.println("------ Datos del producto ------");
                System.out.println("Codigo: " + p.getCodigo());
                System.out.println("Nombre del producto: " + p.getNombre());
                System.out.println("Costo Unitario: " + p.getCostoUnitario());
                return Optional.of(p);
            }
        }
        if (productoEncontrado == false) {
            System.out.println("El producto no fue encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Producto> producto = this.buscar(id);
        if (producto.isEmpty()) {
            System.out.println("El cliente no pudo ser borrado");
        } else {
            listaProductos.remove(producto.get());
            System.out.println("Cliente borrado correctamete");
        }

    }

    @Override
    public List<Producto> traerTodos() {
        return listaProductos;
    }
}
