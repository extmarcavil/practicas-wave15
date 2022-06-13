package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ProductSaveOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductWQuantityDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.OrderNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.ProductOutOfStockException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.IBatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.IPurchaseOrderProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.IPurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.fp_be_java_hisp_w15_g05.service.ProductService.validateUserBuyerRol;

@Service
public class PurchaseOrderService implements IPurchaseOrderService{

    private final IPurchaseOrderRepository poRepository;
    private IProductService productService;
    private IBatchRepository batchRepository;
    private IPurchaseOrderProductRepository purchaseOrderProductRepository;
    private SessionServiceImpl sessionService;


    public PurchaseOrderService(IPurchaseOrderRepository poRepository, IProductService productService, IBatchRepository batchRepository, IPurchaseOrderProductRepository purchaseOrderProductRepository, SessionServiceImpl sessionService) {
        this.poRepository = poRepository;
        this.productService = productService;
        this.batchRepository = batchRepository;
        this.purchaseOrderProductRepository = purchaseOrderProductRepository;
        this.sessionService = sessionService;
    }

    @Override
    public SavePurchaseOrderDTO saveOrder(ReqSavePurchaseOrderDTO order, String token) {
        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);

        validateUserBuyerRol(user);

        double totalPrice = 0;

        for (ProductSaveOrderDTO product : order.getProducts()){
            //producto existe
            Product p =  productService.findById(product.getProduct_id());

            //producto tiene stock disponible
            List<Batch> batchList = productWithBatchRegistered(product.getProduct_id());

            //checkear producto correcto y sumar precio
            totalPrice += checkProductAndSumTotalPrice(batchList,product.getQuantity(),p.getPrice(), product.getProduct_id());
        }

        //primero crear la purchase order
        PurchaseOrder toSave = new PurchaseOrder(null,order.getDate(),order.getOrder_status().getStatus_code(),order.getBuyer_id(),null);
        PurchaseOrder saved = poRepository.save(toSave);

        //luego crear la vinculacion en la tabla intermedia
        for (ProductSaveOrderDTO productDto : order.getProducts()){

            Product aux = new Product();
            aux.setProduct_id(productDto.getProduct_id());

            PurchaseOrderProduct pop = new PurchaseOrderProduct();

            pop.setPurchaseOrderById(saved);
            pop.setProductById(aux);
            pop.setProductQuantity(productDto.getQuantity());

            //guardo por cada producto
            purchaseOrderProductRepository.save(pop);
        }

        return new SavePurchaseOrderDTO(totalPrice);
    }

    @Override
    public List<ProductWQuantityDTO> getListProducts(Integer idOrder, String token) {
        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);

        validateUserBuyerRol(user);

        PurchaseOrder po = poRepository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException("No existe la orden con numero: " + idOrder + "."));

        List<PurchaseOrderProduct> productList = poRepository.getListProducts(po.getOrder_id());

        return mapProdWQuantity(productList);
    }

    @Override
    public SavePurchaseOrderDTO modifyOrder(Integer idOrder, ReqSavePurchaseOrderDTO order, String token) {
        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);

        validateUserBuyerRol(user);

        double totalPrice = 0;

        for (ProductSaveOrderDTO product : order.getProducts()){
            //producto existe
            Product p =  productService.findById(product.getProduct_id());

            //producto tiene stock disponible
            List<Batch> batchList = productWithBatchRegistered(product.getProduct_id());

            //checkear producto correcto y sumar precio
            totalPrice += checkProductAndSumTotalPrice(batchList,product.getQuantity(),p.getPrice(), product.getProduct_id());
        }

        //primero modificar la purchase order
        PurchaseOrder saved =
                poRepository.save(new PurchaseOrder(
                        idOrder,
                        order.getDate(),
                        order.getOrder_status().getStatus_code(),
                        order.getBuyer_id(),
                        null
                ));

        // obtener la lista de la tabla intermedia
        List<PurchaseOrderProduct> popList = purchaseOrderProductRepository.findAllByPurchaseOrderId(idOrder);
        List<PurchaseOrderProduct> toDelete = new ArrayList<>();

        //eliminar los productos que ya no pertenecen al carrito
        for (PurchaseOrderProduct pop : popList){
            boolean isInList = false;

            for (ProductSaveOrderDTO productDto : order.getProducts()){
                if(productDto.getProduct_id() == pop.getProductById().getProduct_id()){
                    isInList = true;
                    break;
                }
            }

            if (isInList) continue;
            toDelete.add(pop);
        }

        if (toDelete.size()>0) purchaseOrderProductRepository.deleteAll(toDelete);

        List<PurchaseOrderProduct> toModify = new ArrayList<>();

        //luego crear o modificar la vinculacion en la tabla intermedia
        for (ProductSaveOrderDTO productDto : order.getProducts()){
            Product auxProd = productService.findById(productDto.getProduct_id());

            PurchaseOrderProduct pop = new PurchaseOrderProduct();

            pop.setPurchaseOrderById(saved);
            pop.setProductById(auxProd);
            pop.setProductQuantity(productDto.getQuantity());

            // buscar en la lista si ya existia
            PurchaseOrderProduct existPop = popList
                    .stream()
                    .filter(auxPop-> auxPop.getProductById().getProduct_id() == productDto.getProduct_id())
                    .findFirst().orElse(null);
            if (existPop != null) pop.setPurchaseOrderProdNumber(existPop.getPurchaseOrderProdNumber());

            //guardo por cada producto
            toModify.add(pop);
        }

        if (toModify.size()>0)purchaseOrderProductRepository.saveAll(toModify);

        return new SavePurchaseOrderDTO(totalPrice);
    }


    /**
     *
     * @param list lista de purchase order product a mapear
     * @return lista de dto mapeada
     */
    private List<ProductWQuantityDTO> mapProdWQuantity(List<PurchaseOrderProduct> list){
        List<ProductWQuantityDTO> result = new ArrayList<>();

        for(PurchaseOrderProduct purchaseOrderProduct : list){
            result.add(new ProductWQuantityDTO(purchaseOrderProduct.getProductById().getName(),purchaseOrderProduct.getProductQuantity()));
        }

        return  result;
    }

    /**
     *
     * @param id del producto
     * @return lista de lotes en los que se encuentre dicho producto o retorna una excepcion
     */
    private List<Batch> productWithBatchRegistered(Integer id){
        List<Batch> batchList = batchRepository.findAllByProductId(id);

        if(batchList.size() == 0) throw new ProductOutOfStockException("producto " + id + " sin lote registrado.");

        return batchList;
    }

    /**
     *
     * @param batchList lista de lotes
     * @param productQuantity cantidad del producto
     * @param productPrice precio del producto
     * @param productId id del producto
     * @return la suma de precios del producto segun el quantity
     */
    private double checkProductAndSumTotalPrice(List<Batch> batchList, Integer productQuantity, double productPrice, Integer productId){
        double totalPrice = 0;
        //recorro cada lote para ver si tiene stock disponible
        boolean haveStock = false;

        for (Batch batch: batchList){
            if(batch.getCurrent_quantity()>= productQuantity) {
                //si se vence en los proximos 3 dias no cuenta
                if(batch.getDue_date().isBefore(LocalDate.now().plusDays(3))) continue;
                haveStock = true;
                totalPrice += productPrice * productQuantity;
                break;
            }
        }

        if (!haveStock) throw new ProductOutOfStockException("producto " + productId + " sin stock.");

        return  totalPrice;
    }
}
