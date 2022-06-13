package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductWQuantityDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionType;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionTypeE;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFactory {

    public static final SectionType Refrigerated = new SectionType(2L, SectionTypeE.REFRIGERATED);
    public static final SectionType Frozen = new SectionType(3L, SectionTypeE.FROZEN);
    public static final SectionType Fresh = new SectionType(1L, SectionTypeE.FRESH);
    private static final ProductWQuantityDTO prodWQuantity = new ProductWQuantityDTO("leche",3);
    private static final ProductWQuantityDTO prodWQuantity1 = new ProductWQuantityDTO("manteca", 1);
    private static Product prod1 = new Product();

    public static List<ProductDTO> getListProducts(){
        List<ProductDTO> lista = new ArrayList<>();
        ProductDTO prod1 = new ProductDTO(1,"leche", Refrigerated);
        ProductDTO prod2 = new ProductDTO(2,"hamburguesa", Frozen);
        lista.add(prod1);
        lista.add(prod2);
        return lista;
    }

    public static List<Product> getListProducts2(){
        List<Product> lista2 = new ArrayList<>();
        Product prod1 = new Product();
        Product prod2 = new Product();

        prod1.setProduct_id(1);
        prod1.setType(Refrigerated);
        prod1.setName("leche");
        prod1.setPrice(150);

        prod2.setProduct_id(2);
        prod2.setType(Frozen);
        prod2.setName("hamburguesa");
        prod2.setPrice(100);


        lista2.add(prod1);
        lista2.add(prod2);
        return lista2;
    }

    //listas de productos (3 listas)

    public static List<Product> getListProductsRefrigerated(){
        List<Product> lista = new ArrayList<>();
        Product prod1 = new Product();

        prod1.setProduct_id(1);
        prod1.setType(Refrigerated);
        prod1.setName("leche");
        prod1.setPrice(150);

        lista.add(prod1);
        return lista;
    }

    public static List<Product> getListProductsFrozen(){
        List<Product> lista = new ArrayList<>();
        Product prod1 = new Product();

        prod1.setProduct_id(1);
        prod1.setType(Frozen);
        prod1.setName("hamburguesa");
        prod1.setPrice(150);

        lista.add(prod1);
        return lista;
    }

    public static List<Product> getListProductsFresh(){
        List<Product> lista = new ArrayList<>();
        Product prod1 = new Product();

        prod1.setProduct_id(1);
        prod1.setType(Fresh);
        prod1.setName("manzana");
        prod1.setPrice(150);

        lista.add(prod1);
        return lista;
    }

    //lista de productosDTO (3 listas)

    public static List<ProductDTO> getListProductsSection3(){
        List<ProductDTO> lista = new ArrayList<>();
        ProductDTO prod1 = new ProductDTO(1,"leche", Refrigerated);
        lista.add(prod1);
        return lista;
    }

    public static List<ProductDTO> getListProductsSection2(){
        List<ProductDTO> lista = new ArrayList<>();
        ProductDTO prod1 = new ProductDTO(1,"hamburguesa", Frozen);
        lista.add(prod1);
        return lista;
    }

    public static List<ProductDTO> getListProductsSection1(){
        List<ProductDTO> lista = new ArrayList<>();
        ProductDTO prod1 = new ProductDTO(1,"manzana", Fresh);
        lista.add(prod1);
        return lista;
    }

    //lista vacía para prueba de excepciones
    public static List<Product> getEmptyList(){
        List<Product> lista = new ArrayList<>();
        return lista;
    }


    public static List<ProductWQuantityDTO> getProdWQuantityList(){
        return Arrays.asList(prodWQuantity,prodWQuantity1);
    }

    public static Product getProducto () {
        prod1.setProduct_id(1);
        prod1.setType(Refrigerated);
        prod1.setName("leche");
        prod1.setPrice(150);

        return prod1;
    }

}
