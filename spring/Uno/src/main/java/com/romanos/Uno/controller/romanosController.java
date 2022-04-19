package com.romanos.Uno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class romanosController {

    @GetMapping("/convertir/{numero}")
    public String conversion(@PathVariable Integer numero){

        String response = "";

        switch (numero) {
            case 1:
                response = "Ⅰ";
                break;
            case 2:
                response = "Ⅱ ";

            case 3:
                response = "Ⅲ";
                break;
            case 4:
                response = "Ⅳ";
                break;
            case 5:
                response = "Ⅴ";
                break;
            case 6:
                response = "Ⅵ";
                break;
            case 7:
                response = "Ⅶ";
                break;
            case 8:
                response = "Ⅷ";
                break;
            case 9:
                response = "Ⅸ";
                break;
            case 10:
                response = "Ⅹ";
                break;
            case 13:
                response = "ⅩⅢ";
                break;
            case 50:
                response = "L";
                break;
            case 100:
                response = "C";
                break;
            case 500:
                response = "D";
                break;
            case 1000:
                response = "M";
                break;


        }
        return response;
    }




}
