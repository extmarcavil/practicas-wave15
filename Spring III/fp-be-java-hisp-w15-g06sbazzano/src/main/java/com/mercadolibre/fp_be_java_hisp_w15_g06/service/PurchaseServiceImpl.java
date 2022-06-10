package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.PurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.RequestProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.SuccessfulOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductsNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.ProductCart;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.PurchaseOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ProductRepository productRepository;
    private final BatchRepository batchRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseOrderRepository purchaseOrderRepository,
                               ProductRepository productRepository,
                               BatchRepository batchRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findProducts() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            throw new ProductsNotFoundException();
        }

        return new ResponseEntity<>(products.stream()
                .map(ProductDTO::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findProductsByCategory(Category category) {
        List<Product> products =  productRepository.findAllByCategory(category);

        if (products.isEmpty()) {
            throw new ProductsNotFoundException();
        }

        return new ResponseEntity<>(products.stream()
                .map(ProductDTO::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SuccessfulOrderDTO> createOrder(PurchaseOrderDTO purchaseOrderDto) {
        List<Long> productsIds = getProductsIds(purchaseOrderDto);
        Map<Long, Integer> quantities = getQuantities(purchaseOrderDto.getProducts());

        List<Product> products = productRepository.findAllById(productsIds);
        List<Batch> batches = batchRepository.findAllByProductIn(products);

        List<Product> productsForPurchaseOrder = new ArrayList<>();

        validateBatches(purchaseOrderDto, quantities, products, batches, productsForPurchaseOrder);

        List<ProductCart> productCarts = productsForPurchaseOrder.stream()
                .map(product -> ProductCart.from(product, purchaseOrderDto.getProducts()))
                .collect(Collectors.toList());

        PurchaseOrder purchaseOrder = PurchaseOrder.createOrderFrom(purchaseOrderDto.getDate(), productCarts);

        purchaseOrderRepository.save(purchaseOrder);

        return new ResponseEntity<>(new SuccessfulOrderDTO(purchaseOrder.getTotalPrice()), HttpStatus.CREATED);
    }

    private void validateBatches(PurchaseOrderDTO purchaseOrderDto, Map<Long, Integer> quantities, List<Product> products, List<Batch> batches, List<Product> productsForPurchaseOrder) {
        for (Batch batch : batches) {
            boolean canCreateNewProduct = addValidationsFor(batch, products, purchaseOrderDto.getDate());

            if (canCreateNewProduct) {
                Product productToSave = batch.getProduct();
                int quantity = quantities.get(productToSave.getId());

                productToSave.setPrice(productToSave.getPrice() * quantity);
                productsForPurchaseOrder.add(batch.getProduct());
            }
        }
    }

    private Map<Long, Integer> getQuantities(List<RequestProductDTO> products) {
        return products.stream()
                .collect(Collectors.toMap(RequestProductDTO::getProductId, RequestProductDTO::getQuantity));
    }

    private boolean addValidationsFor(Batch batch, List<Product> productsForSave, LocalDate requestDate) {
        long currentQuantity = batch.getCurrentQuantity();
        boolean thereIsStock = currentQuantity > 0 && currentQuantity >= productsForSave.size();
        boolean theProductHasNotExpired = validateDueDateFrom(batch.getDueDate(), requestDate);
                
        return thereIsStock && theProductHasNotExpired;
    }

    private boolean validateDueDateFrom(LocalDate batchDueDate, LocalDate requestDate) {
        Period period =  Period.between(batchDueDate, requestDate);

        return period.getDays() > 21;
    }

    private List<Long> getProductsIds(PurchaseOrderDTO purchaseOrderDto) {
        return purchaseOrderDto.getProducts().stream()
                .map(RequestProductDTO::getProductId)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findProductsByOrder(Long idOrder) {
        Optional<PurchaseOrder> maybePurchaseOrder = purchaseOrderRepository.findById(idOrder);

        return new ResponseEntity<>(maybePurchaseOrder.stream()
                .flatMap(purchaseOrder -> Optional.ofNullable(purchaseOrder.getProductCars())
                        .orElseGet(Collections::emptyList)
                        .stream())
                .map(ProductDTO::fromCart)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public PurchaseOrderDTO modifyOrder(Long idOrder, PurchaseOrderDTO purchaseOrderDTO) {
        List<Long> productsIds = getProductsIds(purchaseOrderDTO);
        PurchaseOrder purchaseOrder = purchaseOrderRepository.getPurchaserOrderById(idOrder);

        List<Product> products = productRepository.findAllById(productsIds);
        Map<Long, Integer> quantities = getQuantities(purchaseOrderDTO.getProducts());
        List<Batch> batches = batchRepository.findAllByProductIn(products);

        List<Product> productsForPurchaseOrder = new ArrayList<>();

        validateBatches(purchaseOrderDTO, quantities, products, batches, productsForPurchaseOrder);

        List<ProductCart> productCarts = productsForPurchaseOrder.stream()
                .map(product -> ProductCart.from(product, purchaseOrderDTO.getProducts()))
                .collect(Collectors.toList());

        purchaseOrder.setProductCars(productCarts);
        purchaseOrderRepository.save(purchaseOrder);

        return purchaseOrderDTO;
    }


}
