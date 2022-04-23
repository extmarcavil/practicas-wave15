package ar.com.mercadolibre.bootcam.calorias.controller;

import ar.com.mercadolibre.bootcam.calorias.dto.request.PlatoRequestDTO;
import ar.com.mercadolibre.bootcam.calorias.dto.response.PlatoResponseDTO;
import ar.com.mercadolibre.bootcam.calorias.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    private IPlatoService IPlatoService;

    public PlatoController(IPlatoService IPlatoService) {
        this.IPlatoService = IPlatoService;
    }

    @GetMapping
    public ResponseEntity<PlatoResponseDTO> getDataPlato(@RequestBody PlatoRequestDTO dto) {
        return new ResponseEntity<>(IPlatoService.getDataPlato(dto), HttpStatus.OK);
    }

}
