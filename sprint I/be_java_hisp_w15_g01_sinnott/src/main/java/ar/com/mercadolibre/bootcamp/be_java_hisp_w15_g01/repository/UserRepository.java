package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.util.Optional;

public interface UserRepository {

    /**
     * UserRepository
     * Busca un usuario por id
     *
     * @param id El id del usuario a buscar
     * @return El usuario encontrado
     */
    Optional<User> findById(Long id);

}
