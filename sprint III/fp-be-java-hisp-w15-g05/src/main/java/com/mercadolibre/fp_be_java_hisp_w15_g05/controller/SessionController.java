package com.mercadolibre.fp_be_java_hisp_w15_g05.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.UserResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.ISessionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1")
@RestController
public class SessionController {
    private final ISessionService service;

    public SessionController(ISessionService sessionService) {
        this.service = sessionService;
    }

    /**
     * Realiza la validación del usuario y contraseña ingresado.
     * En caso de ser correcto, devuelve la cuenta con el token necesario para realizar las demás consultas.
     *
     * @param user - user con userName y password
     * @return UserResponseDTO
     */
    @PostMapping("/sign-in")
    public UserResponseDTO login(@RequestBody UserRequestDTO user ) {
        return service.login(user);
    }

}