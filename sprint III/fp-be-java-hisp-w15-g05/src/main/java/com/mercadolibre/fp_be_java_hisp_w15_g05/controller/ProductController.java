package com.mercadolibre.fp_be_java_hisp_w15_g05.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<BatchStockDTO> getProductListInBach(@RequestHeader("Authorization") String token,@PathVariable Integer idProduct, @RequestParam(required = false) String order){
        return new ResponseEntity<>(productService.getListOfProductInBatch( idProduct, order, token), HttpStatus.OK);
    }
    /**
     *
     * @param category not requerido
     * @return lista de productos y status code
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getListProducts(@RequestHeader("Authorization") String token, @RequestParam(required = false) Integer category){
        return new ResponseEntity<>(productService.getListProducts(category,token), HttpStatus.OK);
    }
}
