package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchSectionResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.SectionService;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession.IServiceSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecctionController {

    private final SectionService sectionService;
    private final IServiceSession iServiceSession;

    @Autowired
    public SecctionController(SectionService sectionService, IServiceSession iServiceSession) {
        this.sectionService = sectionService;
        this.iServiceSession = iServiceSession;
    }


    @GetMapping("/api/v1/fresh-products/{idSection}")
    public ResponseEntity<List<BatchSectionResponseDTO>> findAllBatchBySection(@RequestHeader(value= "Authorization") String authorization,
                                                                               @PathVariable Long idSection){
        String username = iServiceSession.getUsername(authorization);
        return sectionService.getAllBatchBySection(idSection);
    }
}
