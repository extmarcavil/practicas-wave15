package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> productList;

    public ProductRepository(){
        productList = new ArrayList<Product>();
        Product product1 = new Product(  1, "Saco", "Mujer", "Koaj", "Rosado","notas");
        Product product2 = new Product(  2, "Botella", "Vidrio", "Meli", "Azul","botella");
        Product product3 = new Product(  3, "Silla", "Gamer", "Lenovo", "Amarillo","silla gamer");
        Product product4 = new Product(  4, "Ventilador", "Pequeño", "Russ", "Verde","ventilador peque");
        Product product5 = new Product(  5, "Equipo", "casa", "Huawei", "Negro","ultimos productos");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    public List<Product> getAll(){
        return productList;
    }

    public Optional<Product> getById(int id){
        return productList.stream()
                .filter(user -> user.getProduct_id()==id)
                .findFirst();
    }

    public void add(Product product){
        productList.add(product);
    }

}
