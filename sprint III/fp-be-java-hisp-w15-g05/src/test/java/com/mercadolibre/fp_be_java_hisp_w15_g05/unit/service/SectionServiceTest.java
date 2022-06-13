package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.OutOfSpaceException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.SectionRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.SectionService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.BatchFactory;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.SectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectionServiceTest {

    @Mock
    SectionRepository sectionRepository;

    @InjectMocks
    SectionService sectionService;

    @Test
    @DisplayName("Obtener una sección existente correctamente")
    void getExistingSection() {
        Section section = SectionFactory.getSectionWithId1();

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));

        Section response = sectionService.getExistingSection(1);

        Assertions.assertEquals(section, response);
    }

    @Test
    @DisplayName("Obtención de una seccion que no existe")
    void getMissingSection() {
        when(sectionRepository.findById(100)).thenReturn(Optional.empty());

        Assertions.assertThrows(
                InvalidFieldException.class,
                () -> sectionService.getExistingSection(100));
    }

    @Test
    @DisplayName("Actualizar el tamaño actual de una seccion")
    void updateSectionSize() {
        Section section = SectionFactory.getSectionWithId1();

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));
        when(sectionRepository.save(section)).thenReturn(section);

        sectionService.updateSectionSize(1, 1);

        Mockito.verify(sectionRepository,Mockito
                        .times(1))
                .save(section);
    }

    @Test
    @DisplayName("Validar que una seccion tenga espacio disponible")
    void validateHasSpaceAvailable() {
        Assertions.assertThrows(
                OutOfSpaceException.class,
                () -> sectionService.validateHasSpaceAvailable(1, 1, 1));
    }

    @Test
    void validateCorrectSectionType() {
        Section section = SectionFactory.getSectionWithId1();
        List<BatchDTO> batchs = BatchFactory.getbatchDTOList();

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));

        sectionService.validateCorrectSectionType(1, batchs);
    }

    @Test
    void validateIncorrectSectionType() {
        Section section = SectionFactory.getSectionWithId2();
        List<BatchDTO> batchs = BatchFactory.getbatchDTOList();

        when(sectionRepository.findById(2)).thenReturn(Optional.of(section));

        Assertions.assertThrows(
                InvalidFieldException.class,
                () -> sectionService.validateCorrectSectionType(2, batchs));
    }

    @Test
    void validateSectionSize() {
        Section section = SectionFactory.getSectionWithId1();
        List<Batch> batchs = BatchFactory.getbatchList();

        when(sectionRepository.findById(1)).thenReturn(Optional.of(section));

        Integer response = sectionService.validateSectionSize(batchs, 1);

        Assertions.assertEquals(1, response);
    }


    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void updateSectionSizeChanged() {
        List<Batch> batchs = BatchFactory.getbatchList();
        Section section = new Section();
        section.setCurrent_size(9);
        section.setSection_id(2);

        when(sectionRepository.save(section)).thenReturn(section);

        sectionService.updateSectionSizeChanged(batchs, 1);

        verify(sectionRepository,Mockito
                        .times(1))
                .save(section);
    }

}
