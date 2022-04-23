package com.pacticaintegradora.blog.service;

import com.pacticaintegradora.blog.exception.EntradaExistenteException;
import com.pacticaintegradora.blog.exception.EntradaNoEncontradaException;
import com.pacticaintegradora.blog.model.EntradaBlog;
import com.pacticaintegradora.blog.repository.IEntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService implements IEntradaService {

    private IEntradaRepository entradaRepository;

    public EntradaService(IEntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    @Override
    public Long nuevaEntrada(EntradaBlog entradaBlog) {
        if (entradaRepository.existeEntrada(entradaBlog)){
            throw new EntradaExistenteException("Entrada existente, no se puede crear nuevamente");
        }
        return entradaRepository.nuevaEntrada(entradaBlog);
    }

    @Override
    public List<EntradaBlog> entradasCreadas() {
        return entradaRepository.entradasCreadas();
    }

    @Override
    public EntradaBlog buscarEntrada(Long id) {
        EntradaBlog entradaBlog = entradaRepository.buscarEntrada(id);
        if (entradaBlog == null)
            throw new EntradaNoEncontradaException("El id " + id + " no corresponde con a ninguna entrada de blog");
        return entradaBlog;
    }
}
