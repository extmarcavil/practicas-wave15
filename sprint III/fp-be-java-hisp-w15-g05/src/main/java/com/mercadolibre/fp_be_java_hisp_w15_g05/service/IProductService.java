package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;

import java.util.List;

public interface IProductService {
    /**
     *
     * @param category (no requerida) recupera la lista de productos
     * @return lista de productos
     */
    List<ProductDTO> getListProducts(Integer category,String token);

    BatchStockDTO getListOfProductInBatch(Integer idProduct, String order, String token);

    /**
     *
     * @param id id del producto a buscar
     * @return un producto o lanza excepcion 404
     */
    Product findById(Integer id);
}
