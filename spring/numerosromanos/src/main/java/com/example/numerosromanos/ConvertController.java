package com.example.numerosromanos;

import com.example.numerosromanos.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    /**
     * Injection of dependency.
     */
    @Autowired
    private IConvertService convertService;


    /**
     * Methods Handler
     *
     * @param number
     * @return
     */
    @GetMapping("/{number}")
    public String getRomanNumerals(@PathVariable int number) {
        String numberRoman = convertService.toRomanNumeral(number);

        return numberRoman;
    }


}
