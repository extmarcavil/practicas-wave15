package com.meli.blog.services;

import com.meli.blog.dto.request.EntradaRequestDTO;
import com.meli.blog.dto.response.EntradaResponseDTO;
import com.meli.blog.dto.response.EntradaResponseFullDTO;
import com.meli.blog.model.EntradaModel;
import com.meli.blog.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    EntradaRepository repository;

    public Number crearEntrada (EntradaRequestDTO datoEntrada) {
        EntradaModel nuevaEntrada = new EntradaModel(nuevoId(), datoEntrada.getTituloEntrada(), datoEntrada.getAutor(), datoEntrada.getFechaPublicacion());
        Number idNuevaEntrada = repository.crearEntrada(nuevaEntrada);
        return idNuevaEntrada;
    }

    public Number nuevoId () {
        return repository.consultaId();
    }

    public List<EntradaRequestDTO> obtenerTodasEntradas () {
        List<EntradaModel> listaDeEntrada = repository.obtenerTodasEntradas();
        List<EntradaRequestDTO> listaDeSalida = new ArrayList<EntradaRequestDTO>();

        for (int i = 0; i<listaDeEntrada.size(); i++) {
            listaDeSalida.add(new EntradaRequestDTO(listaDeEntrada.get(i).getId(), listaDeEntrada.get(i).getTituloEntrada(), listaDeEntrada.get(i).getAutor(), listaDeEntrada.get(i).getFechaPublicacion()));
        }

        return listaDeSalida;

    }

    public EntradaResponseFullDTO obtenerEntradaUnica (int id) {
        EntradaModel entradaFiltrada = repository.obtenerEntradaUnica(id);
        EntradaResponseFullDTO entradaMostrar = new EntradaResponseFullDTO((int)entradaFiltrada.getId(), entradaFiltrada.getTituloEntrada(), entradaFiltrada.getAutor(), entradaFiltrada.getFechaPublicacion());
        return entradaMostrar;
    }

}
