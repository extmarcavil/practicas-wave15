package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDto;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LiteratureService {

    private final LiteratureRepository repository;

    private Literature toLiterature(LiteratureDto literatureDto){
        return Literature.builder()
                .title(literatureDto.getTitle())
                .author(literatureDto.getAuthor())
                .cantPages(literatureDto.getCantPages())
                .editorial(literatureDto.getEditorial())
                .firstPost(literatureDto.getFirstPost())
                .build();
    }

    private LiteratureDto literatureDto(Literature literature){
        return LiteratureDto.builder()
                .title(literature.getTitle())
                .author(literature.getAuthor())
                .cantPages(literature.getCantPages())
                .editorial(literature.getEditorial())
                .firstPost(literature.getFirstPost())
                .build();
    }

    public List<LiteratureDto> getAll(){
        return repository.findAll()
                .stream().map(
                        literature -> literatureDto(literature)
                )
                .collect(Collectors.toList());
    }

    public void saveAll(List<LiteratureDto> list){
        repository.saveAll(
                list.stream()
                        .map(literatureDto -> toLiterature(literatureDto))
                        .collect(Collectors.toList())
        );
    }

    public List<LiteratureDto> getByAuthor(String author){
        return repository.findByAuthorLike(author)
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }

    public List<LiteratureDto> getByContainsWords(List<String> words){
        return repository.findByTitleIsIn(words)
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }

    public List<LiteratureDto> getByCantPagGreaterThan(Integer cant){
        return repository.findByCantPagesGreaterThan(cant)
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }

    public List<LiteratureDto> getByDateBefore(DateDTO dateDTO){
        return repository.findByFirstPostBefore(dateDTO.getDate())
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }

    public List<LiteratureDto> getByDateAfter(DateDTO dateDTO){
        return repository.findByFirstPostAfter(dateDTO.getDate())
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }

    public List<LiteratureDto> getByEditorial(String editorial){
        return repository.findByEditorial(editorial)
                .stream()
                .map(this::literatureDto)
                .collect(Collectors.toList());
    }


}
