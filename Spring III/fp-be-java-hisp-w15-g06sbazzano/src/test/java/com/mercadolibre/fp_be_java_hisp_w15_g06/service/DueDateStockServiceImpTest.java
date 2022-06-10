package com.mercadolibre.fp_be_java_hisp_w15_g06.service;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockListResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IBatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IInboundOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static com.mercadolibre.fp_be_java_hisp_w15_g06.utils.BatchFactory.batchList;
import static com.mercadolibre.fp_be_java_hisp_w15_g06.utils.BatchFactory.getBatchList;

@ExtendWith(MockitoExtension.class)
class DueDateStockServiceImpTest {

    @Mock
    private IBatchRepository repository;

    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @InjectMocks
    private DueDateStockServiceImp service;

    @Test
    @DisplayName("Prueba de la funcion BatchStockDueDate")
    void whenSendDateReturnBatchProductsBetweenDates() throws Exception{
        //Arrange
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(31);

        //ToDO: Consultar que ocurre con el auth en el integration test!

        Mockito.when(repository.findAllByDueDateBetween(today, dueDate)).thenReturn(batchList());
     /*   Mockito.when(inboundOrderRepository.findById(1L)).thenReturn(Optional.of(new InboundOrder(1L, LocalDate.now(),
                null, new Section(1L, Category.FS, null, null, null), null
                )
        ));*/

        //act
        BatchStockListResponseDTO result =  service.BatchStockDueDate(31,"date_asc", Category.FS);

        //assert
        Assertions.assertEquals(getBatchList(), result);

    }

}