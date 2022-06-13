package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductWQuantityDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.OrderNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IProductService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.PurchaseOrderService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.SessionServiceImpl;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.BatchFactory;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.ProductFactory;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.PurchaseOrderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {

    @Mock
    IPurchaseOrderRepository poRepo;

    @Mock
    IProductService productService;

    @Mock
    IBatchRepository batchRepository;

    @Mock
    IPurchaseOrderProductRepository purchaseOrderProductRepository;
    @Mock
    private SessionServiceImpl sessionService;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    PurchaseOrderService poService;

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verifyGetListProducts() {

        List<ProductWQuantityDTO> list = ProductFactory.getProdWQuantityList();
        PurchaseOrder po = PurchaseOrderFactory.getPurchaseOrder();
        List<PurchaseOrderProduct> listadoPo = PurchaseOrderFactory.getListPurchaseOrderProduct();

        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Mockito.when(poRepo.findById(4)).thenReturn(Optional.of(po));
        Mockito.when(poRepo.getListProducts(4)).thenReturn(listadoPo);
        List<ProductWQuantityDTO> result = poService.getListProducts(4,"Bearer ");

        Assertions.assertEquals(result,list);

    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verifyOrderNotFoundException() {
        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Assertions.assertThrows(OrderNotFoundException.class,
                ()->poService.getListProducts(1000000,"Bearer "));
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verifySaveOrder(){
        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        //arrange
        ReqSavePurchaseOrderDTO req = PurchaseOrderFactory.getsavePurchaseOrder();
        PurchaseOrder po = PurchaseOrderFactory.purchaseOrderSave();
        PurchaseOrder poWithOutId = po;
        poWithOutId.setOrder_id(null);

        Product p = ProductFactory.getProducto();
        List<Batch> batchList = BatchFactory.batchListSavePurchase();
        //no lo saco a factory todavia, se lo necesito en otro lado entonces si
        PurchaseOrderProduct pop = new PurchaseOrderProduct();

        SavePurchaseOrderDTO expected = PurchaseOrderFactory.getSavePOdto();

        //mock
        Mockito.when(productService.findById(1)).thenReturn(p);

        Mockito.when(poRepo.save(poWithOutId)).thenReturn(po);

        Mockito.when(batchRepository.findAllByProductId(1)).thenReturn(batchList);
        Mockito.when(purchaseOrderProductRepository.save(pop)).thenReturn(null);

        //act
        SavePurchaseOrderDTO result = poService.saveOrder(req,"Bearer ");

        //arrange
        Assertions.assertEquals(expected,result);
    }
}
