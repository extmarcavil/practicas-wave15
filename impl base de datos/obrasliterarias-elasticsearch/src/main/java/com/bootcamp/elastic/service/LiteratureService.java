package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteratureService implements ILiteratureService{
    private final LiteratureRepository literatureRepository;
    private final ModelMapper modelMapper;

    public LiteratureService(LiteratureRepository literatureRepository, ModelMapper modelMapper) {
        this.literatureRepository = literatureRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LiteratureDTO> saveAll(List<LiteratureDTO> literatureList) {
        List<Literature> literatureToSave = literatureList.stream().map(l->modelMapper.map(l, Literature.class)).collect(Collectors.toList());
        Iterable<Literature> saved = literatureRepository.saveAll(literatureToSave);
        List<LiteratureDTO> response = new ArrayList<>();
        saved.forEach(l-> {
            response.add(modelMapper.map(l, LiteratureDTO.class));
        });
        return response;
    }

    @Override
    public void deleteAll() {
        literatureRepository.deleteAll();
    }

    @Override
    public List<LiteratureDTO> findAll() {
        List<LiteratureDTO> response = new ArrayList<>();
        literatureRepository.findAll().forEach(l-> {
            response.add(modelMapper.map(l, LiteratureDTO.class));
        });
        return response;
    }

    @Override
    public List<LiteratureDTO> findAllByAuthor(String author) {
        return literatureRepository.findAllByAuthor(author)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> findAllByTitleIn(List<String> words) {
        return literatureRepository.findAllByTitleIn(words)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> findAllByCantPagesGreaterThan(Integer amount) {
        return literatureRepository.findAllByCantPagesGreaterThan(amount)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> findAllByFirstPostBefore(LocalDate date) {
        return literatureRepository.findAllByFirstPostBefore(date)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> findAllByFirstPostAfter(LocalDate date) {
        return literatureRepository.findAllByFirstPostAfter(date)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> findAllByEditorial(String editorial) {
        return literatureRepository.findAllByEditorial(editorial)
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }
}
