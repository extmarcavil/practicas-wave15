package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockListResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;

public interface IDueDateStockService {

    BatchStockListResponseDTO BatchStockDueDate(int cantDays, String order, Category category );
}
