package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.BuyerNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    default Buyer getBuyer(Long id) {
        return findById(id).orElseThrow(() -> new BuyerNotFoundException(id));
    }
}
