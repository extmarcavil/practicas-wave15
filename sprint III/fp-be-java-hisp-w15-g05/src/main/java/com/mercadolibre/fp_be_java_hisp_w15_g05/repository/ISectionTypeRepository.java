package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionType;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionTypeE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio encargado de recuperar el section type de los productos
 */
@Repository
public interface ISectionTypeRepository extends JpaRepository<SectionType, Long> {

    Optional<SectionType> findByType(SectionTypeE type);
}
