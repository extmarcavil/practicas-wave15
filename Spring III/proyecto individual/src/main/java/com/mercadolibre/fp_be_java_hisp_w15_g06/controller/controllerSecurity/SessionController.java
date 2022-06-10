package com.mercadolibre.fp_be_java_hisp_w15_g06.controller.controllerSecurity;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.requestDTO.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.UserResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession.IServiceSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1")
@RestController
public class SessionController {

    private final IServiceSession service;

    public SessionController(IServiceSession sessionService){
        this.service = sessionService;
    }

    /**
     * Realiza la validación del usuario y contraseña ingresado.
     * En caso de ser correcto, devuelve la cuenta con el token necesario para realizar las demás consultas.
     *
     * @param user - user con userName y password
     * @return AgentResponseDTO
     */
    @PostMapping("/sign-in")
    public UserResponseDTO login(@RequestBody UserRequestDTO agent ) {

        return service.login(agent);
    }
}
