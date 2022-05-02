package com.testing.validations.controller;

import com.testing.validations.dto.StudentDTO;
import com.testing.validations.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/analyzeScores")
    public ResponseEntity<StudentDTO> analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.analyzeScores(rq));
    }

}
