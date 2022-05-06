package com.bootcamp.youtuber.mapper;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class EntradaBlogMapper {

    @Autowired
    private ModelMapper mapper;

    /**
     * Dot ->  mapToEntity
     */
    public EntradaBlog mapToEntity(EntradaBlogDto entradaDto) {
        log.info("*** EntradaDto Entity {}", entradaDto);
        EntradaBlog entradaEntity = mapper.map(entradaDto, EntradaBlog.class);
        entradaEntity.setFechaPublicacion(LocalDate.now());
        log.info("*** EntradaEntity Dto {}", entradaEntity);

        return entradaEntity;
    }


}
