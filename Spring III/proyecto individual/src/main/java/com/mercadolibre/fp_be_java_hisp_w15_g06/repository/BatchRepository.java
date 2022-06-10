package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//TODO mover estos metodos a un solo batchrepository
@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    List<Batch> findAllByProductIn(List<Product> product);

    Optional<Batch> findByProduct(Product product);

    default Batch getBatchByProduct(Product product) {
        return findByProduct(product).orElseThrow(() -> new ProductNotFoundException(2L));
    }

    List<Batch> findAllByProduct(Product product);

    List<Batch> findAllBySection(Section section);

}
