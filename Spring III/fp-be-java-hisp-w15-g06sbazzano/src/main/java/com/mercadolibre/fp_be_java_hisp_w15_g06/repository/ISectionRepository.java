package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.PurchaseOrderNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.PurchaseOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISectionRepository extends JpaRepository<Section, Long> {

    Optional<Section> findById(Long id);

    Section findAllById(Long idSection);


}
