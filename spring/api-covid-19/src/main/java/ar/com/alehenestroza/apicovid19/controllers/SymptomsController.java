package ar.com.alehenestroza.apicovid19.controllers;

import ar.com.alehenestroza.apicovid19.models.Symptom;
import ar.com.alehenestroza.apicovid19.services.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SymptomsController {
    private final SymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findSymptoms() {
        return new ResponseEntity<>(this.symptomService.findSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name) {
        Symptom symptom = this.symptomService.findSymptom(name);
        String message;
        HttpStatus status;
        if (symptom == null) {
            message = "Sintoma no encontrado";
            status = HttpStatus.NOT_FOUND;
        } else {
            message = "Severidad del sintoma: " + symptom.getSeverity();
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(message, status);
    }
}
