package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.SuccessfulOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.ProductWarehouseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.WarehouseQuatityResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundInAnyWarehouseException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Warehouse;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IBatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IInboundOrderRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IWarehouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WarehouseServiceImpl implements IWarehouseService{

    private final IWarehouseRepository warehouseRepository;
    private final IProductRepository productRepository;
    private final IInboundOrderRepository inboundOrderRepository;
    private final IBatchRepository batchRepository;

    public WarehouseServiceImpl(IWarehouseRepository warehouseRepository, IProductRepository productRepository, IInboundOrderRepository inboundOrderRepository, IBatchRepository batchRepository) {
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
        this.inboundOrderRepository = inboundOrderRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public ResponseEntity<ProductWarehouseDTO> findAllProductsInWarehouse(Long productId, String username) {

        Product product = productRepository.findById(productId)
                                            .orElseThrow(()-> new ProductNotFoundException(productId));

        List<Batch> batchList = batchRepository.findByProduct(product)
                                .orElseThrow(() -> new ProductNotFoundInAnyWarehouseException(productId));


        ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO();
        productWarehouseDTO.setProduct_id(productId);

        List<WarehouseQuatityResponseDTO> warehouseQuatityResponseDTOList = new ArrayList<>();
        HashMap<Long,Integer> quatityPerWarehouse = new HashMap<>();
        Long idWarehouse;
        for(Batch b: batchList) {
            idWarehouse = b.getInboundOrder().getWarehouse().getId();
            if (quatityPerWarehouse.containsKey(idWarehouse))
                quatityPerWarehouse.put(idWarehouse, quatityPerWarehouse.get(idWarehouse) + b.getCurrentQuantity());
            else
                quatityPerWarehouse.put(idWarehouse, b.getCurrentQuantity());
        }

        quatityPerWarehouse.forEach((k,v) ->
            {
                WarehouseQuatityResponseDTO warehouseQuatityResponseDTO = new WarehouseQuatityResponseDTO();
                warehouseQuatityResponseDTO.setWarehouse_code(k);
                warehouseQuatityResponseDTO.setTotal_quantity(v);
                warehouseQuatityResponseDTOList.add(warehouseQuatityResponseDTO);
            }
        );

        if(quatityPerWarehouse.isEmpty())
            throw new ProductNotFoundInAnyWarehouseException(productId);

        productWarehouseDTO.setWarehouses(warehouseQuatityResponseDTOList);
        return new ResponseEntity<>(productWarehouseDTO, HttpStatus.OK);
    }
}
