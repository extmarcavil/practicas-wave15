package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockListResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.IDueDateStockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
public class DueDateStockController {


    private final IDueDateStockService service;

    public DueDateStockController(IDueDateStockService service){
        this.service = service;
    }


    /**
     * Enviar cantidad de dias de interes a chequear el producto
     * @param  cantDays
     * @response BatchStockResponseDTO
     * */
    @GetMapping(path = "fresh-products/batch/list/due-date/{cantDays}")
    public BatchStockListResponseDTO dueDateStockProducts(@RequestHeader(value="Authorization") String token,
                                                          @PathVariable int cantDays,
                                                          @RequestParam(required = false) Category category,
                                                          @RequestParam(defaultValue = "date_asc", required= false) String order){
        return service.BatchStockDueDate(cantDays, order, category);

    }





}
