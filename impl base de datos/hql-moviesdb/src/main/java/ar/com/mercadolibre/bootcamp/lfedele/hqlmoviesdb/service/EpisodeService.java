package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.EpisodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EpisodeService {

    List<EpisodeDto> findAllWithActor(String firstName, String lastName);

}
