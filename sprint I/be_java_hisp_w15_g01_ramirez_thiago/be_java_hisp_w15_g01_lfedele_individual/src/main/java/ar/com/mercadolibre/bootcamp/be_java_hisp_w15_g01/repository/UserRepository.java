package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

}
