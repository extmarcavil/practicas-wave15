package com.meli.convert.controller;

import com.meli.convert.services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    @Qualifier("convertServiceImpl")
    private ConvertService convertService;

    @GetMapping("/decimalToRoman/{number}")
    public ResponseEntity<String> getValueRoman(@PathVariable Integer number) {
        return new ResponseEntity<>(this.convertService.convertDecimalToRoman(number), HttpStatus.OK);
    }
}
