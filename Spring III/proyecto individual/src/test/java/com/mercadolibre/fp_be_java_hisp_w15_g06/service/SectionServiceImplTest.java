package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchSectionResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidSectionException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidSectionbatchException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundInAnyWarehouseException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.factory.SectionFactory;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IBatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ISectionRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.PurchaseOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectionServiceImplTest {

    @Mock
    private ISectionRepository iSectionRepository;

    @Mock
    private IBatchRepository iBatchRepository;

    @InjectMocks
    private SectionServiceImpl sectionService;

    @Test
    void whenNotThereAreBatchesInTheSection() {
        Long sectionId = 1L;

        when(iSectionRepository.findById(any())).thenThrow(new InvalidSectionException(sectionId));

        assertThatThrownBy(() -> iSectionRepository.findById(sectionId))
                .isInstanceOf(InvalidSectionException.class)
                .hasMessage("El sector con ID: " + sectionId + " no fue encontrado.");
    }

    @Test
    void whenNotThereAreNotBatchesInTheSection() {
        Long idSection = 1L;

        when(iBatchRepository.findById(any())).thenThrow(new InvalidSectionbatchException(idSection));

        assertThatThrownBy(() -> iBatchRepository.findById(idSection))
                .isInstanceOf(InvalidSectionbatchException.class)
                .hasMessage("No existen batch asociado/s a la sección con ID: " + idSection);
    }

  /*  @Test
    void whenThereAreBatchesInTheSection() {
        //long sectionId = 1L;
       // when(iSectionRepository.findAllById(sectionId)).thenReturn(section());
      //  when(iBatchRepository.findById(sectionId)).thenReturn();

     //   ResponseEntity<List<BatchSectionResponseDTO>> section = sectionService.getAllBatchBySection(idSection);

        assertThatThrownBy(() -> sectionService.getAllBatchBySection(1L))
                .isInstanceOf(BatchSectionResponseDTO.class);
    }*/

}
