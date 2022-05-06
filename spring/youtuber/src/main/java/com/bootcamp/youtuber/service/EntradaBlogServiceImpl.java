package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;
import com.bootcamp.youtuber.exception.BlogNotFoundException;
import com.bootcamp.youtuber.exception.RepeatedElementException;
import com.bootcamp.youtuber.mapper.EntradaBlogMapper;
import com.bootcamp.youtuber.repository.IEntradaBlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService {

    /**
     * Injection By Constructor
     */
    private IEntradaBlogRepository entradaBlogRepository;
    private EntradaBlogMapper mapper;

    public EntradaBlogServiceImpl(IEntradaBlogRepository entradaBlogRepository, EntradaBlogMapper mapper) {
        this.entradaBlogRepository = entradaBlogRepository;
        this.mapper = mapper;
    }

    /**
     * Metodos Service
     *
     * @param entradaDto
     * @return
     */

    @Override
    public EntradaBlog guardar(EntradaBlogDto entradaDto) {
        EntradaBlog entradaEntity = mapper.mapToEntity(entradaDto);
        EntradaBlog etB = null;

        if (entradaBlogRepository.lista().contains(entradaEntity.getId())) {
            String msj = String.format("Blog con ID: %d repetido", entradaEntity.getId());
            throw new RepeatedElementException(msj);
        } else {
            etB = entradaBlogRepository.guardar(entradaEntity);
        }
        /*entradaBlogRepository.lista().stream()
                .map(blog -> {
                    if (blog.getId()entradaEntity.getId()) {
                        String msj = String.format("Blog con ID: %d repetido", entradaEntity.getId());
                        throw new RepeatedElementException(msj);
                    }
                    return true;
                });*/
        return etB;
    }

    @Override
    public List<EntradaBlog> listar() {
        List<EntradaBlog> list = entradaBlogRepository.lista();
        log.info("lista de la base de datos: " + list);

        return list;
    }

    @Override
    public EntradaBlog visualizar(Integer id) {
        return entradaBlogRepository.lista().stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BlogNotFoundException(String.format("Blog con Id: %d NO encontrado", id)));
    }
}
