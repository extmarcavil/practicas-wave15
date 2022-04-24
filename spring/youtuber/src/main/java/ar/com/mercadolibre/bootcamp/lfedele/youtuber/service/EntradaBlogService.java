package ar.com.mercadolibre.bootcamp.lfedele.youtuber.service;

import ar.com.mercadolibre.bootcamp.lfedele.youtuber.dto.EntradaBlogDto;

import java.util.List;
import java.util.Optional;

public interface EntradaBlogService {
    Long save(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto findById(Long id);
    List<EntradaBlogDto> findAll();
}
