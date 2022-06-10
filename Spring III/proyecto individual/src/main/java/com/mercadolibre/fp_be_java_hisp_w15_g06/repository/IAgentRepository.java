package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Agent;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAgentRepository extends JpaRepository< Agent,Long> {

    Optional<Agent> findByUser(User user);
}
