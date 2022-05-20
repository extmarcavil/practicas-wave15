package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.LiteratureDto;
import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LiteratureServiceImpl implements LiteratureService {
    private final LiteratureRepository repo;
    private final ModelMapper mapper;

    public LiteratureServiceImpl(LiteratureRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<LiteratureDto> findAll() {
        return mapResult(repo.findAll());
    }

    @Override
    public List<LiteratureDto> saveAll(List<LiteratureDto> books) {
        List<Literature> models = books
                .stream()
                .map(ld -> mapper.map(ld, Literature.class))
                .collect(Collectors.toList());

        return StreamSupport
                .stream(this.repo.saveAll(models).spliterator(), false)
                .map(l -> mapper.map(l, LiteratureDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDto> findAllByAuthor(String author) {
        return mapResult(repo.findAllByAuthor(author));
    }

    @Override
    public List<LiteratureDto> findAllByTitleContainsAny(List<String> words) {
        return mapResult(repo.findAllByTitleIn(words));
    }

    @Override
    public List<LiteratureDto> findAllByCantPagesGreaterThan(Integer pages) {
        return mapResult(repo.findAllByCantPagesGreaterThan(pages));
    }

    @Override
    public List<LiteratureDto> findAllByFirstPostBefore(DateDTO dto) {
        return mapResult(repo.findAllByFirstPostBefore(dto.getDate()));
    }

    @Override
    public List<LiteratureDto> findAllByFirstPostAfter(DateDTO dto) {
        return mapResult(repo.findAllByFirstPostAfter(dto.getDate()));
    }

    @Override
    public List<LiteratureDto> findAllByEditorial(String editorial) {
        return mapResult(repo.findAllByEditorial(editorial));
    }

    private List<LiteratureDto> mapResult(List<Literature> lits) {
        return lits
                .stream()
                .map(l -> mapper.map(l, LiteratureDto.class))
                .collect(Collectors.toList());
    }
}
