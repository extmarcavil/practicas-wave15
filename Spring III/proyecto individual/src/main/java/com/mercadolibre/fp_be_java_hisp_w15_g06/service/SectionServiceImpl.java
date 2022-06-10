package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchSectionResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidSectionException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidSectionbatchException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ISectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    private final ISectionRepository sectionRepository;
    private final BatchRepository batchRepository;

    public SectionServiceImpl(ISectionRepository sectionRepository, BatchRepository batchRepository) {
        this.sectionRepository = sectionRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public ResponseEntity<List<BatchSectionResponseDTO>> getAllBatchBySection(Long idSection) {

        Section section = sectionRepository.findAllById(idSection);
        if (section == null) {
            throw new InvalidSectionException(idSection);
        }
        List<Batch> lstRet= batchRepository.findAllBySection(section);

        if (lstRet.isEmpty()) {
            throw new InvalidSectionbatchException(idSection);
        }

        return new ResponseEntity<>((lstRet.stream()
                .map(BatchSectionResponseDTO::from)
                .collect(Collectors.toList())), HttpStatus.OK);
    }

}
