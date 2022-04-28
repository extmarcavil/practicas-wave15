package com.sprint1.be_java_hisp_w15_g03.utils;

import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Se define esta clase para poder implementar metodos repetitivos de los servicios
 */
@Controller
public class Utils implements IUtils {
    private final IMeliRepository repository;

    public Utils(IMeliRepository userRepository) {
        this.repository = userRepository;
    }

    /**
     * Se busca si existe un cierto vendedor,
     * devuelve una excepcion en caso de que no exista.
     * @param sellerId id del vendedor a consultar
     */
    @Override
    public void existeSeller(Integer sellerId){
        if (!repository.hasSeller(sellerId))
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
    }

    /**
     * Se busca si existe cierto comprador,
     * devuelve una excepcion en caso que no exista.
     * @param userId id del usuario a consultar
     */
    @Override
    public void existeUser(Integer userId){
        if (!repository.hasUser(userId))
            throw new PersonNotFoundException("El usuario con el id: " + userId + " no existe");
    }

}
