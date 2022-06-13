package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.BatchProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SectionWarehouseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidRolException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.RolE;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.User;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.ListNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.WrongSectionTypeException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.ISectionTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{


    private ISectionTypeRepository sectionTypeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    private final IProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final SessionServiceImpl sessionService;

    public ProductService(ISectionTypeRepository sectionTypeRepository, IProductRepository productRepository, BatchRepository batchRepository, SessionServiceImpl sessionService) {
        this.sectionTypeRepository = sectionTypeRepository;
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.sessionService = sessionService;
    }

    @Override
    public List<ProductDTO> getListProducts(Integer category,String token) {
        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);

        validateUserBuyerRol(user);

        if(category==null){
            List<Product> productList = productRepository.findAll();
            if(productList.size()!=0){
                List<ProductDTO> listProductDTO = productList.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
                return listProductDTO;
            }
            throw new ListNotFoundException("La lista que está buscando, no existe");
        }
        SectionTypeE sectionTypeE;
        switch (category) {
            case 1:
                sectionTypeE = SectionTypeE.FRESH;
                break;
            case 2:
                sectionTypeE = SectionTypeE.FROZEN;
                break;
            case 3:
                sectionTypeE = SectionTypeE.REFRIGERATED;
                break;

            default:
                throw new WrongSectionTypeException("Número de sección erróneo");
        }
        SectionType sectionType = sectionTypeRepository.findByType(sectionTypeE).orElseThrow(() -> new WrongSectionTypeException("Número de sección erróneo"));
        List<Product> productList = productRepository.findAllByType(sectionType);
        if(productList.size()!=0){
            List<ProductDTO> listProductDTO = productList.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
            return listProductDTO;
        }
        throw new ListNotFoundException("La lista que está buscando, no existe");
    }



    public static void validateUserBuyerRol(User user) {
        if(user.getRol().getRol() != RolE.BUYER)
            throw new InvalidRolException();
    }
    @Override
    public Product findById(Integer id){
        return productRepository
                .findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Producto con id: " + id + " no encontrado."));
    }

    @Override
    public BatchStockDTO getListOfProductInBatch(Integer idProduct, String order, String token) {

        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);
        validateUserRol(user);

        Product product = productRepository.findById(idProduct).orElseThrow(() -> new ProductNotFoundException("Producto con id: " + idProduct + " no encontrado."));
        List<Batch> batchList = batchRepository.findAllByProductId(product);

        if (order != null)
            batchList = orderBatch(order,batchList);

        SectionWarehouseDTO sectionWarehouseDTO = new SectionWarehouseDTO();
        BatchStockDTO batchStockDTO = new BatchStockDTO();

        List<BatchProductDTO> batchProductList = new ArrayList<>();

        batchList.stream().forEach(batch -> {
            if(batch.getDue_date().isAfter(LocalDate.now().plusWeeks(3))) {
                batchStockDTO.setProduct_id(idProduct);

                sectionWarehouseDTO.setSection_id(batch.getSection().getSection_id());
                sectionWarehouseDTO.setWarehouse_id(batch.getSection().getWarehouse().getWarehouse_id());

                batchStockDTO.setSection(sectionWarehouseDTO);

                BatchProductDTO batchProductDTO = new BatchProductDTO();
                batchProductDTO.setBatch_number(batch.getBatch_number());
                batchProductDTO.setDue_date(batch.getDue_date());
                batchProductDTO.setCurrent_quantity(batch.getCurrent_quantity());
                batchProductList.add(batchProductDTO);
            }
        });
        batchStockDTO.setBatch_stock(batchProductList);

        return batchStockDTO;
    }

    private List<Batch> orderBatch (String order, List<Batch> listBatch){
        switch (order) {
            case "L":
                listBatch.sort(Comparator.comparing(Batch::getBatch_number));
                break;
            case "C":
                listBatch.sort(Comparator.comparing(Batch::getCurrent_quantity));
                break;
            case "F":
                listBatch.sort(Comparator.comparing(Batch::getDue_date));
                break;

        }
        return listBatch;
    }

    private void validateUserRol(User user) {
        if(user.getRol().getRol() != RolE.REP)
            throw new InvalidRolException();
    }
}
