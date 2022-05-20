package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteratureServiceImpl implements LiteratureService{
    private final LiteratureRepository literatureRepository;
    private ModelMapper mapper;

    public LiteratureServiceImpl ( LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
        this.mapper = new ModelMapper();
    }
    @Override
    public List<LiteratureDTO> getAll() {
        List<Literature> result = (List<Literature>) literatureRepository.findAll();
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> saveAll(List<LiteratureDTO> respLiteratureDTO) {
        Iterable<Literature> result = this.getLiterature(respLiteratureDTO);
        result = literatureRepository.saveAll(result);
        return this.getLiteratureDTOs((List<Literature>) result);
    }

    @Override
    public void deleteAll() {
        literatureRepository.deleteAll();
    }

    @Override
    public List<LiteratureDTO> findAllByAuthorLike(String author) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByAuthorLike(author);
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> findAllByTitleIn(List<String> words) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByTitleIn(words);
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> findAllByCantPagesGreaterThan(Integer cantPages) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByCantPagesGreaterThan(cantPages);
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> findAllByFirstPostBefore(DateDTO date) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByFirstPostBefore(date.getDate());
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> findAllByFirstPostAfter(DateDTO date) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByFirstPostAfter(date.getDate());
        return this.getLiteratureDTOs(result);
    }

    @Override
    public List<LiteratureDTO> findAllByEditorialLike(String editorial) {
        List<Literature> result = (List<Literature>) literatureRepository.findAllByEditorialLike(editorial);
        return this.getLiteratureDTOs(result);
    }

    private List<LiteratureDTO> getLiteratureDTOs(List<Literature> literatureList) {
        List<LiteratureDTO> literatureDTOList = literatureList
                .stream()
                .map(literature -> mapper.map(literature, LiteratureDTO.class))
                .collect(Collectors.toList());
        return literatureDTOList;
    }

    private List<Literature> getLiterature(List<LiteratureDTO> literatureDTOList) {
        List<Literature> literatureList = literatureDTOList
                .stream()
                .map(literature -> mapper.map(literature, Literature.class))
                .collect(Collectors.toList());
        return literatureList;
    }
}
