package com.repository;

import java.util.List;
import com.models.Cliente;
import com.models.Cliente;

public interface CRUD<T> {
    T registrarElemento();
    T chequearElemento(List<T> elem);
    T registrarFactura(Cliente elem, List<T> elem1, double total);
    void mostrarPantalla(List<T> list);
    void eliminarElemnto(List<T> list);

}
