package com.meli.blog.repository;

import com.meli.blog.model.EntradaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EntradaRepository {

    private List<EntradaModel> listaDeEntrada = new ArrayList<EntradaModel>();

    public Number crearEntrada(EntradaModel datoEntrada) {
        listaDeEntrada.add(datoEntrada);
        return listaDeEntrada.get(listaDeEntrada.size()-1).getId();
    }

    public Number consultaId() {
        if (listaDeEntrada.size() == 0) {
            return 1;
        } else {
            return (listaDeEntrada.get(listaDeEntrada.size()-1).getId().intValue() + 1);
        }
    }

    public List<EntradaModel> obtenerTodasEntradas () {
        return listaDeEntrada;
    }

    public EntradaModel obtenerEntradaUnica (int id) {
        EntradaModel entradaUnica = listaDeEntrada.get(id-1);
        return entradaUnica;
    }
}
