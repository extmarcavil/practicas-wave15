package ar.com.mercadolibre.bootcam.calorias.controller;

import ar.com.mercadolibre.bootcam.calorias.dto.PlatoRequestDTO;
import ar.com.mercadolibre.bootcam.calorias.dto.PlatoResponseDTO;
import ar.com.mercadolibre.bootcam.calorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    private PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public ResponseEntity<PlatoResponseDTO> getDataPlato(@RequestBody PlatoRequestDTO dto) {
        return new ResponseEntity<>(platoService.getDataPlato(dto), HttpStatus.OK);
    }

}
