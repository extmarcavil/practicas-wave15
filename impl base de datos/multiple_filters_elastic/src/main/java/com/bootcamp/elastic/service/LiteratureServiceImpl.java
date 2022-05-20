package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteratureServiceImpl implements LiteratureService {
    private final LiteratureRepository literatureRepository;
    private final ModelMapper modelMapper;

    public LiteratureServiceImpl(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<LiteratureDTO> getAll(String author, String title, Integer minPages, Integer minYear, Integer maxYear, String byPublisher) {
        LocalDate minYearDate = null, maxYearDate = null;

        if(minYear != null)
            minYearDate = LocalDate.of(minYear, 1, 1);

        if(maxYear != null)
            maxYearDate = LocalDate.of(maxYear, 1, 1);

        List<Literature> books = literatureRepository.findAllLiteratureWithFilters(author, title, minPages, minYearDate, maxYearDate, byPublisher);

        return books.stream()
                .map(b -> modelMapper.map(b, LiteratureDTO.class))
                .collect(Collectors.toList()
                );
    }

    @Override
    public boolean saveAll(List<LiteratureDTO> books) {
        literatureRepository.saveAll(books
                .stream()
                .map(b -> modelMapper.map(b, Literature.class))
                .collect(Collectors.toList())
        );

        return true;
    }

    @Override
    public boolean deleteAll() {
        literatureRepository.deleteAll();

        return true;
    }
}
