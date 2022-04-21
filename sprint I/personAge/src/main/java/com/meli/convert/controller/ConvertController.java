package com.meli.convert.controller;

import com.meli.convert.services.ConvertService;
import com.meli.convert.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
public class ConvertController {

    @Autowired
    @Qualifier("convertServiceImpl")
    private PersonService personService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getValueRoman(@PathVariable Integer day,
                                                @PathVariable Integer month,
                                                @PathVariable Integer year) {
        return new ResponseEntity<>(this.personService.getAge(day, month, year), HttpStatus.OK);
    }
}
