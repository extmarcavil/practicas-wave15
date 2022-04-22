package com.example.codemorse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/convert/")
public class codigoMorseController {


    @Autowired
    private ICodeMorseService codeMorseService;

    /**
     * @param code
     * @return
     */
    @GetMapping("/{code}")
    public String convertToWords(@PathVariable String code) {

        return codeMorseService.convertToWords(code);

    }


}
