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

    @GetMapping("/morse-code/{morse}")
    public ResponseEntity<String> getValueRoman(@PathVariable String morse) {
        String[] codes = morse.split(" ");
        return new ResponseEntity<>(this.convertService.convertMorseCode(codes), HttpStatus.OK);
    }
}
