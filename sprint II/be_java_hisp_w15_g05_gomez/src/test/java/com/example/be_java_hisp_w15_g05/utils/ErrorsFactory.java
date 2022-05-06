package com.example.be_java_hisp_w15_g05.utils;

import com.example.be_java_hisp_w15_g05.exceptions.ErrorDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ErrorsFactory {
    public static ErrorDTO postErrorDTO(){
        HashMap<String, List<String>> errors = new HashMap<>();
        //listado de errores
        errors.put("detail.productName", Arrays.asList("El nombre del producto no puede estar vacio"));
        errors.put("detail.brand", Arrays.asList("La marca de producto no debe contener caracteres especiales"));
        errors.put("detail.color", Arrays.asList("El producto debe tener un color"));
        errors.put("detail.productId", Arrays.asList("El ID del post no puede ser menor a 0"));
        errors.put("detail.type", Arrays.asList("El tipo de producto no puede estar vacio"));

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids",errors);

        return errorDTO;
    }
}
