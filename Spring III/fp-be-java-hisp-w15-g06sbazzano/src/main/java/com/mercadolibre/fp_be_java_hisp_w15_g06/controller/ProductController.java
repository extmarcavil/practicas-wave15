package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.PurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.RequestProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.SuccessfulOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.ProductWarehouseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.IWarehouseService;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.PurchaseService;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession.IServiceSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    private final PurchaseService purchaseService;
    private final IServiceSession iServiceSession;
    private final IWarehouseService warehouseService;

    @Autowired
    public ProductController(PurchaseService purchaseService, IServiceSession iServiceSession, IWarehouseService warehouseService) {
        this.purchaseService = purchaseService;
        this.iServiceSession = iServiceSession;
        this.warehouseService = warehouseService;
    }

   @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> findProduct(@RequestHeader(value= "Authorization") String authorization){
        String username = iServiceSession.getUsername(authorization);
        return purchaseService.findProducts();
    }

    @RequestMapping(value = "list", params = "category", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> findProductsByCategory(@RequestHeader(value= "Authorization") String authorization,
                                                                   @RequestParam (required=true) Category category){
        String username = iServiceSession.getUsername(authorization);
        return purchaseService.findProductsByCategory(category);
    }

    @PostMapping("orders")
    public ResponseEntity<SuccessfulOrderDTO> createOrder(@RequestHeader(value= "Authorization") String authorization,
                                                          @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        String username = iServiceSession.getUsername(authorization);
        return purchaseService.createOrder(purchaseOrderDTO);
    }

    @GetMapping("orders/{idOrder}")
    public ResponseEntity<List<ProductDTO>> findProductsByOrder(@RequestHeader(value= "Authorization") String authorization,
                                                                   @PathVariable Long idOrder){
        return purchaseService.findProductsByOrder(idOrder);
    }

    @GetMapping("{idProduct}/warehouse/list")
    public ResponseEntity<ProductWarehouseDTO> findAllProductsInWarehouse(@RequestHeader(value= "Authorization") String authorization,
                                                                          @PathVariable Long idProduct){
        String username = iServiceSession.getUsername(authorization);
        return warehouseService.findAllProductsInWarehouse(idProduct,username);
    }

    @PutMapping("orders/{idOrder}")
    public ResponseEntity<PurchaseOrderDTO> updateOrder(@PathVariable Long idOrder,
                                                        @RequestBody PurchaseOrderDTO purchaseOrderDto){
        PurchaseOrderDTO purchaseOrderDTO = purchaseService.modifyOrder(idOrder, purchaseOrderDto);

        return ResponseEntity.ok(purchaseOrderDTO);
    }


}
