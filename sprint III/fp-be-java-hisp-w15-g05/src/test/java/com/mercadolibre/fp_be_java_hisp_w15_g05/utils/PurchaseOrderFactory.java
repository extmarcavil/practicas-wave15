package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.OrderStatusDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ProductSaveOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.PurchaseOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.PurchaseOrderProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseOrderFactory {
    private static Product leche = new Product();
    private static Product manteca = new Product();
    private static PurchaseOrder purchaseOrder = new PurchaseOrder(4, LocalDate.of(2022,4,1),"carrito",1,new ArrayList<>());
    private static PurchaseOrderProduct pop1 = new PurchaseOrderProduct();
    private static PurchaseOrderProduct pop2 = new PurchaseOrderProduct();

    private static final ReqSavePurchaseOrderDTO savePurchaseOrder = new ReqSavePurchaseOrderDTO(1,LocalDate.now(),new OrderStatusDTO("carrito"),new ArrayList<>());
    private static final SavePurchaseOrderDTO savePOdto = new SavePurchaseOrderDTO(150);

    public static PurchaseOrder getPurchaseOrder(){
        chargeData();
        return purchaseOrder;
    }

    public static PurchaseOrder purchaseOrderSave(){
        return new PurchaseOrder(
                null,
                LocalDate.now(),
                "carrito",
                1,
                null
        );
    }

    public static List<PurchaseOrderProduct> getListPurchaseOrderProduct(){
        chargeData();

        return Arrays.asList(pop1,pop2);
    }

    private static void chargeData(){
        leche.setProduct_id(1);
        leche.setName("leche");
        leche.setPrice(150);
        leche.setPurchaseOrderProductByNumber(new ArrayList<>());

        manteca.setProduct_id(2);
        manteca.setName("manteca");
        manteca.setPrice(100);
        manteca.setPurchaseOrderProductByNumber(new ArrayList<>());

        pop1.setPurchaseOrderProdNumber(11);
        pop1.setPurchaseOrderById(purchaseOrder);
        pop1.setProductById(leche);
        pop1.setProductQuantity(3);

        pop2.setPurchaseOrderProdNumber(10);
        pop2.setPurchaseOrderById(purchaseOrder);
        pop2.setProductById(manteca);
        pop2.setProductQuantity(1);
    }

    public static ReqSavePurchaseOrderDTO getsavePurchaseOrder(){
        List<ProductSaveOrderDTO> productSaveOrderDTOS = new ArrayList<>();
        ProductSaveOrderDTO a = new ProductSaveOrderDTO(1,1);
        productSaveOrderDTOS.add(a);

        savePurchaseOrder.setProducts(productSaveOrderDTOS);
        return savePurchaseOrder;
    }

    public static ReqSavePurchaseOrderDTO getsavePurchaseOrderIntegration(){
        List<ProductSaveOrderDTO> productSaveOrderDTOS = new ArrayList<>();
        ProductSaveOrderDTO a = new ProductSaveOrderDTO(1,1);
        productSaveOrderDTOS.add(a);

        savePurchaseOrder.setProducts(productSaveOrderDTOS);
        return savePurchaseOrder;
    }

    public static ReqSavePurchaseOrderDTO getsavePurchaseOrderInvalidProduct(){
        List<ProductSaveOrderDTO> productSaveOrderDTOS = new ArrayList<>();
        ProductSaveOrderDTO a = new ProductSaveOrderDTO(100000,1);
        productSaveOrderDTOS.add(a);

        savePurchaseOrder.setProducts(productSaveOrderDTOS);
        return savePurchaseOrder;
    }

    public static SavePurchaseOrderDTO getSavePOdto() {
        return savePOdto;
    }

}
