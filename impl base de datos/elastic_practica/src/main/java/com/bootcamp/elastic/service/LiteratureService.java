package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.TitleFilterDTO;
import com.bootcamp.elastic.dto.response.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LiteratureService implements ILiteratureService{
    LiteratureRepository literatureRepository;

    public LiteratureService(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }

    @Override
    public List<LiteratureDTO> findByAuthor(String author) {
        List<Literature> literatureList = literatureRepository.findLiteratureByAuthor(author);

        return customMapper(literatureList);
    }

    @Override
    public List<LiteratureDTO> findByFilter(TitleFilterDTO titleFilterDTO) {
        List<Literature> literatureList = literatureRepository.findAllByTitleContainsIgnoreCase(titleFilterDTO.getText());

        return customMapper(literatureList);
    }

    @Override
    public List<LiteratureDTO> findByPagesGreaterThan(Integer pages) {
        List<Literature> literatureList = literatureRepository.findAllByCantPagesGreaterThan(pages);

        return customMapper(literatureList);
    }

    @Override
    public List<LiteratureDTO> findBeforeDate(LocalDate date) {
        List<Literature> literatureList = literatureRepository.findAllByFirstPostBefore(date);

        return customMapper(literatureList);
    }

    @Override
    public List<LiteratureDTO> findAfterDate(LocalDate date) {
        List<Literature> literatureList = literatureRepository.findAllByFirstPostAfter(date);

        return customMapper(literatureList);
    }

    @Override
    public List<LiteratureDTO> findByEditorial(String editorial) {
        List<Literature> literatureList = literatureRepository.findLiteratureByEditorial(editorial);

        return customMapper(literatureList);
    }

    private List<LiteratureDTO> customMapper(List<Literature> list){
        List<LiteratureDTO> toRet = new ArrayList<>();
        list.forEach(l ->
                toRet.add(new LiteratureDTO(
                        l.getTitle(),
                        l.getAuthor(),
                        l.getCantPages(),
                        l.getEditorial(),
                        l.getFirstPost()
                ))
        );

        return  toRet;
    };
}
