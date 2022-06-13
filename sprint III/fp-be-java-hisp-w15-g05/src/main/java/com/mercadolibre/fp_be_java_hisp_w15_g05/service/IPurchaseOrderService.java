package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductWQuantityDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SavePurchaseOrderDTO;

import java.util.List;

public interface IPurchaseOrderService {
    SavePurchaseOrderDTO saveOrder(ReqSavePurchaseOrderDTO order, String token);
    List<ProductWQuantityDTO> getListProducts(Integer idOrder, String token);
    SavePurchaseOrderDTO modifyOrder(Integer idOrder, ReqSavePurchaseOrderDTO order, String token);

}
