package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.OutOfSpaceException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionTypeE;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService implements ISectionService {

    private SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section getExistingSection(Integer id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new InvalidFieldException("El sector con código " + id + "no existe"));
    }

    @Override
    public void updateSectionSize(Integer id, Integer batchStockSize) {
        Section section = getExistingSection(id);
        section.setCurrent_size(section.getCurrent_size() + batchStockSize);
        sectionRepository.save(section);
    }


    @Override
    public void validateHasSpaceAvailable(Integer currentSize, Integer totalSize, Integer batchStockSize) {
        Integer actualSize = currentSize + batchStockSize;
        if(actualSize > totalSize)
            throw new OutOfSpaceException("El sector no tiene espacio disponible");
    }

    @Override
    public void validateCorrectSectionType(Integer id, List<BatchDTO> batchs) {
        Section section = getExistingSection(id);
        for(BatchDTO batch: batchs) {
            SectionTypeE sectionType = SectionTypeE.getSectionTypeBetween(batch.getMinimum_temperature());

            if(!section.getType().getType().equals(sectionType))
                throw new InvalidFieldException("El sector es de tipo " +  section.getType().getType().toString()
                + ", no puede almacenar al lote Nº " + batch.getBatch_number());
        }
    }

    public Integer validateSectionSize(List<Batch> batchs, Integer sectionCode) {
        Integer amountToAdd = 0;
        Section section = getExistingSection(sectionCode);
        for(Batch batch: batchs){
            if (batch.getSection().getSection_id() != sectionCode) {
                amountToAdd++;
            }
        }
        validateHasSpaceAvailable(section.getCurrent_size(), section.getTotal_size(), amountToAdd);
        return amountToAdd;
    }

    public void updateSectionSizeChanged(List<Batch> batchs, Integer sectionCode) {
        for(Batch batch: batchs) {
            Section section = batch.getSection();
            if (section.getSection_id() != sectionCode) {
                section.setCurrent_size(section.getCurrent_size() - 1);
                sectionRepository.save(section);
            }
        }
    }

}
